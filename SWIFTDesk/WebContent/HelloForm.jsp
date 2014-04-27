<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

/*Ajax Request readyStates
State  Description
0      The request is not initialized
1      The request has been set up
2      The request has been sent
3      The request is in process
4      The request is complete*/

var xmlHttp;

/**
* @return {boolean}
*/
function ValueChanged(url) {

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
   xmlHttp.send(null);
   xmlHttp.onreadystatechange = showMessage
}

function showMessage() {
	alert("State: "+xmlHttp.readyState);
   if (xmlHttp.readyState == 4) {
	   alert(xmlHttp.responseText);
	
	   document.getElementById("testAjax").value=xmlHttp.responseText;
   }
}


</script>
<body>
<s:form action="hello">
<s:textfield name="helloTextFiled" label="Enter Name "/>

<s:select label="Select Country" 
		headerKey="-1" headerValue="Select Country Engines"
		list="countries" 
		name="country" />
		
	
<s:submit value="Submit" />

</s:form>

Test Ajax <input type="text" name="testAjax" id="testAjax" onclick="ValueChanged('ajaxDivUrl.action')"/>



</body> 
</html>