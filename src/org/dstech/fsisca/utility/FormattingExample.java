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
package org.dstech.fsisca.utility;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author franksisca
 *
 */
public class FormattingExample {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Inserisci una data nel formato dd/mm/yyyy");
		SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/mm/yyyy");
		String data = scanner.next();
		Date parse = dateFormat.parse(data);
		
		System.out.println("la data inserita è: " + parse);
//		
//		Date newDate = new Date();
//		
//		System.out.println(newDate);
//		System.out.println(dateFormat.format(newDate));
//		
//		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
//		double value = 23123123.12313521;
//		
//		System.out.println(value);
//		System.out.println(decimalFormat.format(value));
//		
		
	}

}
