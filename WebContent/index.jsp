<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
<sb:head/>
</head>
<body>
 <div >

	<s:form action="verify" cssClass="">
		<s:textfield 
	 
		name="user.uname" 
		label="Enter Username" />
		<br>
		<s:password 
 	name="user.password" 
		label="Enter Password" 
		 />
		<br>
		
		 <s:submit cssClass="btn btn-primary"/>
 		<s:reset cssClass="btn btn-danger"/>
	</s:form>
	
	
	<br>
	<a href="fwdToUserRegistration.action">User Registration</a>
	<a href="hello.action">Say Hello</a>
	<br>
	<a href="role.action">ROLE SEARCH FORM</a>
</div>	
</body>
</html>