package org.dstech.Lorenzo.Registro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Studente extends Persona {

	private String matricola;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola() {
		SimpleDateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		int mese = cal.get(Calendar.MONTH);
		int anno = cal.get(Calendar.YEAR);
		//System.out.println(Persona.class.getName()+mese+anno);
        matricola=(getNome()+mese+anno);
	}	
		
	@Override
	public String matricola() {
		// TODO Auto-generated method stub
		return null;
	}

}
