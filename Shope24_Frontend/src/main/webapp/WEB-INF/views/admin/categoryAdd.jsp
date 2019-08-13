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
</head>
<body class="nav-md">
<div class="container body">
<div class="main_container">

<c:import url="includes/nav.jsp"/>

<!-- 컨텐츠 영역 -->

<div class="right_col" role="main">
<div class="">
<div class="page-title">
<div class="title_left">
</div>
</div>
<div class="clearfix"></div>
<div class="row">
<div class="col-md-12 col-sm-12 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>카테고리 등록</h2>
<div class="clearfix"></div>
</div>
<div class="x_content">

<table class="table hover">
	<button>대분류 추가</button>
	<tr>
		<td><input type="text" class="form-control" value="" name="category" style="width:20%;"/><button>하위 추가</button></td>
		<td><input type="text" class="form-control" value="" name="category" style="width:20%;"/><button>하위 추가</button></td>
		<td><input type="text" class="form-control" value="" name="category" style="width:20%;"/><button>하위 추가</button></td>
	</tr>
</table>


</div>
</div>
</div>
</div>
</div>
</div>


<c:import url="includes/footer.jsp"/>

</div>
</div>

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
<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="dcdbae246a372a62707f1393-|49" defer=""></script>
</body>
</html>