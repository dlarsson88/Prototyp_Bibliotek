package se.prototyp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session != null){
			// H�r sker utloggningen av nuvarande session (anv�ndare)
			session.invalidate();
		}
		// Anv�ndaren skickas sedan till login-sidan
		RequestDispatcher dispatcher;
		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		return;
	}
}
