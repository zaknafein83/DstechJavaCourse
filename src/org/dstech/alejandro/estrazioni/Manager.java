/**
 * 
 */
package org.dstech.alejandro.estrazioni;

import java.io.IOException;
import java.util.ArrayList;

import org.dstech.vangelini.estrazioni.Estrazione;
import org.dstech.vangelini.estrazioni.LetturaSalvataggioFile;

/**
 * @author Alejandro
 *
 */
public class Manager {

	public static ArrayList<Estrazione> load() throws IOException{
		
		System.out.println("Caricamento Estrazioni in corso...");
		LetturaSalvataggioFile file = new LetturaSalvataggioFile();
		ArrayList<Estrazione> lista_estrazioni = null;
		try{
			lista_estrazioni = file.leggiFile("estrazioni.jjj");
			System.out.println("Estrazioni caricate");
		} catch (Exception e){
			file.creaFile("estrazioni.jjj");
			System.out.println("Nessuna estrazione trovata, è stato creato un nuovo file estrazioni.jjj");
			lista_estrazioni = new ArrayList<Estrazione>();
		}
		return lista_estrazioni;
	}
}
