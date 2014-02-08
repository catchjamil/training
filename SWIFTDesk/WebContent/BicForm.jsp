 <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function validbc()
{
	var bc=document.forms["bicForm"]["bic.bankcode"].value;
    if(bc==null || bc=="")
    {
    	document.getElementById("ibc").innerHTML="enter bank code";
    	return false;
    }
    else if(bc.length<4){
    	document.getElementById("ibc").innerHTML="must be of 4 character";
        flag=false;
    }
    else {
    	document.getElementById("ibc").innerHTML="&nbsp;";
    	return true;
    }    
}

//-------------------------------------------------------------------
 function validcc()
    {
	 var cc=document.forms["bicForm"]["bic.countrycode"].value
	 if(cc==null || cc=="")
	    {
	    	document.getElementById("icc").innerHTML="enter country code";
	    	return false;
	    }
	    else if(cc.length<2){
	    	document.getElementById("icc").innerHTML="must be of 2 character";
	    	return false;
	    }
	    else {
	    	document.getElementById("icc").innerHTML="&nbsp;";
	    	return true;
	    }  
    }
//-------------------------------------------------------------------

 function validlc()
    {
	 var lc=document.forms["bicForm"]["bic.locationcode"].value;
	 if(lc==null || lc=="")
	    {
	    	document.getElementById("ilc").innerHTML="enter location code";
	    	return false;
	    }
	    else if(lc.length<2){
	    	document.getElementById("ilc").innerHTML="must be of 2 character";
	    	return false;
	    }
	    else {
	    	document.getElementById("ilc").innerHTML="&nbsp;";
	    	return true;
	    }  
    }

//--------------------------------------------------------------------

 function validbrc()
    {
	 var brc=document.forms["bicForm"]["bic.branchcode"].value;
	 if(brc==null || brc=="")
	    {
	    	document.getElementById("ibrc").innerHTML="enter branch code";
	    	return false;
	    }
	    else if(brc.length<2){
	    	document.getElementById("ibrc").innerHTML="must be of 2 character";
	    	return false;
	    }
	    else {
	    	document.getElementById("ibrc").innerHTML="&nbsp;";
	        return true;
	    }  
    }
//--------------------------------------------------------------//
   function validateForm() {
	   if(!validbc())
		   return false;
	   else if(!validcc())
		   return false;
	   else if(!validlc())
		   return false;
	   else if(!validbrc())
		   return false;
	   else
		   return true;
}
//-----------------------------------------------------------------------
</script>
</head>
<body >
<h2 align="center">BIC CODE INSERT FORM</h2><hr>
<s:form action="bicForm" onsubmit="return validateForm()">
<table border="2" bordercolor="black">
<tr><td colspan="2"><b>&nbsp;<s:property value="message" /></b>

<s:textfield maxlength="4" name="bic.bankcode" label="Bank Code" onblur="validbc()"/>
<tr>
<td><td><label id=ibc style="color: red">&nbsp;</label>

<s:textfield maxlength="2"   name="bic.countrycode" label="Country Code" onblur="validcc()"/>
<tr>
<td><td><label id=icc style="color: red">&nbsp;</label>

<s:textfield  maxlength="2" name="bic.locationcode" label="Location Code" onblur="validlc()"/>
<tr>
<td><td><label id=ilc style="color: red">&nbsp;</label>

<s:textfield maxlength="3" name="bic.branchcode" label="Branch Code" onblur="validbrc()"/>
<tr>
<td><td><label id=ibrc style="color: red">&nbsp;</label>
<s:submit value="Submit" />
<s:reset value="Clear"/>

</table>

</s:form>

</body>
</html>
