<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

	<head>
		<title>catch</title>
	</head>
	<P>The time on the server is ${serverTime}.</P>
	<c:catch var="catchException">
		<% int x = 5/0;%>
	</c:catch>

	<c:if test="${catchException != null}">
		<p>异常为 : ${catchException} <br /> 发生了异常: ${catchException.message}</p>
	</c:if>
	<script type="text/javascript">
		console.info('${userlist}');
	</script>

</html>