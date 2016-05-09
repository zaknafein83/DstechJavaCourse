 
package org.dstech.smastro.EstrazioniDiverlotto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCreaTabella {
	public static void main(String argv[]) throws Exception{
		
		try{
			creaTabella();
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	} 
	private static void creaTabella() throws Exception{
		PropertiesManagment proper=new PropertiesManagment();
		Connection dbConnection=null;
		Statement stm=null;
		
		String creaTabella1="CREATE TABLE TABELLA_BA " +
				"(ESTRAZIONE DATE NOT NULL, " +
				"CONCORSO INTEGER, " +
				"BA1 INTEGER, " +
				"BA2 INTEGER, " +
				"BA3 INTEGER, " +
				"BA4 INTEGER, " +
				"BA5 INTEGER, " +
				"PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella2="CREATE TABLE TABELLA_CA " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" CA1 INTEGER, " +
				" CA2 INTEGER, " +
				" CA3 INTEGER, " +
				" CA4 INTEGER, " +
				" CA5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella3="CREATE TABLE TABELLA_FI " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" FI1 INTEGER, " +
				" FI2 INTEGER, " +
				" FI3 INTEGER, " +
				" FI4 INTEGER, " +
				" FI5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella4="CREATE TABLE TABELLA_GE " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" GE1 INTEGER, " +
				" GE2 INTEGER, " +
				" GE3 INTEGER, " +
				" GE4 INTEGER, " +
				" GE5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella5="CREATE TABLE TABELLA_MI " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" MI1 INTEGER, " +
				" MI2 INTEGER, " +
				" MI3 INTEGER, " +
				" MI4 INTEGER, " +
				" MI5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella6="CREATE TABLE TABELLA_NA " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" NA1 INTEGER, " +
				" NA2 INTEGER, " +
				" NA3 INTEGER, " +
				" NA4 INTEGER, " +
				" NA5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella7="CREATE TABLE TABELLA_PA " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" PA1 INTEGER, " +
				" PA2 INTEGER, " +
				" PA3 INTEGER, " +
				" PA4 INTEGER, " +
				" PA5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		String creaTabella8="CREATE TABLE TABELLA_RM " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" RM1 INTEGER, " +
				" RM2 INTEGER, " +
				" RM3 INTEGER, " +
				" RM4 INTEGER, " +
				" RM5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella9="CREATE TABLE TABELLA_TO " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" TO1 INTEGER, " +
				" TO2 INTEGER, " +
				" TO3 INTEGER, " +
				" TO4 INTEGER, " +
				" TO5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella10="CREATE TABLE TABELLA_VE " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" VE1 INTEGER, " +
				" VE2 INTEGER, " +
				" VE3 INTEGER, " +
				" VE4 INTEGER, " +
				" VE5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		String creaTabella11="CREATE TABLE TABELLA_NZ " +
				"(ESTRAZIONE DATE NOT NULL, " +
				" CONCORSO INTEGER, " +
				" NZ1 INTEGER, " +
				" NZ2 INTEGER, " +
				" NZ3 INTEGER, " +
				" NZ4 INTEGER, " +
				" NZ5 INTEGER, " +
				" PRIMARY KEY (ESTRAZIONE))";
		
		try{
			
			dbConnection=proper.getDBConnection();
			stm=dbConnection.createStatement();
			
			System.out.println(creaTabella1);
			stm.executeQuery(creaTabella1);
			System.out.println("Tabella \"TABELLA_BA\" creata correttamente");
			
			System.out.println(creaTabella2);
			stm.executeQuery(creaTabella2);
			System.out.println("Tabella \"TABELLA_CA\" creata correttamente");
			
			System.out.println(creaTabella3);
			stm.executeQuery(creaTabella3);
			System.out.println("Tabella \"TABELLA_FI\" creata correttamente");
			
			System.out.println(creaTabella4);
			stm.executeQuery(creaTabella4);
			System.out.println("Tabella \"TABELLA_GE\" creata correttamente");
			
			System.out.println(creaTabella5);
			stm.executeQuery(creaTabella5);
			System.out.println("Tabella \"TABELLA_MI\" creata correttamente");
			
			System.out.println(creaTabella6);
			stm.executeQuery(creaTabella6);
			System.out.println("Tabella \"TABELLA_NA\" creata correttamente");
			
			System.out.println(creaTabella7);
			stm.executeQuery(creaTabella7);
			System.out.println("Tabella \"TABELLA_PA\" creata correttamente");
			
			System.out.println(creaTabella8);
			stm.executeQuery(creaTabella8);
			System.out.println("Tabella \"TABELLA_RM\" creata correttamente");
			
			System.out.println(creaTabella9);
			stm.executeQuery(creaTabella9);
			System.out.println("Tabella \"TABELLA_TO\" creata correttamente");
			
			System.out.println(creaTabella10);
			stm.executeQuery(creaTabella10);
			System.out.println("Tabella \"TABELLA_VE\" creata correttamente");
			
			System.out.println(creaTabella11);
			stm.executeQuery(creaTabella11);
			System.out.println("Tabella \"TABELLA_NZ\" creata correttamente");
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}finally{
			if(stm!=null){
				stm.close();
			}
			if(dbConnection!=null){
				dbConnection.close();
			}
		}
	}
}