package org.dstech.edoardo.diverlotto;

import java.sql.Connection;
import java.sql.SQLException;

import org.dstech.edoardo.diverlotto.ConnessioneDB;

public class JDBCConnectionTest { //verifica connessione stabilita al db

	public static void ConnectionTest()  throws SQLException {
		Connection dbConnection = null;
		try {
			dbConnection = ConnessioneDB.getconnessioneDB();
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
