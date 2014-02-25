<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/home.css">
<script src="../../js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style>
table.reportadd {
	font-family: Arial;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.reportadd th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.reportadd td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
<script type="text/javascript">
$(document).ready(function () {
    var counter = 0;

    $("#addrow").on("click", function () {
        counter = $('#reportsadd tr').length - 2;
        var newRow = $("<tr>");
        var cols = "";

        
    	cols += '<TD><input type="text" name="Amount' + counter +  '" id="Amount' + counter +  '"/></TD>';
       	cols += '<TD><input type="text" name="Category' + counter +  '" id="Category' + counter +  '"/></TD>';
       	cols += '<TD><input type="text" name="Notes' + counter +  '" id="Notes' + counter +  '"/></TD>';
       	cols += '<TD><input type="text" name="expensedate' + counter +  '" id="expensedate' + counter +  '"/></TD>';
       	cols += '<TD><input type="text" name="Currency' + counter +  '" id="Currency' + counter +  '"/></TD>';
       	cols += '<TD><input type="text" name="Users' + counter +  '" id="Users' + counter +  '"/></TD>';
       	cols += '<td><input type="button" class="delrow"  value="Delete"></td>';
        newRow.append(cols);
        if (counter == 4) $('#addrow').attr('disabled', true).prop('value', "You've reached the limit");
        $("table.reportadd").append(newRow);
        counter++;
    });

   
    $("table.reportadd").on("click", ".delrow", function (event) {
        $(this).closest("tr").remove();
        counter -= 1;
        $('#addrow').attr('disabled', false).prop('value', "Add Row");
    });


});

</script>
</head>
<body>

<s:select headerKey="0" headerValue="Select Month"
 name="smonth" list="#{'1':'Jan','2':'Feb','3':'Mar','4':'Apr','5':'May','6':'Jun'}" 
 value="1" />
 
	<div id="auform" class="gwd-div-d25v">
		<div id='TextBoxesGroup'>
			<button class="add" id="addrow" >Add</button>
			<div id="TextBoxDiv1">
				<table class="reportadd" id="reportsadd">
					<tr>
						<th>Amount</th>
						<th>Notes</th>
						<th>Category</th>
						<th>Date</th>
						<th>Currency</th>
						<th>Users</th>
					</tr>
					<tr>
					<TR>
						<TD><sj:textfield name="Amount" label="Amount" id="Amount1" /></TD>
						<TD><sj:textfield name="Notes" label="Notes" id="Notes1" /></TD>
						<TD><sj:textfield name="Category" label="Category" id="Category1" /></TD>
						<TD><sj:textfield name="expensedate" label="Date" id="expensedate1" /></TD>
						<TD><sj:textfield name="Currency" label="Currency" id="Currency1" /></TD>
						<TD><sj:textfield name="Users" label="Users" id="Users1" /></TD>
						
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>