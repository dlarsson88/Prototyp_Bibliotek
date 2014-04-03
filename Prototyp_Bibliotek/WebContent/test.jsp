<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="se.prototyp.database.DBOperations" import="java.util.ArrayList"
    import="java.text.SimpleDateFormat" import="java.util.Date"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testtesttest</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mystyles.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
    <script src="js/myscripts.js"></script>
</head>
<body>

<%
DBOperations dbo = new DBOperations();
ArrayList<String> list = dbo.getBooks();
for(String book: list){
%>
Bok: <%=book %>
<br>
<%} %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

%>

Hämtat: <%=sdf.format(date) %> 

</body>
</html>