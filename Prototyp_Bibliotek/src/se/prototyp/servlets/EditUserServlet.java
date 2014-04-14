package se.prototyp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.prototyp.services.EditUserService;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String StringId = (String) session.getAttribute("savedUserId");
		int id = Integer.parseInt(StringId);
		String userName = (String) req.getParameter("userName");
		String firstName = (String) req.getParameter("firstName");
		String familyName = (String) req.getParameter("familyName");
		String password = (String) req.getParameter("password");
		
		EditUserService editUserService = new EditUserService();
		RequestDispatcher dispatcher;

		if(editUserService.editUser(id, userName, firstName, familyName, password)){
			session.setAttribute("savedUserName", userName);
			session.setAttribute("savedFirstName", firstName);
			session.setAttribute("savedFamilyName", familyName);
			session.setAttribute("savedPassword", password);
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		else{
			dispatcher = req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
	}
	
	
}
