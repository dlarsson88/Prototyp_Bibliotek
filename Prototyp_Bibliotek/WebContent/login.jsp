<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" name="viewport" content="width=device-width">
<title>Login Page</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mystyles.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
    <script src="js/myscripts.js"></script>
    <link rel="shortcut icon" href="http://www.odontologi.gu.se/kirurgi/img/gu_logga.png">
</head>
<body>
<div class="page-header">
<h1>  <a href="main.jsp"> <span class="glyphicon glyphicon-book"></span> Bibliotek Informatika</a> <small>Inloggning</small> </h1>
</button>
</div>
	<form action="login" method = "post">
		User Name: <input type = "text" name = "userName" />
		<br>
		Password: <input type = "password" name = "password" />
		<br>
		<input type = "submit" value="Logga in" class="btn btn-primary btn-sm"/>
	</form>
	<br>
	
	<button type="button" class="btn btn-success btn-default" id="register"><strong>+</strong>
  <span class="glyphicon glyphicon-user"></span> Har du ingen anv�ndare?
	</button>
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
		<input type = "submit" value="Registrera" class="btn btn-primary btn-sm"/>
	</form>
</body>
</html>