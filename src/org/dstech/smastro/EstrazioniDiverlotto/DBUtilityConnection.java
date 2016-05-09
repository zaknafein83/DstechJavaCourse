
package org.dstech.smastro.EstrazioniDiverlotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBUtilityConnection {
	public static void DBUtilityConnection() throws Exception{
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
		
}
}
	
	
	
