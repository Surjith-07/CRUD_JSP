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

@WebServlet("/CreateStudent")
public class CreateStudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setDepartment(request.getParameter("department"));
		student.setBranch(request.getParameter("branch"));
		student.setAddress(request.getParameter("address"));

		String studentId = request.getParameter("id");
		System.out.println(studentId + "+-------------------------------------------------");
		try {
			StudentDAO.addStudent(student);
			RequestDispatcher view = request.getRequestDispatcher("view.jsp");
			request.setAttribute("students", StudentDAO.getAllStudent());
			view.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
