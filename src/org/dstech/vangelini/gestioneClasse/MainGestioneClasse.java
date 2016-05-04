package org.dstech.vangelini.gestioneClasse;

import java.io.IOException;
import java.util.ArrayList;

public class MainGestioneClasse {

	public static void main(String[] args) throws IOException {
		//Caricamento Classe
		System.out.println("Caricamento Classi in corso...");
		LetturaSalvataggioFile file = new LetturaSalvataggioFile();
		//supress da cancellare 
		@SuppressWarnings("unused")
		ArrayList<Classe> classi = new ArrayList<Classe>();
		try{
			classi = file.leggiFileClasse("classi.jjj");
			System.out.println("classi caricate.");
		} catch (Exception e){
			file.creaFileClasse("classi.jjj");
			System.out.println("Nessuna classe trovata, è stato creato un nuovo file classe.jjj");
		}
		//Caricamento Registro
		
		//
		
	}

}
