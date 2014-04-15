package se.prototyp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.prototyp.services.GetUserInfoService;
import se.prototyp.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userNameLogin");
		String password = request.getParameter("passwordLogin");
		LoginService loginService = new LoginService();
		RequestDispatcher dispatcher;
		
		if(loginService.authenticate(userName, password)){
	
			GetUserInfoService getUserInfoService = new GetUserInfoService();
			ArrayList<String> userInfo = getUserInfoService.getUserInfo(userName, password);
			HttpSession session = request.getSession();
			
			String firstName = userInfo.get(2);
			String familyName = userInfo.get(3);
			String id = userInfo.get(0);
			
			session.setAttribute("savedUserId", id);
			session.setAttribute("savedUserName", userName);
			session.setAttribute("savedFirstName", firstName);
			session.setAttribute("savedFamilyName", familyName);
			session.setAttribute("savedPassword", password);
			
			dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("svar", "Fel användarnamn eller lösenord!");
			dispatcher.forward(request, response);
		}
		
		
	}

}
