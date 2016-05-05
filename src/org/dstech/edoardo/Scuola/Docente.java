package org.dstech.edoardo.Scuola;

import java.util.Calendar;

public class Docente extends Persona {
	
	//Creo la matricola del docente piu i suoi parametri
	
	public String setMatricola(Persona persona){
		Calendar cal = Calendar.getInstance();
		cal.setTime(persona.getDataDiNascita());
		int mese = cal.get(Calendar.MONTH);
		return setMatricola(persona);
	}
	

	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return null;
	}

}
