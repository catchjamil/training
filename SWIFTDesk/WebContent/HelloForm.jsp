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
<s:form action="hello">
<s:textfield name="helloTextFiled" label="Enter Name "/>

<s:select label="Select Country" 
		headerKey="-1" headerValue="Select Country Engines"
		list="countries" 
		name="country" />
		
		
<s:select label="Select Account" 
		headerKey="-1" headerValue="Select Account Engines"
		list="accounts" 
		name="account" />
		
<s:submit value="Submit" />

</s:form>
</body> 
</html>