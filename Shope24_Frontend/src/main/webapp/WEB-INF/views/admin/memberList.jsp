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
					<a href="/admin/memberList" class="list-group-item">고객 관리</a> 
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
					<h2> 고객 리스트 보기 </h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                          <th>아이디</th>
                          <th>이름</th>
                          <th>이메일</th>
                          <th>생년월일</th>
                          <th>성별</th>
                          <th>연락처</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items='${list }' var='list' varStatus='status'>
						<tr>
							<td>${list.id }</td>
							<td>${list.name }</td>
							<td>${list.email }</td>
							<td>${list.birth }</td>
							<td>${list.gender }</td>
							<td>${list.phone }</td>
						</tr> 
					</c:forEach>
                      </tbody>
                    </table>

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
