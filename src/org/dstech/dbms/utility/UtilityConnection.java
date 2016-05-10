package org.dstech.dbms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilityConnection {
	public static Connection getDBConnection() throws Exception {
//metodo che ritorna connessione al db
		Connection dbConnection = null;

		try {

			Class.forName(Constants.DB_DRIVER);//passo un valore preso dalla classe variabili

		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection( //meotod connessione con parametri x connessione
					Constants.DB_CONNECTION, Constants.DB_USER,Constants.DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
