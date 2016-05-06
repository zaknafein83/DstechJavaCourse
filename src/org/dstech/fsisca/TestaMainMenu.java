/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package org.dstech.fsisca;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author franksisca
 *
 */
public class TestaMainMenu {

	public static void main(String[] args) {
		creaMetodo(new String());
		
		double in = 2.01*100.0;
		BigDecimal integer = new BigDecimal(2.01);
		
		BigDecimal mol = new BigDecimal(100.0);
		BigDecimal multiply = mol.multiply(integer);
		System.out.println(multiply);
		
		
		System.out.println(in);
				
				
//		Scanner scanner = new Scanner(System.in);
//		while (true)
//			try {
//				showMenu();
//				int nextInt = Integer.parseInt(scanner.next());
//				while (nextInt != 9) {
//					showMenu();
//					nextInt = scanner.nextInt();
//				}
//			} catch (InputMismatchException exp) {
//				System.out.println("Only int");
//
//			}catch (NumberFormatException exp) {
//				System.out.println("Only int");
//
//			}
	}


	/**
	 * Questo metodo è completamente inutile ma è bello!!!
	 * 
	 * @param string legge una stringa inutile
	 * 
	 */
	private static void creaMetodo(String string) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 
	 */
	private static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 - fai qualcosa");
		System.out.println("9 - Esci");
	}

}
