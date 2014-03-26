
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

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
      
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
 
   </head>
   
<body>


<div class="span9">
	<tiles:insertAttribute name="header" />
	
	
	
	
<%
   User obj = (User)session.getAttribute("userDetails");
if(obj != null){
	 %>
	
	<div class="span9">
		<tiles:insertAttribute name="mainMenu" />
	</div>
<%}
%>
</div>
<% 	if(obj != null){
	 %>
	<div style="width:100px">
		<tiles:insertAttribute name="leftSideMenu" />
	</div>
<%}
%>
	
	
	<div style="width:500px">
		<tiles:insertAttribute name="body" />
	</div>


	<div class="span9">
		<tiles:insertAttribute name="footer" />
	</div>
	
	
	<div class="row">
  <div class="span9">
    Level 1 column
    <div class="row">
      <div class="span6">Level 2</div>
      <div class="span3">Level 2</div>
    </div>
  </div>
</div>
	
	
	</body>
 </html>


