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
				<td class="list_mem_name"><span>ID</span><label>姓名</label><span>职务</span><span>性别</span><span>手机</span>
				</td>
				<td class="op_span">操作</td>
			</tr>
			<%for (int i=0; i<15; i++) { %>
			<tr class="list_tr">
				<td class="list_mem_name" onclick="getArticle()"><span>1011610410</span><label>李哲浩</label>
					<span>C-level</span><span>男</span><span>13752130586</span>
				</td>
				<td class="del_button">...</td>
			</tr><%} %>
		</section>
	</table>
</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
