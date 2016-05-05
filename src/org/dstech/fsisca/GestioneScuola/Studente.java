/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author franksisca
 *
 */
public class Studente extends Persona {

	
	private String matricola;
	/* (non-Javadoc)
	 * @see org.dstech.fsisca.GestioneScuola.Persona#getMatricola()
	 */
	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return this.getNome() + this.getMeseNascita() + this.getAnnoNascita();
	}

	private String getMeseNascita() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDataNascita());
		int month = cal.get(Calendar.MONTH) + 1;
		return "" + month;
	}
	private String getAnnoNascita() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDataNascita());
		int year = cal.get(Calendar.YEAR);
		return "" + year;
	}
	/**
	 * @param matricola the matricola to set
	 */
	@SuppressWarnings("unused")
	private void setMatricola(String matricola) {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Studente [");
		if (this.getMatricola() != null)
			builder.append("matricola=").append(this.getMatricola());
		builder.append("]");
		return builder.toString();
	}
	
	
}
