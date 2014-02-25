<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
<head>
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
$(document)
.ready(function() {
	var counter = 0;
	$("#addrow").on("click", function() {
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
				if (counter == 4)
					$('#addrow')
							.attr('disabled', true)
							.prop('value',
									"You've reached the limit");
				$("table.reportadd").append(newRow);
				counter++;
			});

	$("table.reportadd").on("click",".delrow",
		function(event) {
			$(this).closest("tr").remove();
			counter -= 1;
			$('#addrow').attr('disabled', false).prop(
					'value', "Add Row");
		});
	
	$("#Save").on("click", function(){
		var result = document.getElementsByName("Amount");
		var amt = "amount=";
			for(var i=0; i<result.length; i++){
			 amt = amt + result.item(i).value + ";";
			}
		result = document.getElementsByName("Category");
		var cat = "Category=";
			for(var i=0; i<result.length; i++){
				cat = cat + result.item(i).value + ";";
			}
		result = document.getElementsByName("Users");
		var users = "Users=";
			for(var i=0; i<result.length; i++){
				users = users + result.item(i).value + ";";
			}
		result = document.getElementsByName("expensedate");
		var expensedate = "expensedate=";
			for(var i=0; i<result.length; i++){
				expensedate = expensedate + result.item(i).value + ";";
			}
		result = document.getElementsByName("Currency");
		var Currency = "Currency=";
			for(var i=0; i<result.length; i++){
				Currency = Currency + result.item(i).value + ";";
			}
		result = document.getElementsByName("Currency");
		var Currency = "Currency=";
			for(var i=0; i<result.length; i++){
				Currency = Currency + result.item(i).value + ";";
			}
		result = document.getElementsByName("Notes");
		var Notes = "Notes=";
			for(var i=0; i<result.length; i++){
				Notes = Notes + result.item(i).value + ";";
			}
		var param = "action=saveExpense&" + amt+"&"+cat+"&"+users+"&"+expensedate+"&"+Currency+"&"+Notes;
		alert(param);
		$.ajax({
		    url :"/expt/ExpenseAct.action?",
		    type: "POST", 
		    date: param,
		    success: function(data, textStatus, jqXHR)
		    {
		    	alert("\nStatus: " + status);
		    }
		  });
		return false;
	});

});
</script>
</head>
<body>
	<div id="auform" class="gwd-div-d25v"> 
		<div id='TextBoxesGroup'>
			<s:hidden name="reportmap" value="%{reportmap}" />
			<div id="TextBoxDiv1">
				<table class="reportadd" id="reportsadd">
					<tr>
						<th>Amount</th>
						<th>Category</th>
						<th>Users</th>
						<th>Date</th>
						<th>Currency</th>
						<th>Notes</th>
					</tr>
					<s:iterator value="expenseMap" status="status">
						<s:iterator value="value">
							<s:set var="%{key}" value="%{value}"/>
						</s:iterator>
						<tr>

							<TD><sj:textfield name="Amount" id="Amount" value="%{amount}" /></TD>
							<TD><sj:textfield name="Category" id="Category"  value="%{category}" /></TD>
							<TD><sj:textfield name="Users" id="Notes" value="%{users}" /></TD>
							<TD><sj:textfield name="expensedate" id="expensedate" value="%{expensedate}" /></TD>
							<TD><sj:textfield name="Currency" id="Currency" value="%{currency}" /></TD>
							<TD><sj:textfield name="Notes" id="Notes" value="%{notes}" /></TD>
							<s:if test="#status.count == 2">
								<td><input type="button" class="delrow"  value="Delete"></td>
							</s:if>
						</tr>
					</s:iterator>
				</table>
			</div>
			<button class="add" id="addrow">Add Expense to Report</button>
			<button class="Save" id="Save">Save Report</button>
		</div>
	</div>
</body>
</html>