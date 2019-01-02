<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">

.formcontainer{
border: 1px solid #B8B8B8;
padding:50px,60px;
margin-top:20vh;
}

.heading{
text-align:center;
}
.submitbutton{
margin-bottom:3%;
}


-webkit-box-shadow: -1px 4px 26px 11px rgba(0,0,0,0.75);
-moz-box-shadow: -1px 4px 26px 11px rgba(0,0,0,0.75);
box-shadow: -1px 4px 26px 11px rgba(0,0,0,0.75);
</style>
</head>
<body>

<div class="container-fluid">
<div class="row">
<div class="col-md-3"> <!-- Left size --></div>
<div class="col-md-6">


<form method="post" action="loginprocess.jsp" class="formcontainer" >
<div class="heading">
<h1>Login Form</h1>
</div>
<div class="form-group">
<label for="email purpose">Email-address</label>
<input type="email" class="form-control" name="email" id="emailId" placeholder="Enter your Email">
<small id="emailHelp" class="form-text text-muted">We'll never share your email</small>
</div>

<div class="form-group">
<label for="password purpose">Password</label>
<input type="password" class="form-control" name="password" id="passwordId" placeholder="Enter your Password"> 
</div>

<button type="submit" class="btn btn-success btn-block submitbutton">Submit</button>

</form>
</div><!-- end of middle row -->
</div><!--  end of row -->
</div>

</body>
</html>
