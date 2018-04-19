<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	
	<head>
		<title>Bootstrap 实例 - 嵌套列</title>
		<meta charset="utf-8">	
		<!-- 包含头部信息用于适应不同设备 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 包含 bootstrap 样式表 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
		<script src="${pageContext.request.contextPath}/js/jquery/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="container ">
			<h1>Hello, world!</h1>
			<div class="row">
				<div class="col-md-3 ">
					<h4>第一列</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
					<div class="row">
						<div class="col-md-3 jsk-box">33</div>
						<div class="col-md-9 jsk-box">99</div>
					</div>
				</div>

				<div class="col-md-9">
					<h4>第二列 - 分为四个盒子</h4>
					<div class="row">
						<div class="col-md-6 jsk-box">
							<p>Consectetur art party Tonx culpa semiotics. Pinterest assumenda minim organic quis.
							</p>
						</div>
						<div class="col-md-6 jsk-box">
							<p> sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
							</p>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6 jsk-box">
							<p>quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
							</p>
						</div>
						<div class="col-md-6 jsk-box">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>