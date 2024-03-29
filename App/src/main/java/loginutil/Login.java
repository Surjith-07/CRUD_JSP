package loginutil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserName = request.getParameter("username");
		String UserPassword = request.getParameter("password");
		try {
			if (LoginDAO.validateUser(UserName, UserPassword)) {
				System.out.println("UserName");
				HttpSession session = request.getSession();
				session.setAttribute("username", UserName);
//				response.sendRedirect("view.jsp");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
				requestDispatcher.forward(request, response);
			} else {

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
