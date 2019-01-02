<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sms Data</title>



<style type="text/css" title="currentStyle">
			@import "./resource/css/demo_table_jui.css";
			@import "./resource/css/jquery-ui-1.9.2.custom.min.css";
</style>
<style>
.table-container{
 width:800px;
}
tr.odd{
background: #EDE4D4 !important;
}
tr.odd td.sorting_1{
background: #EDE4D4 !important;
}
tr.even td.sorting_1{
background: #fff !important;
}
</style>
</head>
<body>
<%
		if(session.getAttribute("Id")== null)
		{
			response.sendRedirect("index.jsp");
		}
%>

<div class="row">
<div class="col-md-2 col-sm-4 col-xs-6"><!-- left Side -->
</div>
<div class="col-md-8 col-sm-4 col-xs-24"><!-- Middle Side -->
<div class="table-container table-responsive-sm table-responsive-md table-responsive-lg">
	  	<table  cellpadding="0" cellspacing="0" border="0"  class="display jqueryDataTable">
			<thead>
				<tr>
				   <th>Id</th>
					<th>Call_From</th>
					<th>Call_To</th>
					<th>Message</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
	 	</table>
  	</div> 	
<!-- End of Middle Side -->  
</div>
<div class="col-md-2 col-sm-4 col-xs-6">
<form action="FirstServlet" method="post">
<input type="submit" value="logout">
</form>

<!-- End of Right Side Div --></div>
<!-- End of Row --></div>  	


  	<script src="./resource/js/jquery-1.8.3.min.js"></script>
  	<script src="./resource/js/jquery.dataTables.min.js"></script>
  	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  	<script src="./resource/js/my-demo-table-script.js"></script>
  	
  	
 
</body>
</html>