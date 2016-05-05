package org.dstech.lulizi.registroClasse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Persona {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	private Date dataDiNascita;
	
   
    
	


	
	

	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) throws ParseException {
	   
	    
		
      
		
		
		
		this.dataDiNascita = dataDiNascita;
	}
	public Persona()
    {
    	
    }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}
	
	
	
	
	
	
	
	

}
