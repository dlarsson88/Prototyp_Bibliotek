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
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Vi spar den data anv�ndaren skrivit in i formul�ret.
		String userName = request.getParameter("userNameLogin");
		String password = request.getParameter("passwordLogin");
		LoginService loginService = new LoginService();
		RequestDispatcher dispatcher;
		
		// Vi tittar s� att anv�ndaren finns i databasen.
		if(loginService.authenticate(userName, password)){
			
			// Vi h�mtar anv�ndarens �vrig data ifr�n databasen. Vi spar denna i en lista.
			GetUserInfoService getUserInfoService = new GetUserInfoService();
			ArrayList<String> userInfo = getUserInfoService.getUserInfo(userName, password);
			HttpSession session = request.getSession();
			
			// Vi sparar ner datan i str�ngar
			String firstName = userInfo.get(2);
			String familyName = userInfo.get(3);
			String id = userInfo.get(0);
			
			// Vi spar ner all anv�ndardata i sessionen (Vi loggar in anv�ndaren)
			session.setAttribute("savedUserId", id);
			session.setAttribute("savedUserName", userName);
			session.setAttribute("savedFirstName", firstName);
			session.setAttribute("savedFamilyName", familyName);
			session.setAttribute("savedPassword", password);
			
			// Anv�ndaren skickas till main-sidan.
			dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			// Vi skickar tillbaka anv�ndaren till login-sidan med ett felmeddelande.
			dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("svar", "Fel anv�ndarnamn eller l�senord!");
			dispatcher.forward(request, response);
		}
		
		
	}

}
