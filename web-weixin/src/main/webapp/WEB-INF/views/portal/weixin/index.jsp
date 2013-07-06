<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="huake" uri="http://www.huake.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<title>赛事对阵详情</title>
	<style type="text/css">
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {padding: 0;margin: 0; }
		ul li{ list-style:none;}
		table {border-collapse: collapse;border-spacing: 0;}
		body { font-family: 微软雅黑, Verdana, sans-serif;}
		.fl{ float:left;} .fr{ float:right;}.clear{ clear:both;}.pd10{ padding:0 10px}
		a{text-decoration:none;}
		.container{ height:auto; overflow:hidden;}
		.logo img{ width:100%;}
		.title{ height:36px;font-size:18px;color: #838282; font-weight:bold; line-height:36px; text-align:center;} 
		.space{ height:auto; overflow:hidden;}
		.time{ height:26px; line-height:26px; background:#dde3ef; font-size:16px;}
		.itinerary{ height:auto; overflow:hidden;  border-bottom:1px solid #CCCCCC; padding:10px 10px;}
		.itinerary dl{ width:20%; text-align:center;line-height:30px;}
		.itinerary dl dt{ color:#6db013;}
		.itinerary dl dd{color:#969696;}
		.itinerary table { text-align:center;}
		.itinerary table tr { line-height:30px;}
		.itinerary table tr td i{ font-style:normal;color:#969696;}
		.color_red{ color:#FF0000;}
		/* .footer	{ height:auto; overflow:hidden;} */	
		.copyRight{font-size: 7px;letter-spacing: 0px;text-align:center;color: #cccccc;}
		/* .footer ul li{padding:0 5px;line-height:20px; text-align:center; font-size:14px;} */
		li a{ color:#CCCCCC;}
		li.last{border-bottom:none;}
		ul{margin:5px 0;}
		.hr{ background:url(<c:url value="/resources/img/hr.png"/>) repeat-x left  bottom;}
		#baidu{display:none;}
		.footer	{ height:auto; overflow:hidden; color:#0088CC; font-size:12px; line-height:30px;}	
		.footer ul li{padding:0 5px;line-height:20px; text-align:center;}
		.footer ul li span{ color:#000000;font-size:10px;}
	</style>
</head>
<body>
	<div class="logo"><img src= "${ctx}/resources/img/yqkan_header.png" /></div>
	<div class="title"> ${game.name } </div>
	<div class="space hr">
		<c:forEach items="${playDates }" var="date">
			<div class="time"> 
				<span class="date pd10">${date.key }</span><span class="day">${date.value }</span> 
			</div>
			<c:forEach items="${gamePlays }" var="play">
				<c:if test="${play.playDate == date.key }">
					<div class="itinerary pd10">
						<dl class="fl">
							<dt>${play.playTimeStr }</dt>
							<dd>${play.category }</dd>
						</dl>
						<table width="80%" class="fr">
							<tr>
								<td width="47%">${play.homeTeam }</td>
								<td width="6%"><i>vs</i></td>
								<td width="47%">${play.guestTeam }</td>
							</tr>
							<tr class="color_red">
								<td width="47%">${play.scoreHome }</td>
								<td width="6%"></td>
								<td width="47%">${play.scoreGuest }</td>
							</tr>
						</table>
						<div class="clear"></div>
					</div>
				</c:if>
			</c:forEach>
		</c:forEach>
	</div>
	<div class="footer">
		<ul>
			<li><span>一起看官网：</span><a href="http://www.yqkan.cn" target="_blank">http://www.yqkan.cn</a></li>
			<li><span>新浪微博：</span><a href="http://weibo.com/u/2823672984">http://weibo.com/u/2823672984</a></li>   
		</ul>
	</div>
	<div id="baidu">
		<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Feb4498e9424feed6edb981a4c4e57a01' type='text/javascript'%3E%3C/script%3E"));
			$(document).ready(function(){
				$(".itinerary").last().css("border-bottom", "none");
			});
		</script>
	</div>
</body>
</html>