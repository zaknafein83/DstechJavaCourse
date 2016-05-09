
package org.dstech.smastro.EstrazioniDiverlotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBUtilityConnection {
	
	public static void main(String[] args) throws Exception{
		PropertiesManagment proper=new PropertiesManagment();
		Connection dbConnection = null;
		
		try{
			Class.forName(proper.getDBDriver());
			
		}catch(ClassNotFoundException e){
			throw new Exception(e.getMessage());
		}
		try{
			dbConnection=DriverManager.getConnection(
					proper.getDBConnection(),
					proper.getDBUsername(),
					proper.getDBPassword());
			
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}
	
	
		
		//qui si caricano le vecchie estrazioni
		Scanner sc=new Scanner(System.in);
		int risp=0;
		do
		{
			System.out.println("Benvenuto all'estrazione");
			System.out.println("1) Dato un numero, verificare per ogni tabella da quanto tempo non viene estratto");
			System.out.println("2) il numero col maggior ritardo di estrazione per ogni singola tabella"); 
			System.out.println("3) dati due numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione"); 
			System.out.println("4) dati tre numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione"); 
			System.out.println("5) dati tre numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione"); 
			System.out.println("6) dati quattro numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione"); 
			System.out.println("7) dati cinque numeri, verificare da quanto tempo non vengono estratti nella stessa estrazione");
			System.out.println("8) Giocare scommessa"); 
			System.out.println("9) Uscita dal programma");
			boolean notInt= true;
			while(notInt){
					
			System.out.println("Quale operazione vuoi scegliere?");
			try
			{
				risp=sc.nextInt();
			}catch(InputMismatchException e){
				risp = 0;
			}
			sc.nextLine();
			}
			switch(risp){
			case 1:
			}	
}while(risp!=9);
System.out.println("fine");
			
	}
}
	
	
	
