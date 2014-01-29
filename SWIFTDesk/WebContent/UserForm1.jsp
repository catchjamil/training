

<html>
<body>
	<center><b><s:property value="message" /></b></center>
	<s:form action ="userForm">
      <s: textfeild name="user.name"  label ="Enter Email Id"/>
      <br>
      <s: password name ="user.password" label="Enter Password" />
      <br>
      <s: password name="user.password" label="Confirm Password" />
      <br>
      <s: textfeild name="user.firstName" label="First Name" />
      <br>
      <s:submit value="Submit" align="center" />
	</s:form>

</body>
</html>
