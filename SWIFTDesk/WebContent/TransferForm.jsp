<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" >

var xmlHttp;

function ValueChanged(url) {
	var pname=document.forms["transfer"]["transfer.beneficiary"].value;
   try {
       xmlHttp = new XMLHttpRequest();
   } catch (e) {
       try {
           xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
       } catch (e) {
           try {
               xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
           } catch (e) {
               alert("Your browser does not support AJAX..!");
               return false;
           }
       }
   }
   xmlHttp.open("POST", url, true);
   xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
   xmlHttp.send("name="+pname);
   xmlHttp.onreadystatechange = showMessage;
}

function showMessage() {
	   if (xmlHttp.readyState == 4) {	
		   var str=xmlHttp.responseText;
		   var tmp = str.split(',');
		   var sel = document.getElementById("acc_no");
		     sel.options.length=null;
		     //sel.options[i]=//new Option(tmp[i], tmp[i]);
		     for(var i=0; i<tmp.length-1; i++) {
		   			 sel.options[i]=new Option(tmp[i], tmp[i]);
		  }
   }
}
function ValidateForm(){
return true;	
}



</script>
</head>
<body>
<h1 align="center">Fund Transfer</h1><hr><br>
<s:form action="transfer"  onsubmit="return validateForm()"  >
<table border="1" bgcolor="lightgrey">
<s:property value="message"/>

<s:select label="Select Account" 
		headerKey="-1" headerValue="Select Account Engines"
		list="accounts" 
		name="transfer.sourceAcc" />

<s:textfield  label="Originator of Remitance" name="transfer.oor"/>
<tr>
<td><td><label id=ioor style="color: red">&nbsp;</label>
<s:textfield  label="Transfer Amount" name="transfer.transferAmount"/>
<tr>
<td><td><label id=ita style="color: red">&nbsp;</label>


<s:select label="Select Payee" 
		headerKey="-1" headerValue="Select Payee"
		list="payees" 
		name="transfer.beneficiary"   onchange="ValueChanged('getDesAcNo.action')"/>
		<tr><td><label>Select Account No.</label>
		<td>
		 <select id="acc_no" name="des_no">
    <option>Choose a acc number</option>
  </select></tr>
<!-- s:textfield name="transfer.DestinationAcc" label="Payee Account No." id="dac_no" disabled="true"/-->	
<!-- s:select label="Select Payee Account" 
		headerKey="-1" headerValue="Select Account"
		list="payeeAcc"
		name="transfer.DestinationAcc" id="transfer.DestinationAcc" /-->

		

<s:property value="message"/>	
<s:textfield label="IFSC" name="transfer.ifsc"/>
<tr>
<td><td><label id=iifsc style="color: red">&nbsp;</label>
<s:textfield label="Payment Details" name="transfer.paymentDeyail"/>
<tr>
<td><td><label id=ipd style="color: red">&nbsp;</label>
<s:submit label="Transfer" />



</table>
</s:form>
</body>
</html>