package org.dstech.smastro.Registro;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Studente extends Persona {
	private String matricola;
	
	public String getMatricola(){
		return matricola;
	}
	
	public void setMatricola(String dateFormat) {
		this.matricola = dateFormat;
	}


	public String getMatricola(Studente persona){
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm/yyyy");
		Calendar calendario= Calendar.getInstance();
		int year=calendario.get(Calendar.YEAR);
		int month=calendario.get(Calendar.MONTH);
		return (persona.getNome()+month+year);
	}


}
