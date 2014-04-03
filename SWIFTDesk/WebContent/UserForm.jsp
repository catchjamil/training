
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
<body >
<div class="control-label col-xs-10">
<h1>User Creation</h1>
<b><s:property value="message" /></b>
 <s:form action="userForm" onsubmit="return validateForm()" cssClass="form-horizontal">
<div class="form-group">
<s:textfield size="30" name="user.uname"
			label="Enter Username" onblur="validuname()" />
<s:label id="un" cssStyle="color: red;">&nbsp;</s:label>
</div>
<div class="form-group">
<s:password size="30" name="user.password"
			label="Enter Password" onblur="validpass()" />
<s:label id="pa" cssStyle="color: red;">&nbsp;</s:label>
</div>
<div class="form-group">
<s:password size="30" name="user.passwordc"
	label="Confirm Password" onblur="validpassc()" cssClass=""/>
<s:label id="pac" cssStyle="color: red;">&nbsp;</s:label>
</div>
<div class="form-group">
<s:textfield size="30" name="user.firstName"
	label="First Name" onblur="validfname()" />
<s:label id="fn" cssStyle="color: red;">&nbsp;</s:label>
</div>
<div class="form-group">
<s:textfield size="30" name="user.lastName"
	label="Last Name" onblur="validlname()" />
<s:label id="ln" cssStyle="color: red;">&nbsp;</s:label>
</div>
<div class="form-group">
<s:textfield size="30" name="user.email" label="E-mail"
	onblur="validemail()" />
<s:label id="em" cssStyle="color: red;">&nbsp;</s:label>
</div>
<s:select list="roles" label="User type" name="user.roleID" headerValue="select" headerKey="-1" listKey="id" listValue="roleName"/>
	<s:div cssClass="form-group">
 <s:submit cssClass="btn btn-primary"/>
 <s:reset cssClass="btn btn-danger"/>
</s:div>

</s:form>
<a href="listUserForm.action">List All Users</a>
</div>
</body>
</html>