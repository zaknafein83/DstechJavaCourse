package org.dstech.vangelini.gestioneClasse;
/*
 * @created by Angelz94
 * 
 */

//Main da terminare, debug dei metodi (probabile errore nella classe Calendar, incrementare month di 1).

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
		
		//fine caricamento registro
		//dichiaro la lista contenenti le classi
		ArrayList<Classe> lista_classi = new ArrayList<Classe>();
		
		System.out.println("-- Benveuto in MyClass --");
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		int risposta = 0;
		do{
			System.out.println("Scegliere l'operazione da effettuare:");
			System.out.println("1 - Stampa lista classi");
			System.out.println("2 - Crea nuova classe");
			System.out.println("3 - Modifica Classe");
			System.out.println("4 - Informazioni Classe");
			System.out.println("9 - Esci");
			boolean notInt = true;
			while(notInt){
				System.out.println("Inserisci numero operazione da effettuare: ");
				try{
					risposta = io.nextInt();
					notInt = false;
				} catch(InputMismatchException exp){
					notInt = true;
				}
				io.nextLine();
			}		
			switch(risposta){
				case 1:
					if(lista_classi.size() == 0){
						System.out.println("Nessuna classe trovata");
					} else {
						for(Classe classe : lista_classi){
							classe.stampaClasse();
						}
					}
				break;
				case 2:
					String nome_classe = "";
					boolean notStringNuovaClasse = true;
					while(notStringNuovaClasse){
						System.out.println("Inserisci nome classe: ");
						try{
							nome_classe = io.next();
							notStringNuovaClasse = false;
						} catch(InputMismatchException exp){
							notStringNuovaClasse = true;
						}
						io.nextLine();
					}	
					Classe nuova_classe = new Classe();
					nuova_classe.setNome_classe(nome_classe);
				break;
				case 3:
					int risposta2 = 0;
					//modifica classe (modifica di studenti nella classe o docenti)
					int pos = stampaNomiClasse(lista_classi);
					//in caso di selezione sbagliata decrementare pos di 1
					Classe classe_selezionata = lista_classi.get(pos);
					do{
						System.out.println("Scegliere l'operazione da effettuare sulla classe: "+classe_selezionata.getNome_classe());
						System.out.println("1 - Stampa lista studenti");
						System.out.println("2 - Aggiungi Studente");
						System.out.println("3 - Rimuovi Studente");
						System.out.println("4 - Informazione Docenti");
						System.out.println("9 - Esci");
						boolean notIntSelezioneSceltaClasse = true;
						while(notIntSelezioneSceltaClasse){
							System.out.println("Inserisci numero operazione da effettuare: ");
							try{
								risposta2 = io.nextInt();
								notInt = false;
							} catch(InputMismatchException exp){
								notInt = true;
							}
							io.nextLine();
						}
						switch(risposta2){
							case 1:
								classe_selezionata.stampaClasse();
							break;
							case 2:
								Persona nuovo_studente = new Studente();
								String nome_studente = "";
								boolean notStringNomeStudente = true;
								while(notStringNomeStudente){
									System.out.println("Inserisci Nome Studente: ");
									try{
										nome_studente = io.next();
										notStringNomeStudente = false;
									} catch(InputMismatchException exp){
										notStringNomeStudente = true;
									}
									io.nextLine();
								}	
								nuovo_studente.setNome(nome_studente);
								//inserimento cognome
								
								//inserimento codFiscale
								
								//inserimento dataNascita
								
								//set matricola
								
								//
							break;
							case 3:
								//stampa lista studenti
								
								//seleziona studente
								
								//rimuovi studente
							break;
							case 4: 
								//menu per docenti
								
								//stampa docente
								
								//inserisci docente
								
								//rimuovi docente
								
								//esci
								
							break;
							case 9:
								risposta2 = 9;
							break;
							default:
								System.out.println("Scelta non valida!");
							break;
						}
					} while(risposta2 != 9);
				break;
				case 4:
					//informazioni classe (Appello, ricerca Studente etc.)
				break;
				case 9:
					risposta = 9;
				break;
				default:
					System.out.println("Selezione non valida! Riprovare.");
				break;
			}
		} while(risposta != 9);
		//io.close();
		System.out.println("La ringraziamo per aver usato MyClass");
	}
	
	public static int stampaNomiClasse(ArrayList<Classe> lista_classi){
		int i = 0;
		System.out.println("Seleziona Classe da modificare");
		for(Classe classe : lista_classi){
			i++;
			System.out.println(i+" - "+classe.getNome_classe());
		}
		int risposta = 0;
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		boolean notInt = true;
		while(notInt){
			System.out.println("Inserisci numero associato alla classe da modificare: ");
			try{
				risposta = io.nextInt();
				notInt = false;
			} catch(InputMismatchException exp){
				notInt = true;
			}
			io.nextLine();
		}		
		return risposta;
	}
}
