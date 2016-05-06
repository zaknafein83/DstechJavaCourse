package org.dstech.lulizi.dbms;

import java.util.Date;
import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dstech.dbms.utility.DBUtilityConnection;

/**
 *
 * @author Domenico
 */
public class InserisciInColonnaSpecifica {

	public static void main(String[] argv) throws Exception {

		try {

			inserisciInColonna();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void inserisciInColonna() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String inserisciInColonna = "INSERT INTO UTENTE (professione)"+
				"VALUES (?)";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(inserisciInColonna);
			preparedStatement.setString(1, "Operaio");  
						
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record inserito nella Colonna Scelta!");

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
