package org.dstech.edoardo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EsercizioPattern {

	private static final String NUMERI = "[0-9]{3} [0-9]{3} [0-9]{4}|[0-9]{10}";
	private static final String MAILPATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		String s = input.nextLine();

		Pattern patternMail = Pattern.compile(MAILPATTERN);

		Matcher matcherMail = patternMail.matcher(s);

		Pattern patternNumeri = Pattern.compile(NUMERI);

		Matcher matcherNumeri = patternNumeri.matcher(s);

		if (matcherMail.find()) {

			System.out.println("E' una mail!");

		} else if (matcherNumeri.find()) {

			System.out.println("E' un numero!");

		} else {
			System.out.println("ERRORE");

		}

	}
}
