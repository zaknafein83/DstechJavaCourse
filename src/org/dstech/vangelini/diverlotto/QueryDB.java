package org.dstech.vangelini.diverlotto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryDB {
	private static final String CR = "\n";
	private static final String LINE = ",";
	private static final Object INTEGER = " INTEGER NOT NULL ";
	private static final Object KEY = " PRIMARY KEY ";
	private static final Object VAR = " VARCHAR(10) ";

	public boolean verificaRiempimentoTabella() throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String query = "SELECT * FROM tabella_tabelle LIMIT 1;";
		ArrayList<String> lista_tabelle = new ArrayList<String>();
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next())
		    {
				 lista_tabelle.add(rs.getString("nome_tabella"));
		    }
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
		//seconda query
		query = "SELECT COUNT(*) as conteggio FROM "+lista_tabelle.get(0)+";";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
		    {
				 int conteggio = rs.getInt("conteggio");
				 if(conteggio > 1){
					 return true;
				 } else {
					 return false;
				 }
		    }
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
		
		return false;
	}
	
	//public void riempiTabelle(List<String> LeggiFile) throws Exception{
		//vecchio inserimento
		/*URL resourceAsStream = QueryDB.class.getClassLoader().getResource("resources/estrazionidellotto.csv");
		File file = new File(resourceAsStream.getPath());
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		readLine = buffereReader.readLine();
		String citta[] = {"BA", "CA", "FI", "GE", "MI", "NA", "PA", "RM", "TO", "VE", "NZ"};
		while (readLine != null && readLine.isEmpty()) {
			String[] split = readLine.split(";");
			//stampaSpliti(split);
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
		buffereReader.close();*/
	//}
	
	/*private void stampaSpliti(String[] split) {
		// TODO Auto-generated method stub
		for (int i = 0; i < split.length; i++) {
			System.out.print(split[i] + " ");			
		}
		System.out.println();
	}*/

	/*private void inserisciDatiInTabella(String citta, String data, String concorso, String num1, String num2, String num3, String num4, String num5) throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String split[] = data.split("/");
		String nuova_data = split[2]+"-"+split[1]+"-"+split[0];
		String query = "INSERT INTO `"+citta+"` VALUES ('"+nuova_data+"', "+concorso+", "+num1+", "+num2+", "+num3+", "+num4+", "+num5+");";
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
	}*/
	
	/*public void creazioneTabelle() throws Exception {
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
                 " PRIMARY KEY ( ESTRAZIONE ));";
		System.out.println("Creazione in corso...");
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
	}*/
	
	public static List<String> leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		List<String> lista = new ArrayList<String>();
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			lista.add(readLine);
			readLine = buffereReader.readLine();
		}
		buffereReader.close();
		return lista;
	}
	
	public String[] selectTabellaTabelle() throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String query = "SELECT nome_tabella FROM tabella_tabelle ORDER BY id LIMIT 11";
		String[] lista_tabelle = new String[11];
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while (rs.next())
		    {
				String nome_tabella = rs.getString("nome_tabella");
				lista_tabelle[i] = nome_tabella;
				i++;
		    }
			/*for(String nome : lista_tabelle){
				System.out.print(nome+" ");
			}
			System.out.println("");*/
			return lista_tabelle;
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
		return null;
	}
	
	public void insertTableScript(String[] splitRow) throws Exception {
		String[] nome_tabella = selectTabellaTabelle();
		String[] onlyTableName = Arrays.copyOfRange(splitRow, 2, splitRow.length);
		int i2 = 0;
		for (int i = 5; i <= onlyTableName.length; i += 5) {
			insertSingleTableStatemente(splitRow[0], splitRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i), nome_tabella[i2]);
			i2++;
		}
	}	
	
	private static void insertSingleTableStatemente(String firstColumn, String secondColumn, String[] parameters, String nome_tabella) throws Exception {
		StringBuilder script = new StringBuilder("INSERT INTO ").
				append("`").append(nome_tabella).append("`").
				append(" VALUES ").append("(").
				append("\"").append(firstColumn).append("\"").append(LINE).
				append(secondColumn).append(LINE);
		for (int i = 0; i < parameters.length; i++) {
			if(i == (parameters.length)-1){
				script.append(parameters[i]);
			} else {
				script.append(parameters[i]).append(LINE);
			}
		}
		script.append(");");
		System.out.println(script);
		//esegui query
		Connection dbConnection = null;
		Statement statement = null;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(script.toString());
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
	
	public void createTableScript(String[] splitRow) throws Exception {
		String[] onlyTableName = Arrays.copyOfRange(splitRow, 2, splitRow.length);
		ArrayList<String> lista_tabelle = new ArrayList<String>();
		for (int i = 5; i <= onlyTableName.length; i += 5) {
			System.out.println("Creazione in corso di: "+onlyTableName[i-5]);
			//prendere il nome delle tabelle
			String nome = onlyTableName[i-5];
			String nome_tabella = nome.substring(0, 2);
			lista_tabelle.add(nome_tabella);
			createSingleTableStatemente(splitRow[0], splitRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i));
		}
		creaTabellaDelleTabelle(lista_tabelle);
	}
	
	private static void creaTabellaDelleTabelle(ArrayList<String> lista_tabelle) throws Exception{
		Connection dbConnection = null;
		Statement statement = null;
		String query = "CREATE TABLE IF NOT EXISTS `tabella_tabelle` "+
                 "(id int NOT NULL AUTO_INCREMENT, " +
                 " nome_tabella VARCHAR(5) NOT NULL, " + 
                 " PRIMARY KEY ( id ));";
		//System.out.println("Creazione in corso...");
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(query);
			System.out.println("Tabella `tabella_tabelle` creata con successo o già esistente!");
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
		riempiTabellaTabelle(lista_tabelle);
	}

	private static void riempiTabellaTabelle(ArrayList<String> lista_tabelle) throws Exception, SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		for(String nome_tabella : lista_tabelle){ 
			String query = "INSERT INTO tabella_tabelle (nome_tabella) VALUES ('"+nome_tabella+"');";
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
	}
	
	private static void createSingleTableStatemente(String firstColumn, String secondColumn, String[] parameters) throws Exception {
		StringBuilder script = new StringBuilder("CREATE TABLE IF NOT EXISTS ").
				append("`").append(parameters[0].substring(0, 2)).append("`").append(CR).
				append("(").append(CR).
				append(firstColumn).append(VAR).append(LINE).append(CR).
				append(secondColumn).append(INTEGER).append(LINE).append(CR);
		for (int i = 0; i < parameters.length; i++) {
			script.append(parameters[i]).append(INTEGER).append(LINE).append(CR);
		}
		script.append(KEY).append("(").append(firstColumn).append("))").append(CR);
		//System.out.println(script);
		//eseguire query!!!
		Connection dbConnection = null;
		Statement statement = null;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(script.toString());
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