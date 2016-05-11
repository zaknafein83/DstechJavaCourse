package org.dstech.lulizi.dbms;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.dstech.dbms.utility.UtilityConnection;

/**
 *
 * @author Domenico
 */
public class CreaTabella {
	public static void main(String[] argv) throws Exception {

		try {

			createDbUserTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void createDbUserTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;
		
		 String createTableSQL = "CREATE TABLE UTENTE " +
                 "(ID INTEGER NOT NULL AUTO_INCREMENT, " + //id necessariamente valorizzato e autoincrementato
                 " NOME VARCHAR(255), " + 
                 " COGNOME VARCHAR(255), " + 
                 " ETA INTEGER, " + 
                 " CITTA VARCHAR(255), " +
                 " DATA_CREAZIONE DATE, " +
                " PRIMARY KEY ( id ))";		//chiave primaria ID, ciè la prima colonna ID è la chiave primaria, non puo essere duplicata sulla tabella

		try {
			dbConnection = UtilityConnection.getDBConnection();
			statement = dbConnection.createStatement(); //statement è istruzione che viene inviata al database

			System.out.println(createTableSQL);

			statement.execute(createTableSQL); //invia esecuzione al db

			System.out.println("Tabella \"UTENTE\" creata con successo!");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
