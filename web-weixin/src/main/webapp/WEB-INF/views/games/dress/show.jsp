<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="huake" uri="http://www.huake.com/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>服饰详细信息</title>
</head>
<body>
	<div class="page-header">
		<h2>#${dress.id}-服饰详细信息</h2>
	</div>

	<table class="table table-bordered table-striped">
		<tbody>
		
			<tr>
				<td>商家名称</td>
				<td>${dress.name }</td>
			</tr>
			
			<tr>
				<td>地址</td>
				<td>${dress.address }</td>
			</tr>
			
			
			<tr>
				<td>优惠描述</td>
				<td>${dress.discount }</td>
			</tr>
			
			<tr>
				<td>活动开始日期</td>
				<td>${dress.startDate} </td>
			</tr>
			
			<tr>
				<td>活动结束日期</td>
				<td>${dress.overDate }</td>
			</tr>
			
			<tr>
				<td>服饰推荐</td>
				<td>${dress.dressRecommend }</td>
			</tr>
			
			<tr>
				<td>评分</td>
				<td>${dress.rating }</td>
			</tr>	
			
			<tr>
				<td>优惠细则</td>
				<td>${dress.discountRules }</td>
			</tr>

			
		</tbody>
	</table>
	<div class="form-actions">
		<a href="<%=request.getContextPath()%>/mgr/weixin/dress/index" class="btn">返回</a>
    </div>
    		<script type="text/javascript">
		$(document).ready(function(){
			$("#dress").addClass("active");
		});
	</script> 
</body>
</html>