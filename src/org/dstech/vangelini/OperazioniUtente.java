package org.dstech.vangelini;

import java.util.ArrayList;

public abstract class OperazioniUtente extends Operazioni{
	
	public void ritiroDenaro(UtenteBase utente, double denaro){
		if(denaro > 500){
			System.out.println("Importo richiesto supera la soglia di 500 euro");
		} else {
			double saldo = utente.getSaldo();
			if(saldo < denaro){
				System.out.println("Importo richiesto supera la disponibilita");
			} else{
				saldo = saldo - denaro;
				utente.setSaldo(saldo);
				aggiungiMuovimento(utente, "Prelievo", denaro);
			}
		}
	}
	
	public static void aggiungiMuovimento(UtenteBase utente, String nomeMuovimento, double importo){
		ArrayList<Muovimenti> muovimenti= utente.getMuovimenti();
		Muovimenti muovimento = new Muovimenti(importo, nomeMuovimento, System.currentTimeMillis());
		muovimenti.add(muovimento);
		utente.setMuovimenti(muovimenti);
	}
	
	public void depositaDenaro(UtenteBase utente, double denaro){
		double saldo = utente.getSaldo();
		saldo = saldo + denaro;
		utente.setSaldo(saldo);
		utente.addMovimento(new Muovimenti(denaro, "DEPOSITO", System.currentTimeMillis()));
//		aggiungiMuovimento(utente, "Deposito", denaro);
	}
	
}