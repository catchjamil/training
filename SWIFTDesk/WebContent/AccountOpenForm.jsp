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

<s:form>
<div>
<s:select name="userTitle"
headerKey="-1" headerValue="Select" list="#{'Mr.':'Mr.','Mrs.':'Mrs.','Miss':'Miss'}" label="Name"/>
<s:textfield name="firstName" ="first name"/>
<s:textfield name="middleName" />
<s:textfield name="lastName" />
</div>
<s:textfield name="GardianName" label="Name"/>
<s:textfield name="motherName" label="Mother Name"/>



</s:form>


</body>
</html>