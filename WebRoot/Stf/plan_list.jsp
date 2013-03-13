<%@ page language="java" import="java.util.*,model.Plan"
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
				<td class="list_mem_name"><span>ID</span><label>计划名称</label><span>状态</span><span>结束时间</span><span>反馈</span>
				</td>
				<td class="op_span">&nbsp;&nbsp;&nbsp;&nbsp;操作</td>
			</tr>
			<%
				HttpSession se = request.getSession();
				ArrayList<Plan> pList = (ArrayList<Plan>) se.getAttribute("pList");
				for (int i = 0; i < pList.size(); i++) {
					Plan plan = pList.get(i);
			%>
			<tr class="list_tr">
				<td class="list_mem_name"><span><%=plan.getpId()%></span><label onclick="showMember(<%=plan.getpId()%>)"><%=plan.getpName()%></label>
					<span><%=plan.getpStatus()%></span><span><%=plan.getpEndDate()%></span><span><%=plan.getpFeedback()%></span>
				</td>
				<td class="op_button" id="op_button<%=i %>" onclick="hrOpButton(<%=i %>,<%=plan.getpId()%>)">...</td>
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
