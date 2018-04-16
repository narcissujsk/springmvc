<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<title>c:set 标签实例</title>
	</head>
	<script type="text/javascript">
		console.info('${userlist}');
		var obj = eval('${userlist}');
		console.info('obj is '+obj);
		console.info('obj is '+obj[0].id);
	</script>

	<body>
		<c:set var="salary" scope="session" value="${2000*2}" />
		<c:set var="serverTime" value=" time by cset 20:00" />
		<c:out value="${salary}" />
		<c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>
		<c:out value="${userlist}" escapeXml="false">userlist is null</c:out>
		<br/>

		<c:out value="${obj}" escapeXml="false">obj is null</c:out>
		<br/>
		<P>The time on the server is ${serverTime}.</P>
		<P>user is ${user}.</P>
		<P>user2 is ${user2}.</P>
	</body>

</html>