<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validateform(){
	if(user==! || user==null)
		alert("please enter the user name");
	return false;
    }
else if(password=null || password==""){
	alert("Enter the password");
	return false;
} 
else if(passwordcnfm=null || passwordcnfm==""){
	lert("Enter the password");
	return false;
}
else if(firstnm==null || firstnm==||){
	lert("Please re Enter the first name");
	return false;
}
else if(lastnm=null || lastnm==""){
	lert("please re enter the last name");
	return false;
}
else if(emailid=null || emailid==""){
	lert("please re enter the emailid");
	return false;
}
</script>

<body>
<i>Registration Form</i><hr><br>
<center><b><s:property value="message" /></b></center>
	<s:form action="userForm" onsubmit="return validateForm()" />
		<s:textfield name="user.uname" label="Enter Username" />
		<s:password  name="user.password label="Enter Password" />
		<s:password  name=user.passwordcnfm label="Confirm Password" />
		<s:textfeild name=user.firstnm label="First Name" />
		<s:textfeild name=user.lastnm label="Last Name" />
		<s:textfeild name=user.email label="Email Id" />
		<s:Submit value="Submit" />
		<s:reset value="Reset" />
		
</body>
</html>