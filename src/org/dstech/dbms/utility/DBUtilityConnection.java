package org.dstech.dbms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection {
	public static Connection getDBConnection() throws Exception {
//metodo che ritorna connessione al db
		Connection dbConnection = null;

		try {

			Class.forName(Variabili.DB_DRIVER);//passo un valore preso dalla classe variabili

		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		}

		try {

			dbConnection = DriverManager.getConnection( //meotod connessione con parametri x connessione
					Variabili.DB_CONNECTION, Variabili.DB_USER,Variabili.DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
