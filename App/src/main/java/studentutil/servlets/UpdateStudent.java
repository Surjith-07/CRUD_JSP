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
import studentutil.model.Student;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "default";
		}
		try {
			switch (action) {
			case "edit":
				int id = Integer.parseInt(request.getParameter("id"));
//	                System.out.println(id);
				Student student = StudentDAO.getStudentById(id);
				student.setId(id);
				RequestDispatcher edit = request.getRequestDispatcher("edit.jsp");
				edit.forward(request, response);
				break;
			default:
				RequestDispatcher view = request.getRequestDispatcher("view.jsp");
				view.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		String studentId = request.getParameter("id");
		student.setName(request.getParameter("name"));
		student.setDepartment(request.getParameter("department"));
		student.setBranch(request.getParameter("branch"));
		student.setAddress(request.getParameter("address"));
		student.setId(Integer.parseInt(studentId));
		try {
			StudentDAO.updateStudent(student);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("view.jsp");
		view.forward(request, response);
	}
}
