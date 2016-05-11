package org.dstech.vangelini.diverlotto;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnectionTest { 

	public static void testConnection()  throws SQLException {
		Connection dbConnection = null;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
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