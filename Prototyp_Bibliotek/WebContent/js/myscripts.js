/*
 * A page can't be manipulated safely until the document is "ready." 
 * jQuery detects this state of readiness for you. 
 * Code included inside $( document ).ready() will only run once the page 
 * Document Object Model (DOM) is ready for JavaScript code to execute. 
 */
$(document).ready(function() {
	
	// Gömmer alla paneler i de dokument som importerat detta javascript-dokument öppnas.
	$("#registerpanel").hide();
	$("#katalogisera").hide();
	$("#listaAllt").hide();
	$("#listaEnskildTitel").hide();
	$("#avregistreraKnapp2").hide();
	$(".taBortInput").hide();
	$("#listaPagaendeLan").hide();
	$("#redigeraAnvandare").hide();
	
	
	// När registerknappen klickats på kör vi denna funktion..
	// Denna knapp har getts id="register" i dokumentet login.jsp.
	// Vi når detta id genom att ange den som #register.
	// Denna del kallas för selectorn. ---> http://api.jquery.com/id-selector/
	$("#register").click(function(){
		
		// Registerpanelen slidar in (eller ut) med en snabbhet av "250".
		// Registerpanelen har getts id="registerpanel" i dokumentet login.jsp.
		$("#registerpanel").slideToggle(250);

	});
	// Funktion slut
	
	// Ny funktion... samma mönster gäller.
	$("#katalogiseraKnapp").click(function(){
		
		$("#katalogisera").fadeToggle(500);
		// Observera att vi gömmer alla paneler som inte är "katalogiserapanelen". Vi vill endast att katalogiserapanelen ska synas.
		// Observera också att det säkert kan göras 100 gånger bättre om man förstår vad man håller på med.
		// Detta är självklart inte ett bra sätt att göra saker på men det fungerar.. for now.
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
