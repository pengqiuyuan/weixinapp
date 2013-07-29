<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.huake.com/functions" prefix="huake" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>美食管理</title>
	</head>

<body>
<script type="text/javascript" src=" />"></script>
		<div class="page-header">
    		<h2>美食管理</h2>
  		</div>
		<form:form id="queryForm" class="well form-search" method="get"  modelAttribute="foodCondtions"  actioin="${ctx}/mgr/weixin/food/index">
				<label>商家名称:</label>
				<form:input path="name" type="text" cssClass="input-small" /> 
<%-- 				<label>上映开始日期:</label>
				<form:input type="text" path="startDate" class="input-small Wdate" size="12" onClick="WdatePicker()" />
				<label>上映结束日期:</label>
				<form:input type="text" path="endDate" class=" input-small Wdate" size="12" onClick="WdatePicker()" /> --%>
				<input type="submit" class="btn" value="查 找" />
		</form:form>
		
		<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
					    <th title="动作">操作</th>
						<th title="影片名称">商家名称</th>
						<th title="放映地点">地点</th>
						<th title="本片导演">美食推荐</th>				
						<th title="上映日期">活动日期</th>
					</tr>
				</thead>
			    <tbody>
    				<c:forEach items="${page.result }" var="item">  
    			    <tr>
    			    <td>
						<div class="btn-group">
							<a class="btn" href="#">#${item.id}</a>
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							    <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
					            <li><a href="<%=request.getContextPath()%>/mgr/weixin/food/${item.id }/edit"><i class="icon-edit"></i>修改</a></li>
					            <li><a href="<%=request.getContextPath()%>/mgr/weixin/food/${item.id }/delete"><i class="icon-trash"></i>删除</a></li>
					            <li><a href="<%=request.getContextPath()%>/mgr/weixin/food/${item.id }/get"><i class="icon-th"></i>详情</a></li>
					            <li class="divider"></li>
					          </ul>
						</div>	
					</td>
        			<td title="${item.name}"><c:out value="${item.name}"/></td>
        			<td title="${item.address}"><c:out value="${item.address}"/></td>
        			<td title="${item.foodRecommend}"><c:out value="${item.foodRecommend}"/></td>   
        			<td><fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd"/></td>  
    			    </tr>  
    		        </c:forEach>  
		       </tbody>
		</table>
		    
		<form:form id="pageForm" method="get" modelAttribute="page" >
			<form:hidden path="pageNo" id="pageNo"/>
			<div class="pagination">
		        <ul>
		          <li class="disabled"><a href="#">第${page.pageNo}页, 共${page.totalPages}页</a></li>
		          <li><a href="javascript:jumpPage(1)">首页</a></li>
		          <li><a href="javascript:jumpPage(${page.prePage})">上一页</a></li>
		          <li><a href="javascript:jumpPage(${page.nextPage})">下一页</a></li>
		          <li><a href="javascript:jumpPage(${page.totalPages})">末页</a></li>
		        </ul>
		      </div>
		</form:form>
		<div class="form-actions">
			<a href="<%=request.getContextPath()%>/mgr/weixin/food/add" class="btn btn-primary">添加美食资料</a>
			<a href="<%=request.getContextPath()%>/mgr/foods/douban/index" class="btn btn-info">从豆瓣导入影片资料</a>
		</div>

	<script type="text/javascript">
	function jumpPage(pageNo){
		$("#pageNo").val(pageNo);
		$("#pageForm").submit();
		}
		$(document).ready(function(){
			$("#food").addClass("active");
		});
		$(document).ready(function(){
			$("#foods").addClass("active");
			$(".inbox").click(function(){
				
				$("#foodName").html($(this).attr("title"));
				$('#confirmInbox').modal('toggle');
			});
		});
	</script>
</body>
</html>