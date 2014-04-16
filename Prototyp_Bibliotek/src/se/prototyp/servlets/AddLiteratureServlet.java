package se.prototyp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.prototyp.services.AddLiteratureService;
import se.prototyp.services.DBConsistencyService;

@WebServlet("/catalog")
public class AddLiteratureServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String title = req.getParameter("title");
		AddLiteratureService addLiteratureService = new AddLiteratureService();
		RequestDispatcher dispatcher;
		
		// Vi kollar om boken redan existerar i databasen. 
		DBConsistencyService consistency = new DBConsistencyService();
		if(consistency.checkIfLiteratureExists(title)){
			req.setAttribute("svar", "Verket du försöker lägga till finns redan i databasen.");
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
		}
		
		// Vi kollar om boken lyckas läggas in i databasen.
		if(addLiteratureService.addLiterature(title) > 0){
			req.setAttribute("svar", "Verket har lagts till i databasen.");
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		else{
			req.setAttribute("svar", "Verket kunde inte läggas till.");
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
	}

}
