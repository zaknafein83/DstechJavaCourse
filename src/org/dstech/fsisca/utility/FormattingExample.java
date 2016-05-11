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
		formatDate();
		formatString();
	}

	/**
	 * 
	 */
	private static void formatString() {
		// TODO Auto-generated method stub
		String next = "Ciao a tutti da %s";
		System.out.println("Inserisci il tuo nome: ");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.next();
		next = String.format(next, nome);
		System.out.println(next);
	}

	private static void formatDate() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci una data nel formato dd/mm/yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		String data = scanner.next();
		Date parse = dateFormat.parse(data);

		System.out.println("la data inserita è: " + parse);
	}

}
