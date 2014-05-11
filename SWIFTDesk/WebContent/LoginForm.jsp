<%@ taglib prefix="s" uri="/struts-tags"%>
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
		 
		 <tr><td> &nbsp; </td>	<td>&nbsp;</td></tr>
		<tr><td> 
		 </td>
 		<td><s:submit theme="simple"/><s:reset theme="simple"/></td></tr>
	</s:form>
	
	
	
</div>	
