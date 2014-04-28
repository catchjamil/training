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
<h3>Menu Adder</h3><hr>

<s:form action="menuForm" >	
<s:property value="message"/>
<br>
<s:textfield  name="menu.name" label="Menu Name"/>
<s:textfield  name="menu.href" label="Link "/>
<s:select name="menu.parentId" list="menulist" listKey="id"
		  headerKey="-1" headerValue="Select Parent Menu" 
		  listValue="name"  label="Parent ID"/>
<tr><td>&nbsp;</td></tr>
<tr><td></td>
<td><s:submit theme="simple"/>
<s:reset theme="simple"/></td></tr>
<table class="table table-striped">
   <caption>Menu </caption>
   <thead>
      <tr>
         <th>Id</th>
         <th>Name </th>
         <th>URL</th>
         <th>Parent Id</th>
      </tr>
   </thead>
   <tbody>
   <s:iterator status="stat" value="menulist">
      <tr>
        <td><s:property value="Id"/>    
		<td><s:property value="name"/>  
		<td><s:property value="href"/> 
		<td><s:property value="parentId"/> 
      </tr>
    </s:iterator>  
   </tbody>
</table>



</s:form>
</body>
</html>