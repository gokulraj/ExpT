<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="../expt/css/home.css">
<script src="../expt/js/jquery.js"></script>
<title>Expense Tracker</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	$(document).ready(function() {
		$('#selectreport').change(function() {
			window.location="/expt/ExpenseAct.action?action=elist&selectreport="+this.value; 
			return false;
		});
	});
</script>
</head>

<body>
	<h4 class="gwd-h4-a32x">
		<span class="gwd-span-0owa">Expense Tracker</span>
	</h4>

	<nav class="gwd-nav-j1aq">

		<div id="reports" class="gwd-span-0bql">
			<s:select name="selectreport" headerKey="0" headerValue="Select a Report"
				label="Select Reports" list="reportmap" value="%{defaultReport}"  />
			<a href="/expt/jsp/reports/CreatReport.jsp">Create report</a>
			<a href="/expt/jsp/reports/CreatReport.jsp">Generate report</a>
		</div>
	</nav>
	<s:hidden name="defaultReport" value="%{defaultReport}"/>
	<div id="content">
		<s:include value="/jsp/expenses/expensereport.jsp" />
	</div>
	<div id="testing"></div>
</body>

</html>