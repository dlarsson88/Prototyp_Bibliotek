package se.prototyp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.prototyp.services.AddLiteratureService;

@WebServlet("/catalog")
public class AddLiteratureServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String title = req.getParameter("title");
		AddLiteratureService addLiteratureService = new AddLiteratureService();
		RequestDispatcher dispatcher;
		
		if(addLiteratureService.addLiterature(title) > 0){
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		else{
			System.out.println("Ej tillagd.");
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
	}

}
