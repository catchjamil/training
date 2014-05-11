<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>Menu Link Adder</title>
      
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<h3>Role Menu Mapper</h3><hr>

<s:form action="roleMenu" >	
<s:property value="message"/>
<s:select name="role.Id" list="Rolelist" listKey="Id"
		  headerKey="-1" headerValue="Select Role" 
		  listValue="roleName"  label="Role"/>
<tr><td>&nbsp;</td></tr>
<tr><td></td>
<td><s:submit theme="simple"/>
<s:reset theme="simple"/></td></tr>
<table class="table table-striped">
   <caption>Edit Menu </caption>
   <thead>
      <tr>
         <th>Menu Id</th>
         <th>Menu Name</th>
      </tr>
   </thead>
   <tbody>
   <s:iterator status="stat" value="Menulist">
      <tr>
        <td><s:property value="Id"/>    
		<td><s:property value="name"/>  
		<td> 
		 
      </tr>
    </s:iterator>  
   </tbody>
</table>



</s:form>
</body>
</html>