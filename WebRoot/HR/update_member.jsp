<%@ page language="java" import="java.util.*,model.User"
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

<body onload="panelHeight(2)" onresize="panelHeight(2)">
	<%@include file="/back_end_header.jsp"%>
	<%
		ArrayList<User> userList = (ArrayList<User>) request
				.getAttribute("uList");
		ArrayList<String> mgrList = (ArrayList<String>) request
				.getAttribute("mgrList");
		User u = userList.get(0);
	%>
	<article class="HR_panel shadow_a" id="panel">
		<form action="hr/UpdateMember?uId=<%=u.getuId()%>" method="post">
			<header class="HR_title">HR - Update member</header>
			<section class="new_mem_table shadow_c" id="member_list">

				<div id="paper">
					<table>
						<tr>
							<td><label>姓名：</label>
							</td>
							<td colspan="3"><span><%=u.getuName()%></span>
							</td>
							<td><label>权限：</label>
							</td>
							<td colspan="3"><span><%=u.getuRole()%></span>
							</td>
						</tr>
						<tr>
							<td><label>ID：</label>
							</td>
							<td colspan="7"><span><%=u.getuId()%></span>
							</td>
						</tr>
						<tr>
							<td><label>职务：</label>
							</td>
							<td><span><%=u.getuPosition()%></span>
							</td>
							<td><label>性别：</label>
							</td>
							<td><span><%=u.getuGender()%></span>
							</td>
							<td><label>用户专业：</label>
							</td>
							<td colspan="3"><span><%=u.getuProfessional()%></span>
							</td>
						</tr>
						<tr>
							<td><label>用户经验：</label>
							</td>
							<td colspan="3"><span><%=u.getuExprience()%></span>
							</td>
							<td><label>主管：</label>
							</td>
							<td colspan="3">
								<%
									if (u.getuName().equals(u.getuMgr())) {
								%><span><%=u.getuMgr()%></span> <%
 	} else {
 %><select name="userMgr"><option><%=u.getuMgr()%></option>
									<%
										for (int i = 0; i < mgrList.size(); i++) {
									%><option><%=mgrList.get(i)%></option>
									<%
										}
									%>
							</select> <%
 	}
 %>
							</td>
						</tr>
						<tr>
							<td><label>备注：</label>
							</td>
							<td colspan="7"><textarea draggable="false"
									name="userEducation"><%=u.getuEducation()%></textarea>
							</td>
						</tr>
					</table>
				</div>

			</section>
			<section class="op_div">
				<button type="submit" class="addMember">Update</button>
				<button type="button" class="addMember"
					onclick="delMember(<%=u.getuId()%>)">Delete</button>
			</section>
		</form>
	</article>

</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
