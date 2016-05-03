package org.dstech.lulizi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPattern {
	

	public static void main(String[] args) {
		// leggere da tastiera stringa e dire se è numero di tel o email
		boolean risposta=false;
		do{
		Scanner inputtast= new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String input= inputtast.nextLine(); 
		System.out.println("Hai inserito la stringa "+input);
		
//		String inputRisposta= inputtast.nextLine();
		String telefono   = "\\d{3} \\d{3} \\d{4}";
		String telefono2 ="\\d{10}";
		String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]*)$";
		
		
		if (input.matches(telefono)|| input.matches(telefono2) ) {
		    System.out.println("La stringa: " + input +" è un telefono");
		}
		else if  (input.matches(email))
				{
			System.out.println("La stringa: " + input +" è un email");
				}
		else{
			System.out.println("Non è ne un telefono ne una stringa");
		}
		
		System.out.println("Vuoi inserire un altra stringa? S o N");
		
		input= inputtast.nextLine();
		
		String risp = "s|S";
		if (input.matches(risp))
				{
			risposta=true;
				}
		else
		{
			risposta=false;
		}
			} while (risposta);
	}		
}
