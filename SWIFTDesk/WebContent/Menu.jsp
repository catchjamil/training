<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>Menu Link Adder</title>
      
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<s:form action="menuForm" >
<s:property value="message"/>
<br>
<s:textfield  name="menu.name" label="Menu Name"/>
<s:textfield  name="menu.href" label="Link "/>
<s:select name="menu.parentId" key="personBean.residency" list="menulist" listKey="menuId"
		  headerKey="-1" headerValue="Select Parent Menu" 
		  listValue="name"  label="Parent ID"/>
<s:submit/>
<s:reset/>




</s:form>
</body>
</html>