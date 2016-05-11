package org.dstech.Lorenzo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Pattern2 {

	static Scanner sc = new Scanner(System.in);
	private static final String TELEFONO = ("\\d{3} \\d{3} \\d{4}|\\d{10}"); // "('/\\d+/',
																				// testo,
																				// ris)";
	private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void main(String[] args) {
		String testo = sc.nextLine();
		Pattern pattern = Pattern.compile(TELEFONO);
		Pattern pattern1 = Pattern.compile(EMAIL);
		Matcher matcher = pattern.matcher(testo);
		Matcher matcher1 = pattern1.matcher(testo);

		// while (matcher.find()) {
		// System.out.println("è un numero di telefono: " + testo);
		// }
		//
		// while (matcher1.find()) {
		// System.out.println("è una email: " + testo);
		// }
		// if (!(matcher.find() | matcher1.find())) {
		// System.out.println("è altro");
		// }

		if (matcher.find()) {
			System.out.println("è un numero di telefono: " + testo);
		}

		else if (matcher1.find()) {
			System.out.println("è una email: " + testo);
		} else
			System.out.println("è altro");
	}
}
