<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Shope24 </title>

<link href="/assets/admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="/assets/admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<link href="/assets/admin/vendors/nprogress/nprogress.css" rel="stylesheet">

<link href="/assets/admin/build/css/custom.min.css" rel="stylesheet">

<link href="/assets/summernote/dist/summernote.css" rel="stylesheet">
</head>
<script type="text/javascript">
        function sendFile(file, editor) {
        	
			data = new FormData();
			data.append("uploadFile", file);
           
			console.log(data);
		    $.ajax({ // ajax를 통해 파일 업로드 처리
		        data : data,
		        type : "POST",
		        url : "/imgUpload",
		        cache : false,
		        contentType : false,
		        processData : false,
		        success : function(data) { 
		           $(editor).summernote('editor.insertImage', data.url);
		        },
		        error:function(request,status,error){
		           alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		         
		        
		        }
		    });   
		}
       
       function deleteFile(src) {
    	    $.ajax({
    	        data: {src : src},
    	        type: "POST",
    	        url: "/imgDelete",
    	        cache: false,
    	        success: function(data) {
    	            console.log(data);
    	            alert('삭제완료');
    	        }
    	    });
    	};
   </script>
<body class="nav-md">
<div class="container body">
<div class="main_container">

<c:import url="includes/nav.jsp"/>

<!-- 컨텐츠 영역 -->

<div class="right_col" role="main">
<div class="x_panel">
			<div class="x_title">
				<h1>상품 등록</h1>
				<br>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form id="FILE_FORM" method="post" enctype="multipart/form-data" action="">
				<h2 style="font-weight:bold;"> 썸네일 이미지 등록 </h2>
					<label> 첫 번째 이미지가 메인 이미지로 등록 됩니다. </label> <br>
					<input type="file" id="imgBtn" name="imgBtn" class="imgBtn btn btn-default" />
		        </form>
				
				<br><br>
				<div class="row imgArea">
					
				</div>
				
				<script>
				
				$(function(){  
					
	                $('#imgBtn').change(function(){
	                	if($('#imgBtn').get(0).files.length != 0){
	                		var form = $('#FILE_FORM')[0];
							var form_data = new FormData(form);
							var file = $(this)[0].files[0];
							form_data.append('file', file);
							
							var ext = file.name.split(".").pop().toLowerCase();
							if(ext.length > 0){
								if($.inArray(ext, ["gif","png","jpg","jpeg"]) == -1) { 
									alert("gif,png,jpg 파일만 업로드 할수 있습니다.");
									$(this).val("");
									return false;
								}                  
							}
							
							$.ajax({
		                        url: "/admin/imgUpload",
		                        type: "post",
		                        data: form_data,
		                        dataType: 'json',
		                        enctype: 'multipart/form-data',
		                        contentType: false,
		                        crossDomain: true,
		                        processData: false,
		                        success: function(result) {
		                        	
		                        	obj = JSON.parse(result);
		                        	
		                            $area = $('.imgArea');
		                            $div = $('<div class="col-lg-3 col-md-3 mb-3">')
		                            $img = $('<img class="col-lg-12 col-md-12 mb-12" name="'+obj.fileName+'" alt="이미지" src="' + obj.url + '" />');
		                            $btn = $('<button class="delBtn btn btn-danger btn-xs" style="margin-left:43%;">X</button>');
		                            $input = $('<input type="hidden" value="' + obj.changeName + '" />');
		                            
		                            $div.append($img);
		                            $div.append($btn);
		                            $div.append($input);
		                            
		                            $area.append($div);
		                            
		                            $(function(){
		                            	$('.delBtn').click(function(){
		                            		
		                            		var fileName = $(this).parent().children('input').val();
		                            		check = true;
		                            		$.ajax({
		        		                        url: "/admin/imgDelete?fileName="+fileName,
		        		                        type: "get",
		        		                        success: function(result) {
		        		                        	
		        		                        },
		        		                        error: function(error) {
		        		                        	check = false;
		        		                        }
		                            		});
		                            		if(check == true){
		                            			$(this).parent().remove();
		                            		}
		                            	});
		                            });
		                            
		                        },
								error : function(error){
									
								}
							});
	                	}
	                });
				});    
				
				</script>
				
				<form id="productForm" data-parsley-validate action="/admin/product" method="post">
					<!-- enctype="multipart/form-data" autocomplete="off"  > -->
					<h2 style="font-weight:bold;">판매 글 설정</h2>
					
					<label for="categoryNo">카테고리</label>
					<select id="categoryNo" name="categoryNo" class="form-control">
						<c:forEach items="${ list }" var="category" varStatus="status">
							<option value="${ category.no }">
								${ category.name }
							</option>
						</c:forEach>
					</select>
					<script>
						$(function(){
							$('#category').click(function(){
								console.log($(this).children()).val();
							});
						})
					</script>
					<br>
					<label for="displayName">판매 글 제목 * :</label>
					<input type="text" id="title" class="form-control" name="title" />
					<br>
					
					<label>상품 소개 작성</label>
					<textarea id="summernote" name="content" ></textarea>
					
					<br><hr><br>
					
					<h2 style="font-weight:bold;">상품 입력</h2>
					<br>
					
					<label for="price">상품 이름 * :</label>
					<input type="text" id="name" class="form-control" name="name" data-parsley-trigger="change" />
					<br>
					
					<label for="price">가격 * :</label>
					<input type="text" id="price" class="form-control" name="price" data-parsley-trigger="change" />
					<br>
					
					<label for="stock">재고 * :</label>
					<input type="text" id="stock" class="form-control" name="stock" value='' />
					<br>
					
					<a id="addOption" class="btn btn-default">옵션 추가</a><br>
					<div id="optionTable">
					
					</div>
					<script>
						$(function(){
							$('#addOption').click(function(){
								var option = prompt('옵션 입력\n(입력 순서대로 적용 / 잘못 입력된 옵션 값은 체크 해제) \nex)	90/BLACK\n95/BLACK\n100/BLACK...');
								if(option === null){
									return;
								}
								$('#optionTable').append(
									'<label for="'+ option + '">'+option+'</label>' +
								    '<input type="checkbox" id="' + option + '" class="optionClass" name="option" value="' + option + '" checked /><br>'                    
								);


							});
						});
					</script>
					
					<br>
					
					
					<hr>
					
					
					<button type="button" id="apply" class="btn btn-primary" style='width: 30%;'>등록</button>
					<br><br>
					<a href="/product" id="cancel" class="btn btn-danger" style='width: 30%;'>취소</a>
				</form>
				<script>
					$(function(){
						$('#apply').click(function(){
							var title = $("#title").val();
							var content = $("#content").val();
							var categoryNo = $('#categoryNo').val();
							
							var name = $('#name').val();
							var price = $('#price').val();
							var stock = $('#stock').val();
							
							var optionList = new Array();
							$('input:checkbox[name="option"]:checked').each(function(){
								optionList.push($(this).val());
							});
							
							var productDTO = {title:title, content:content, categoryNo:categoryNo, name:name, price:price, stock:stock, optionList:optionList};
							
							$.ajax({
						        url: "/admin/product",
								type: "POST",
								data: JSON.stringify(productDTO),
								dataType: "json",
								contentType:'application/json; charset=utf-8',
								success: function(result){
									
								},
								error: function(xhr, error){
									
								}
						    });
							

						});
					});
				</script>
				<!-- end form for validations -->
			</div>
		</div>

