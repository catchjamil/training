<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
      <title>Bootstrap 101 Template</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="js/jquery-2.1.0.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="bootstrap/js/bootstrap.min.js"></script>
      
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script>
$(document).ready(function(){
	$("#nav li").hover(
	function(){
		$(this).children('ul').hide();
		$(this).children('ul').slideDown('fast');
	},
	function () {
		$('ul', this).slideUp('fast');            
	});
});
</script>
      
      
   </head>
   <body>
<h4 align="center"> Greetings from SwiftDesk</h4>


<br>
</body>
</html>