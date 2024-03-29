package studentutil.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String url = "jdbc:mysql://localhost:3306/****";
	private static final String userName = "root";
	private static final String password = "****";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userName, password);
	}
}
