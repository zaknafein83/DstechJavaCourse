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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QueryDB {
	private static final String CR = "\n";
	private static final String LINE = ",";
	private static final Object INTEGER = " INTEGER NOT NULL ";
	private static final Object KEY = " PRIMARY KEY ";
	//private static final Object VAR = " VARCHAR(10) ";
	private static final Object TIMESTAMP = " DATE ";

	public void scommessa(){
		//inserire cosa vuoi giocare (ambo, terno, quaderna, cinquina)
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		int risposta = 0;
		do{
			System.out.println("Scegliere la giocata da effettuare:");
			System.out.println("1 - Numero estratto(1)");
			System.out.println("2 - Ambo");
			System.out.println("3 - Terno");
			System.out.println("4 - Quaderna");
			System.out.println("5 - Cinquina");
			System.out.println("9 - Esci");
			boolean notInt = true;
			while(notInt){
				System.out.println("Inserisci numero operazione da effettuare: ");
				try{
					risposta = io.nextInt();
					notInt = false;
				} catch(InputMismatchException exp){
					notInt = true;
				}
				io.nextLine();
			}		
			switch(risposta){
				case 1:
					giocaScommessa(1);
				break;
				case 2:
					giocaScommessa(2);
				break;
				case 3:
					giocaScommessa(3);
				break;
				case 4:
					giocaScommessa(4);
				break;
				case 5:
					giocaScommessa(5);
				break;
				case 9:
					risposta = 9;
				break;
				default: 
					System.out.println("Risposta non valida!");
				break;
			}
		}while(risposta != 9);
	}
	
	private static ArrayList<Integer> selezionaNumeriGiocata(int n){
		ArrayList<Integer> lista_numeri = new ArrayList<Integer>();
		System.out.println("Inserire "+n+" numeri:");
		@SuppressWarnings("resource")
		Scanner io2 = new Scanner(System.in);
		int i = 0;
		while(i < n){
			System.out.println("Inserire "+(i+1)+"° numero:");
			try{
				Integer nuovo_numero = io2.nextInt();
				if(!lista_numeri.contains(nuovo_numero) && (nuovo_numero > 0 && nuovo_numero <= 90)){
					lista_numeri.add(nuovo_numero);
					i++;
				} else {
					System.out.println("Numero gia inserito precedentemente o non valido!");
				}
			} catch(Exception e){
				System.out.println("Inserimento non valido!");
			}
			io2.nextLine();
		} 
		if(lista_numeri.size() == n){
			return lista_numeri;
		} else {
			return null;
		}
	}
	
	private static void giocaScommessa(int n){
		ArrayList<Integer> lista_numeri = selezionaNumeriGiocata(n);
		//memorizzare in una lista le estrazioni fatte su ogni ruota.
		HashMap<String, Estrazione> lista_estrazioni = new HashMap<String, Estrazione>();
		QueryDB query = new QueryDB();
		String[] nome_tabella = null;
		try {
			nome_tabella = query.selectTabellaTabelle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date data = new Date();
		for(String tabella : nome_tabella){
			Estrazione nuova_estrazione = new Estrazione(data);
			lista_estrazioni.put(tabella, nuova_estrazione);
		}
		//controllare la giocata con le estrazioni (Stampa vincita o perdita)	
		for(String tabella : lista_estrazioni.keySet()){
			Estrazione verificaEstrazione = lista_estrazioni.get(tabella);
			List<Integer> numeri_estrazione = verificaEstrazione.getNumeri_estratti();
			int contatore = 0;
			for(Integer numero : lista_numeri){
				if(numeri_estrazione.contains(numero)){
					contatore++;
				}
			}
			if(contatore == lista_numeri.size()){
				System.out.println("Su la ruota di '"+tabella+"' - Hai vintoooooo NDIAMOOOOOO!");
			} else {
				System.out.println("Su la ruota di '"+tabella+"' - Hai perso! ");
			}
			System.out.println("numeri estratti sulla ruota: "+lista_estrazioni.get(tabella).toString());
			System.out.println("");
		}
	}
	
	public void numberLate() throws Exception{
		//numero con maggior ritardo per ogni singola tabella;
		QueryDB query = new QueryDB();
		String[] nome_tabella = query.selectTabellaTabelle();
		int dimensione_tabella_tabelle = nome_tabella.length;
		Timestamp data;
		Timestamp data_trovata;
		for(int i2 = 0; i2 < dimensione_tabella_tabelle; i2++){
			int numero = 0;
			data = null;
			for(int i =  0; i < 90; i++){
				data_trovata = trovaRitardoNumero((i+1), nome_tabella[i2]); //trova data, dato il numero
				//System.out.println("confronta numero: "+numero+" - "+data+" con "+(i+1)+" - "+data_trovata);
				if(i == 0){
					data = data_trovata;
					numero = i+1;
				} else if(data.after(data_trovata)){
					//System.out.println("Minore!");
					numero = i+1;
					data = data_trovata;
				}
			}
			//stampa risultato
			String data_convert = data.toString();
			System.out.println("Per la tabella "+nome_tabella[i2]+" il numero piu atteso è: '"+numero+"', che non viene estratto dal: "+data_convert.substring(0, 10)+";");
		}
	}
	
	private static Timestamp trovaRitardoNumero(int n, String tabella) throws Exception{
		String condizione_where = " ";
		condizione_where = condizione_where+"(";
		for(int i2 = 1; i2 <= 5; i2++){
			if(i2 != 1){
				condizione_where = condizione_where+" OR ";
			}
			condizione_where = condizione_where+tabella+i2+" = "+n;
		} 
		condizione_where = condizione_where+" )";
		Connection dbConnection = null;
		Statement statement = null;
		String query2 = "SELECT ESTRAZ FROM `"+tabella+"` WHERE "+condizione_where+" ORDER BY ESTRAZ DESC LIMIT 1;";
		//System.out.println(query2);
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(query2);
			ResultSet rs = statement.executeQuery(query2);
			//stampare data risultato
			if(rs.next() == true){
				rs.previous();
				while (rs.next()){
					Timestamp data_time_stamp = rs.getTimestamp("ESTRAZ");
					//String data = data_time_stamp.toString();
					return data_time_stamp;
				    //System.out.println("I numeri scelti non vengono estratti sulla ruota "+tabella+" dal: "+data.substring(0, 10));
			    }
			} else {
				return null;
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
		return null;
	}
	
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
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date parsedDate = dateFormat.parse(firstColumn);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    firstColumn = timestamp.toString();
		    firstColumn = firstColumn.substring(0, 10);
		}catch(Exception e){
			e.printStackTrace();
		}
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
		//System.out.println(script);
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
			//System.out.println("Creazione in corso di: "+onlyTableName[i-5]);
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
			//System.out.println("Tabella `tabella_tabelle` creata con successo o già esistente!");
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
				append(firstColumn).append(TIMESTAMP).append(LINE).append(CR).
				append(secondColumn).append(INTEGER).append(LINE).append(CR);
		for (int i = 0; i < parameters.length; i++) {
			script.append(parameters[i]).append(INTEGER).append(LINE).append(CR);
		}
		script.append(KEY).append("(").append(firstColumn).append("))").append(CR);
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