package org.dstech.edoardo.Scuola;

import java.util.Calendar;

public class Studente extends Persona {
	  
    
	//Creo la matricola dello studente piu i suoi parametri
	
	public String setMatricola(Studente persona){
		Calendar cal = Calendar.getInstance();
		cal.setTime(persona.getDataDiNascita());
		int mese = cal.get(Calendar.MONTH);
		int anno = cal.get(Calendar.YEAR);
		return setMatricola(persona);
		
	}

	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return null;
	}


}
