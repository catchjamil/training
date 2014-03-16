<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <html>
   <head>
      <title>Bootstrap</title>
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


<div id="header">
	<tiles:insertAttribute name="myHeader" />
</div>
<div id="wrap">
	<div id="content">
		<tiles:insertAttribute name="myBody" />
	</div>
	<div id="sidebar">
		<tiles:insertAttribute name="mymenu" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="myFooter" />
	</div>
</div>
     
	</body>
 </html>


