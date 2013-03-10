<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
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


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style_b.css">

</head>

<body onload="panelHeight(1)" onresize="panelHeight(1)">
	<%@include file="/back_end_header.jsp"%>

	<article class="HR_panel shadow_a" id="panel">
		<header class="HR_title">HR</header>
		<section class="member_div shadow_c">
			<iframe src="HR/member_list.jsp" height="497px" width="720px" frameborder="0" id="member_list"></iframe>
		</section>
		<section class="op_div">
			<input type="search" class="search">
			<button class="search_button">S</button>
				<a href="hr/ShowNewMember"><button class="addMember">New</button></a>
		</section>
	</article>

</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/back_end.js"></script>

</html>
