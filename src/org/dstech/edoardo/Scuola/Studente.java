package org.dstech.edoardo.Scuola;

import java.util.Calendar;

public class Studente extends Persona {

	private String matricola;

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String getMatricola() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDataDiNascita());
		int mese = cal.get(Calendar.MONTH);
		int anno = cal.get(Calendar.YEAR);
		this.matricola = anno + "" + mese;
		return matricola;

	}

}
