<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account summary</title>
</head>
<body>
<a href="getTransferSum.action">Account statement</a>
<table class="table table-stripped">
   <thead>
      <tr>
         <th>Account Number</th>
         <th>Name of sender</th>
         <th>Amount</th>
         <th>Des. Acc. No.</th>
         <th>Payee Name</th>
         
      </tr>
   </thead>
 <s:iterator   status="stat" value="list1" >  
  <tbody> 
  <tr>
  <td><s:property value="sourceAcc"/></td>
   <td><s:property value="Oor"/></td>
    <td><s:property value="transferAmount"/></td>
     <td><s:property value="destinationAcc"/></td>
           <td><s:property value="beneficiary"/></td>
  </tr>
 </s:iterator>

   </tbody>
<s:submit value="Submit"/>
</table>
</body>
</html>