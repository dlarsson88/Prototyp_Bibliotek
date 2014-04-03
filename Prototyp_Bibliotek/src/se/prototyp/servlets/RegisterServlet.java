package se.prototyp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.prototyp.services.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName, firstName, familyName, password;
		userName = request.getParameter("userName");
		firstName = request.getParameter("firstName");
		familyName = request.getParameter("familyName");
		password = request.getParameter("password");
		RegisterService registerService = new RegisterService();
		RequestDispatcher dispatcher;
		
		if(userName != "" && firstName != "" && familyName != "" && password != ""){
			boolean result = registerService.addUser(userName, firstName, familyName, password);
			if(result){
				dispatcher = request.getRequestDispatcher("registersuccess.jsp");
				dispatcher.forward(request, response);
				return;
			}
			else{
				dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
