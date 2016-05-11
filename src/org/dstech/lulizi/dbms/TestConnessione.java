package org.dstech.lulizi.dbms;

import java.sql.Connection;
import java.sql.SQLException;

import org.dstech.dbms.utility.UtilityConnection;

public class TestConnessione { //verifica connessione stabilita al db

	public static void main(String[] argv) {

		try {

			testConnection();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void testConnection()  throws SQLException {

		Connection dbConnection = null;

		try {
			dbConnection = UtilityConnection.getDBConnection();
			System.out.println("Connessione stabilita con successo");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		} finally {
			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
	}

}
