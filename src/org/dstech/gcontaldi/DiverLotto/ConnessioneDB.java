/**
 * 
 */
package org.dstech.gcontaldi.DiverLotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Gianluca
 *
 */
public class ConnessioneDB {
	
	/**
	 * @param args
	 * @throws Exceptùion
	 */
	public static void main(String[] args) throws Exception {
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


}
