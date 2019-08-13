<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<div class="col-md-3 left_col">
<div class="left_col scroll-view">
<div class="navbar nav_title" style="border: 0;">
<a href="/admin/main" class="site_title"><i class="fa fa-paw"></i> <span>Shope 24</span></a>
</div>
<div class="clearfix"></div>

<br />

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
<div class="menu_section">
<h3>관리자 메뉴</h3>
<ul class="nav side-menu">
<li><a href="/admin/main"><i class="fa fa-home"></i> Home </a></li>
<li><a href="/admin/memberList"><i class="fa fa-edit"></i> 고객 관리 </a>
</li>
<li><a><i class="fa fa-desktop"></i> 상품 관리 <span class="fa fa-chevron-down"></span></a>
<ul class="nav child_menu">
<li><a href="general_elements.html">카테고리 등록</a></li>
<li><a href="/admin/product">상품 등록</a></li>
<li><a href="typography.html">상품 수정</a></li>
<li><a href="icons.html">진열 상태 변경</a></li>
<li><a href="glyphicons.html">재고 상태</a></li>
</ul>
</li>
</ul>
</div>
</div>
</div>
</div>

<div class="top_nav">
<div class="nav_menu">
<nav>
<div class="nav toggle">
<a id="menu_toggle"><i class="fa fa-bars"></i></a>
</div>
<ul class="nav navbar-nav navbar-right">
<li class="">
<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
<img src="images/img.jpg" alt="">John Doe
<span class=" fa fa-angle-down"></span>
</a>
<ul class="dropdown-menu dropdown-usermenu pull-right">
<li><a href="javascript:;"> Profile</a></li>
<li>
<a href="javascript:;">
<span class="badge bg-red pull-right">50%</span>
<span>Settings</span>
</a>
</li>
<li><a href="javascript:;">Help</a></li>
<li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
</ul>
</li>
<li role="presentation" class="dropdown">
<a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
<i class="fa fa-envelope-o"></i>
<span class="badge bg-green">6</span>
</a>
<ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
<li>
<a>
<span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
<span>
<span>John Smith</span>
<span class="time">3 mins ago</span>
</span>
<span class="message">
Film festivals used to be do-or-die moments for movie makers. They were where...
</span>
</a>
</li>
<li>
<div class="text-center">
<a>
<strong>See All Alerts</strong>
<i class="fa fa-angle-right"></i>
</a>
</div>
</li>
</ul>
</li>
</ul>
</nav>
</div>
</div>

