package org.dstech.fsisca.Alejandro;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alejandro
 *
 */
public class PatternExample {

	private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String NUM_TEL = "\\d{3} \\d{3} \\d{4}|\\d{10}";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci il tuo telefono o la tua mail");
		String testo = scan.nextLine();

		Pattern pattern = Pattern.compile(NUM_TEL);
		Matcher matcher = pattern.matcher(testo);

		Pattern pattern2 = Pattern.compile(EMAIL);
		Matcher matcher2 = pattern2.matcher(testo);

		if (matcher.find())
			System.out.println("Hai inserito un telefono)");

		else if (matcher2.find())
			System.out.println("Hai inserito una mail");

		else
			System.out.println("Inserisci il tuo telefono o la tua mail");

	}
}
