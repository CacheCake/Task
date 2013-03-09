<%@page import="java.util.ArrayList, model.User"%>
<%
	HttpSession se = request.getSession();
	ArrayList<User> uList = (ArrayList<User>) se.getAttribute("uList");
	User user = uList.get(0);
%>
<header id="back_end_header" class="shadow_a"><%=user.getuName()%></header>