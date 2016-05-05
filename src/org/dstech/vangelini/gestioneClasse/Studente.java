package org.dstech.vangelini.gestioneClasse;

import java.util.Calendar;

public class Studente extends Persona{
	
	public String getMatricola(Studente persona){
		Calendar cal = Calendar.getInstance();
		cal.setTime(persona.getDataNascita());
		int mese = cal.get(Calendar.MONTH);
		int anno = cal.get(Calendar.YEAR);
		return (persona.getNome()+mese+anno);
	}

	@Override
	public String getMatricola() {
		return null;
	}
}
