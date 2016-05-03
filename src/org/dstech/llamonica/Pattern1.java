package org.dstech.llamonica;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern1 {
	private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String TELEFONO = ("\\d{3} \\d{3} \\d{4}|\\d{10}");

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci frase o numero");
		String testo = scanner.nextLine();

		Pattern pattern = Pattern.compile(EMAIL);
		Pattern pattern1 = Pattern.compile(TELEFONO);
		Matcher matcher = pattern.matcher(testo);
		Matcher matcher1 = pattern1.matcher(testo);
		int n = 0;
		int i = 0;

		while (matcher.find()) {
			System.out.println("è una email");
			n = 1;
		}
		while (matcher1.find()) {
			System.out.println("è un numero");
			i = 1;
		}
		if (n == 0 && i == 0) {
			System.out.println("è un'altro");
		}
	}

}
