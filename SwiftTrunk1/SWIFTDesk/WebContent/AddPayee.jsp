<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payee</title>
<script type="text/javascript">

function validac(){
var ac= document.forms["addPayee"]["payee.account_no"].value;
	if(ac==null || ac=="")
	{
		document.getElementById("iac").innerHTML="enter account no";
		 return false;
	}
	else if(ac.length<9){
		document.getElementById("iac").innerHTML="at least 9 digit long";
		 return false;
	}
	else if(!(/^\d+$/.test(ac))){
		document.getElementById("iac").innerHTML="digist only";
		 return false;
	}
	else {
		document.getElementById("iac").innerHTML="&nbsp;";
		 return true;
	}
	
}
//-----------------------------------------------------------------//
function validrac(){
	var ac= document.forms["addPayee"]["payee.account_no"].value;
	var rac= document.forms["addPayee"]["payee.reaccount_no"].value;
	if(rac==null || rac=="")
	{
		document.getElementById("irac").innerHTML="re enter account no";
		 return false;
	}
	else if(ac!=rac){
		document.getElementById("irac").innerHTML="account no.s does not match";
		 return false;
	}
	else {
		document.getElementById("irac").innerHTML="&nbsp;";
		 return true;
	}
	
}
//-----------------------------------------------------------------//
function validnm(){
	var nm= document.forms["addPayee"]["payee.Name"].value;
	if(nm==null || nm=="")
	{
		document.getElementById("inm").innerHTML="enter name of payee";
		 return false;
	}
	else if(!(/^[a-z]+$/i.test(nm))){
		document.getElementById("inm").innerHTML="alphabate only";
		 return false;
	}
	else {
		document.getElementById("inm").innerHTML="&nbsp;";
		 return true;
	}
}
//-----------------------------------------------------------------//
function validnn(){
	var nn= document.forms["addPayee"]["payee.nickName"].value;
	if(nn==null || nn=="")
	{
		document.getElementById("inn").innerHTML="enter nick name of payee";
		 return false;
	}
	else if(!(/^[a-z]+$/i.test(nn))){
		document.getElementById("inn").innerHTML="alphabate only ";
	    return false;
	}
	else {
		document.getElementById("inn").innerHTML="&nbsp;";
		 return true;
	}
}
//-----------------------------------------------------------------//

function validateForm(){
	if(!validac())
		return false;
	else if(!validrac())
		return false;
	else if(!validnm())
		return false;
	else if(!validnn())
		return false;
	else
		return true;
}
</script>
</head>
<body>
	<h1 align="center"><u>Add Payee</u></h1><hr>
	<s:form action="addPayee" onsubmit="return validateForm()">
	<table border="6"  align="center" bgcolor="lightgrey" cellspacing=0>
	<tr>
	<th colspan="2">
	<h3>Payee Details</h3>
	<tr>
	<th colspan="2"><s:property value="message"/>
	<s:textfield size="35" maxlength="18" name="payee.account_no"  label="Payee Account Number" onblur="validac()" />
	<td>
	<td><label id=iac style="color: red">&nbsp; </label>
	<s:textfield size="35" maxlength="18" name="payee.reaccount_no" label="Re-enter Account Number" onblur="validrac()" />
	<td>
	<td><label id=irac style="color: red">&nbsp; </label>
    <s:textfield size="35" name="payee.Name" label="Payee Name" onblur="validnm()" />
	<td>
	<td><label id=inm style="color: red">&nbsp; </label> 
	<s:textfield size="35" name="payee.nickName" label="Payee Nick Name"  onblur="validnn()"/>
	<td>
	<td><label id=inn style="color: red">&nbsp; </label> 
	<s:label   value="xxxxxxxxxx" label="Payee Registration alert to be sent on mobile no" />
	<td>
	<td><label>&nbsp; </label>
	
	<s:submit value="  Add " />
	<s:reset value="Reset"/>
	
	</table>
	</s:form>
</html>