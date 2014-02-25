<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../expt/css/home.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div id="auform" class="gwd-div-d25v">
    	<s:form action="ExpenseAct">
			<s:textfield name="Amount" label="Amount" />
			<s:textfield name="Notes" label="Notes" />
			<s:textfield name="Category" label="Category" />
			<s:textfield name="expensedate" label="Date"/>
			<sj:textfield name="Currency" label="Curreny" />
			<s:submit/>
		</s:form>
    </div>
</body>
</html>