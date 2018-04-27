<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/web/inc.jsp"></jsp:include>
<html>


<body>
	<div id="tabchartContent2" style="display: none" class="datalist-wrap">
		<table class="table table-hover " id="inhostIpmiTable" width="100%">
			<thead>
				<tr>
					<th width="25%">传感器名称</th>
					<th width="25%">监控时间</th>
					<th width="25%">指标值</th>
					<th width="25%">传感器状态</th>
				</tr>
			</thead>
		</table>
	</div>

	<table id="table_id_example" class="display">
		<thead>
			<tr>
				<th>Column 1</th>
				<th>Column 2</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Row 1 Data 1</td>
				<td>Row 1 Data 2</td>
			</tr>
			<tr>
				<td>Row 2 Data 1</td>
				<td>Row 2 Data 2</td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id_example').DataTable();
		});
	</script>
</body>

</html>