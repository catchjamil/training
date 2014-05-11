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
<h3>BIC CODE INSERT FORM</h3><hr>
<s:form action="bicForm" onsubmit="return validateForm()">
<s:property value="message" />
<s:textfield maxlength="4" name="bic.bankcode" label="Bank Code" onblur="validbc()"/>
<s:label id="ibc" cssStyle="color: red">&nbsp;</s:label>

<s:textfield maxlength="2"   name="bic.countrycode" label="Country Code" onblur="validcc()"/>
<s:label id="icc" cssStyle="color: red">&nbsp;</s:label>

<s:textfield  maxlength="2" name="bic.locationcode" label="Location Code" onblur="validlc()"/>
<s:label id="ilc" cssStyle="color: red">&nbsp;</s:label>
<s:textfield maxlength="3" name="bic.branchcode" label="Branch Code" onblur="validbrc()"/>
<s:label id="ibrc" cssStyle="color: red">&nbsp;</s:label>
<tr><td> &nbsp; </td>	
<td>&nbsp;</td></tr>
<tr><td> </td>
 <td><s:submit theme="simple"/><s:reset theme="simple"/></td></tr>
</s:form>
</body>
</html>
