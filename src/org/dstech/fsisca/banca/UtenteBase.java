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
public class UtenteBase extends UtenteGenerico implements AzioniConto{

	private double saldo;

	public UtenteBase(String id, double saldoIniziale) {
		super(id);
		this.saldo = saldoIniziale;
	}

	public UtenteBase(String id) {
		this(id, 0.0);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicUser [saldo=").append(saldo).append("] - [id = " + this.getId() + "]");
		return builder.toString();
	}

	@Override
	public boolean prelievo(double importoDaPrelevare) {
		if (importoDaPrelevare <= this.getSaldo()) {
			double nuovoSaldo = this.getSaldo()-importoDaPrelevare;
			this.setSaldo(nuovoSaldo);
			return true;
		}
		return false;
	}

	@Override
	public boolean deposito(double importoDaDepositare) {
		double nuovoSaldo = this.getSaldo() + importoDaDepositare;
		this.setSaldo(nuovoSaldo);
		return true;
	}
}
