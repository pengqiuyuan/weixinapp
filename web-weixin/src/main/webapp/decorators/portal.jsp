<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>一起看－演出、电影、赛事、奥运</title>
	<meta name="keywords" content=""/>
	<meta name="description" content=""/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/portal.css" />"/>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<decorator:head/>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div class="toolbar" id="tbContainer">
				<div class="inner">
					<div class="toplink">
						<a href="#">您好，欢迎来到一起看票务网！请[登录][免费注册]</a>
						<span class="split"></span>
						<a href="#">我的订单</a>
						<span class="split"></span>
						<a href="#">手机版</a>
						<span class="split"></span>
						<a href="#">帮助中心</a>
					</div>
				</div>
			</div>
			<div id="logoContainer">
				<div class="inner clearfix">
					<h1 id="logo"><a href="#">一起看票务网</a></h1>
					<div id="cityContainer">
						<span class="city">福州</span>
						<a href="#" class="area mainbg ">切换城市</a>
					</div>
				</div>
			</div>
			<div id="navContainer">
				<div class="inner">
					<ul id="mainNav" class="clearfix">
						<li class="active"><a href="#" class="home">首页</a></li>
						<li class="split"></li>
						<li><a href="#" class="movie">电影</a></li>
						<li class="split"></li>
						<li><a href="#" class="movie">演出</a></li>
						<li class="split"></li>
						<li><a href="#" class="movie">赛事</a></li>
						<li class="split"></li>
						<li><a href="#" class="movie">奥运</a></li>
						<li class="split"></li>
						<li class="service"></li>
					</ul>
				</div>
			</div>

		</div>
		<div id="contentContainer">
			<decorator:body />
		</div>
	</div>
</body>
</html>
