package org.dstech.vangelini;

import java.util.ArrayList;

public abstract class Operazioni implements Utente{
	
	public void StampaSaldo(UtenteBase utente){
		double saldo = utente.getSaldo();
		System.out.println("Il saldo è: "+saldo);
	}
	
	public void ListaMuovimenti(UtenteBase utente){
		ArrayList<Muovimenti> muovimenti = utente.getMuovimenti();
		int i = 0;
		System.out.println("Utente: "+utente.getId());
		for(Muovimenti muovimento : muovimenti){
			i++;
			System.out.println(i+" "+muovimento.getAzione()+" denaro: "+muovimento.getDenaro());
		}
	}
	
}
