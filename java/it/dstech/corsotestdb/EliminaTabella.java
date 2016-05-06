package it.dstech.corsotestdb;

import it.dstech.jpatest.utility.DBUtilityConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminaTabella {
	public static void main(String[] argv) throws Exception {

		try {

			deleteRecordIntoTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void deleteRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "DELETE FROM UTENTE "
				+ " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.setInt(1, 2);
			
			

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record eliminato nella tabella REGISTRATION!");

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