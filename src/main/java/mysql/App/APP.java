/**
 * 
 */
package mysql.App;

import mysql.EntityDAO.EntityDAO;
import mysql.model.Users;

/**
 * @author JONATHAN
 */
public class APP {

	public static void main(String ...args) {
		Users user1 = new Users();
		user1.setName("KYEYUNE JONATHAN");
		user1.setEmail("jonathan@gmal.com");
		
		//EntityDAO.createUser(user1);
		
		Users user2 = new Users();
		user2.setName("KAMOGA ALEX");
		user2.setEmail("alex@gmal.com");
		
		//EntityDAO.createUser(user2);
		
		 EntityDAO.getUserById(1);
		 EntityDAO.getUserById(2);
	}
}
