package org.dstech.vangelini.diverlotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection {
	
	public static Connection getDBConnection() throws Exception {
		Connection dbConnection = null;
		PropertiesManagement prop = new PropertiesManagement();
		try {
			Class.forName(prop.getDBDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(prop.getDBConnection(), prop.getDBUsername(), prop.getDBPassword());
			return dbConnection;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
