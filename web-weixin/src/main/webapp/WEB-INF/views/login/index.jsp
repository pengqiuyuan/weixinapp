<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="cn">
<head>
	<title>管理登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="微信管理平台登录">
	<meta name="author" content="skylai">
	<!-- Le styles -->
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-responsive.css" />" rel="stylesheet">
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
	<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />">
	<style type="text/css">
	body {padding-top: 60px;padding-bottom: 40px;}
	</style>
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
					class="brand" href="#">"微信公众平台"后台管理系统</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="hero-unit">
				<div class="">
					<form class="form-horizontal" action="<c:url value='/mgr/login_check'/>" method="post">
						<fieldset>
							<legend>管理员登录</legend>
							<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message }">
								<div class="alert alert-error">
									登录未能成功, 请重试.<br /> 原因 :
									<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
								</div>
							</c:if>
							<div class="control-group">
								<label class="control-label" for="j_username">用户名：</label>
								<div class="controls">
									<input class="input-xlarge focused" name="j_username" id="j_username" type="text" value="">
									<span class="help-inline">请输入登录用户名.</span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="j_password">登录密码：</label>
								<div class="controls">
									<input class="input-xlarge" name="j_password" id="j_password" type="password" value="">
									<span class="help-inline">请输入登录密码.</span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="j_captcha">验证码：</label>
								<div class="controls">
									<input class="input-xlarge" name="j_captcha" id="j_captcha" type="text" value="">
									<span class="help-inline">请输入验证码.</span></p></p>
									<div class="control-group"> 
										<img id="captchaImg" src="<c:url value="/jcaptcha.jpg"/>" /> 
									</div>
								</div>
							</div>
							
							<div class="control-group">
								<div class="controls">
									<input class="input-xlarge" name="_spring_security_remember_me" id="_spring_security_remember_me" type="checkbox" value="">
									两周内记住我
									<span style="margin-left: 25px">
										<a href="javascript:refreshCaptcha()">看不清楚换一张</a>    
                                    </span>
								</div>
							</div>
							<div class="form-actions">
								<button type="submit" class="btn btn-primary">确定登录</button>
							</div>
						</fieldset>
					</form>
				</div>
		</div>
		<hr />
		<footer>
			<p>© Company 2013</p>
		</footer>
	</div>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript">  
		function refreshCaptcha() {  
   			 $('#captchaImg').hide().attr(  
            		'src',  
           			'<c:url value="/jcaptcha.jpg"/>' + '?' + Math  
                    		.floor(Math.random() * 100)).fadeIn();  
		}  
	</script>  
</body>
</html>