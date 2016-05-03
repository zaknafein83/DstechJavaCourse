package org.dstech.vangelini.Agenda;

import java.util.ArrayList;
import java.util.Collections;

public class Agenda {
	private ArrayList<Persona> listaPersone;

	public Agenda(ArrayList<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}
	
	public Agenda() {
		this.listaPersone = new ArrayList<Persona>();
	}

	public ArrayList<Persona> getListaPersone() {
		return listaPersone;
	}

	public void setListaPersone(ArrayList<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}
	
	public boolean aggiungiPersona(Persona persona){
		if(this.listaPersone.add(persona)){
			return true;
		}
		return false;
	}
	
	public boolean rimuoviPersona(Persona persona){
		if(this.listaPersone.remove(persona)){
			return true;
		}
		return false;
	}
	
	public void stampaListaPersone(){
		for(Persona persona : this.listaPersone){
			System.out.println(persona);
		}
	}
	
	public Persona ricercaPerNumeroTelefonico(String telefono_ricercato){
		for(Persona persona : listaPersone){
			if(persona.getNumero_telefono() == telefono_ricercato){
				return persona;
			}
		}
		return null;
	}
	
	public Persona ricercaPerOrdineAlfabetico(String nome){
		for(Persona persona : listaPersone){
			if(persona.getNome() == nome){
				return persona;
			}
		}
		return null;
	}
	
	public void stampaInOrdineAlfabeticoPerNome(){
		ArrayList<String> lista_ordinata = new ArrayList<String>();
		for(Persona persona : listaPersone){
			lista_ordinata.add(persona.getNome());
		}
		Collections.sort(lista_ordinata, String.CASE_INSENSITIVE_ORDER);
		for(String nome : lista_ordinata){
			System.out.println(nome);
		}
	}
	
	public void stampaInOrdineAlfabeticoPerCognome(){
		ArrayList<String> lista_ordinata = new ArrayList<String>();
		for(Persona persona : listaPersone){
			lista_ordinata.add(persona.getCognome());
		}
		Collections.sort(lista_ordinata, String.CASE_INSENSITIVE_ORDER);
		for(String cognome : lista_ordinata){
			System.out.println(cognome);
		}
	}
	
}
