package org.dstech.vangelini.gestioneClasse;

import java.util.Calendar;

public class Docente extends Persona {
	
	public String getMatricola(Persona persona){
		Calendar cal = Calendar.getInstance();
		cal.setTime(persona.getDataNascita());
		int mese = cal.get(Calendar.MONTH);
		return (persona.getCognome()+mese+persona.getCodFiscale());
	}

	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
