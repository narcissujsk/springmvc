<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

	<head>
		<title>cout</title>
	</head>

	<body>
		<h1>Hello world! cout</h1>
		<h1>&lt;c:out&gt; 实例</h1>
		<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
		<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
		<c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>
		<c:out value="${userlist}" escapeXml="false">userlist is null</c:out>
		<br/>
		<c:out value="${userlist2}" escapeXml="false">userlist2 is null</c:out>
		<br/>
		<P>The time on the server is ${serverTime}.</P>
	</body>
<script type="text/javascript">
 	console.info('${userlist}');
</script>
</html>