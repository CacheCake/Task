<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>Lolit后台管理 - HR</title>

<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style_b.css">

</head>

<body class="list_mem_bg">
	<table class="list_mem_table list_mar">
		<section>
			<tr class="list_header">
				<td class="task_th">未实施</td>
				<td class="task_th">实施中</td>
				<td class="task_th">以完成</td>
			</tr>
			<div class="task_div">
				<%
					for (int i = 0; i < 3; i++) {
				%>
				<section class="task_box1 shadow_a">123</section>
				<section class="task_box1 shadow_a">123</section>
				<section class="task_box3 shadow_a">123</section>
				<section class="task_box2 shadow_a">123</section>
				<%
					}
				%>
			</div>
		</section>
	</table>
</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
