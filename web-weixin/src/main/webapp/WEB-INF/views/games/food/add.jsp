<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="huake" uri="http://www.huake.com/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>添加美食资料</title>
<script type="text/javascript"
	src="<c:url value="/resources/bak/date/My97DatePicker/My97DatePicker/WdatePicker.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.uploadify.v2.1.4.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/swfobject.js" />"></script>

<script type="text/javascript" src="${ctx}/resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/uploadify.css" /> " type="text/css"></link>
</head>

<body>
	<div class="page-header">
		<h2>添加美食资料</h2>
	</div>
	<form:form modelAttribute="food" method="post" id="form" cssClass="form-horizontal" action="${ctx}/mgr/weixin/food/${food.id==null?'save':'update' }" >
<%-- 		<jsp:include page="../common/alert-error.jsp" /> --%>
		<form:hidden path="id" name="id" />
		
		<div
			class="control-group <huake:hasBindFieldError name="food" field="name">error</huake:hasBindFieldError>">
			<label for="name" class="control-label">商家名称</label>
			<div class="controls">
				<form:input path="name" name="name" cssClass="input-xxlarge" value="${food.name}" placeholder="渔人码头"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="food" field="address">error</huake:hasBindFieldError>">
			<label for="address" class="control-label">地点</label>
			<div class="controls">
				<form:input path="address" name="address" cssClass="input-xxlarge" value="${food.address}" placeholder="宝龙城市广场"/>
			</div>
		</div>		
		
		<div class="control-group <huake:hasBindFieldError name="food" field="discount">error</huake:hasBindFieldError>">
			<label for="discount" class="control-label">优惠描述</label>
			<div class="controls">
				<form:input path="discount" name="discount" cssClass="input-xxlarge" value="${food.discount}" placeholder="菜金7.8折"/>
			</div>
		</div>	
		
		<div class="control-group <huake:hasBindFieldError name="food" field="foodRecommend">error</huake:hasBindFieldError>">
			<label for="foodRecommend" class="control-label">美食推荐</label>
			<div class="controls">
				<form:input path="foodRecommend" name="foodRecommend" cssClass="input-xxlarge" value="${food.foodRecommend}" placeholder="全场锅类5折"/>
			</div>
		</div>
		
		<div class="control-group <huake:hasBindFieldError name="food" field="rating">error</huake:hasBindFieldError>">
			<label for="rating" class="control-label">评分</label>
			<div class="controls">
				<form:input path="rating" name="rating" cssClass="input-xxlarge" value="${food.rating}" placeholder="10"/>
			</div>
		</div>	
		
		<div
			class="control-group <huake:hasBindFieldError name="food" field="startDate">error</huake:hasBindFieldError>">
			<label for="startDate" class="control-label">活动开始日期</label>
			<div class="controls">
				<form:input path="startDate" name="startDate" cssClass="input-small" size="10" 
				onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" value="${food.startDate}" placeholder="2012-02-14"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="food" field="overDate">error</huake:hasBindFieldError>">
			<label for="overDate" class="control-label">活动结束日期</label>
			<div class="controls">
				<form:input path="overDate" name="overDate" cssClass="input-small" size="10" 
				onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" value="${food.overDate}" placeholder="2012-02-14"/>
			</div>
		</div>
		
		
		<div class="control-group <huake:hasBindFieldError name="food" field="thumbail">error</huake:hasBindFieldError>">
			<label for=thumbail class="control-label">缩略图</label>
			<div class="controls">
				<form:input type="file" path="thumbail" name="thumbail" cssClass="input-xxlarge" value="${food.thumbail}"/>
				<span style="color: green;">* 建议上传图片大小为120 * 80</span>
				
				<form:hidden path="thumbail"/>
	  			<c:if test="${food.thumbail != null && food.thumbail != ''}">
	  				<div id="thumbail">
						<img alt="${food.address }" src="<c:url value="${food.thumbail }" />">  				
	  				</div>
	  			</c:if>
				
			</div>
		</div>
		<div class="control-group <huake:hasBindFieldError name="food" field="largeThumbail">error</huake:hasBindFieldError>">
			<label for="largeThumbail" class="control-label">缩略图</label>
			<div class="controls">
				<form:input type="file" path="largeThumbail" name="largeThumbail" cssClass="input-xxlarge" value="${food.largeThumbail}" />
				<span style="color: green;">* 建议上传图片大小为325 * 200</span>
				
				<form:hidden path="largeThumbail"/>
	  			<c:if test="${food.largeThumbail != null && food.largeThumbail != ''}">
	  				<div id="largeThumbail">
						<img alt="${food.address }" src="<c:url value="${food.largeThumbail }" />">  				
	  				</div>
	  			</c:if>
				
			</div>
		</div>
		
		<div class="control-group <huake:hasBindFieldError name="food" field="discountRules">error</huake:hasBindFieldError>">
			<label for="discountRules" class="control-label">优惠细则</label>
			<div class="controls">
				<form:textarea path="discountRules" name="discountRules"  value="${food.discountRules}" rows="5" cols="100" cssClass="textarea input-xxlarge" placeholder=""/>
			</div>
		</div>
		

		<div class="form-actions">
				<c:choose>
		         	<c:when test="${food.id==null }">
		           		<button type="submit" class="btn btn-primary">保存</button>
		         	</c:when>
		         	<c:otherwise>
		           		<button type="submit" class="btn btn-primary">修改</button>
		         	</c:otherwise>
		        </c:choose>
			<a href="<%=request.getContextPath()%>/mgr/weixin/food/index" class="btn">返回</a>
		</div>
	</form:form>

	<script type="text/javascript">
		$(function() {
			$.metadata.setType("attr", "validate");
			var validate;

			//foods_poster_upload($("#upload"),$("#status"));
			validate = $("#form")
					.validate(
							{
								ignore : ".ignore",
								errorClass : 'help-inline',
								errorHandler : function(error, element) {
									element.parent("div").parent("div")
											.addClass("error");
								},
								success : function(label) {
									if (label.attr("for") == "imdb") {
										label
												.html('<img src="<c:url value="/resources/img/checked.gif" />"/>');

									}
									label.parent("div").parent("div")
											.removeClass("error");

								},
								rules : {
									director : 'required',
									actor : 'required',
									summary : 'required',
									focus : 'required',
									duration : {
										required : true,
										digits : true,
									},
									pubDate : 'required',
									name : 'required',

								},
								messages : {
									imdb : {
										required : '请输入编号',
										remote : '<img src="<c:url value="/resources/img/unchecked.gif" />"/><span class="error">编号已经存在</span>'
									},
									director : "请输入导演名",
									actor : "请输入演员",
									summary : "请输入简介",
									focus : "请输入看点",
									duration : {
										required : "请输入时长",
									},

									pubDate : "请输入上映日期",
									name : "请输入电影名称",
								},

							});

		});
	</script>
</body>
</html>
