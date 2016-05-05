package org.dstech.smastro.Registro;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Studente extends Persona {
	private String matricola;
	
	public String getMatricola(){
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm/yyyy");
		Calendar calendario= Calendar.getInstance();
		int year=calendario.get(Calendar.YEAR);
		int month=calendario.get(Calendar.MONTH);
		this.matricola = (this.getNome()+month+year);
		return this.matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
/**
 * 
 */
public Studente() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Studente [matricola=").append(matricola).append("]");
	return builder.toString();
}



}
