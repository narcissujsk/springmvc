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

		<div class="box">
			<pre>
 @Name：layer-v<script>document.write(layer.v)</script> 弹层组件说明
 @Author：jsk
 @Site：<a href="http://layer.layui.com/"  target="_blank">http://layer.layui.com/</a>


<strong>【注意事项】</strong>
一、使用时，请把文件夹layer整个放置在您站点的任何一个目录，只需引入layer.js即可，除jQuery外，其它文件无需再引入。
二、如果您的js引入是通过合并处理或者您不想采用layer自动获取的绝对路径，您可以通过layer.config()来配置（详见官网API页）
三、jquery需1.8+
四、更多使用说明与演示，请参见layer官网。
五、使用时请务必保留来源，请勿用于违反我国法律法规的web平台。
六、layer遵循MIT开源协议，将永久性提供无偿服务。
</pre>
		</div>

		<div class="box" style="text-align:center">
			<a href="http://layer.layui.com/" target="_blank">更多示例</a>
			<a href="http://www.layui.com/doc/modules/layer.html" target="_blank">使用文档</a>
			<a href="http://fly.layui.com/" id="suggest">交流反馈</a>
			<a href="javascript:;" id="about">关于</a>
		</div>

		<script>
			;
			! function() {

				//页面一打开就执行，放入ready是为了layer所需配件（css、扩展模块）加载完毕
				layer.ready(function() {
					layer.open({
						type: 2,
						title: '欢迎页',
						maxmin: true,
						area: ['800px', '500px'],
						content: 'http://layer.layui.com/test/welcome.html',
						end: function() {
							layer.tips('Hi', '#about', {
								tips: 1
							})
						}
					});
				});

				//关于
				$('#about').on('click', function() {
					layer.alert(layer.v + '--layer.v');
				});

			}();
		</script>

	</body>

</html>