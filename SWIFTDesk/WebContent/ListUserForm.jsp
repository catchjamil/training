<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.odd{
background-color: gray;
}
span{
margin-left:560px;
margin-bottom:15px;
color:maroon;
}
.pagebanner{
display: none;
}
.pagelinks{
color: maroon;
margin-left: -150px;
margin-top:20px;
}
#txt_filter{
display: none;
}
.exportlinks
{
margin-left: 451px;
}
.export{
 
margin-left: 0px;
}
</style>
</head>
<body>

<display:table export="true" id="123" name="listUsers" requestURI="" pagesize="10" cellpadding="2px" cellspacing="2px" style="margin-left:450px;margin-top:20px;">

<display:column property="id" title="Employee ID" sortable="true"></display:column>
<display:column property="firstName" title="Employee First Name" sortable="true"></display:column>
<display:column property="uname" title="User Name" sortable="true"></display:column>
<display:column property="email" title="Email ID" sortable="true"></display:column>
</display:table>

</body>
</html>