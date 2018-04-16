<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/web/inc.jsp"></jsp:include>
<html>

<head>
	<title>Home</title>
</head>

<body>
	<h1>Hello world!</h1>

	<P> The time on the server is ${serverTime}. </P>
	<P> The users ${userlist}. </P>
	<script type="text/javascript">
		$.ajax({
			url: '${pageContext.request.contextPath}' + "/users",
			type: "post",
			dataType: 'json',
			async: false,
			data: {
				id: "1",
				name: "name"
			},
			success: function(json) {
				if(json != null) {
					console.info(json);
					json.forEach(function(user, i) {
						console.info(user.id + "-----" + user.name + "----" + i);
					});
					users = json;
				}
			},
			error: function() {

			}
		});
	</script>

	<c:forEach var="user" items="${users}">
		userid
		<c:out value="${user.id}" /> &nbsp &nbsp &nbsp &nbsp username
		<c:out value="${user.name}" />
		</br>
	</c:forEach>
</body>

</html>