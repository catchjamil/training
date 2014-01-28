
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
///var x=document.forms["myForm"]["user.uname"].value;
var x=document.field.uname.value;
if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
var x1=document.forms["myForm"]["email"].value;
var atpos=x1.indexOf("@");
var dotpos=x1.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x1.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
</script>
<body>
<center><b><s:property value="message" /></b></center>
	<s:form action="userForm" name = "myFrom" onsubmit="return(validateForm())">
		<s:textfield name="user.uname" label="Enter Username" />
		<br>
		<s:password name="user.password" label="Enter Password" />
		<br>
		<s:password name="user.password" label="Confirm Password" />
		<br>
		<s:textfield name="user.firstName" label="First Name" />
		<br>
		<s:textfield name="user.email" label="E-mail" />
		<br>
		<s:submit value="Submit" align="center" />
	</s:form>

</body>
</html>