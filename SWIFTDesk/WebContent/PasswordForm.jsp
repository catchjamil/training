 <%@page import="com.sd.training.struts2.bean.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sb:head/>
<script type="text/javascript">


function validoldpass(){
	  var pass =document.forms["passReset"]["pass.oldpass"].value; 
	  if (pass==null||pass=="")
	  {
		  document.getElementById("oldp").innerHTML="Enter the old password ";
		  return false;
	  }
	  else{
			document.getElementById("oldp").innerHTML="";
			return true;
		}
	}
	//------------------------------------------------------------------//
    function validpass(){
	  var pass =document.forms["passReset"]["pass.newpass"].value; 
	  if (pass==null||pass=="")
	  {
		  document.getElementById("newp").innerHTML="Enter the password ";
		  return false;
	  }
	  else if(pass.length()<8){
		  document.getElementById("newp").innerHTML=" must be 8 character long";
			return flase;
	  }
	  else{
			document.getElementById("newp").innerHTML="";
			return true;
		}
	}
	//---------------------------------------------------//
	function validpassc()
	{ 
		var pass =document.forms["passReset"]["pass.newpass"].value; 
		var passc =document.forms["passReset"]["pass.newpassc"].value; 
		if (passc==null||passc=="")
		  {
			document.getElementById("cp").innerHTML="Enter the confirm password ";
			return false;
		  }
		
		else if (pass!=passc)
		  {
			  document.getElementById("cp").innerHTML="passwords are not matched ";
			  return false;
		  }
		  else{
				document.getElementById("cp").innerHTML="";
				return true;
			}
	}  
//-------------------------------------------------------------------------//
function validateForm()
{ 
	if(!validoldpass())
		return false;
	else if(!validpass())
		return false;
	else if(!validpassc())
		return false;
	else
	return true;	
}
</script>
</head>
<body>
<h1>password example</h1>
 <%
    User user=(User)session.getAttribute("userDetails");		
		%>
<s:form action="passReset" onsubmit="return validateForm()">
<s:property value="message"/>
    <s:label label="UserId" ><%=user.getUname()%></s:label>
	<s:password label="Enter OldPassword" name="pass.oldpass" id="oldp" onblur="validoldpass()" />
	<s:password label="Enter NewPassword" name="pass.newpass" id="newp" onblur="validpass()"/>
	<s:password label="confirm NewPassword" name="pass.newpassc" id="cp" onblur="validpassc()"/>
 
	<s:submit  value="submit" />
    <s:reset  value="Reset" />
</s:form>

</body>
</html>