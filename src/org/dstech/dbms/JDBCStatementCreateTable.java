package org.dstech.dbms;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.dstech.dbms.utility.DBUtilityConnection;

/**
 *
 * @author Domenico
 */
public class JDBCStatementCreateTable {
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
		
		 String createTableSQL = "CREATE TABLE REGISTRATION " +
                 "(ID INTEGER NOT NULL AUTO_INCREMENT, " + //id necessariamente valorizzato e autoincrementato
                 " NOME VARCHAR(255), " + 
                 " COGNOME VARCHAR(255), " + 
                 " ETA INTEGER, " + 
                 " PRIMARY KEY ( id ))";		//chiave primaria ID, ciè la prima colonna ID è la chiave primaria, non puo essere duplicata sulla tabella

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement(); //statement è istruzione che viene inviata al database

			System.out.println(createTableSQL);

			statement.execute(createTableSQL); //invia esecuzione al db

			System.out.println("Tabella \"REGISTRATION\" creata con successo!");

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
