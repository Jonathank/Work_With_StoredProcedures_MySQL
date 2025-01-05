/**
 * 
 */
package mysql.EntityDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.DBConnection.DataBaseConnection;

/**
 * @author JONATHAN
 */
public class EntityDAO {

	private static Connection conn = DataBaseConnection.getConnection();
	private static CallableStatement stmt;
	
	public static void createUser(String name, String email) {
		try {
	    String query = "{CALL InsertUser(?, ?)}";  // Calling the InsertUser stored procedure
	        stmt = conn.prepareCall(query);
	        
	        stmt.setString(1, name);
	        stmt.setString(2, email);
	        stmt.executeUpdate();
	        
	        System.out.println("User created successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void getUserById(int id) {
	    String query = "{CALL GetUserById(?)}";  // Calling the GetUserById stored procedure
	    try {
	    	stmt = conn.prepareCall(query);
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            System.out.println("ID: " + rs.getInt("id"));
	            System.out.println("Name: " + rs.getString("name"));
	            System.out.println("Email: " + rs.getString("email"));
	        } else {
	            System.out.println("User not found!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void updateUser(int id, String name, String email) {
	    String query = "{CALL UpdateUser(?, ?, ?)}";  // Calling the UpdateUser stored procedure
	    try {
	         CallableStatement stmt = conn.prepareCall(query);
	        
	        stmt.setInt(1, id);
	        stmt.setString(2, name);
	        stmt.setString(3, email);
	        stmt.executeUpdate();
	        
	        System.out.println("User updated successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void deleteUser(int id) {
	    String query = "{CALL DeleteUser(?)}";  // Calling the DeleteUser stored procedure
	    try {
	         CallableStatement stmt = conn.prepareCall(query);
	        
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	        
	        System.out.println("User deleted successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
