<%@ page language="java" import="java.util.*,model.Task" pageEncoding="UTF-8"
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


	<%
		ArrayList<Task> tList = (ArrayList<Task>) request
				.getAttribute("tList");
		HttpSession ses = request.getSession();
		ses.setAttribute("tList", tList);
	%>
	
	
	<%@include file="/back_end_header.jsp"%>

	<article class="HR_panel shadow_a" id="panel">
		<header class="HR_title">
			Plans for
			<%=user.getuName()%></header>
		<section class="member_div shadow_c">
			<iframe src="Stf/plan_list.jsp" height="497px" width="720px"
				frameborder="0" id="member_list"></iframe>
		</section>
		<section class="op_div">
			<input type="search" class="search">
			<button class="search_button">S</button>
			<button class="addMember" onclick="showAddPanel()">New</button>
		</section>
	</article>



	<div class="above_div" id="add_above" hidden onclick="hidAddPanel()">
		<section class="above_panel shadow_b" onmouseout="mOut()"
			onmouseover="mIn()">
			<form action="stf/NewPlan" method="post">
				<table class="newTask">
					<tr>
						<td class="newTaskTd">任务名称：</td>
						<td><input type="text" name="planName" placeholder="如：任务一">
						</td>
					</tr>
					<tr>
						<td class="newTaskTd">描述：</td>
						<td><textarea name="planDescription"></textarea>
						</td>
					</tr>
					<tr>
						<td class="newTaskTd">所属任务：</td>
						<td><select name="taskId">
								<%
									for (int i = 0; i < tList.size(); i++) {
									Task task = tList.get(i);
								%><option><%=task.gettId()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td class="newTaskTd">开始日期：</td>
						<td><input type="date" name="planBeginDate">
						</td>
					</tr>
					<tr>
						<td class="newTaskTd">结束日期：</td>
						<td><input type="date" name="planEndDate">
						</td>
					</tr>
				</table>
				<button class="newTask_button" type="submit">New task</button>
			</form>
		</section>
	</div>

</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
