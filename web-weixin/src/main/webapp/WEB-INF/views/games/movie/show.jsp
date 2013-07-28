<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="huake" uri="http://www.huake.com/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>影片详细信息</title>
</head>
<body>
	<div class="page-header">
		<h2>#${movie.id}-影片详细信息</h2>
	</div>

	<table class="table table-bordered table-striped">
		<tbody>
			<tr>
				<td>影院地址</td>
				<td>${movie.address }</td>
			</tr>
			
			
			<tr>
				<td>优惠描述</td>
				<td>${movie.discount }</td>
			</tr>
			
			<tr>
				<td>活动开始日期</td>
				<td>${movie.startDate} </td>
			</tr>
			
			<tr>
				<td>活动结束日期</td>
				<td>${movie.overDate }</td>
			</tr>
			
			<tr>
				<td>优惠细则</td>
				<td>${movie.discountRules }</td>
			</tr>
			
			<tr>
				<td>影片名称</td>
				<td>${movie.name }</td>
			</tr>
			
			<tr>
				<td>导演</td>
				<td>${movie.director }</td>
			</tr>
			
			<tr>
				<td>演员</td>
				<td>${movie.actor }</td>
			</tr>
			
			<tr>
				<td>上映日期</td>
				<td>${movie.pubDate }</td>
			</tr>
			
			<tr>
				<td>时长</td>
				<td>${movie.duration }</td>
			</tr>
			
			<tr>
				<td>看点</td>
				<td>${movie.focus }</td>
			</tr>
			
			<tr>
				<td>语言</td>
				<td>${movie.language }</td>
			</tr>
			
			<tr>
				<td>国家/地区</td>
				<td>${movie.country }</td>
			</tr>
			
			<tr>
				<td>影片类型</td>
				<td>${movie.type }</td>
			</tr>
			
			<tr>
				<td>简介</td>
				<td>${movie.summary }</td>
			</tr>
			
		</tbody>
	</table>
	<div class="form-actions">
		<a href="<%=request.getContextPath()%>/mgr/weixin/movie/index" class="btn">返回</a>
    </div>
    		<script type="text/javascript">
		$(document).ready(function(){
			$("#movie").addClass("active");
		});
	</script> 
</body>
</html>