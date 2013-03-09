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

<title>Task后台管理 - HR</title>

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

	<article class="HR_panel shadow_a" id="panel">
		<form action="hr/NewMember" method="post">
			<header class="HR_title">HR - New member</header>
			<section class="new_mem_table shadow_c" id="member_list">

				<div id="paper">
					<table>
						<tr>
							<td><label>姓名：</label></td>
							<td colspan="3"><input type="text" name="userName">
							</td>
							<td><label>权限：</label></td>
							<td colspan="3"><select name="userRole"><option>管理员</option>
									<option>主管</option>
									<option>员工</option>
							</select></td>
						</tr>
						<tr>
							<td><label>密码：</label></td>
							<td colspan="7"><input type="password" name="userPwd1"
								value="666666"></td>
						</tr>
						<tr>
							<td><label>确认密码：</label></td>
							<td colspan="7"><input type="password" name="userPwd2"
								value="666666"></td>
						</tr>
						<tr>
							<td><label>职务：</label></td>
							<td><select name="userPosition"></select></td>
							<td><label>性别：</label></td>
							<td><select name="userGender"></select></td>
							<td><label>用户专业：</label></td>
							<td colspan="3"><input type="text" name="userProfessional">
							</td>
						</tr>
						<tr>
							<td><label>用户经验：</label></td>
							<td colspan="3"><input type="text" name="userExprience">
							</td>
							<td><label>主管：</label></td>
							<td colspan="3"><select name="userMgr"></select></td>
						</tr>
						<tr>
							<td><label>备注：</label></td>
							<td colspan="7"><textarea draggable="false"
									name="userEducation"></textarea></td>
						</tr>
					</table>
				</div>

			</section>
			<section class="op_div">
				<button type="submit" class="addMember">Update</button>
				<section class="op_div">
		</form>
	</article>

</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
