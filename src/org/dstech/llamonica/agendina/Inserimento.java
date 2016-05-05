package org.dstech.llamonica.agendina;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Inserimento {
	public List<Persone>listaPersone=new ArrayList();

	public void numeroTelefono() {
Scanner scanner=new Scanner(System.in);
System.out.println("inserisci telefono");
String telefono=scanner.nextLine();
		for (Persone elemento :listaPersone) {

			if (telefono.equals(elemento.getTelefono())) {

				System.out.println(elemento.getNome() + "  " + elemento.getCognome() + "   " + elemento.getEta() + "   "
						+ elemento.getTelefono() + "   " + elemento.getEmail());
			}
		}

	}

	public void inserisciPersona() {

		Persone persone = creaPersona();

		listaPersone.add(persone);

	}

	public static Persone creaPersona() {
		Scanner scanner = new Scanner(System.in);
		Persone persone = new Persone();

		System.out.println("nome");
		String nome = scanner.nextLine();
		System.out.println("cognome");
		String cognome = scanner.nextLine();
		System.out.println("eta");
		String eta = scanner.nextLine();
		System.out.println("telefono");
		String telefono = scanner.nextLine();

		System.out.println("email");
		String email = scanner.nextLine();

		persone.setNome(nome);
		persone.setCognome(cognome);
		persone.setEta(eta);
		persone.setTelefono(telefono);
		persone.setEmail(email);
		return persone;
	}

	public void modificaPersona() {
		Scanner scanner = new Scanner(System.in);

		String inserimento = scanner.next();

		for (Persone elemento : listaPersone) {

			if (elemento.getCognome().equals(inserimento)) {
				System.out.println("Che campo vuoi modificare");
				System.out.println("1 - Nome");
				System.out.println("2 - Cognome");
				System.out.println("3 - Età");
				System.out.println("4 - telefono");
				System.out.println("5 - Mail");
				Scanner scanner2 = new Scanner(System.in);
				int numero = scanner2.nextInt();
				Scanner scanner3 = new Scanner(System.in);
				System.out.println("inserisci modifica");
				String modifica = scanner3.nextLine();
				switch (numero) {
				case 1:
					elemento.setNome(modifica);

					break;

				case 2:
					elemento.setCognome(modifica);
					break;
				case 3:
					elemento.setEta(modifica);
					break;
				case 4:
					elemento.setTelefono(modifica);
				case 5:
					elemento.setEmail(modifica);
					break;

				}

			}

		}

	}

	public void rimuoverePersone() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci cognome di chi vuoi eliminare");
		String inserimento = scanner.next();
		System.out.println(inserimento);
		Persone sss = null;
		for (Persone elemento : listaPersone) {
			if (inserimento.equals(elemento.getCognome())){
				System.out.println("Entra");
				sss = elemento;
			} else {
				System.out.println("Non Entra");
			}
		}
		listaPersone.remove(sss);
	}
public void stampareListaOrdineAlfabetico(){
	Scanner scanner=new Scanner(System.in);
	System.out.println("inserisci lettera");
	String inserimento = scanner.next();
	//if () {
	for(Persone elemento:listaPersone){
			
	}
	
	
			
}

}