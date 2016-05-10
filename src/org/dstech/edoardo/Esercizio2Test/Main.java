/**
 * 
 */
package org.dstech.edoardo.Esercizio2Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author edoardopierguidi
 *
 */								
public class Main {

	public static void main(String[] args) throws ParseException {

		ArrayList<Lottomatica> listaEstrazione = new ArrayList<Lottomatica>();

		// qui dobbiamo caricare

		Scanner tastiera = new Scanner(System.in);
		int risposta = 0;
		do {
			System.out.println("Menu");
			System.out.println("1- Nuova estrazione");
			System.out.println("2- Storico estrazioni");
			System.out.println("3- Rimuovi estrazione");
			System.out.println("9- Esci dal programma");
			System.out.println("Seleziona scelta");

			try {
				risposta = tastiera.nextInt();
			} catch (InputMismatchException e) {
				risposta = 0;
			}
			tastiera.nextLine();
			switch (risposta) {
			case 1:
				Date data = new Date();
				DateFormat formatoData = new SimpleDateFormat("dd/mm/yy hh:mm");
				String newData = formatoData.format(data);
				data = formatoData.parse(newData);
				Lottomatica nuovaEstrazione = new Lottomatica(data);
				listaEstrazione.add(nuovaEstrazione);

				// Salvataggio file

				break;
			case 2:
				for (Lottomatica estrazione : listaEstrazione) {
					System.out.println(estrazione);
				}

				break;
			case 3:

				Lottomatica estrazioneSelezionata = selezionaEstrazione(listaEstrazione);
				listaEstrazione.remove(estrazioneSelezionata);

				break;
			case 9:
				risposta = 9;

				break;
			default:
				System.out.println("Risposta Sbagliata");
				break;

			}
		} while (risposta != 9);
		System.out.println("End Program");
	}

	public static Lottomatica selezionaEstrazione(
			ArrayList<Lottomatica> listaEstrazione) {
		int i = 0;
		for (Lottomatica estrazione :listaEstrazione){
			i++;
			System.out.println(i+" - "+estrazione.getDataEstrazione());
		}
		Scanner tastiera2 = new Scanner(System.in);
		System.out.println("Seleziona estrazione da eliminare");
		boolean notInt = true;
		int estrazioneSelezionata = 0;
		while(notInt){
			try {
				estrazioneSelezionata = tastiera2.nextInt();
				if(estrazioneSelezionata >= 0 && estrazioneSelezionata < listaEstrazione.size()){
					notInt = false;
				}else{
					System.out.println("Scelta non valida");

				}
			} catch (InputMismatchException e) {
				System.out.println("Operazione non consentita");

				estrazioneSelezionata = 0;
			}
		}
		Lottomatica estrazione = listaEstrazione.get(estrazioneSelezionata-1);

		return estrazione;
	}
}
