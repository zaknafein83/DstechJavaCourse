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

		Persona persona2 = new Persona();
		persona2.setNome("Ronaldo");
		persona2.setCognome("Da silva");
		persona2.setEmail("ronaldo@yahoo.it");
		persona2.setEta(23);
		persona2.setTelefono("+3405558830");

		Persona persona3 = new Persona();
		persona3.setNome("Claudio");
		persona3.setCognome("Ranieri");
		persona3.setEmail("ranieri@yahoo.it");
		persona3.setEta(64);
		persona3.setTelefono("+3405558830");

		Agendina agendina = new Agendina();

		agendina.addPersona(persona);
		agendina.addPersona(persona2);
		agendina.addPersona(persona3);

		agendina.stampListPersone();
		agendina.removePersona(persona2);
		System.out.println(agendina.searchForTelefono("+3400898830"));
		System.out.println(agendina.searchForNome("Claudio"));
		agendina.stampListPersoneAlpha("nome");

	}

}
