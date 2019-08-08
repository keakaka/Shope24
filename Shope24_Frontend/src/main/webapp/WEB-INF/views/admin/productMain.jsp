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
<body>

	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Shope24</h1>
				<div class="list-group">
					<a href="#" class="list-group-item">고객 관리</a> <a
						href="/admin/product" class="list-group-item">상품 관리</a> <a
						href="#" class="list-group-item">주문 관리</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel"></div>

				<div class="row">
					<div class="col-lg-9 col-md-9 mb-9">
						<div class="right_col" role="main">
							<div class="x_panel">
								<div class="x_title">
									<h2 style="font-weight:bold;">상품 등록</h2>
									<br>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<!-- start form for validation -->
									<form id="productForm" data-parsley-validate action="/admin/insertProduct" method="post"
										enctype="multipart/form-data" autocomplete="off">
										
										<label for="fullname">상품 명 * :</label> 
										<input type="text" id="proName" class="form-control" name="proName" required />
										<br>
										<label for="option">옵션 입력</label> 
										<input type="text" class="form-control" name="option" id="option" value="" checked />
										<br>
										<label for="price">가격 * :</label> 
										<input type="text" id="price" class="form-control" name="price" data-parsley-trigger="change" required />
										<br> 
										<label for="stock">재고 * :</label> 
										<input type="text" id="stock" class="form-control" name="stock" value='' />
										<br>
										<label>상품 소개 작성</label>
										<textarea id="summernote" name="content" required></textarea>
										<input type="hidden" id='memberNo' name="memberNo" value="">
										<br>
										<label>썸네일 : &nbsp; </label>
										<input type="file" id='thumbnail' name="filename" size=40>
										<br>
										<button type="button" id='Enrollment' class="btn btn-primary" style='width: 100%;'>등록</button>
										<br><br>
										<button type="button" id='Enrollment' class="btn btn-danger" style='width: 100%;'>취소</button>
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
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
		<!-- /.Footer -->

		<!-- include summernote css/js -->
		<link
			href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
			rel="stylesheet">
		<script
			src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

		<script>
			$('#summernote').summernote({
				placeholder : 'Hello stand alone ui',
				tabsize : 2,
				height : 300
			});
		</script>
</body>

</html>
