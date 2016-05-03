package org.dstech.smastro.agendina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.dstech.vangelini.Agenda.Persona;


public class Agenda {
	private ArrayList<Persona>listaPersone;
	
	public Agenda(ArrayList<Persona>listaPersone){
		this.listaPersone=listaPersone;
	}
	public Agenda(){
		this.listaPersone=new ArrayList<Persona>();
	}
	
	public ArrayList<Persona> getListaPersone() {
		return listaPersone;
	}
	public void setListaPersone(ArrayList<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}
	
	public void StampaListaPersone(List<Persona> listaPersone) {

		for (Persona persona:this.listaPersone){
			System.out.println(persona);
		}
	}
	
	public void Aggiungi(Persona persona){
		if(this.listaPersone.add(persona)){
			System.out.println("La persona "+persona+" e' stata aggiunta");
		}
			System.out.println("Non e' stata aggiunta nessuna persona alla lista");
		}
	
	public void Rimuovi(Persona persona){
		if(this.listaPersone.remove(persona)){
			System.out.println("La persona "+persona+" e' stata rimossa");
		}
		System.out.println("Non hai rimosso nessuna persona dalla lista");
	}
	
	public void OrdinamentoPerCognome(){
		ArrayList<String>listaOrdinata=new ArrayList<String>();
		for(Persona persona:listaPersone){
			listaOrdinata.add(persona.geCognome());
		}
		Collections.sort(listaOrdinata,String.CASE_INSENSITIVE_ORDER);
		System.out.println(cognome);
	}
	
	public Persona ricercaOrdine(String nome){
		for(Persona persona : listaPersone){
			if(persona.getNome() == nome){
				return persona;
			}
		}
		return null;
	}
	public Persona RicercaPerTelefono(String numero){
		for(Persona persona:listaPersone){
			if(persona.getTelefono()==numero){
				return persona;
			}
			return null;
		}
	}
    }
	

