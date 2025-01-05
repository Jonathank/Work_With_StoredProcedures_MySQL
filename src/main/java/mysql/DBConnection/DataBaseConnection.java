package mysql.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author JONATHAN
 */
public class DataBaseConnection {
	private static Connection conn = null;
	static {
		String URL ="jdbc:mysql://localhost/STORED_PROCEDURES";
		String USER = "root";
		String PASS = "Jnana_2002";
		
		try {
			
			conn = DriverManager.getConnection(URL, USER, PASS);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return conn;
	}
}
