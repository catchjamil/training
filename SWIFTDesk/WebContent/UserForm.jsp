<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
  <center><b><s:property value="message" /></b></center>
	<s:form action="userForm">
		<s:textfield name="user.uname" label="Enter Username" />
		<br>
		<s:password name="user.password" label="Enter Password" />
		<br>
		<s:password name="user.password" label="Confirm Password" />
		<br>
		<s:textfield name="user.firstName" label="First Name" />
		<br>
		<s:submit value="Submit" align="center" />
	</s:form>
	`
</body>
</html>