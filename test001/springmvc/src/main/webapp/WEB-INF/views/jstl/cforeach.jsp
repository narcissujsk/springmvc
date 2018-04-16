<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

	<head>
		<title>cout</title>
	</head>

	<body>

		<P>The time on the server is ${serverTime}.</P>
		<c:forEach var="i" begin="1" end="5">
			Item
			<c:out value="${i}" />
			<p>
		</c:forEach>
		<c:forEach var="user" items="${users}">
			userid
			<c:out value="${user.id}" /> &nbsp &nbsp &nbsp &nbsp username
			<c:out value="${user.name}" />
			</br>
		</c:forEach>

		<c:forTokens items="google,runoob,taobao" delims="," var="name">
			<c:out value="${name}" />
			<p>
		</c:forTokens>
	</body>
	<script type="text/javascript">
		console.info('${userlist}');
		users = eval('${userlist}');
		console.info(users);
		for(var i in users) {
			console.info(users[i]);
		}
		
		users.forEach(function(user,i){
				console.info(i+" "+user.id+" "+user.name);
		})
		
	</script>

</html>