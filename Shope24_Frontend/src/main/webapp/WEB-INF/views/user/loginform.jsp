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
<form action="/user/auth" method="post">
<h1>로 그 인</h1>
<div>
<input type="text" class="form-control" name="id" placeholder="ID"/>
</div>
<div>
<input type="password" class="form-control" name="password" placeholder="Password"/>
</div>
<div>
<button type="submit" id="login" class="btn btn-default">로그인</button>
<a class="reset_pass" href="#">비밀번호를 잃어버리셨습니까?</a>
</div>
<div class="clearfix"></div>
<div class="separator">
<p class="change_link">처음 방문하세요 ?
<a href="#signup" class="to_register"> 회원가입 하러 가기 </a>
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
<form method="post" action="/user/join" id="joinform">
<h1>계정 만들기</h1>
<div>
<label for="id">아이디</label>
<input type="text" class="form-control" placeholder="6자 이상 영문/숫자 " id="id" name="id"/>
</div>
<!-- <button id="checkId" class="btn btn-dark btn-xs"> ID 중복체크 </button> -->
<div>
<label for="password">비밀번호</label>
<input type="password" class="form-control" placeholder="8자 이상 문자/숫자/특수 문자" id="password" name="password"/>
</div>
<div>
<label for="name">이름</label>
<input type="text" class="form-control" placeholder="이름" id="name" name="name"/>
</div>
<div>
<label for="email">이메일</label>
<input type="email" class="form-control" id="email" placeholder="이메일" name="email" />
</div>
<div>
<label for="phone">연락처</label>
<input type="text" class="form-control" id="phone" placeholder="연락처" name="phone" />
</div>
<div>
<label for="date">생년월일</label>
<input type="date" class="form-control" id="birth" placeholder="생년월일" name="birth" />
</div>
<div>
<br><br>
<label for="Male">
<input type="radio" value="M" id="Male" name="gender"/>
	MAN
</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label for="Female">
<input type="radio" value="F" id="Female" name="gender"/>
	WOMAN
</label>
</div>
	
<div>
<a id="join" class="btn btn-dark">회원가입</a>
<a id="cancel" class="btn btn-dark" href="/">취소</a>
</div>
<div class="clearfix"></div>

<script>
	$(function(){
		$('#join').click(function(){
			var id = $('#id').val();
			var password = $('#password').val();
			var name = $('#name').val();
			var email = $('#email').val();
			var phone = $('#phone').val();
			var birth = $('#birth').val();
			var gender = $('input[name="gender"]:checked').val();
			$.ajax({
				url: "/user/join",
				type: "POST",
				data: { id:id, password:password, name:name, email:email, phone:phone, birth:birth, gender:gender },
				dataType: "json",
				success: function(result){
					if(result == 'success'){
						location.href='/';
					}else{
						alert(result);
					}
					
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
