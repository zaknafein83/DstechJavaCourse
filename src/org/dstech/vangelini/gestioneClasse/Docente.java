package org.dstech.vangelini.gestioneClasse;

import java.util.Calendar;

public class Docente extends Persona {
	private String matricola;
	
	public void setMatricola(Docente docente){
		Calendar cal = Calendar.getInstance();
		cal.setTime(docente.getDataNascita());
		int mese = cal.get(Calendar.MONTH);
		matricola = (docente.getCognome()+mese+docente.getCodFiscale());
	}
	
	@Override
	public String getMatricola() {
		return matricola;
	}
	
}