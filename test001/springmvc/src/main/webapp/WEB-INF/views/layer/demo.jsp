<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

	<head>
		<title>Home</title>
		<script src="${pageContext.request.contextPath}/js/JQuery/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
	</head>

	<body>
		<h1>
	Hello world!  
	</h1>

		<P> The time on the server is ${serverTime}. </P>

		<button id="test1" class="btn">弹出一个提示层</button></br>

		<button id="test2" class="layui-btn">弹出一个页面层</button></br>

		<button id="parentIframe" class="btn">弹出一个iframe层</button></br>

		<button id="test4" class="btn">弹出一个loading层</button></br>

		<button id="test5" class="btn">弹出一个tips层</button></br>
		<script>
			; //弹出一个提示层
			$('#test1').on('click', function() {
				layer.msg('hello');
			});

			//弹出一个页面层
			$('#test2').on('click', function() {
				layer.open({
					type: 1,
					area: ['600px', '360px'],
					shadeClose: true, //点击遮罩关闭
					content: '\<\div style="padding:20px;">自定义内容\<\/div>'
				});
			});

			//弹出一个iframe层
			$('#parentIframe').on('click', function() {
				layer.open({
					type: 2,
					title: 'iframe父子操作',
					maxmin: true,
					shadeClose: true, //点击遮罩关闭层
					area: ['800px', '520px'],
					content: "${pageContext.request.contextPath}/web/layer.jsp"
				});
			});

			//弹出一个loading层
			$('#test4').on('click', function() {
				var ii = layer.load();
				//此处用setTimeout演示ajax的回调
				setTimeout(function() {
					layer.close(ii);
				}, 1000);
			});

			//弹出一个tips层
			$('#test5').on('click', function() {
				layer.tips('Hello tips!', '#test5');
			});
		</script>

	</body>

</html>