<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name='viewport' content='width=device-width， initial-scale=1.0， minimum-scale=1.0， maximum-scale=1.0， user-scalable=no'>
	<title>无效页面</title>
	<style type="text/css">
		#baidu{display:none}
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {padding: 0;margin: 0;}
		body{ background:#f3f0ea;background: url(${ctx}/resources/img/no_plays.png) no-repeat center center;  background-attachment:fixed;}
        .logo img{width:100%;}
        .title{ height:36px;font-size:18px;color: #838282; font-weight:bold; line-height:36px; text-align:center;}
        .hr{ background:url(<c:url value="/resources/img/hr.png"/>) repeat-x left  top;}
		.copyRight{font-size: 7px;letter-spacing: 0px;text-align:center;color: #cccccc;}
		li a{ color:#CCCCCC;}
		li.last{border-bottom:none;}
		ul{margin:5px 0;}
		.footer	{ width:100%; height:auto; overflow:hidden; color:#0088CC; font-size:12px; line-height:30px;position:absolute; bottom:0; left:0;}	
		.footer ul li{padding:0 5px;line-height:20px; text-align:center;}
		.footer ul li span{ color:#000000;font-size:10px;}
	</style>
</head>
<body>
	<div class="logo"><img src= "${ctx}/resources/img/yqkan_header.png" /></div>
	<div class="title"> ${game.name } </div>
	<div class="footer hr">
		<ul>
			<li><span>一起看官网：</span><a href="http://www.yqkan.cn" target="_blank">http://www.yqkan.cn</a></li>
			<li><span>新浪微博：</span><a href="http://weibo.com/u/2823672984">http://weibo.com/u/2823672984</a></li>   
		</ul>
	</div>
	<div id="baidu">
		<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Feb4498e9424feed6edb981a4c4e57a01' type='text/javascript'%3E%3C/script%3E"));
		</script>
	</div>
</body>
</html>
