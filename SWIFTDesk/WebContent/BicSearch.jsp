 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bic Search</title>
</head>
<body>
<h3>BIC Search</h3>
<s:form action="bicSearch">


<s:select label="Select Country Code" 
		headerKey="-1" headerValue="Select Country Code"
		list="countryCc" 
		name="bic.countrycode" />
<s:submit label="Search"/>
<s:reset/>

</s:form>

<table>

<s:iterator status="stat" value="bicList">
<tr>
<td><s:property value="bankcode"/>    
<td><s:property value="countrycode"/>  
<td><s:property value="locationcode"/> 
<td><s:property value="branchcode"/> 
</tr>
</s:iterator>
</table>
</body>
</html>