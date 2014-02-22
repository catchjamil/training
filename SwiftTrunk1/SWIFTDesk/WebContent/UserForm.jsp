
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

//-------------------------------------------------------------//
function validuname()
{
var uname=document.forms["userForm"]["user.uname"].value;
if (uname==null || uname=="")
  {
	  	
	document.getElementById("un").innerHTML="Username must be filled out";
	  	return false;
  }
else{
	document.getElementById("un").innerHTML="&nbsp;";
		return true;
	}
}
//-------------------------------------------------//
 function validpass(){
  var pass =document.forms["userForm"]["user.password"].value; 
  if (pass==null||pass=="")
  {
	  document.getElementById("pa").innerHTML="Enter the password ";
	  return false;
  }
  else{
		document.getElementById("pa").innerHTML="&nbsp;";
		return true;
	}
}
//---------------------------------------------------//
function validpassc()
{ 
	var pass =document.forms["userForm"]["user.password"].value;
	var passc=document.forms["userForm"]["user.passwordc"].value;
	if (passc==null||passc=="")
	  {
		document.getElementById("pac").innerHTML="Enter the confirm password ";
		return false;
	  }
	
	else if (pass!=passc)
	  {
		  document.getElementById("pac").innerHTML="passwords are not matched ";
		  return false;
	  }
	  else{
			document.getElementById("pac").innerHTML="&nbsp;";
			return true;
		}
}  
//---------------------------------------------------// 
function validfname(){ 
var fname=document.forms["userForm"]["user.firstName"].value;
 if (fname==null||fname=="")
  {
	 document.getElementById("fn").innerHTML="First name is required";
	 return false;
  }
 else{
		document.getElementById("fn").innerHTML="&nbsp;";
		return true;
	}
}
//-----------------------------------------------// 
function validlname(){
 var lname=document.forms["userForm"]["user.lastName"].value;
  if (lname==null||lname=="")
  {
	  document.getElementById("ln").innerHTML="Last Name is required ";
	  return false;
  }else{
		document.getElementById("ln").innerHTML="&nbsp;";
		return true;
	}
} 
//-----------------------------------------------------------//
  function validemail(){ 
	  	var email =document.forms["userForm"]["user.email"].value;
		var atpos=email.indexOf("@");
		var dotpos=email.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
  		{
			document.getElementById("em").innerHTML="Not a valid e-mail address";
			return false;
  		}
		else{
			document.getElementById("em").innerHTML="&nbsp;";
			return true;
		}
  }  
//----------------------------------------------------------------//  
function validateForm()
{ 
	if(!validuname())
		return false;
	else if(!validpass())
		return false;
	else if(!validpassc())
		return false;
	else if(!validfname())
		return false;
	else if(!validlname())
		return false;
	else if(!validemail())
		return false;
	else
	return true;	
}
</script>
</head>
<body bgcolor="lightblue">
	<h2 align="center">
		<u>User Registration Form</u>
	</h2>
	<hr>
	<br>
	<table border=5 align="center" cellpadding="20" bgcolor="lightgrey">

		<tr>
			<td><b><s:property value="message" /></b> <s:form
					action="userForm" onsubmit="return validateForm()">

					<tr>
						<td><s:textfield size="30" name="user.uname"
								label="Enter Username" onblur="validuname()" />
						<td>
						<td><label id="un" style="color: red;"> &nbsp;</label>
					<tr>
						<td><s:password size="30" name="user.password"
								label="Enter Password" onblur="validpass()" />
						<td>
						<td><label id="pa" style="color: red;">&nbsp;</label>
					<tr>
						<td><s:password size="30" name="user.passwordc"
								label="Confirm Password" onblur="validpassc()" />
						<td>
						<td><label id="pac" style="color: red;">&nbsp;</label>
					<tr>
						<td><s:textfield size="30" name="user.firstName"
								label="First Name" onblur="validfname()" />
						<td>
						<td><label id="fn" style="color: red;">&nbsp;</label>
					<tr>
						<td><s:textfield size="30" name="user.lastName"
								label="Last Name" onblur="validlname()" />
						<td>
						<td><label id="ln" style="color: red;">&nbsp;</label>
					<tr>
						<td><s:textfield size="30" name="user.email" label="E-mail"
								onblur="validemail()" />
						<td>
						<td><label id="em" style="color: red;">&nbsp;</label>
					<tr>
						<td><s:submit value="Submit" /></td>
						<td><s:reset value="Reset  " /></td>
					</tr>
				</s:form>
	</table>
</body>
</html>