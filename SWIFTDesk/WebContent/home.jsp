<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <s:property value="message"/>  
 <table class="table table-striped">
   <caption >Account Details </caption>
   <thead>
      <tr>
         <th>Account Number</th>
         <th>Account Type </th>
         <th>Balance</th>
         
      </tr>
   </thead>
   <tbody>
  <s:iterator status="stat" value="accountDetails">
      <tr>
        <td><s:property value="accountnumber"/>    
		<td><s:property value="accounttype"/>  
		<td><s:property value="balance"/> INR
		
      </tr>
   </s:iterator>
   </tbody>
</table>
  