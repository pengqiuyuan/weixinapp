<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="cn">
	<head>
		<title>微信公众平台管理系统：<decorator:getProperty property="title" default="管理面板"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Le styles -->
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/css/jquery-ui-1.8.21.custom.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/css/additional.css" />" rel="stylesheet" />
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		    <![endif]-->
		<!-- link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />"-->
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js?" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.8.21.custom.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.datepicker.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.json-2.3.min.js" />"></script>
		<decorator:head/>
		<style type="text/css">
		body {padding-top: 60px;padding-bottom: 40px;}
		</style>
	</head>
	<body>
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
					</a> 
					
					<div class="nav-collapse">
			          <ul class="nav">
			            
			            <li class="dropdown" id="app">
			              <a href="#" class="dropdown-toggle" data-toggle="dropdown">应用管理 <b class="caret"></b></a>
			              <ul class="dropdown-menu">
			              	<li><a href="<%=request.getContextPath()%>/mgr/apps/index">专题管理</a></li>      </ul>
			            </li>
			            
			           	<li class="dropdown" id="mobile">
			              <a href="#" class="dropdown-toggle" data-toggle="dropdown">手机专题 <b class="caret"></b></a>
			              <ul class="dropdown-menu">
			              	<li><a href="<%=request.getContextPath()%>/mgr/mobile/index">专题管理</a></li>
			              </ul>
			            </li>

			            <li class="dropdown" id="website">
			              <a href="#" class="dropdown-toggle" data-toggle="dropdown">门户网站管理 <b class="caret"></b></a>
			              <ul class="dropdown-menu">
			                <li><a href="<%=request.getContextPath()%>/mgr/website/index">门户管理</a></li>
			              </ul>
			            </li>
			          </ul>
			          
			          <ul class="nav pull-right">
			          	<li class="divider-vertical"></li>
			          	<li class="dropdown">
			          		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user icon-black"></i>欢迎您<b class="caret"></b></a>
			          		<ul class="dropdown-menu nav-list">
				                <li><a href="#"><i class="icon-cog"></i>个人资料设置</a></li>
				                <li><a href="#"><i class="icon-envelope"></i>通知中心</a></li>
				              </ul>
			          	</li>
			          	<li class="divider-vertical"></li>
			            <li><a href="<c:url value='/mgr/logout'/>" title="Sign Out">安全退出</a></li>
			          </ul>
			        </div>
				</div>
			</div>
		</div>
		<div class="container">
			<decorator:body />
			<!-- End Main Content -->
			<hr />
			<footer>
				<p>© WeiXin LTD. 2012</p>
			</footer>
		</div>
		<script type="text/javascript">
			$('.dropdown-toggle').dropdown();
		</script>
	</body>
</html>