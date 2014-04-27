
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="com.sd.training.struts2.bean.User"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html>
   <head>
      <title>SWIFTDesk</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <!-- <link rel="stylesheet" type="text/css" media="all" href="style.css" /> -->
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="js/jquery-2.1.0.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
      
           <style>
.label {
    border-radius: 0.25em;
    color: #1A1E1A;
    display: inline;
    font-size: 75%;
    font-weight: 700;
    line-height: 1;
    padding: 0.2em 0.6em 0.3em;
    text-align: center;
    vertical-align: baseline;
    white-space: nowrap;
}

 </style>
      
 
   </head>
   
<body>


	<tiles:insertAttribute name="header" />
	
<%
   User obj = (User)session.getAttribute("userDetails");
if(obj != null){
	 %>
		<tiles:insertAttribute name="mainMenu" />
<%}
%>
<div>
<table width="100%">		
<tr>
<% 	if(obj != null){
	 %><td valign="top" width="200">
		<tiles:insertAttribute name="leftSideMenu" /></td>
<%}
%>
<td>
		<tiles:insertAttribute name="body" />
</td>		
</tr>
</table>
</div>		
		<tiles:insertAttribute name="footer" />
	</body>
 </html>


