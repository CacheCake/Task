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

<title>Task后台管理 - 主管</title>

<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style_b.css">

</head>

<body onload="panelHeight(1)" onresize="panelHeight(1)">
	<%@include file="/back_end_header.jsp"%>

	<article class="HR_panel shadow_a" id="panel">
		<header class="HR_title">
			Tasks for
			<%=user.getuName()%></header>
		<section class="member_div shadow_c">
			<iframe src="Mgr/task_list.jsp" height="497px" width="720px"
				frameborder="0" id="member_list"></iframe>
		</section>
		<section class="op_div">
			<input type="search" class="search">
			<button class="search_button">S</button>
			<button class="addMember" onclick="showAddPanel()">New</button>
		</section>
	</article>


	<div class="above_div" id="add_above" hidden onclick="hidAddPanel()">
		<%
			ArrayList<String> mgrList = (ArrayList<String>) request
					.getAttribute("mgrList");
		%>
		<section class="above_panel shadow_b" onmouseout="mOut()"
			onmouseover="mIn()">
			<form action="mgr/NewTask" method="post">
				<table class="newTask">
					<tr>
						<td class="newTaskTd">任务名称：</td>
						<td><input type="text" name="taskName" placeholder="如：任务一">
						</td>
					</tr>
					<tr>
						<td class="newTaskTd">描述：</td>
						<td><textarea name="taskDescription"></textarea></td>
					</tr>
					<tr>
						<td class="newTaskTd">实施人：</td>
						<td><select name="user_uMgr">
								<%
									for (int i = 0; i < mgrList.size() - 1; i++) {
								%><option><%=mgrList.get(i)%></option>
								<%
									}
								%>
						</select>
						</td>
					</tr>
					<tr>
						<td class="newTaskTd">开始日期：</td>
						<td><input type="date" name="taskBeginDate"></td>
					</tr>
					<tr>
						<td class="newTaskTd">结束日期：</td>
						<td><input type="date" name="taskEndDate"></td>
					</tr>
				</table>
				<button class="newTask_button" type="submit">New task</button>
			</form>
		</section>
	</div>

</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
