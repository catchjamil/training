<%@page import="com.sd.training.struts2.bean.User"%>
<h4 align="center"> Header</h4>

<%
   User obj = (User)session.getAttribute("userDetails");
if(obj != null){
	 %>
Welcome <%= obj.getUname() %> 	 
<a href="logout.action">Logout</a>
<%}
%>
