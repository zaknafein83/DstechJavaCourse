/**
 * 
 */
package org.dstech.llamonica.lottomatica;

import java.io.LineNumberInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author luca
 *
 */
public class mainEstrazione {
	//List<Integer> listaEstrazione = new ArrayList();

	public static void main(String[] args) throws ParseException {
		ArrayList<Estrazione> listaEstrazione = new ArrayList();
		// qui si caricano le vecchie estrazione
		Scanner scanner = new Scanner(System.in);
		int risposta = 0;
		do {
			System.out.println("1-nuova estrazione");
			System.out.println("2-storico estrazione");
			System.out.println("3-rimuovi estrazione");
			System.out.println("9-esci dal programma");

			try {

				risposta = scanner.nextInt();

			} catch (InputMismatchException e) {
				risposta = 0;

			}
			scanner.nextLine();
			switch(risposta){
			case 1:
				   Date data=new Date();
				DateFormat formatter=new SimpleDateFormat("dd/MM/yyyy :hh mm");  
			   String newData =formatter.format(data);
			   data=formatter.parse(newData);
			   
			   Estrazione nuovaestrazione=new Estrazione(data);
			   listaEstrazione.add(nuovaestrazione);
			   
			   //salvataggio in file delle estrazione
			   
			   
			   
			       break;
			case 2:
				   for(Estrazione estrazione:listaEstrazione){
					   System.out.println(estrazione);
					   
				   }
				
				break;
			case 3:
				Estrazione estrazioneselezionata=selezioneEstrazione(listaEstrazione);
				listaEstrazione.remove(estrazioneselezionata);
				
				//salvataggio in file delle estrazioni
				break;
			case 9:
				risposta=9;
				break;
			default: 
				System.out.println("risposta non valida");
				break;
			}
				
				
				
				
		} while (risposta !=9);

	}
public static Estrazione selezioneEstrazione(ArrayList<Estrazione> listaEstrazione){
	int i=0;
	
	for(Estrazione estrazione:listaEstrazione){
		i++;
		System.out.println(i+ " - "+ estrazione.getDataEstrazione());
		
	}
	Scanner scanner1=new Scanner(System.in);
	System.out.println("seleziona estrazione da eliminare");
	boolean notint=true;
	int estrazioneselezionata=0;
	while(notint){
		try {

			estrazioneselezionata = scanner1.nextInt();
            if(estrazioneselezionata>=0 & estrazioneselezionata>listaEstrazione.size()){
            	notint=false;
            }
            	else{
            		System.out.println("scelta non valida");
            		
            	
            	
            }
		} catch (InputMismatchException e) {
			System.out.println("Operazione non consentita");
			
			

		}return null;
	
	}
	Estrazione estrazione=listaEstrazione.get(estrazioneselezionata-1);
	return estrazione;
}
}
