package org.dstech.vangelini;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Operatore operatore_uno = new Operatore(1);
		Operatore operatore_due = new Operatore(2);
		Operatore operatore_terzo = new Operatore(3);
		
		UtenteBase utente_base_uno = new UtenteBase(4, 3000);
		UtenteBase utente_base_due = new UtenteBase(5, 4000);
		UtenteBase utente_base_tre = new UtenteBase(6, 6000);
		
		UtentePremium utente_premium_uno = new UtentePremium(7, 30000, 2000);
		UtentePremium utente_premium_due = new UtentePremium(8, 21000, 2000);
		UtentePremium utente_premium_tre = new UtentePremium(9, 45000, 3000);
		
		int prima_risposta = 0;
		Scanner io = new Scanner(System.in);
		do{
			System.out.println("Identificati, Sei un Cliente(1) o un Operatore(2):");
			prima_risposta = io.nextInt();
		} while(!(prima_risposta == 1 || prima_risposta == 2));
		
		int flag = 0;
	}
	
}
