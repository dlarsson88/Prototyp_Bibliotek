package se.prototyp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.prototyp.services.GetLoansService;

@WebServlet("/getLoans")
public class GetLoansServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		GetLoansService getLoans = new GetLoansService();
		// Vi hämtar alla lån ifrån databasen och spar dem i en lista.
		ArrayList<String> loans = getLoans.getLoans();
		
		RequestDispatcher dispatcher;
		
		dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, resp);
		return;
	}
}
