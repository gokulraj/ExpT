<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../expt/css/home.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div id="auform" class="gwd-div-d25v">
    	<s:form action="user">
			<s:textfield name="username" label="Username" />
			<s:textfield name="firstname" label="First Name" />
			<s:textfield name="lastname" label="Last Name" />
			<s:textfield name="email" label="Email"/>
			<s:submit/>
		</s:form>
    </div>
</body>
</html>