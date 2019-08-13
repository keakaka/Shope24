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
<h3>Plain Page</h3>
</div>
<div class="title_right">
<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
<div class="input-group">
<input type="text" class="form-control" placeholder="Search for...">
<span class="input-group-btn">
<button class="btn btn-default" type="button">Go!</button>
</span>
</div>
</div>
</div>
</div>
<div class="clearfix"></div>
<div class="row">
<div class="col-md-12 col-sm-12 col-xs-12">
<div class="x_panel">
<div class="x_title">
<h2>Plain Page</h2>
<ul class="nav navbar-right panel_toolbox">
<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
</li>
<li class="dropdown">
<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
<ul class="dropdown-menu" role="menu">
<li><a href="#">Settings 1</a>
</li>
<li><a href="#">Settings 2</a>
</li>
</ul>
</li>
<li><a class="close-link"><i class="fa fa-close"></i></a>
</li>
</ul>
<div class="clearfix"></div>
</div>
<div class="x_content">
Add content to the page ...
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
<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="dcdbae246a372a62707f1393-|49" defer=""></script></body>
</html>
