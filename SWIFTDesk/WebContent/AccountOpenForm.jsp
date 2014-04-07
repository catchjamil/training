<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head/>
<sb:head/>
</head>
<body>

<s:form>
<div>
<s:select name="userTitle"
headerKey="-1" headerValue="Select" list="#{'Mr.':'Mr.','Mrs.':'Mrs.','Miss':'Miss'}" label="Name"/>
<s:textfield name="firstName" label="First name"/>
<s:textfield name="middleName" label="Middle name"/>
<s:textfield name="lastName" label="Last name" />
</div>
<s:textfield name="fatherName" label="Father's Name"/>
<s:textfield name="motherName" label="Mother's Name"/>

<s:datetimepicker name="dob" label="DOB" displayFormat="dd-MMM-yyyy"   required="true" />

<s:textfield name="nationality" label="Nationality"/>
<s:label label="Correspondence Address(Current Address)"/>
<s:textarea name="address" label="Address"/>
<s:textfield name="state" label="State"/>
<s:textfield name="pin" label="PIN"/>
<s:textfield name="city" label="City/District"/>
<s:label label="Permanent Address"/>
<s:select name="userTitle"
headerKey="-1" headerValue="Select" list="#{'No':'No','Yes':'Yes'}" label="Same as Correspondence"/>

<s:textarea name="address" label="Address"/>
<s:textfield name="state" label="State"/>
<s:textfield name="pin" label="PIN"/>
<s:textfield name="city" label="City/District"/>
<s:textfield name="phoneNo" label="Phone No."/>
<s:textfield name="email" label="E-mail"/>
<s:submit/>
<s:reset/>
</s:form>


</body>
</html>