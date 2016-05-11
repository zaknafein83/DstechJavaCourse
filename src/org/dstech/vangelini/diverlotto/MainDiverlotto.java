package org.dstech.vangelini.diverlotto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * Manca ordinamento dei risultati (modifica l'attributo di ESTRAZ da String a Date)
 * Manca case 2 (numero con maggior ritardo per ogni tabella)
 * Manca case 7 (giocata)
 * 
 */
public class MainDiverlotto {

	public static void main(String[] args) throws Exception {
		System.out.println("Benvenuto nel programma");
		try {
			JDBCConnectionTest.testConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		//verifica se ci sono tabelle
		QueryDB query = new QueryDB();
		
		@SuppressWarnings("static-access")
		List<String> leggiFile = query.leggiFile(MainDiverlotto.class.getResource("/resources/estrazionidellotto.csv").getPath());
		String firstRow = leggiFile.get(0);
		String[] splitRow = firstRow.split(";");
		leggiFile.remove(0);
		query.createTableScript(splitRow);
		try {
			//query.creazioneTabelle();
			if(!query.verificaRiempimentoTabella()){
				//query.riempiTabelle(leggiFile);
				for(String riga : leggiFile){
					if(!riga.isEmpty()){
						String elementi_riga[] = riga.split(";");
						query.insertTableScript(elementi_riga);
					}
				}
			} else {
				System.out.println("Tabelle gia riempite.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		int risposta = 0;
		do{
			System.out.println("Scegliere l'operazione da effettuare:");
			System.out.println("1 - Dato un numero, verificare per ogni tabella da quanto tempo non viene estratto");
			System.out.println("2 - Il numero col maggior ritardo di estrazione per ogni singola tabella");
			System.out.println("3 - Dati due numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("4 - Dati tre numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("5 - Dati quattro numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("6 - Dati cinque numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("7 - Giocare scommessa");
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
					//dato 1 numero verificare per ogni tabella da quanto non viene estratto
					controlloEstrazioni(1);
				break;
				case 2:
					//numero col maggior ritardo di estrazione.
				break;
				case 3:
					//dati 2 numero verificare per ogni tabella da quanto non vengono estratti
					controlloEstrazioni(2);
				break;
				case 4:
					//dati 3 numero verificare per ogni tabella da quanto non vengono estratti
					controlloEstrazioni(3);
				break;
				case 5:
					//dati 4 numero verificare per ogni tabella da quanto non vengono estratti
					controlloEstrazioni(4);
				break;
				case 6:
					//dati 5 numero verificare per ogni tabella da quanto non vengono estratti
					controlloEstrazioni(5);
				break;
				case 7:
					//scommessa
				break;
				case 9:
					//esci
				break;
				default:
					System.out.println("Risposta non valida");
				break;
			}
		} while(risposta != 9);
		//io.close();
		System.out.println("La ringraziamo per aver usato il programma");
	}
	
	private static void controlloEstrazioni(int numeri) throws Exception{
		int i = 0;
		ArrayList<Integer> numeri_selezionati = new ArrayList<Integer>();
		System.out.println("Inserire "+numeri+" numeri:");
		@SuppressWarnings("resource")
		Scanner io2 = new Scanner(System.in);
		while(i < numeri){
			System.out.println("Inserire "+(i+1)+"° numero:");
			try{
				Integer nuovo_numero = io2.nextInt();
				if(!numeri_selezionati.contains(nuovo_numero) && (nuovo_numero > 0 && nuovo_numero <= 90)){
					numeri_selezionati.add(nuovo_numero);
					i++;
				} else {
					System.out.println("Numero gia inserito precedentemente o non valido!");
				}
			} catch(Exception e){
				System.out.println("Inserimento non valido!");
			}
			io2.nextLine();
		} 
		QueryDB query = new QueryDB();
		String[] nome_tabella = query.selectTabellaTabelle();
		//foreach delle tabelle
		for(String tabella : nome_tabella){ 
			String condizione_where = " ";
			for(i = 0; i < numeri; i++){
				condizione_where = condizione_where+"(";
				for(int i2 = 1; i2 <= 5; i2++){
					if(i2 != 1){
						condizione_where = condizione_where+" OR ";
					}
					condizione_where = condizione_where+tabella+i2+" = "+numeri_selezionati.get(i);
				}
				condizione_where = condizione_where+")";
				if(i >= 0 && i < (numeri-1)){
					condizione_where = condizione_where+" AND ";
				}
			}
			Connection dbConnection = null;
			Statement statement = null;
			String query2 = "SELECT ESTRAZ FROM `"+tabella+"` WHERE "+condizione_where+" ORDER BY ESTRAZ DESC LIMIT 1;";
			System.out.println(query2);
			try {
				dbConnection = DBUtilityConnection.getDBConnection();
				statement = dbConnection.prepareStatement(query2);
				ResultSet rs = statement.executeQuery(query2);
				//stampare data risultato
				if(rs.next() == true){
					rs.previous();
					while (rs.next())
				    {
						String data = rs.getString("ESTRAZ");
					    System.out.println("I numeri scelti non vengono estratti sulla ruota "+tabella+" dal: "+data);
				    }
				} else {
					System.out.println("Combinazione mai uscita!");
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
		}
	}
}
