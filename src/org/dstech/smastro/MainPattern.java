package org.dstech.smastro;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPattern {
	private static final String TELEFONO = "\\d{2} \\d{4} \\d{3}";
	private static final String E_MAIL = "^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]*)$";

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String t = sc.nextLine();

		Pattern pattern = Pattern.compile(TELEFONO);
		Pattern pattern1 = Pattern.compile(E_MAIL);
		Matcher matcher = pattern.matcher(t);
		Matcher matcher1 = pattern1.matcher(t);

		if (matcher.find()) {
			System.out.println("La stringa che hai inserito e' un telefono");
		}

		else if (matcher1.find()) {
			System.out.println("La stringa che hai inserito e' un'e-mail");
		}
		else {System.out.println("La stringa non è un telefono e neanche un email");}
		
	}

}
