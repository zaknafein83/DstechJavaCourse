package org.dstech.gcontaldi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EsPattern {

	private static final String MAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String TELEFONO = "\\d{3} \\d{3} \\d{4}|\\d{10}";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci un numero di telefono o una mail");
		String testo = sc.nextLine();

		Pattern pattern = Pattern.compile(MAIL);
		Matcher matcher = pattern.matcher(testo);

		Pattern pattern2 = Pattern.compile(TELEFONO);
		Matcher matcher2 = pattern2.matcher(testo);

		if (matcher.find())
			System.out.println("Ok! Hai inserito una mail ;)");

		else if (matcher2.find())
			System.out.println("Ok! Hai inserito un telefono ;)");

		else
			System.out.println("Insirisci solo una mail o un telefono.");

	}
}
