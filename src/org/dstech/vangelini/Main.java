package org.dstech.vangelini;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args) {
		Scanner io = new Scanner(System.in);
		System.out.print("Inserisci Stringa: ");
		String stringaInserita = io.nextLine();
		String prima_regola = "(^\\d{10}$)";
		String seconda_regola = "(^\\d{3} \\d{3} \\d{4}$)";
		String terza_regola = "(^\\w+@\\w+\\.\\w{2,6}$)";
		Pattern pattern = Pattern.compile(prima_regola+"|"+seconda_regola+"|"+terza_regola);
		Matcher matcher = pattern.matcher(stringaInserita);
		while(matcher.find()){
			System.out.println("Keyword trovata: "+matcher.group());
		}
		System.out.println("Programma terminato");
	}

}
