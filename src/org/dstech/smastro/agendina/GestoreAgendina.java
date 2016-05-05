package org.dstech.smastro.agendina;

import java.util.Date;

public class GestoreAgendina {
	public static void main(String args[]){
		AgendaSimone agenda=new AgendaSimone();
		agenda.aggiungiPersona(creaPersona());
	
	}
	public static Persona creaPersona(){
		String nome="giannastasio";
		String cognome="pippo";
		int eta=23;
		String telefono="345 6587987";
		String email="gianni@pippi.com";
		Date data=new Date();
		Persona giannastasio=new Persona(nome,cognome,eta,telefono,email,data);
		return giannastasio;
	}
}
