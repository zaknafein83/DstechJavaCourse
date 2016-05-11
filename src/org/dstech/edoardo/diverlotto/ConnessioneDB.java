/**
 * 
 */
package org.dstech.edoardo.diverlotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author edoardo
 *
 */
public class ConnessioneDB {
	
	/**
	 * @param args
	 * @return 
	 * @throws Exceptùion
	 */
	public static Connection getconnessioneDB() throws Exception {
		
		Connection dbConnection = null;
		
		PropertiesManagment propertiesManagement = new PropertiesManagment();

		try {

			Class.forName(propertiesManagement.getDBDriver());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection(
					propertiesManagement.getDBConnection(), 
					propertiesManagement.getDBUsername(), 
					propertiesManagement.getDBPassword());
			
			return dbConnection;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

	}

}
