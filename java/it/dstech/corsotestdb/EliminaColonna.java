package it.dstech.corsotestdb;

import it.dstech.jpatest.utility.DBUtilityConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminaColonna {
	public static void main(String[] argv) throws Exception {

		try {

			cancellaColonna();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void cancellaColonna() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String cancellaColonna = "ALTER TABLE UTENTE"
			    + "DROP COLUMN dateCreated";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(cancellaColonna);

			
			preparedStatement.execute(cancellaColonna); 
			
			System.out.println("Colonna eliminata nella tabella UTENTE!");

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
