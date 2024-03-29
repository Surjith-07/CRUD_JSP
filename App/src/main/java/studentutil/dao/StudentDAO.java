package studentutil.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentutil.db.DbConnection;
import studentutil.model.Student;

public class StudentDAO {
//	private static Logger logger = LoggerFactory.getLogger(StudentDAO.class);

	public static void addStudent(Student student) throws ClassNotFoundException, SQLException {
		String query = "insert into student values(default,?,?,?,?);";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDepartment());
			preparedStatement.setString(3, student.getBranch());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
//			logger.error(e.getMessage());
			throw e;
		}
	}

	public static List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
		List<Student> students = new ArrayList<>();
		ResultSet resultSet;
		System.out.println("wrfwerkfmklw3mnflk3nmefkn3wklfnmk,3wmn");
		String query = "select * from student;";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery(query);
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setDepartment(resultSet.getString("department"));
				student.setBranch(resultSet.getString("branch"));
				student.setAddress(resultSet.getString("address"));
				students.add(student);
			}
			System.out.println(students);
		} catch (SQLException | ClassNotFoundException e) {
//			logger.error(e.getMessage());
			throw e;
		}
		return students;
	}

	public static Student getStudentById(int id) throws ClassNotFoundException {
		ResultSet resultSet;
		Student student = null;
		String query = "select name,department,branch,address from student where id = ?";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				student = new Student(resultSet.getString("name"), resultSet.getString("department"),
						resultSet.getString("branch"), resultSet.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception Occured" + e.getMessage());
		}
		return student;
	}

	public static void updateStudent(Student student) throws ClassNotFoundException, SQLException {
		String query = "update student set name = ? , department= ?, branch = ?, address= ? where id = ?";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDepartment());
			preparedStatement.setString(3, student.getBranch());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setInt(5, student.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
//			logger.error(e.getMessage());
			throw e;
		}
	}

	public static void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from student where id = ?";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("1234567890-1234567890234567890");
		} catch (SQLException e) {
//			logger.error(e.getMessage());
			throw e;
		}
	}
}