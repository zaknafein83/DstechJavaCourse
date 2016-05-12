package org.dstech.llamonica.diverlotto;



import java.sql.Connection;
import java.sql.SQLException;

import org.dstech.dbms.utility.DBUtilityConnection;

public class JDBCConnectionTest {

	private static final Connection PropertiesManagement = null;

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
			dbConnection = PropertiesManagement;
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
