<%@ page language="java" import="java.util.*,model.Task;"
	pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
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
		<%
			HttpSession se = request.getSession();
			ArrayList<Task> tList = (ArrayList<Task>) se.getAttribute("tList");

			ArrayList<String> mgrList = (ArrayList<String>) se
					.getAttribute("mgrList");
		%>
		<section>
			<tr class="list_header">
				<td class="task_th">未实施</td>
				<td class="task_th">实施中</td>
				<td class="task_th">以完成</td>
			</tr>
			<div class="task_div">

				<%
					for (int i = 0; i < tList.size(); i++) {
						Task task = tList.get(i);
						if ("未实施".equals(task.gettStatus())) {
				%>


				<!-- 1 -->

				<section class="task_box1 shadow_a" id="task<%=task.gettId()%>">
					<form action="mgr/UpdateTask?tId=<%=task.gettId()%>" method="post"
						id="updateTask">
						<label class="hidden_over_b"
							onclick="showUpdatePanela(<%=task.gettId()%>)"><%=task.gettName()%></label>
						<p class="hidden_over_a"><%=task.gettDescription()%></p>
						<aside><%=task.gettEndDate()%></aside>
				</section>

				<section class="task_boxa shadow_a" id="taska<%=task.gettId()%>"
					hidden onmouseout="mOut()" onmouseover="mIn()">
					<input type="text" class="hidden_over_b"
						value="<%=task.gettName()%>" name="taskName">
					<textarea class="hidden_over_a" name="taskDescription"><%=task.gettDescription()%></textarea>
					<select name="user_uMgr">
						<%
							for (int j = 0; j < mgrList.size() - 1; j++) {
						%><option><%=mgrList.get(j)%></option>
						<%
							}
						%>
					</select>
					<button type="submit" onclick="goSubmit()">Update</button>
					<aside><%=task.gettBeginDate()%>
						—
						<%=task.gettEndDate()%></aside>
					</form>
				</section>



				<%
					} else if ("实施中".equals(task.gettStatus())) {
				%>

				<!-- 2 -->

				<section class="task_box2 shadow_a" id="task<%=task.gettId()%>">
					<label class="hidden_over_b"
						onclick="showUpdatePanela(<%=task.gettId()%>)"><%=task.gettName()%></label>
					<button
						onclick="taskDone(<%=task.gettId()%>,'<%=task.gettName()%>')"></button>
					<p class="hidden_over_a"><%=task.gettDescription()%></p>
					<aside><%=task.gettEndDate()%></aside>
				</section>

				<section class="task_boxb shadow_a" id="taska<%=task.gettId()%>"
					hidden onmouseout="mOut()" onmouseover="mIn()">
					<label class="hidden_over_b"><%=task.gettName()%></label>
					<button
						onclick="taskDone(<%=task.gettId()%>,'<%=task.gettName()%>')"></button>
					<p class="hidden_over_a"><%=task.gettDescription()%></p>
					<div>
						实施人：<%=task.getUser_uMgr()%></div>
					<div>
						<a href="stf/ShowPlanL?tId=<%=task.gettId()%>"><button
								class="plan_deti_button" type="button">Plans</button> </a>
					</div>
					<aside><%=task.gettBeginDate()%>
						—
						<%=task.gettEndDate()%></aside>
				</section>




				<%
					} else if ("已完成".equals(task.gettStatus())) {
				%>

				<!-- 3 -->

				<section class="task_box3 shadow_a" id="task<%=task.gettId()%>">
					<label class="hidden_over_b"
						onclick="showUpdatePanela(<%=task.gettId()%>)"><%=task.gettName()%></label>
					<button
						onclick="taskCollect(<%=task.gettId()%>,'<%=task.gettName()%>')"></button>
					<p class="hidden_over_a"><%=task.gettDescription()%></p>
					<aside><%=task.gettEndDate()%></aside>
				</section>

				<section class="task_boxc shadow_a" id="taska<%=task.gettId()%>"
					hidden onmouseout="mOut()" onmouseover="mIn()">
					<label class="hidden_over_b"><%=task.gettName()%></label>
					<button
						onclick="taskCollect(<%=task.gettId()%>,'<%=task.gettName()%>')"></button>
					<p class="hidden_over_a"><%=task.gettDescription()%></p>
					<div>
						实施人：<%=task.getUser_uMgr()%></div>
					<div>
						<a href="stf/ShowPlanL?tId=<%=task.gettId()%>"><button
								class="plan_deti_button" type="button">Plans</button> </a>
					</div>
					<aside><%=task.gettBeginDate()%>
						—
						<%=task.gettEndDate()%></aside>
				</section>
				<%
					}
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
