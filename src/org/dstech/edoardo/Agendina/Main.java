package org.dstech.edoardo.Agendina;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.dstech.vangelini.Agenda.LetturaSalvataggioFile;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//agenda start
		System.out.println("Caricamento Agenda in corso...");
		LetturaSalvataggioFile file = new LetturaSalvataggioFile();
		Agenda agenda = null;
		try{
//			agenda = file.leggiFile("agendina.jjj");
			System.out.println("Agenda caricata.");
		} catch (Exception e){
			file.creaFile("agendina.jjj");
			System.out.println("Nessuna agenda trovata, è stato creato un nuovo file agendina.jjj");
			agenda = new Agenda();
		}
		
		
		System.out.println("-- Benveuto in MyAgend --");
		//scelte dell'utente
		Scanner io = new Scanner(System.in);
		int risposta = 0;
		do{
			System.out.println("Scegliere l'operazione da effettuare:");
			System.out.println("1 - Mostra Lista Contatti");
			System.out.println("2 - Aggiungi Contatto");
			System.out.println("3 - Rimuovi Contatto");
			System.out.println("4 - Modifica Contatto");
			System.out.println("5 - Ricerca Numero Telefonico");
			System.out.println("6 - Ricerca Contatto");
			System.out.println("7 - Mostra Lista Ordinata Per Cognome");
			System.out.println("8 - Mostra Lista Ordinata Per Nome");
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
					agenda.stampaListaPersone();
				break;
				case 2:
					Persona persona = new Persona();
					
					//Nome
					boolean notStringNome = true;
					String nome = "Non Impostato";
					while(notStringNome){
						System.out.println("Inserisci Nome: ");
						try{
							nome = io.next();
							notStringNome = false;
						} catch(InputMismatchException exp){
							notStringNome = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					persona.setNome(nome);
					//
					
					//Cognome
					boolean notStringCognome = true;
					String cognome = "Non Impostato";
					while(notStringCognome){
						System.out.println("Inserisci Cognome: ");
						try{
							cognome = io.next();
							notStringCognome = false;
						} catch(InputMismatchException exp){
							notStringCognome = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					persona.setCognome(cognome);
					//
					
					//eta
					boolean notIntEta = true;
					int eta = 0;
					while(notIntEta){
						System.out.println("Inserisci Eta: ");
						try{
							eta = io.nextInt();
							notIntEta = false;
						} catch(InputMismatchException exp){
							notIntEta = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					persona.setEta(eta);
					//
					
					//Email
					boolean notStringEmail = true;
					String email = "Non Impostato";
					while(notStringEmail){
						System.out.println("Inserisci Email: ");
						try{
							email = io.next();
							if(Agenda.controlloEmail(email)){
								notStringEmail = false;
							} else {
								System.out.println("Email non valida, Riprova");
							}
						} catch(InputMismatchException exp){
							notStringEmail = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					persona.setEmail(email);
					//
					
					//Telefono
					boolean notStringTelefono = true;
					String tel = "Non Impostato";
					while(notStringTelefono){
						System.out.println("Inserisci Telefono: ");
						try{
							tel = io.next();
							if(Agenda.controlloTel(tel)){
								notStringTelefono = false;
							} else {
								System.out.println("Telefono non valido, Riprova");
							}
						} catch(InputMismatchException exp){
							notStringTelefono = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					persona.setNumero_telefono(tel);
					//
					
					//Data Aggiunta alla rubrica
					Date data = new Date();
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			        String new_data = formatter.format(data);
					persona.setData(new_data);
					//
					agenda.aggiungiPersona(persona);
				break;
				case 3:
					//rimuovi
					Persona persona_selezionata = agenda.personaRicercata();
					agenda.rimuoviPersona(persona_selezionata);
				break;
				case 4:
					//modifica
					Persona persona_selezionata_per_modifica = agenda.personaRicercata();
					int risposta_nuova_modifica = 0;
					do{
						int risposta_nuova = 0;
						System.out.println("Cosa vuoi modificare del contatto con nome: "+persona_selezionata_per_modifica.getNome()+" e cognome: "+persona_selezionata_per_modifica.getCognome()+"?");
						System.out.println("1 - Nome");
						System.out.println("2 - Cognome");
						System.out.println("3 - Eta");
						System.out.println("4 - Email");
						System.out.println("5 - Telefono");
						System.out.println("6 - Esci dalle modifiche del contatto");
						System.out.println("7 - Visualizza informazioni contatto");
						boolean notIntRisposta = true;
						while(notIntRisposta){
							System.out.println("Inserisci numero operazione da effettuare: ");
							try{
								risposta_nuova = io.nextInt();
								notIntRisposta = false;
							} catch(Exception exp){
								notIntRisposta = true;
							}
							io.nextLine();
						}		
						switch(risposta_nuova){
							case 1:
								boolean notStringNomeDaModificare = true;
								String nomeDaModificare = persona_selezionata_per_modifica.getNome();
								while(notStringNomeDaModificare){
									System.out.println("Inserisci Nuovo Nome: ");
									try{
										nomeDaModificare = io.next();
										notStringNomeDaModificare = false;
									} catch(InputMismatchException exp){
										notStringNomeDaModificare = true;
										System.out.println("Non valido, Riprova");
									}
									io.nextLine();
								}
								persona_selezionata_per_modifica.setNome(nomeDaModificare);
							break;
							case 2:
								boolean notStringCognomeDaModificare = true;
								String cognomeDaModificare = persona_selezionata_per_modifica.getCognome();
								while(notStringCognomeDaModificare){
									System.out.println("Inserisci Nuovo Cognome: ");
									try{
										cognomeDaModificare = io.next();
										notStringCognomeDaModificare = false;
									} catch(InputMismatchException exp){
										notStringCognomeDaModificare = true;
										System.out.println("Non valido, Riprova");
									}
									io.nextLine();
								}
								persona_selezionata_per_modifica.setCognome(cognomeDaModificare);
							break;
							case 3:
								boolean notIntEtaDaModificare = true;
								int etaDaModificare = persona_selezionata_per_modifica.getEta();
								while(notIntEtaDaModificare){
									System.out.println("Inserisci Nuova Eta: ");
									try{
										etaDaModificare = io.nextInt();
										notIntEtaDaModificare = false;
									} catch(InputMismatchException exp){
										notIntEtaDaModificare = true;
										System.out.println("Non valido, Riprova");
									}
									io.nextLine();
								}
								persona_selezionata_per_modifica.setEta(etaDaModificare);
							break;
							case 4:
								//Email
								boolean notStringEmailDaModificare = true;
								String emailDaModificare = persona_selezionata_per_modifica.getEmail();
								while(notStringEmailDaModificare){
									System.out.println("Inserisci Nuova Email: ");
									try{
										emailDaModificare = io.next();
										if(Agenda.controlloEmail(emailDaModificare)){
											notStringEmailDaModificare = false;
										} else {
											System.out.println("Email non valida, Riprova");
										}
									} catch(InputMismatchException exp){
										notStringEmailDaModificare = true;
										System.out.println("Non valido, Riprova");
									}
									io.nextLine();
								}
								persona_selezionata_per_modifica.setEmail(emailDaModificare);
							break;
							case 5:
								boolean notStringTelefonoDaModificare = true;
								String telDaModificare = persona_selezionata_per_modifica.getNumero_telefono();
								while(notStringTelefonoDaModificare){
									System.out.println("Inserisci Nuovo Telefono: ");
									try{
										tel = io.next();
										if(Agenda.controlloTel(tel)){
											notStringTelefonoDaModificare = false;
										} else {
											System.out.println("Telefono non valido, Riprova");
										}
									} catch(InputMismatchException exp){
										notStringTelefonoDaModificare = true;
										System.out.println("Non valido, Riprova");
										io.nextLine();
									}
									
								}
								persona_selezionata_per_modifica.setNumero_telefono(telDaModificare);
							break;
							case 6:
								risposta_nuova_modifica = 6;
							break;
							case 7:
								System.out.println(persona_selezionata_per_modifica);
							break;
							default:
								System.out.println("Selezione non valida! Riprovare.");
							break;
						}
					} while(risposta_nuova_modifica != 6);
					
					//persona_selezionata_per_modifica.modificaPersona(nuovo_nome, nuovo_cognome, nuova_eta, nuovo_numero_telefono, nuova_email, nuova_data);
				break;
				case 5:
					//ricerca numero telefonico
					boolean notStringTelefonoRicercato = true;
					String telefono_ricercato = "Non Impostato";
					while(notStringTelefonoRicercato){
						System.out.println("Inserisci Telefono: ");
						try{
							tel = io.next();
							if(Agenda.controlloTel(tel)){
								notStringTelefonoRicercato = false;
							} else {
								System.out.println("Telefono non valido, Riprova");
							}
						} catch(InputMismatchException exp){
							notStringTelefonoRicercato = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					System.out.println(agenda.ricercaPerNumeroTelefonico(telefono_ricercato));
					//
				break;
				case 6:
					//ricerca contatto
					boolean notStringContattoRicercato = true;
					String contatto_ricercato = "Non Impostato";
					while(notStringContattoRicercato){
						System.out.println("Inserisci Nome da trovare: ");
						try{
							contatto_ricercato = io.next();
							notStringTelefonoRicercato = false;
						} catch(InputMismatchException exp){
							notStringContattoRicercato = true;
							System.out.println("Non valido, Riprova");
						}
						io.nextLine();
					}
					ArrayList<Persona> lista_ricercata = new ArrayList<Persona>();
					lista_ricercata = agenda.ricercaPerOrdineAlfabetico(contatto_ricercato);
					if(lista_ricercata.size() > 0){
						Agenda.stampaLista(lista_ricercata);
					} else {
						System.out.println("Nessun contatto trovato!");
					}
				break;
				case 7:
					agenda.stampaInOrdineAlfabeticoPerCognome();
				break;
				case 8:
					agenda.stampaInOrdineAlfabeticoPerNome();
				break;
				case 9:
					risposta = 9;
				break;
				default:
					System.out.println("Selezione non valida! Riprovare.");
				break;
			}
		} while(risposta != 9);
		io.close();
		try{
//			file.salvaFile("agendina.jjj", agenda);
		} catch (Exception e){
			file.creaFile("agendina.jjj");
//			file.salvaFile("agendina.jjj", agenda);
		}
		System.out.println("Agenda Salvata.");
		System.out.println("La ringraziamo per aver usato MyAgend");
	}
}