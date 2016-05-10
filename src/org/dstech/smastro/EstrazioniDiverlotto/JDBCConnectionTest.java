
package org.dstech.smastro.EstrazioniDiverlotto;

import java.sql.Connection;
import java.sql.SQLException;


public class JDBCConnectionTest {
	private static void testConnection()  throws SQLException {
		PropertiesManagment proper=new PropertiesManagment();

		Connection dbConnection = null;

		try {

			testConnection();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

		try {
			dbConnection = proper.getDBConnection();
			System.out.println("Connessione stabilita con successo");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		} finally {
			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}	
	


