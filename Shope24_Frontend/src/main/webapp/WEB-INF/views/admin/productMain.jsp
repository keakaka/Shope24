<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css"
	rel="stylesheet">

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

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

<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">Shope24</h1>
				<div class="list-group">
					<a href="#" class="list-group-item">고객 관리</a> 
					<a href="/admin/product" class="list-group-item">상품 관리</a> 
					<a href="#" class="list-group-item">주문 관리</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel"></div>
				<div class="row">
					<div class="col-lg-12 col-md-12 mb-12">
						<div class="right_col" role="main">
						
							<div class="x_panel">
								<div class="x_title">
									
									<br>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<!-- start form for validation -->
									<form id="productForm" data-parsley-validate action="/admin/insertProduct" method="post"
										enctype="multipart/form-data" autocomplete="off">
										<h2 style="font-weight:bold;">판매 글 설정</h2>
										
										<label for="category">카테고리</label>
										<select id="category" id="category" name="category" class="form-control">
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
										<input type="text" id="displayName" class="form-control" name="displayName" />
										<br>
										
										<label>상품 소개 작성</label>
										<textarea id="summernote" name="content" ></textarea>
										<input type="hidden" id='memberNo' name="memberNo" value="">
										
										<br><hr><br>
										
										<div class="row">
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<img class="card-img-top" src="http://placehold.it/500X500" alt="">
												<div class="card-body">
													대표 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<a><img class="card-img-top" src="http://placehold.it/500X500" alt=""></a>
												<div class="card-body">
													서브 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<img class="card-img-top" src="http://placehold.it/500X500" alt="">
												<div class="card-body">
													서브 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<img class="card-img-top" src="http://placehold.it/500X500" alt="">
												<div class="card-body">
													서브 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<img class="card-img-top" src="http://placehold.it/500X500" alt="">
												<div class="card-body">
													서브 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card h-60">
												<img class="card-img-top" src="http://placehold.it/500X500" alt="">
												<div class="card-body">
													서브 이미지
													<input type="file" class="form-control" style="border:none;" value="파일 업로드" placeholder="File">
												</div>
											</div>
										</div>
										</div>
										
										<br><hr><br>
										
										<h2 style="font-weight:bold;">상품 입력</h2>
										<br>
										
										<label for="price">상품 이름 * :</label> 
										<input type="text" id="price" class="form-control" name="price" data-parsley-trigger="change" />
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
													    '<input type="checkbox" id="' + option + '" name="option" value="' + option + '" checked><br>'                    
													); 


												});
											});
										</script>
										
										<br>
										
										
										<hr>
										
										
										<button type="button" id='apply' class="btn btn-primary" style='width: 100%;'>등록</button>
										<br><br>
										<button type="button" id='cancel' class="btn btn-danger" style='width: 100%;'>취소</button>
									</form>
									<!-- end form for validations -->
								</div>
							</div>
						</div>
					</div>
					
					<!-- /.row -->
				</div>
				<!-- /.col-lg-9 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
		
		</div>
		<!-- Footer -->
		<hr><br><br>
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
		<!-- /.Footer -->

		<!-- include summernote css/js -->
		<link
			href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
			rel="stylesheet">
		<script
			src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

		<script>
			$(document).ready(function() {
				var fileExtension = [ '.jpg', '.png', '.jpeg', '.gif', ];
				$('#summernote').summernote({ // summernote를 사용하기 위한 선언
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
		
<script type="text/javascript" src="/ind-script/optimizer.php?filename=rZXPUsMgEMYfILn6HEwdD9696M3R8QEIbNJtgF0XaPXtJf3jWEdtS5wcsln4fny7A0QtyYNaXIvqRXvYkIxKIFIWA2oVFS5uQ7uKV-qveRlZm1GtXjPI-_61aG_Kc6RkoaGIj_iRBUPqT0_U1mNQQa9x0AkpqERcoYqhq1B5CLnRZoor1L0eIRoh56qXzokMeXaQoJYRvZa0BMcgtYiOaCyU8We9ZlaPQjabpJ6-sIpxf37f7ovDO7Jw2Rq8z_UkXsEbU8xyRqfAYqJpCNYIm7Pn9-hgOwwxnhYdvBkKPQ6_-jqrtE5HNDP0UTuIdfoOAvSYGocx1RHIhXGGd0zgZ-2KBMFuKWVHdhhgppemEEVfehYciVki76L6Xm5dEE9ns7Hg0BdHMsvLFNV5YeLMh68Hrwd4BgemsrK1dmj1dMw-o12ddThH2jb7Rl3e7p1Q4VTUC0-sC3-G7PKAIZbsPtNmbA19vwTqOBu0A6T_IHnKcbL0AQ&type=js&k=fc7f5e7599f9c0a458b8888785e1d74d7d9a4223&t=1565116574"></script>
<script type="text/javascript" src="/ind-script/optimizer.php?filename=tZRtboMwDIYvwN-dI9pusBtMk3YAEwwEnDhzkn7s9AtrqVZVnQoZPzF5n9cfiVXPFtXzi6hWwOKeZVSCgZNoVMl40KMaPhPKUXlKnXEhR8-RKpkqsESoCashPKkLywt3GafI1OrjBHmfoUNQkCJnE_O1TFanenKyxi2SBSTUsebDfSV4r96Em6TjldSfYy2LVcZCh0bzMvf825qwrNAfp78a9Hi-6_S654DudYDD-VRBGhZcakHHJCXF7CHqvjpdwQJMgxEMlTT17vwf9Cezm57OurEQgoDTJY2EpvHFMxUkiLmQkmuBlq_lDy8gDYSuAZnXUBZXc2wl8mqnNQJdd7vU1sLY-wKYZmLxRo8oDve_P1cCd0CmgbyA5yQvgWIgHmIeQrgFZ4JnF3A7hx7J44YV9OAa2tIgbwXTHrfjt4biP-RPPL00NU5v9xs&type=js&k=a95d56669a7ca3147a9a8a9fca0490947e5b47e8&t=1564511514"></script>
<script type="text/javascript" src="/ind-script/optimizer.php?filename=rZJNTsQwDIUP0G45hwWcACGxRqARazcxrTtJbZxkoJyeTlXxI82mLavEUd6X9-xAJ5Hg-sZATVrDCIEbOLCiO8ITJSnmCPoE98WMBjdC6kQrNXZU9-kKtundUlWvYhHzDtLs5L8wJXNYBXl-eThoEPQ_u936t0JlXW_P6ddl7yTRAG5etivvevy4rLZfkhMG9pjFLl9FVXg08cXlPy_pcvYtB4chNJOhKpUmct6GM2o5ZVpp5ta8ouUR-mk6NtY5athHwJIl8SfVPGhZmyVI25IB-sjDtjao0YnpvVrqbZDzv5tMeKOAmWWodo565kW0I-XaSYyyMRx5buSc6Qs&type=js&k=3b6f28be01dc0278d13ec6eceaba20edf2e3c21a&t=1562737249"></script>
		
</body>

</html>
