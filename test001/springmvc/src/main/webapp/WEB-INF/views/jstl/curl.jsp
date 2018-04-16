<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<title>c:forTokens 标签实例</title>
	</head>

	<body>
		<P>The time on the server is ${serverTime}.</P>
		<h1>&lt;c:param&gt; 实例</h1>
		<c:url var="myURL" value="main.jsp">
			<c:param name="name" value="Runoob" />
			<c:param name="url" value="www.runoob.com" />
		</c:url>
		<a href="/<c:out value=" ${myURL} "/>">
			使用 &lt;c:param&gt; 为指定URL发送两个参数。</a>
	</body>

</html>