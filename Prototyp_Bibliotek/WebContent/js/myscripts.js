$(document).ready(function() {

	
	$("#registerpanel").hide();
	
	$("#register").click(function(){

		$("#registerpanel").slideToggle(250);

	});


});

$(document).ready(function() {
	
	$("#katalogisera").hide();
	$("#listaAllt").hide();
	$("#listaEnskildTitel").hide();
	$("#avregistreraKnapp2").hide();
	$(".taBortInput").hide();
	$("#listaPagaendeLan").hide();
	$("#redigeraAnvandare").hide();
	
	$("#katalogiseraKnapp").click(function(){

		$("#katalogisera").fadeToggle(500);
		$("#listaAllt").hide();
		$("#listaEnskildTitel").hide();
		$("#searchedTitle").hide();
		$("#listaPagaendeLan").hide();
		$("#redigeraAnvandare").hide();
	});
	$("#listaAlltKnapp").click(function(){
		$("#listaAllt").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaEnskildTitel").hide();
		$("#searchedTitle").hide();
		$("#listaPagaendeLan").hide();
		$("#redigeraAnvandare").hide();
	});
	$("#listaEnskildTitelKnapp").click(function(){
		$("#listaEnskildTitel").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaAllt").hide();
		$("#searchedTitle").hide();
		$("#listaPagaendeLan").hide();
		$("#redigeraAnvandare").hide();
		
	});
	$("#pagaendeLanKnapp").click(function(){
		$("#listaPagaendeLan").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaAllt").hide();
		$("#searchedTitle").hide();
		$("#listaEnskildTitel").hide();
		$("#redigeraAnvandare").hide();
	});
	$("#redigeraAnvandareKnapp").click(function(){
		$("#redigeraAnvandare").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaAllt").hide();
		$("#searchedTitle").hide();
		$("#listaEnskildTitel").hide();
		$("#listaPagaendeLan").hide();
	});
	
	
	$("#avregistreraKnapp").click(function(){
		$(".taBortInput").slideToggle(500);
		$("#avregistreraKnapp2").slideToggle();

	});

	

});
