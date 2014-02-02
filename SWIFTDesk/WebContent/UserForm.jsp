
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
var flag=true;
var uname=document.forms["userForm"]["user.uname"].value;
//var x =document.getElementById("user.uname");
var email =document.forms["userForm"]["user.email"].value;
var pass =document.forms["userForm"]["user.password"].value;
var passc =document.forms["userForm"]["user.passwordc"].value;
var fname=document.forms["userForm"]["user.firstName"].value;
var lname=document.forms["userForm"]["user.lastName"].value;

if (uname==null || uname=="")
  {
	document.getElementById("un").innerHTML="enter user name";  	
	//alert("Username must be filled out");
	  	flag= false;
  }
else{
	document.getElementById("un").innerHTML="";
}
  if (pass==null||pass=="")
  {
	  document.getElementById("pa").innerHTML="enter password";
	  	//alert("Enter the password ");
	  		flag= false;
  }
  else{
		document.getElementById("pa").innerHTML="";
	}
  if (passc==null||passc=="")
  {
	  document.getElementById("pac").innerHTML="enter confirm password";
		flag= false;
  }
  else{
		document.getElementById("pac").innerHTML="";
	}
  if (pass!=passc)
  {
	  document.getElementById("pac").innerHTML="password not matched";
		flag= false;
  }
  else{
		document.getElementById("pac").innerHTML="";
	}
  if (fname==null||fname=="")
  {
	  document.getElementById("fn").innerHTML="enter first name";
		flag= false;
  }
  else{
		document.getElementById("fn").innerHTML="";
	}
  if (lname==null||lname=="")
  {
	  document.getElementById("ln").innerHTML="enter last name";
		flag= false;
  }
  else{
		document.getElementById("ln").innerHTML="";
	}
    
		var atpos=email.indexOf("@");
		var dotpos=email.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x1.length)
  		{
			document.getElementById("em").innerHTML="invalid e-mail ID";
			flag= false;
  		}
		else{
			document.getElementById("em").innerHTML="";
		}
    
return flag; 
}
</script>
<body>
<table  width=75% border=1 cellpadding=10 cellspacing=5>
<tr>
<td><center><h2>User Registration Form</h2></center>
 <b><s:property value="message" /></b>
<s:form action="userForm" onsubmit="return validateForm()">
<tr>
<td><s:textfield name="user.uname" label="Enter Username" ></s:textfield>
<td><p id=un style="color: red;"></p>
</tr>	
<tr>
<td><s:password name="user.password" label="Enter Password" />
<td><p id=pa style="color: red;"></p>
</tr>
<tr>
<td><s:password name="user.passwordc" label="Confirm Password" />
<td><p id=pac style="color: red;"></p>
</tr>
<tr>
<td><s:textfield name="user.firstName" label="First Name" />	
<td><p id=fn style="color: red;"></p>
</tr>
<tr>
<td><s:textfield name="user.lastName" label="Last Name" />
<td><p id=ln style="color: red;"></p>
</tr>
<tr>
<td><s:textfield name="user.email" label="E-mail" />	
<td><p id=em style="color: red;"></p>
</tr>
<tr>
<td ><s:submit value="Submit" /></td>
<td ><s:reset value="Reset " /></td></tr>
</s:form>
</table>
</body>
</html>