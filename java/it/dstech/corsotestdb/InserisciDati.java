package it.dstech.corsotestdb;

import it.dstech.jpatest.utility.DBUtilityConnection;
import java.util.Date;
import java.lang.String;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Domenico
 */
public class InserisciDati {

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

		String insertTableSQL = "INSERT INTO UTENTE"
				+ "(ID, NOME, COGNOME, ETA, CITTA, DATA_CREAZIONE) VALUES"
				+ "(default,?,?,?,?,?)"; //???? punti interrogativi x definire valori variabili. Default il primo xche si autoincrementa

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, "Luca");  //il numero è la posizione riferita al punto interrogativo sopra, quindi riferito a nome
			preparedStatement.setString(2, "Verdi"); //secondo punto=cognome
			preparedStatement.setInt(3, 22);
			preparedStatement.setString(4, "Milano");
			preparedStatement.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now())); //data Creazione utente
			
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record inserito nella tabella UTENTE!");

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