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

import se.prototyp.services.DBConsistencyService;
import se.prototyp.services.GetUserInfoService;
import se.prototyp.services.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName, firstName, familyName, password;
		userName = request.getParameter("userNameRegister");
		firstName = request.getParameter("firstNameRegister");
		familyName = request.getParameter("familyNameRegister");
		password = request.getParameter("passwordRegister");
		RegisterService registerService = new RegisterService();
		RequestDispatcher dispatcher;
		
		// Kollar om användaren matat in något i samtliga fält.
		if(userName != "" && firstName != "" && familyName != "" && password != ""){
			DBConsistencyService consistency = new DBConsistencyService();
			
			// Vi tittar om användarnamnet redan finns i databasen.
			if(consistency.checkIfUserNameExists(userName)){
				dispatcher = request.getRequestDispatcher("login.jsp");
				request.setAttribute("svar", "Användarnamnet finns redan i databasen. Välj ett annat.");
				dispatcher.forward(request, response);
			}
			else{
				// Vi försöker att uppdatera databasen med den nya användaren.
				boolean result = registerService.addUser(userName, firstName, familyName, password);
				// Vi tittar så att databasen faktiskt uppdaterades.
					if(result){
	
						GetUserInfoService getUserInfoService = new GetUserInfoService();
						ArrayList<String> userInfo = getUserInfoService.getUserInfo(userName, password);
						String id = userInfo.get(0);
						
						// Användaren loggas in i session.
						HttpSession session = request.getSession();
						session.setAttribute("savedUserId", id);
						session.setAttribute("savedUserName", userName);
						session.setAttribute("savedFirstName", firstName);
						session.setAttribute("savedFamilyName", familyName);
						session.setAttribute("savedPassword", password);
						
						// Användaren skickas till main.jsp som inloggad.
						request.setAttribute("svar", "Välkommen " + userName + "! Du är nu registrerad på Bibliotek Informatika.");
						dispatcher = request.getRequestDispatcher("main.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else{
						// Databasen blev inte uppdaterad med den nya användaren.
						dispatcher = request.getRequestDispatcher("login.jsp");
						dispatcher.forward(request, response);
					}
			}

		}
		else{
			// Användaren har inte matat in något i samtliga fält.
			dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("svar", "Du måste fylla i samtliga fält.");
			dispatcher.forward(request, response);
		}
	}

}
