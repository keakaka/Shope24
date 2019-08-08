<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">
</head>
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
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
				</div>

				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
					</div>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
