package org.dstech.smastro.agendina;

import java.util.ArrayList;
import java.util.List;

public class AgendaSimone {
	private List<Persona>listaPersone;
	public AgendaSimone(){
		listaPersone=new ArrayList<Persona>();
		
	}
	public void aggiungiPersona(Persona persona){
		listaPersone.add(persona);
	}
}
