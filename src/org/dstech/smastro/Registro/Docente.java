package org.dstech.smastro.Registro;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Docente extends Persona {
	private String matricola;
	
	public String getMatricola(){
		return matricola;
	}
	
	public void setMatricola(String dateFormat) {
		this.matricola = dateFormat;
	}
	
	public String getMatricola(Docente p){
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm");
		Calendar calendario=Calendar.getInstance();
		int month=calendario.get(Calendar.MONTH);
		return (p.getCognome()+month+getCodFisc());
		


}
}