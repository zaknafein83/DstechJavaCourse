package org.dstech.vangelini.diverlotto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDB {
	
	public void gestisciQuery(int scelta){
		switch(scelta){
			case 1:
			try {
				creazioneTabelle();
				riempiTabelle();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			case 2:
				
			break;
			case 3:
				
			break;
			default:
				
			break;
		}
	}
	
	/*private void selectTestTabellePresenti() throws Exception {
		System.out.println("Controllo tabelle in corso...");
		Connection dbConnection = null;
		Statement statement = null;
		String query = "SELECT * FROM BA LIMIT 1;";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
		    statement.close();
		} catch (SQLException e) {
			try {
				creazioneTabelle();
				riempiTabelle();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}*/
	
	private void riempiTabelle() throws Exception{
		URL resourceAsStream = QueryDB.class.getClassLoader().getResource("resources/estrazionidellotto.csv");
		File file = new File(resourceAsStream.getPath());
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		readLine = buffereReader.readLine();
		String citta[] = {"BA", "CA", "FI", "GE", "MI", "NA", "PA", "RM", "TO", "VE", "NZ"};
		while (readLine != null) {
			String[] split = readLine.split(";");
			inserisciDatiInTabella(citta[0], split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
			inserisciDatiInTabella(citta[1], split[0], split[1], split[7], split[8], split[9], split[10], split[11]);
			inserisciDatiInTabella(citta[2], split[0], split[1], split[12], split[13], split[14], split[15], split[16]);
			inserisciDatiInTabella(citta[3], split[0], split[1], split[17], split[18], split[19], split[20], split[21]);
			inserisciDatiInTabella(citta[4], split[0], split[1], split[22], split[23], split[24], split[25], split[22]);
			inserisciDatiInTabella(citta[5], split[0], split[1], split[27], split[28], split[29], split[30], split[31]);
			inserisciDatiInTabella(citta[6], split[0], split[1], split[32], split[33], split[34], split[35], split[36]);
			inserisciDatiInTabella(citta[7], split[0], split[1], split[37], split[38], split[39], split[40], split[41]);
			inserisciDatiInTabella(citta[8], split[0], split[1], split[42], split[43], split[44], split[45], split[46]);
			inserisciDatiInTabella(citta[9], split[0], split[1], split[47], split[48], split[49], split[50], split[51]);
			inserisciDatiInTabella(citta[10], split[0], split[1], split[52], split[53], split[54], split[55], split[56]);
			readLine = buffereReader.readLine();
		}
		buffereReader.close();
	}
	
	private void inserisciDatiInTabella(String citta, String data, String concorso, String num1, String num2, String num3, String num4, String num5) throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String split[] = data.split("/");
		String nuova_data = split[2]+"-"+split[1]+"-"+split[0];
		String query = "INSERT INTO "+citta+" VALUES ('"+nuova_data+"', "+concorso+", "+num1+", "+num2+", "+num3+", "+num4+", "+num5+");";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(query);
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
	
	private void creazioneTabelle() throws Exception {
		System.out.println("Creazione tabelle in corso...");
		String citta[] = {"BA", "CA", "FI", "GE", "MI", "NA", "PA", "RM", "TO", "VE", "NZ"};
		for(String elemento : citta){
			creaTabella(elemento);
		}
	}	
	
	private void creaTabella(String nome_tabella) throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String query = "CREATE TABLE IF NOT EXISTS `"+nome_tabella+"` "+
                 "(ESTRAZIONE DATE NOT NULL, " +
                 " CONCORSO INTEGER NOT NULL, " + 
                 " "+nome_tabella+"1 INTEGER, " + 
                 " "+nome_tabella+"2 INTEGER, " + 
                 " "+nome_tabella+"3 INTEGER, " + 
                 " "+nome_tabella+"4 INTEGER, " + 
                 " "+nome_tabella+"5 INTEGER, " + 
                 " PRIMARY KEY ( ESTRAZIONE ),"
                 + "UNIQUE (CONCORSO))";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(query);
			System.out.println("Tabella \""+nome_tabella+"\" creata con successo o già esistente!");
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