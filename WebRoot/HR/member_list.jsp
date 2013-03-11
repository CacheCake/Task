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

<body class="list_mem_bg">
	<table class="list_mem_table list_mar">
		<section>
			<tr class="list_header">
				<td class="list_mem_name"><span>ID</span><label>姓名</label><span>职务</span><span>性别</span><span>主管</span>
				</td>
				<td class="op_span">&nbsp;&nbsp;&nbsp;&nbsp;操作</td>
			</tr>
			<%
				HttpSession se = request.getSession();
				ArrayList<User> uList = (ArrayList<User>) se.getAttribute("uList");
				for (int i = 0; i < uList.size(); i++) {
					User user = uList.get(i);
			%>
			<tr class="list_tr">
				<td class="list_mem_name"><span><%=user.getuId()%></span><label onclick="showMember(<%=user.getuId()%>)"><%=user.getuName()%></label>
					<span><%=user.getuRole()%></span><span><%=user.getuGender()%></span><span><%=user.getuMgr()%></span>
				</td>
				<td class="op_button" id="op_button<%=i %>" onclick="hrOpButton(<%=i %>,<%=user.getuId()%>)">...</td>
			</tr>
			<%
				}
			%>
		</section>
	</table>
</body>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
