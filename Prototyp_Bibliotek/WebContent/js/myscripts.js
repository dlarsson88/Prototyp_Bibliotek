$(document).ready(function() {

	
	$("#registerpanel").hide();
	
	$("#register").click(function(){

		$("#registerpanel").fadeToggle(500);

	});


});

$(document).ready(function() {
	
	$("#katalogisera").hide();
	$("#listaAllt").hide();
	$("#listaEnskildTitel").hide();
	$("#avregistreraKnapp2").hide();
	$(".taBortInput").hide();
	
	$("#katalogiseraKnapp").click(function(){

		$("#katalogisera").fadeToggle(500);
		$("#listaAllt").hide();
		$("#listaEnskildTitel").hide();
		$("#searchedTitle").hide();
	});
	$("#listaAlltKnapp").click(function(){
		$("#listaAllt").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaEnskildTitel").hide();
		$("#searchedTitle").hide();
	});
	$("#listaEnskildTitelKnapp").click(function(){
		$("#listaEnskildTitel").fadeToggle(500);
		$("#katalogisera").hide();
		$("#listaAllt").hide();
		$("#searchedTitle").hide();
		
	});
	$("#avregistreraKnapp").click(function(){
		$(".taBortInput").slideToggle(500);
		$("#avregistreraKnapp2").slideToggle();

	});
	
	

});
