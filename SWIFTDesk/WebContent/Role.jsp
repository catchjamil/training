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
<h2 align="center"> <u>ROLE SEARCH FORM</u></h2>
<s:form action="role" />

<s:textfield name="roleTextFiled" label="Enter Name "/>

<s:select label="Select Country" 
		headerKey="-1" headerValue="Select Country Engines"
		list="countries" 
		name="country" />
		
		
<s:select label="Select Account" 
		headerKey="-1" headerValue="Select Account Engines"
		list="accounts" 
		name="account" />
		
    
<table align="center">

<s:submit value="Submit"/>
<s:submit value="Reset" />
</table>
<s:form/>
</body>
</html>