package loginutil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserName = request.getParameter("username");
		String UserPassword = request.getParameter("password");
		if (UserName.isEmpty() || UserPassword.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("signup.jsp");
			view.forward(request, response);
		} else {
			try {
				LoginDAO.createUser(UserName, UserPassword);
				HttpSession session = request.getSession();
				session.setAttribute("username", UserName);
				RequestDispatcher view = request.getRequestDispatcher("view.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
