<!DOCTYPE html>
<html>
  
  <head>
    <title>Expense Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../expt/css/home.css">
  </head>

 <script type="text/javascript">
    $(document).ready(function(){
    	  $('#useradd').click(function() {
	    	  $('#usersadd').load("/expt/adduser.action");
	    	  return false;
	    	});
    });
	  
   </script>
     
  <body>
    <nav class="gwd-div-ibs0">
    	<span class="gwd-span-41le">
    		<a id="useradd" href="#">Add </a>	&nbsp; &nbsp; 
    		<!--  <a href="/expt/users.action">Delete</a> -->
    	</span>
    </nav>
    
    <div id="usersadd" ></div>
    
  </body>

</html>