</div>


<c:import url="includes/footer.jsp"/>

</div>
</div>

<!-- include summernote css/js -->
<script src="/assets/summernote/dist/summernote.js"></script>

<script>
	$(document).ready(function() {
		var fileExtension = [ '.jpg', '.png', '.jpeg', '.gif', ];
		$('#summernote').summernote({
			height : 300,
			lang : 'ko-KR',
			toolbar : [ 
				['style',
					[
					'bold',
					'italic',
					'underline',
					'clear' 
					]
				],
				[
				'font',
					[
					'strikethrough',
					'superscript',
					'subscript' 
					] 
				],
				[ 'fontsize',
				[ 'fontname', 'fontsize' ] ],
				[ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ],
				[ 'insert', [ 'picture',
								'link',
								'video',
								'table',
								'hr' ] ] ],
				callbacks : { 
					onImageUpload : function(files, editor, welEditable) {
						
						for (var i = files.length - 1; i >= 0; i--) {
							for (var j = 0; j < fileExtension.length; j++) {
								var extleng = files[i].name.length;
								var extdot = files[i].name
										.lastIndexOf('.');
								var ext = files[i].name.substring( extdot, extleng ).toLowerCase();
								console.log(ext + ' / ' + fileExtension[j])
								if (ext == fileExtension[j]) {
									sendFile( files[i], this );
								}
							}
						}
					},
							onMediaDelete : function(target) {
								alert(target[0].src);
								deleteFile(target[0].src);
								console.log(target[0].src)
							}
						}
					});
			});
</script>


<script src="/assets/admin/vendors/jquery/dist/jquery.min.js" type="dcdbae246a372a62707f1393-text/javascript"></script>

<script src="/assets/admin/vendors/bootstrap/dist/js/bootstrap.min.js" type="dcdbae246a372a62707f1393-text/javascript"></script>

<script src="/assets/admin/vendors/fastclick/lib/fastclick.js" type="dcdbae246a372a62707f1393-text/javascript"></script>

<script src="/assets/admin/vendors/nprogress/nprogress.js" type="dcdbae246a372a62707f1393-text/javascript"></script>

<script src="/assets/admin/build/js/custom.min.js" type="dcdbae246a372a62707f1393-text/javascript"></script>

<script type="dcdbae246a372a62707f1393-text/javascript">
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-23581568-13', 'auto');
ga('send', 'pageview');

</script>
<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="dcdbae246a372a62707f1393-|49" defer=""></script></body>
</html>
