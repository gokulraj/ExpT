<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="../expt/css/home.css">
<script src="../expt/js/jquery.js"></script>
<title>Expense Tracker</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>

<body>
	
	<div class="report" >
		<s:form action="creatreport">
			<s:textfield name="reportname" label="Reportname" />
			<s:submit label="Creat Report"/>
		</s:form>

	</div>
	
</body>

</html>