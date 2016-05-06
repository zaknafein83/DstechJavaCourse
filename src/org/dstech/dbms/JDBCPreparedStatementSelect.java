package org.dstech.dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dstech.dbms.utility.DBUtilityConnection;

public class JDBCPreparedStatementSelect {
	private static final Connection con = null;

	public static void main(String[] argv) throws Exception {

		try {

			selectFromTable();

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}

	private static void selectFromTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * FROM REGISTRATION ";
				
				

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(selectTableSQL);

						
			

			// execute insert SQL stetement
			
			
			  
			ResultSet rs = statement.executeQuery(selectTableSQL);
			
			while (rs.next())
		      {
		        int ID=rs.getInt("ID");
		        String Nome= rs.getString("NOME");
		        String Cognome= rs.getString("COGNOME");
		        int Eta= rs.getInt("ETA");
		         
		        
		       System.out.println(ID + " "+ Nome + " " + Cognome + " " + Eta);
		       
		       
		      }
		      statement.close();
		  
	
	
			

			
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
