/**
 * 
 */
package org.dstech.alejandro.estrazioni;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.dstech.vangelini.estrazioni.Estrazione;
import org.dstech.vangelini.estrazioni.LetturaSalvataggioFile;

/**
 * @author Alejandro
 *
 */
public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		
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
		Scanner io = new Scanner(System.in);
		int risposta = 0;
		do{
			System.out.println("###################################");
			System.out.println("Menu:");
			System.out.println("1 - Nuova Estrazione");
			System.out.println("2 - Storico Estrazioni");
			System.out.println("3 - Rimuovi Estrazione");
			System.out.println("9 - Esci dal programma");
			System.out.println("###################################");
			try{
				risposta = io.nextInt();
			} catch(InputMismatchException e){
				risposta = 0;
			}
			io.nextLine();
			switch(risposta){
				case 1:
					Date data = new Date();
					DateFormat formatter = new SimpleDateFormat("dd/mm/yy hh:mm");
					String new_data = formatter.format(data);
					data = formatter.parse(new_data);
					Estrazione nuova_estrazione = new Estrazione(data);
					lista_estrazioni.add(nuova_estrazione);
					//salvataggio in file delle estrazioni
					try{
						file.salvaFile("estrazioni.jjj", lista_estrazioni);
					} catch (Exception e){
						file.creaFile("estrazioni.jjj");
						file.salvaFile("estrazioni.jjj", lista_estrazioni);
					}
				break;
				case 2:
					for(Estrazione estrazione : lista_estrazioni){
						System.out.println(estrazione);
					}
				break;
				case 3:
					Estrazione estrazione_selezionata = selezionaEstrazione(lista_estrazioni);
					lista_estrazioni.remove(estrazione_selezionata);
					
					try{
						file.salvaFile("estrazioni.jjj", lista_estrazioni);
					} catch (Exception e){
						file.creaFile("estrazioni.jjj");
						file.salvaFile("estrazioni.jjj", lista_estrazioni);
					}
				break;
				case 9:
					risposta = 9;
				break;
				default:
					System.out.println("Risposta non valida!");
				break;
			}
		} while(risposta != 9);
		try{
			file.salvaFile("estrazioni.jjj", lista_estrazioni);
		} catch (Exception e){
			file.creaFile("estrazioni.jjj");
			file.salvaFile("estrazioni.jjj", lista_estrazioni);
		}
		System.out.println("Programma terminato!");
	}

	public static Estrazione selezionaEstrazione(ArrayList<Estrazione> lista_estrazioni){
		int i = 0;
		for(Estrazione estrazione : lista_estrazioni){
			i++;
			System.out.println(i+" - "+estrazione.getData_estrazione());
		}
		Scanner io2 = new Scanner(System.in);
		System.out.println("Seleziona estrazione da eliminare: ");
		boolean notInt = true;
		int estrazione_selezionata = 0;
		while(notInt){
			try{
				estrazione_selezionata = io2.nextInt();
				if(estrazione_selezionata >= 0 && estrazione_selezionata < lista_estrazioni.size()){
					notInt = false;
				} else {
					System.out.println("Scelta non valida!");
				}
			} catch(InputMismatchException e){
				System.out.println("Operazione non consentita");
			}
		} 
		Estrazione estrazione = lista_estrazioni.get(estrazione_selezionata-1);
		return estrazione;
	}
}
