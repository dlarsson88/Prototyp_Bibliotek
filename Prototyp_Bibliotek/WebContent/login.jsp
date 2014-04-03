<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mystyles.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
    <script src="js/myscripts.js"></script>
    
</head>
<body>
	<div class="page-header">
  		<h1>Logga in <small></small></h1>
	</div>
	<form action="login" method = "post">
		User Name: <input type = "text" name = "userName" />
		<br>
		Password: <input type = "password" name = "password" />
		<br>
		<input type = "submit" value="Logga in"/>
	</form>
	<br>
	
	<button type="button" id="register">Har du ingen användare?</button>
	<form id = "registerpanel" action="register" method = "post">
		<div class="page-header">
  			<h1>Registrera <small></small></h1>
		</div>
		User name: <input type = "text" name = "userName" />
		<br>
		First Name: <input type = "text" name = "firstName" />
		<br>
		Family Name: <input type = "text" name = "familyName" />
		<br>
		Password: <input type = "password" name = "password" />
		<br>
		<input type = "submit" />
	</form>
</body>
</html>