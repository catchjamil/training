<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Fund Transfer</h1><hr><br>
<s:form action="transfer" onsubmit="validateForm()">
<table border="1">
<s:property value="message"/>
<s:select label="Account" list="ac_list" name="name"/>
<s:textfield name="transfer.Oor" label="Originator of Remitance"/>
<tr>
<td><td><label id=ioor style="color: red">&nbsp;</label>


</table>
</s:form>
</body>
</html>