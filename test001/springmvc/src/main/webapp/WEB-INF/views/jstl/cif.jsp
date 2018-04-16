<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<title>c:if 标签实例</title>
	</head>
	<P>The time on the server is ${serverTime}.</P>

	<body>
		<c:set var="salary" scope="session" value="${1000*2}" />
		<c:if test="${salary > 2000}">
			<p>我的工资为:
				<c:out value="${salary}" />
				<p>
		</c:if>
	</body>
	<script>
	</script>

</html>