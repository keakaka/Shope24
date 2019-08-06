<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gentelella Alela! | </title>

<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/assets/admin/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/assets/admin/nprogress/nprogress.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/assets/admin/animate.css/animate.min.css" rel="stylesheet">

<link href="${pageContext.servletContext.contextPath }/assets/css/custom.min.css" rel="stylesheet">
</head>
<body class="login">
<div>
<a class="hiddenanchor" id="signup"></a>
<a class="hiddenanchor" id="signin"></a>
<div class="login_wrapper">
<div class="animate form login_form">
<section class="login_content">
<form>
<h1>로 그 인</h1>
<div>
<input type="text" class="form-control" placeholder="ID" required="" />
</div>
<div>
<input type="password" class="form-control" placeholder="Password" required="" />
</div>
<div>
<a class="btn btn-default submit" href="index.html">로그인</a>
<a class="reset_pass" href="#">비밀번호를 잃어버리셨습니까?</a>
</div>
<div class="clearfix"></div>
<div class="separator">
<p class="change_link">처음 방문하세요 ?
<a href="#signup" class="to_register"> 회원가입 화면으로 </a>
</p>
<div class="clearfix"></div>
<br />
<div>
<h1><i class="fa fa-paw"></i> Shope24</h1>
<c:import url='/WEB-INF/views/includes/footer.jsp' />
</div>
</div>
</form>
</section>
</div>
<div id="register" class="animate form registration_form">
<section class="login_content">
<form>
<h1>계정 만들기</h1>
<div>
<input type="text" class="form-control" placeholder="Id" id="id" required="" /><button id="checkId" class="btn btn-dark"> ID 중복체크 </button>
</div>
<div>
<input type="email" class="form-control" placeholder="Email" required="" />
</div>
<div>
<input type="password" class="form-control" placeholder="Password" required="" />
</div>
	
<div>
<a class="btn btn-default submit" href="/user/join">회원가입</a>
</div>
<div class="clearfix"></div>

<script>
	$(function(){
		$('#checkId').click(function(){
			var id = $('#id').val();
			$.ajax({
				url: "/user/checkId",
				type: "GET",
				data: { id:id },
				success: function(result){
					
				},
				error: function(xhr, error){
					
				}
			});
		});
	});
</script>

<div class="separator">
<p class="change_link">이미 가입하셨나요 ?
<a href="#signin" class="to_register"> 로그인 화면으로 </a>
</p>
<div class="clearfix"></div>
<br />
<div>
<h1><i class="fa fa-paw"></i> Shope24</h1>
<c:import url='/WEB-INF/views/includes/footer.jsp' />
</div>
</div>
</form>
</section>
</div>
</div>
</div>
</body>
</html>
