package se.prototyp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.prototyp.services.GetLiteratureService;

@WebServlet("/getLiterature")
public class GetLiteratureServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GetLiteratureService getLiteratureService = new GetLiteratureService();
		// Vi h�mtar ut all litteratur fr�n databasen och spar allt i en lista.
		ArrayList<String> literature = getLiteratureService.getLiterature();
		RequestDispatcher dispatcher;
		
		dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, resp);
		return;

		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Vi spar ner den data anv�ndaren skrivit in i formul�ret.
		String title = req.getParameter("soktTitel");
		GetLiteratureService getLiteratureService = new GetLiteratureService();
		// Vi h�mtar ut all litteratur (som har titeln) fr�n databasen och spar allt i en lista.
		ArrayList<String> literature = getLiteratureService.getLiterature(title);
		RequestDispatcher dispatcher;

		dispatcher = req.getRequestDispatcher("searchedTitle.jsp");
		dispatcher.forward(req, resp);
		return;
	}
	
}
