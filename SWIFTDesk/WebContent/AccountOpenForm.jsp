<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head theme="simple"/>
<script type="text/javascript">
function checkaddress()
{

	var x=document.getElementById("sameaddress");
	var flag="Yes";
	if(x.value==flag){
	var address=document.getElementById("address");
	var state=document.getElementById("state");
	var pin=document.getElementById("pin");
	var city=document.getElementById("city");
	document.getElementById("paddress").innerHTML=address.value;
	document.getElementById("ps").value=state.value;
	document.getElementById("ppin").value=pin.value;
	document.getElementById("pcity").value=city.value;
	}
else {//if(x=="No"){
	document.getElementById("paddress").innerHTML="";
	document.getElementById("pstate").innerHTML="";
	document.getElementById("ppin").innerHTML="";
	document.getElementById("pcity").innerHTML="";
	}
}
</script>
</head>
<body>

<s:form action="accountOpenForm">
<s:property value="message"/>
<s:property value="accountnumber"/>
<s:select name="user.nameTitle" id="nameTitle"
headerKey="-1" headerValue="Select" list="#{'Mr.':'Mr.','Mrs.':'Mrs.','Miss':'Miss'}" label="Name"/>
<s:textfield name="user.firstname" label="First name" id="firstname"/>
<s:textfield name="user.middlename" label="Middle name" id="middlename"/>
<s:textfield name="user.lastname" label="Last name" id="lastname" />

<s:textfield name="user.fathername" label="Father's Name" id="fathername"/>
<s:textfield name="user.mothername" label="Mother's Name" id="mothername"/>

<s:datetimepicker name="user.dob" label="DOB" displayFormat="dd-MM-yyyy" id="dob" />
<s:textfield name="user.nationality" label="Nationality" id="nationality"/>
<s:label label="Correspondence Address(Current Address)"/>
<s:textarea name="user.address" label="Address" id="address"/>
<s:textfield name="user.state" label="State" id="state"/>
<s:textfield name="user.pin" label="PIN" id="pin"/>
<s:textfield name="city" label="City/District" id="city"/>
<s:label label="Permanent Address"/>
<s:select name="user.sameaddress" id="sameaddress" 
headerKey="-1" headerValue="Select" list="#{'No':'No','Yes':'Yes'}" label="Same as Correspondence" onchange="checkaddress()"/>

<s:textarea name="user.paddress" label="Address" id="paddress"/>
<s:textfield name="user.ps" label="State" id="ps"/>
<s:textfield name="user.ppin" label="PIN" id="ppin"/>
<s:textfield name="user.pcity" label="City/District" id="pcity"/>
<s:textfield name="user.phoneNo" label="Phone No." id="phoneNo"/>
<s:textfield name="user.email" label="E-mail" id="email"/>
<s:textfield name="user.balance" label="Account Balance" id="balance"/>
<s:select name="user.accounttype" id="accounttype" 
headerKey="-1" headerValue="Select" list="#{'Saving':'Saving','Current':'Current'}" 
label="Account Type"/>

<tr><td>&nbsp;</td></tr>
<tr><td></td>
<td><s:submit theme="simple"/>
<s:reset theme="simple"/></td></tr>
</s:form>


</body>
</html>