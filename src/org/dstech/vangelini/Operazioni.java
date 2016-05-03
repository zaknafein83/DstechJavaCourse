package org.dstech.vangelini;

import java.util.ArrayList;

public abstract class Operazioni implements Utente {

	public void stampaSaldo(UtenteBase utente) {
		double saldo = utente.getSaldo();
		System.out.println("Il saldo è: " + saldo);
	}

	public void listaMuovimenti(UtenteBase utente) {
		ArrayList<Muovimenti> muovimenti = utente.getMuovimenti();
		System.out.println("Utente: " + utente.getId());
		for (int i = 0; i < muovimenti.size(); i++) {
			Muovimenti muovimento = muovimenti.get(i);
			System.out.println(i + " " + muovimento.getAzione() + " denaro: " + muovimento.getDenaro());
		}
	}

}
