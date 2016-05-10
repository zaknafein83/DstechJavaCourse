
package org.dstech.smastro.EstrazioniDiverlotto;

import java.sql.Connection;
import java.sql.SQLException;

import org.dstech.dbms.utility.DBUtilityConnection;

import java.sql.PreparedStatement;

public class InserisciInTabella {
		public static void main(String argv[]) throws Exception{
			try{
				InserisciRecord();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
		private static void InserisciRecord()throws Exception {
			Connection dbConnection=null;
			PreparedStatement pstm=null;
			
			String inserisciTabella1= "INSERT INTO TABELLA_BA"
					+"(ESTRAZIONE, CONCORSO, BA1, BA2, BA3, BA4, BA5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella2= "INSERT INTO TABELLA_CA"
					+"(ESTRAZIONE, CONCORSO, CA1, CA2, CA3, CA4, CA5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella3= "INSERT INTO TABELLA_FI"
					+"(ESTRAZIONE, CONCORSO, FI1, FI2, FI3, FI4, FI5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella4= "INSERT INTO TABELLA_GE"
					+"(ESTRAZIONE, CONCORSO, GE1, GE2, GE3, GE4, GE5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella5= "INSERT INTO TABELLA_MI"
					+"(ESTRAZIONE, CONCORSO, MI1, MI2, MI3, MI4, MI5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella6= "INSERT INTO TABELLA_NA"
					+"(ESTRAZIONE, CONCORSO, NA1, NA2, NA3, NA4, NA5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella7= "INSERT INTO TABELLA_PA"
					+"(ESTRAZIONE, CONCORSO, PA1, PA2, PA3, PA4, PA5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella8= "INSERT INTO TABELLA_RM"
					+"(ESTRAZIONE, CONCORSO, RM1, RM2, RM3, RM4, RM5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella9= "INSERT INTO TABELLA_TO"
					+"(ESTRAZIONE, CONCORSO, TO1, TO2, TO3, TO4, TO5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella10= "INSERT INTO TABELLA_VE"
					+"(ESTRAZIONE, CONCORSO, VE1, VE2, VE3, VE4, VE5) VALUES"
					+"(default,?,?,?,?,?,?)";
			
			String inserisciTabella11= "INSERT INTO TABELLA_NZ"
					+"(ESTRAZIONE, CONCORSO, NZ1, NZ2, NZ3, NZ4, NZ5) VALUES"
					+"(default,?,?,?,?,?,?)";
			try{
				dbConnection=DBUtilityConnection.getDBConnection();
				
				pstm=dbConnection.prepareStatement(inserisciTabella1);
				pstm=dbConnection.prepareStatement(inserisciTabella2);
				pstm=dbConnection.prepareStatement(inserisciTabella3);
				pstm=dbConnection.prepareStatement(inserisciTabella4);
				pstm=dbConnection.prepareStatement(inserisciTabella5);
				pstm=dbConnection.prepareStatement(inserisciTabella6);
				pstm=dbConnection.prepareStatement(inserisciTabella7);
				pstm=dbConnection.prepareStatement(inserisciTabella8);
				pstm=dbConnection.prepareStatement(inserisciTabella9);
				pstm=dbConnection.prepareStatement(inserisciTabella10);
				pstm=dbConnection.prepareStatement(inserisciTabella11);
				
				
				
			}catch(SQLException e) {

				System.err.println(e.getMessage());

			} finally {

				if (pstm != null) {
					pstm.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			}
			
		}

}
