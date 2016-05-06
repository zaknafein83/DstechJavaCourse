package it.dstech.jpatest;

import it.dstech.jpatest.utility.DBUtilityConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Domenico
 */
public class JDBCPreparedStatementInsert {

	public static void main(String[] argv) throws Exception {

		try {

			insertRecordIntoTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void insertRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO REGISTRATION"
				+ "(ID, NOME, COGNOME, ETA) VALUES"
				+ "(default,?,?,?)"; //???? punti interrogativi x definire valori variabili. Default il primo xche si autoincrementa

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, "ffffff");  //il numero è la posizione riferita al punto interrogativo sopra, quindi riferito a nome
			preparedStatement.setString(2, "ffffff"); //secondo punto=cognome
			preparedStatement.setInt(3, 7);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record inserito nella tabella REGISTRATION!");

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
