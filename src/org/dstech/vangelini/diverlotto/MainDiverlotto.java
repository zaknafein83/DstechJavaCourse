package org.dstech.vangelini.diverlotto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDiverlotto {

	public static void main(String[] args) throws IOException {
		try {
			JDBCConnectionTest.testConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		//verifica se ci sono tabelle
		QueryDB query = new QueryDB();
		try{
			query.gestisciQuery(1);
		} catch(Exception e){
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
					//dati 2 numero verificare per ogni tabella da quanto non viene estratto
					controlloEstrazioni(2);
				break;
				case 4:
					//dati 3 numero verificare per ogni tabella da quanto non viene estratto
					controlloEstrazioni(3);
				break;
				case 5:
					//dati 4 numero verificare per ogni tabella da quanto non viene estratto
					controlloEstrazioni(4);
				break;
				case 6:
					//dati 5 numero verificare per ogni tabella da quanto non viene estratto
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
	
	private static void controlloEstrazioni(int numeri){
		//String limit = String.valueOf(numeri);
		
	}
}
