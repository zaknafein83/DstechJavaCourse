package org.dstech.lulizi.dbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dstech.dbms.utility.DBUtilityConnection;

public class AggiornaTabella {
	public static void main(String[] argv) throws Exception {

		try {

			updateRecordIntoTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void updateRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "UPDATE REGISTRATION SET"
				+ " NOME = ?, COGNOME=?, ETA=? CITTA=?, DATA_CREAZIONE=?"
				+ " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, "NomeAggiornato");
			preparedStatement.setString(2, "CognomeAggiornato");
			preparedStatement.setInt(3, 22);
			preparedStatement.setString(4, "CittaAggiornata");
			preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
			
			preparedStatement.setInt(4, 1);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record aggiornato nella tabella UTENTE!");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
