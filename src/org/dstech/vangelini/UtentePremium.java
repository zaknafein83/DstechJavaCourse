package org.dstech.vangelini;

public class UtentePremium extends UtenteBase{
	private double fido;

	public UtentePremium(Integer id, double saldo, double fido) {
		super(id, saldo);
		this.fido = fido;
	}

	public double getFido() {
		return fido;
	}

	public void setFido(double fido) {
		this.fido = fido;
	}
	
	public void RitiroDenaro(UtentePremium utente, double denaro){
		if(denaro > 500){
			System.out.println("Importo richiesto supera la soglia di 500 euro");
		} else {
			double saldo = utente.getSaldo();
			double fido = utente.getFido();
			double saldo_totale = saldo + fido;
			if(saldo_totale <= denaro){
				AggiungiMuovimento(utente, "Prelievo", denaro);
				if(saldo <= denaro){
					saldo = saldo - denaro;
					utente.setSaldo(saldo);
				} else {
					double differenza = saldo - denaro;
					utente.setSaldo(0);
					double nuovoFido = fido - differenza;
					utente.setFido(nuovoFido);
				}
			} else {
				System.out.println("Importo richiesto supera la disponibilita");
			}
		}
	}
	
}