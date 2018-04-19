<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

	<head>
		<title>Home</title>
	</head>

	<body>
		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>
	</body>
	<script data-main="${pageContext.request.contextPath}/js/other/a" id="require" src="${pageContext.request.contextPath}/js/require.js" defer async="true">
	
	
	</script>
	</body>

</html>