package loginutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import studentutil.db.DbConnection;

public class LoginDAO {
	public static boolean validateUser(String UserName, String UserPassword) throws Exception {
		String query = "select * from login where username = ? and password = ?";
		ResultSet resultSet;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, UserName);
			preparedStatement.setString(2, UserPassword);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
		return false;
	}

	public static void createUser(String UserName, String UserPassword) throws Exception {
		String query = "insert into login values (?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, UserName);
			preparedStatement.setString(2, UserPassword);
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}
}
