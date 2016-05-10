package org.dstech.gcontaldi.lottomatica;

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
 * @author Gianluca
 *
 */
public class MainEstrazione {

	public static void main(String[] args) throws ParseException, IOException {

		ArrayList<Estrazione> listaEstrazione = new ArrayList<>();

		// si caricano le vecchie estrazioni
		
		System.out.println("Caricamento Estrazioni in corso...");
		LetturaSalvataggioFile file = new LetturaSalvataggioFile();
		ArrayList<Estrazione> listaEstrazioni = null;
		try{
			listaEstrazioni = file.leggiFile("estrazioni.jjj");
			System.out.println("Estrazioni caricate");
		} catch (Exception e){
			file.creaFile("estrazioni.jjj");
			System.out.println("Nessuna estrazione trovata, è stato creato un nuovo file estrazioni.jjj");
			listaEstrazioni = new ArrayList<Estrazione>();
		}

		Scanner sc = new Scanner(System.in);
		int risposta = 0;
		do {
			System.out.println("-----Benvenuto! Cosa vuoi fare?-----");
			System.out.println("1 - Nuova estrazione");
			System.out.println("2 - Storico estrazioni");
			System.out.println("3 - Elimina estrazione");
			System.out.println("9 - Chiudi programma");

			try {
				risposta = sc.nextInt();

			} catch (InputMismatchException e) {

				risposta = 0;
			}

			sc.nextLine();

			switch (risposta) {

			case 1:
				Date data = new Date();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm");
				String newData = formatter.format(data);
				data = formatter.parse(newData);

				Estrazione nuovaEstrazione = new Estrazione(data);
				listaEstrazione.add(nuovaEstrazione);

				// salvataggio estrazioni in file
				
				try{
					file.salvaFile("estrazioni.jjj", listaEstrazioni);
				} catch (Exception e){
					file.creaFile("estrazioni.jjj");
					file.salvaFile("estrazioni.jjj", listaEstrazioni);
				}

				break;
			case 2:
				for (Estrazione estrazione : listaEstrazione) {
					System.out.println(estrazione);
				}

				break;
			case 3:
				Estrazione estrazioneSelezionata = selezioneEstrazione(listaEstrazione);
				listaEstrazione.remove(estrazioneSelezionata);
				
				// salvataggio estrazioni in file
				
				try{
					file.salvaFile("estrazioni.jjj", listaEstrazioni);
				} catch (Exception e){
					file.creaFile("estrazioni.jjj");
					file.salvaFile("estrazioni.jjj", listaEstrazioni);
				}
				
				break;
			case 9:
				risposta = 9;
				break;
			default:
				System.out.println("Risposta non valida. Riprova");
				break;

			}

		} while (risposta != 9);
		try{
			file.salvaFile("estrazioni.jjj", listaEstrazioni);
		} catch (Exception e){
			file.creaFile("estrazioni.jjj");
			file.salvaFile("estrazioni.jjj", listaEstrazioni);
		}
		System.out.println("Programma terminato");
	}

	

	public static Estrazione selezioneEstrazione(ArrayList<Estrazione> listaEstrazione) {

		int i = 0;
		for (Estrazione estrazione : listaEstrazione) {
			i++;
			System.out.println(i + " - " + estrazione.getData_estrazione());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Selezione estrazione da elminare");
		boolean notint = true;
		int estrazioneSelezionata = 0;
		while (notint) {
			try {
				estrazioneSelezionata = scanner.nextInt();
				if (estrazioneSelezionata <= 0 & estrazioneSelezionata > listaEstrazione.size()) {
					notint = false;

				} else {
					System.out.println("Scelta non valida");
				}

			} catch (InputMismatchException e) {
				System.out.println("Operazione non consentita");

			}
			return null;
		}
		Estrazione estrazione = listaEstrazione.get(estrazioneSelezionata - 1);
		return estrazione;
	}
}
