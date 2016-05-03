package org.dstech.alejandro.agendina;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setNome("Alejandro");
		persona.setCognome("BlaBlaBla");
		persona.setEmail("aledip@yahoo.it");
		persona.setEta(22);
		persona.setTelefono("+3400898830");
		
		Agendina agendina = new Agendina();
		
		agendina.addPersona(persona);
		
		agendina.stampListPersone();
		agendina.stampListPersoneAlpha("nome");
	}
	
	
	
	

}
