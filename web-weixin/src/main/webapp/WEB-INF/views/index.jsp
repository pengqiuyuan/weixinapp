<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>控制台面板</title>
</head>

<body>
	<h2>
		<a href="<c:url value="/" />">admin dasboard</a>
	</h2>
	<script type="text/javascript">
	$(document).ready(function(){
			$("#dashboard").addClass("active");
	});
	</script>
</body>
</html>