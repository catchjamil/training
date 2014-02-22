<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="menuForm">
<s:textfield  name="menu.menuId" label="Menu ID"/>
<s:textfield  name="menu.name" label="Menu Name"/>
<s:textfield  name="menu.href" label="Link "/>
<s:textfield  name="menu.parentId" label="Parent ID"/>
<s:submit/>
<s:reset/>




</s:form>
</body>
</html>