
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function validateForm()
{
var uname=document.forms["userForm"]["user.uname"].value;
//var x =document.getElementById("user.uname");
var email =document.forms["userForm"]["user.email"].value;
var pass =document.forms["userForm"]["user.password"].value;
var passc =document.forms["userForm"]["user.passwordc"].value;
var fname=document.forms["userForm"]["user.firstName"].value;
var lname=document.forms["userForm"]["user.lastName"].value;

if (uname==null || uname=="")
  {
	  	alert("Username must be filled out");
	  	return false;
  }
  else if (pass==null||pass=="")
  {
	  	alert("Enter the password ");
	  	return false;
  }
  else if (passc==null||passc=="")
  {
	  	alert("Enter the confirm password ");
	  	return false;
  }
  else if (pass!=passc)
  {
	  	alert("passwords are not matched ");
	  	return false;
  }
  else if (fname==null||fname=="")
  {
	  	alert("First Name is required ");
	  	return false;
  }
  else if (lname==null||lname=="")
  {
	  	alert("Last Name is required ");
	  	return false;
  }
  else{  
		var atpos=email.indexOf("@");
		var dotpos=email.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x1.length)
  		{
  			alert("Not a valid e-mail address");
  			return false;
  		}
  }  
return true; 
}
</script>
<body>
<table>
<center><b>User Registration Form</b></center><hr><hr><br></center>
 <center><b><s:property value="message" /></b></center>
	<s:form action="userForm">
<center><b><s:property value="message" /></b></center>
	<s:form action="userForm" onsubmit="return validateForm()">

		<s:textfield name="user.uname" label="Enter Username" />
		
		<s:password name="user.password" label="Enter Password" />
		
		<s:password name="user.passwordc" label="Confirm Password" />

		<s:textfield name="user.firstName" label="First Name" />
		
		<s:textfield name="user.lastName" label="Last Name" />
		
		<s:textfield name="user.email" label="E-mail" />
		
		<s:submit value="Submit" />

		<s:reset value="Reset "  />

	</s:form>
<<<<<<< .mine
	</table>

=======

>>>>>>> .r105
</body>
</html>