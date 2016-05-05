/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.util.Calendar;

/**
 * @author franksisca
 *
 */
public class Docente extends Persona {

	
	private String matricola;
	/* (non-Javadoc)
	 * @see org.dstech.fsisca.GestioneScuola.Persona#getMatricola()
	 */
	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return this.getCognome()+getMeseNascita()+this.getCodFiscale();
	}

	/**
	 * @return
	 */
	private String getMeseNascita() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDataNascita());
		int month = cal.get(Calendar.MONTH) + 1;
		return "" + month;
	}

	/**
	 * @param matricola the matricola to set
	 */
	@SuppressWarnings("unused")
	private void setMatricola(String matricola) {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Docente [");
		if (this.getMatricola() != null)
			builder.append("matricola=").append(this.getMatricola());
		builder.append("]");
		return builder.toString();
	}
	
	
}
