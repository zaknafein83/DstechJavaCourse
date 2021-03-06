package it.dstech.corsotestdb;

import it.dstech.jpatest.utility.DBUtilityConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AggiungiColonna {
	public static void main(String[] argv) throws Exception {

		try {

			aggiungiUnaColonna();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void aggiungiUnaColonna() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "ALTER TABLE UTENTE"
			    + "ADD COLUMN state VARCHAR(20), "
			    + "ADD COLUMN dateCreated DATETIME";
				

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(sql);

			
			preparedStatement.execute(sql); 
			
			System.out.println("Colonna aggiunta nella tabella UTENTE!");

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
