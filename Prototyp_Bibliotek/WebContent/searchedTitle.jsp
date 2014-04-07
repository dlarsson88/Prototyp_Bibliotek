<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList" import="se.prototyp.services.GetLiteratureService"
    import="java.text.SimpleDateFormat" import="java.util.Date"
    import="java.util.Collections"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibliotek Informatika</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mystyles.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>	
    <script src="js/myscripts.js"></script>
	
	<link rel="shortcut icon" href="http://www.odontologi.gu.se/kirurgi/img/gu_logga.png">
</head>
<body>
<div class="page-header">
<h1>  <a href="main.jsp"> <span class="glyphicon glyphicon-book"></span> Bibliotek Informatika</a> <small>Administration</small> </h1>
</button>
</div>
<nav class="navbar navbar-default" role="navigation">	
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li id="katalogiseraKnapp"><a href="#">Katalogisera</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Lista <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li id="listaAlltKnapp"><a href="#">Samtliga verk<span class="badge">
            <%
            GetLiteratureService gts = new GetLiteratureService();
  			int amount = gts.getNumberOfTitles()+1;
            %>
            <%=amount %>
            </span></a></li>
            <li id="listaEnskildTitelKnapp"><a href="#">Enskilt verk</a></li>
            <li id="pagaendeLanKnapp"><a href="#">Pågående lån</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profil <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">xxx</a></li>
            <li><a href="#">xxx</a></li>
            <li><a href="#">xxx</a></li>
            <li class="divider"></li>
            <li><a href="#">xxx</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>




	<form id = "katalogisera" action="catalog" method = "post" class="navbar-form navbar-left">
		Titel: <input type = "text" name = "title" class="form-control" placeholder="Titel..."/>
		<br><br>
		<input type = "submit" value="Lägg till" class="btn btn-primary"/>
	</form>



<div id="listaAllt">
	<div id="listTitlesFunction">
	<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	%>
	<strong>Hämtat:</strong> <%=sdf.format(date) %> 
	<br>
	<br>
	
    <button type="button" class="btn btn-danger" id="avregistreraKnapp">Avregistrera</button>
	<button type="button" class="btn btn-danger btn-lg" id="avregistreraKnapp2">
  	<span class="glyphicon glyphicon-remove"></span> Avregistrera
	</button>
	
	<br>
	<br>
	<form>
	<%
	GetLiteratureService getLiteratureService = new GetLiteratureService();
	ArrayList<String> list = getLiteratureService.getLiterature();
	for(String book: list){
	%>
	<!--

	-->
  <ul class="list-group">

	<li class="list-group-item list-group-item-info" id="bokListning"><input type="checkbox" class="taBortInput">Bok: <%=book %> </li>
	<%} %>
	</ul>
	</form>
	<%

	
	%>
	

	</div>
</div>

<div id="listaEnskildTitel">
      <form class="navbar-form navbar-left" role="Sök" action="getLiterature" method="post" >
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Titel..." name="soktTitel">
        </div>
        <button type="submit" class="btn btn-default" id="search">Sök</button>
      </form>	
</div>

<div id="searchedTitle">
	<%
	GetLiteratureService getLiteratureService2 = new GetLiteratureService();
	ArrayList<String> list2 = getLiteratureService2.getLiterature(request.getParameter("soktTitel"));
	for(String book: list2){
	%>
	Bok: <%=book %>
	<br>
	<%} %>
</div>

</body>
</html>