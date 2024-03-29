package studentutil.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentutil.dao.StudentDAO;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "default";
		}
		try {
			switch (action) {
			case "delete":
				int id = Integer.parseInt(request.getParameter("id"));
				StudentDAO.deleteStudent(id);
				RequestDispatcher delete = request.getRequestDispatcher("view.jsp");
				delete.forward(request, response);
				break;
			default:
				RequestDispatcher view = request.getRequestDispatcher("view.jsp");
				view.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
