/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package org.dstech.fsisca.banca;

/**
 * @author franksisca
 *
 */
public class UtentePremium extends UtenteBase {

	private double fido;

	public UtentePremium(String id, double saldoIniziale, double fido) {
		super(id, saldoIniziale);
		this.fido = fido;
	}

	public UtentePremium(String id, double saldoIniziale) {
		this(id, saldoIniziale, Costants.FIDO);
	}

	public UtentePremium(String id) {
		this(id, 0.0, Costants.FIDO);
	}

	/**
	 * @return the fido
	 */
	public double getFido() {
		return fido;
	}

	/**
	 * @param fido
	 *            the fido to set
	 */
	public void setFido(double fido) {
		this.fido = fido;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PremiumUser [fido=").append(fido).append("] - [id= " + this.getId() + "] - [saldo=" + this.getSaldo() + "]");
		return builder.toString();
	}
	
	@Override
	public boolean prelievo(double importoDaPrelevare) {
		if((this.getSaldo() + this.getFido())>=importoDaPrelevare){
			if(getSaldo() >= importoDaPrelevare){
				double nuovoSaldo = this.getSaldo() - importoDaPrelevare;
				this.setSaldo(nuovoSaldo);
				return true;
			} else {
				double soldiDaScalareAFido = importoDaPrelevare - this.getSaldo();
				this.setSaldo(0.0);
				double nuovoFido = this.getFido() - soldiDaScalareAFido;
				this.setFido(nuovoFido);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deposito(double importoDaDepositare) {
		if(this.getFido() < Costants.FIDO) {
			double fillFido = Costants.FIDO - this.getFido();
			if(fillFido >= importoDaDepositare){
				double nuovoFido = this.getFido() + importoDaDepositare;
				this.setFido(nuovoFido);
			} else {
				double nuovoSaldo = importoDaDepositare - fillFido;
				this.setFido(Costants.FIDO);
				this.setSaldo(nuovoSaldo);
			}
		}
		return true;
	}

}
