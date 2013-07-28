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
<title>添加影片资料</title>
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
		<h2>添加影片资料</h2>
	</div>
	<form:form modelAttribute="movie" method="post" id="form" cssClass="form-horizontal" action="${ctx}/mgr/weixin/movie/${movie.id==null?'save':'update' }" >
<%-- 		<jsp:include page="../common/alert-error.jsp" /> --%>
		<form:hidden path="id" name="id" />
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="address">error</huake:hasBindFieldError>">
			<label for="address" class="control-label">地点</label>
			<div class="controls">
				<form:input path="address" name="address" cssClass="input-xxlarge" value="${movie.address}" placeholder="宝龙城市广场"/>
			</div>
		</div>		
		
		<div class="control-group <huake:hasBindFieldError name="movie" field="discount">error</huake:hasBindFieldError>">
			<label for="discount" class="control-label">优惠描述</label>
			<div class="controls">
				<form:input path="discount" name="discount" cssClass="input-xxlarge" value="${movie.discount}" placeholder="2D电影25元，3D电影30元(特殊影片需补足差价)"/>
			</div>
		</div>		
		
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="startDate">error</huake:hasBindFieldError>">
			<label for="startDate" class="control-label">活动开始日期</label>
			<div class="controls">
				<form:input path="startDate" name="startDate" cssClass="input-small" size="10" 
				onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" value="${movie.startDate}" placeholder="2012-02-14"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="overDate">error</huake:hasBindFieldError>">
			<label for="overDate" class="control-label">活动结束日期</label>
			<div class="controls">
				<form:input path="overDate" name="overDate" cssClass="input-small" size="10" 
				onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" value="${movie.overDate}" placeholder="2012-02-14"/>
			</div>
		</div>
		
		
		<div class="control-group <huake:hasBindFieldError name="movie" field="thumbail">error</huake:hasBindFieldError>">
			<label for=thumbail class="control-label">缩略图</label>
			<div class="controls">
				<form:input type="file" path="thumbail" name="thumbail" cssClass="input-xxlarge" value="${movie.thumbail}"/>
				<span style="color: green;">* 建议上传图片大小为120 * 80</span>
				
				<form:hidden path="thumbail"/>
	  			<c:if test="${movie.thumbail != null && movie.thumbail != ''}">
	  				<div id="thumbail">
						<img alt="${movie.address }" src="<c:url value="${movie.thumbail }" />">  				
	  				</div>
	  			</c:if>
				
			</div>
		</div>
		<div class="control-group <huake:hasBindFieldError name="movie" field="largeThumbail">error</huake:hasBindFieldError>">
			<label for="largeThumbail" class="control-label">缩略图</label>
			<div class="controls">
				<form:input type="file" path="largeThumbail" name="largeThumbail" cssClass="input-xxlarge" value="${movie.largeThumbail}" />
				<span style="color: green;">* 建议上传图片大小为325 * 200</span>
				
				<form:hidden path="largeThumbail"/>
	  			<c:if test="${movie.largeThumbail != null && movie.largeThumbail != ''}">
	  				<div id="largeThumbail">
						<img alt="${movie.address }" src="<c:url value="${movie.largeThumbail }" />">  				
	  				</div>
	  			</c:if>
				
			</div>
		</div>
		
		<div class="control-group <huake:hasBindFieldError name="movie" field="discountRules">error</huake:hasBindFieldError>">
			<label for="discountRules" class="control-label">优惠细则</label>
			<div class="controls">
				<form:textarea path="discountRules" name="discountRules"  value="${movie.discountRules}" rows="5" cols="100" cssClass="textarea input-xxlarge" placeholder="特殊场次(影展、首映式、见面会、动感电影等)与情人节、平安夜、圣诞节及法定节假日除外、每卡每天限购4张"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="name">error</huake:hasBindFieldError>">
			<label for="name" class="control-label">影片名称</label>
			<div class="controls">
				<form:input path="name" name="name" cssClass="input-xxlarge" value="${movie.name}" placeholder="碟中碟4"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="director">error</huake:hasBindFieldError>">
			<label for="director" class="control-label">导演</label>
			<div class="controls">
				<form:input path="director" name="director" cssClass="input-xxlarge" value="${movie.director}" placeholder="冯小刚"/>
			</div>
		</div>
 		<div
			class="control-group <huake:hasBindFieldError name="movie" field="actor">error</huake:hasBindFieldError>">
			<label for="actor" class="control-label">演员</label>
			<div class="controls">
				<form:input path="actor" name="actor" cssClass="input-xxlarge" value="${movie.actor}" placeholder="陶红"/>
				<p class="help-block">多个演员间以小写逗号(",")分割</p>
			</div>
		</div>
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="pubDate">error</huake:hasBindFieldError>">
			<label for="pubDate" class="control-label">上映日期</label>
			<div class="controls">
				<form:input path="pubDate" name="pubDate" cssClass="input-small" size="10" 
				onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" value="${movie.pubDate}" placeholder="2012-02-14"/>
			</div>
		</div>
		
		<div
			class="control-group <huake:hasBindFieldError name="movie" field="duration">error</huake:hasBindFieldError>">
			<label for="duration" class="control-label">时长</label>
			<div class="controls">
				<form:input path="duration" name="duration" cssClass="input-small" value="${movie.duration}" placeholder="120分钟"/>
			</div>
		</div>
		<div class="control-group <huake:hasBindFieldError name="movie" field="focus">error</huake:hasBindFieldError>">
			<label for="focus" class="control-label">看点</label>
			<div class="controls">
				<form:input path="focus" name="focus" cssClass="input-xxlarge" value="${movie.focus}" />
			</div>
		</div>

		<div class="control-group <huake:hasBindFieldError name="movie" field="language">error</huake:hasBindFieldError>">
			<label for="language" class="control-label">语言</label>
			<div class="controls">
				<form:input path="language" name="language" cssClass="input-xxlarge"  value="${movie.language}" placeholder="汉语普通话"/>
				<p class="help-block">多种语言间以小写逗号(",")分割</p>
			</div>
		</div>
		
		<div class="control-group <huake:hasBindFieldError name="movie" field="country">error</huake:hasBindFieldError>">
			<label for="country" class="control-label">国家/地区</label>
			<div class="controls">
				<form:input path="country" name="country" cssClass="input-xxlarge" value="${movie.country}" placeholder="中国大陆,香港"/>
				<p class="help-block">多个国家间以小写逗号(",")分割</p>
			</div>
		</div>
		
		<div class="control-group <huake:hasBindFieldError name="movie" field="type">error</huake:hasBindFieldError>">
			<label for="type" class="control-label">影片类型</label>
			<div class="controls">
				<form:input path="type" name="type" cssClass="input-xxlarge" value="${movie.type}" placeholder="言情,动作"/>
				<p class="help-block">多种类型间以小写逗号(",")分割</p>
			</div>
		</div>

		<div class="control-group <huake:hasBindFieldError name="movie" field="summary">error</huake:hasBindFieldError>">
			<label for="summary" class="control-label">简介</label>
			<div class="controls">
				<form:textarea path="summary" name="summary"  rows="5" cols="100" value="${movie.summary}" cssClass="textarea input-xxlarge" />
			</div>
		</div>

		<div class="form-actions">
				<c:choose>
		         	<c:when test="${movie.id==null }">
		           		<button type="submit" class="btn btn-primary">保存</button>
		         	</c:when>
		         	<c:otherwise>
		           		<button type="submit" class="btn btn-primary">修改</button>
		         	</c:otherwise>
		        </c:choose>
			<a href="<%=request.getContextPath()%>/mgr/weixin/movie/index" class="btn">返回</a>
		</div>
	</form:form>

	<script type="text/javascript">
		$(function() {
			$.metadata.setType("attr", "validate");
			var validate;

			//movies_poster_upload($("#upload"),$("#status"));
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
