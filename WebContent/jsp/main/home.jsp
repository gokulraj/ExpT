<!DOCTYPE html>
<html>
  
  <head>
  	<link rel="stylesheet" type="text/css" href="../expt/css/home.css">
  	<script src="../expt/js/jquery.js"></script>
    <title>Expense Tracker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 </head>
 <script type="text/javascript">
    $(document).ready(function(){
    	  $('#ehome').click(function() {
	    	  $('#content').load("/expt/ehome.action");
	    	  return false;
	    	});
    	  
    	  $('#users').click(function() {
	    	  $('#content').load("/expt/users.action");
	    	  return false;
	    	});
    });
	  
   </script>
     
  <body>
    <nav class="gwd-nav-j1aq">
    	<span class="gwd-span-0bql">
    		<a id="ehome" href="#">EXPENSE </a>	&nbsp; &nbsp; 
    		<a href="/expt/reports.action">REPORTS </a> &nbsp; &nbsp;
    		<a id="users" href="#">USERS </a>
    	</span>
    </nav>
    
    <div id="content"></div>
  </body>

</html>