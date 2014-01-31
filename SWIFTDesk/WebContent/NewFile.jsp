<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>java script function document.write()</title>
</head>
<script> type= "text/javascript">

</script>

<body>
	<center><b><s:property value="message" /></b></center>
	<s:form action="userForm" name = "myFrom" onsubmit="javascript:return validateForm()"/>

	<s: textfield name="user.uname" label ="Enter UserName" />
	<br>
	<s: password name="user.password" label="Enter Password" />
	<br>
	<s: password name="user.password" label ="Enter Confirm Password" />
	<br>
	<s: Mobile   name="user.mobile" label ="Enter Mobile No" />  
	<s:submit value="Submit" align="center" />
	<s: form />
</body>
</html>
