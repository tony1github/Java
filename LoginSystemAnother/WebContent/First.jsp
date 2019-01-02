<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Management</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.check{
font-size:100px;
}
</style>
</head>
<body>
<h1>Yoh I am here!!</h1>

<div class="check">
Great
</div>

<%
		if(session.getAttribute("Id")== null)
		{
			response.sendRedirect("index.jsp");
		}
%>


<div class="row">
<div class="col-md-2 col-sm-2 col-xs-6"><!-- left Side --></div>
<div class="col-md-8 col-sm-8 col-xs-24"><!-- Middle Side -->

<%@ page import="bean.LoginDao"
		import="java.util.*"
		import="bean.Sms"
 %>

<div class="table-responsive-sm table-responsive-md table-responsive-lg">
<table class="table table-hover">
<thead class="thead-dark">
<tr>
<th scope="col">Id</th>
<th scope="col">Call_From</th>
<th scope="col">Call_To</th>
<th scope="col">Message</th>
</tr>
</thead>
<tbody>
<%  LoginDao object1 = new LoginDao();
	List<Sms> check = new ArrayList<>();
	
	String spageid=request.getParameter("page");  
	int pageid=Integer.parseInt(spageid);  
	int total=3;  
	if(pageid==1){}  
	else{  
	    pageid=(pageid-1)*total+1;  
	}  
	
	check = object1.getSmsDetails(pageid ,total);

	for(Sms sms: check)
{
//	System.out.println(sms.getId());
}	

if(!check.isEmpty())
{
	for(int i=0;i<check.size();i++)
	{ 	System.out.println(check.get(i).getCall_From()+ check.get(i).getMessage());
		int Id = check.get(i).getId(); 
		long Number1 = check.get(i).getCall_From();
		long Number2 = check.get(i).getCall_To();
		String Message = check.get(i).getMessage();
		
		%>
<tr>
<td><%= Id %></td>
<td><%= Number1 %></td>
<td><%= Number2 %></td>
<td><%= Message %></td>
</tr>
<%} } %>

</tbody>
</table>
</div>



</div>
<div class="col-md-2 col-sm-2 col-xs-6">

<form action="First">
<input type="submit" value="logout">
</form>


</div>
</div>


Details are shown below:
<br/>
<br/>
Id:<%= session.getAttribute("Id") %><br/>
Name:<%= session.getAttribute("Name") %><br/>
Surname:<%= session.getAttribute("Surname") %><br/>
Location:<%= session.getAttribute("Location") %><br/>
PhoneNo:<%= session.getAttribute("Phone") %><br/>



<% int iteratorNumber = object1.countDatabase();
	for(int i=1;i<=iteratorNumber;i++)
	{%>
		<a href="First.jsp?page=<%= i %>"><%= i %></a>	
<%}
%>


</body>
</html>
