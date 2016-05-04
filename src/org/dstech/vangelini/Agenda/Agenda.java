package org.dstech.vangelini.Agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public static boolean controlloEmail(String email){
		String prima_regola = "(^\\w+@\\w+\\.\\w{2,6}$)";
		Pattern pattern = Pattern.compile(prima_regola);
		Matcher matcher = pattern.matcher(email);
		if(matcher.find()){
			return true;
		}
		return false;
	}

	public static boolean controlloTel(String tel){
		//regola per telefono (+39 338 1234567 | +39 3381234567 | 3381234567 | +39 338 123 4567)
		String prima_regola = "(^+39 \\d{3} \\d{7}$)";	
		String seconda_regola = "(^\\d{10}$)";
		String terza_regola = "(^+39 \\d{3} \\d{3} \\d{4}$)";
		String quarta_regola = "(^+39 \\d{10}$)";
		Pattern pattern = Pattern.compile(seconda_regola+"|"+terza_regola+"|"+quarta_regola+"|"+prima_regola);
		Matcher matcher = pattern.matcher(tel);
		if(matcher.find()){
			return true;
		}
		return false;
	}
	
	public Persona ricercaPerNumeroTelefonico(String telefono_ricercato){
		for(Persona persona : listaPersone){
			if(telefono_ricercato.equals(persona.getNumero_telefono())){
				return persona;
			}
		}
		return null;
	}
	
	public ArrayList<Persona> ricercaPerOrdineAlfabetico(String nome){
		ArrayList<Persona> listaPersoneRicercate = new ArrayList<Persona>();
		for(Persona persona : listaPersone){
			if(nome.equals(persona.getNome())){
				listaPersoneRicercate.add(persona);
			}
		}
		return listaPersoneRicercate;
	}
	
	public static void stampaLista(ArrayList<Persona> lista_ricercata){
		for(Persona persona : lista_ricercata){
			System.out.println(persona);
		}
	}
	
	public Persona personaRicercata(){
		int i = 0;
		for(Persona persona : listaPersone){
			i++;
			System.out.println(i+" - "+persona);
		}
		Scanner io2 = new Scanner(System.in);
		boolean notInt = true;
		int index = 0;
		while(notInt){
			System.out.println("Inserisci posizione della persona: ");
			try{
				index = io2.nextInt();
				notInt = false;
			} catch(InputMismatchException exp){
				notInt = true;
				System.out.println("Non valido, Riprova");
			}
			io2.nextLine();
		}
		//io2.close();
		Persona persona = listaPersone.get(--index);
		return persona;
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
