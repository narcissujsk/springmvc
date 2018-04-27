<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/web/inc.jsp"></jsp:include>
<!DOCTYPE html>
<html>

	<head>
		<title>Bootstrap 实例 - 嵌套列</title>
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
		<div class="container ">
			<div class="h1">Bootstrap标题一</div>
			<div class="h2">Bootstrap标题二</div>
			<div class="h3">Bootstrap标题三</div>
			<div class="h4">Bootstrap标题四</div>
			<div class="h5">Bootstrap标题五</div>
			<div class="h6">Bootstrap标题六</div>
		</div>
	</body>

</html>