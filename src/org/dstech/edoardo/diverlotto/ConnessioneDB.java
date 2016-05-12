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
	public static void connessioneDB() throws Exception {
		PropertiesManagment propertiesManagement = new PropertiesManagment();

		Connection dbConnection = null;

		try {

			Class.forName(propertiesManagement.getDBDriver());

		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection(
					propertiesManagement.getDBConnection(), 
					propertiesManagement.getDBUsername(), 
					propertiesManagement.getDBPassword());

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * @return
	 */


}
