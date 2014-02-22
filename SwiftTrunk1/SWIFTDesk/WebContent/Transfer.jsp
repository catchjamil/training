<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm() {
	return false;
	
}

</script>
</head>
<body>
<h1 align="center">Fund Transfer</h1><hr><br>
<s:form action="transfer" onsubmit="return validateForm()">
<table border="1">
<s:property value="message"/>
<s:div id="sac_no" name="transfer.sourceAcc"></s:div>

<s:textfield  label="Originator of Remitance" name="transfer.oor"/>
<tr>
<td><td><label id=ioor style="color: red">&nbsp;</label>
<s:textfield  label="Transfer Amount" name="transer.TransferAmount"/>
<tr>
<td><td><label id=ita style="color: red">&nbsp;</label>

<s:div id="dac_no" name="transfer.DestinationAcc"></s:div>

<s:select label="Select Account" 
		headerKey="-1" headerValue="Select Account Engines"
		list="accounts" 
		name="transfer.beneficiary" />
		
<s:textfield label="IFSC" name="transfer.ifsc"/>
<s:textfield label="Payment Details" name="transfer.paymentDeyail"/>
<tr>
<td><td><label id=ipd style="color: red">&nbsp;</label>
<s:submit label="Transfer" />



</table>
</s:form>
</body>
</html>