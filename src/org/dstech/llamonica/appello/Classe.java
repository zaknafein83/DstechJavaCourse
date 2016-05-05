package org.dstech.llamonica.appello;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Classe {

	List<Studente> listaStudenti = new ArrayList<>();
	List<Docente> listaDocenti = new ArrayList<>();
	List<Persona> listaPresenze = new ArrayList<>();
	List<Persona> listassenze = new ArrayList<>();

	public void creaFile(String registro1) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(contenutoDaSalvare);
		FileWriter fileWriter = new FileWriter(registro1);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();

	}

	public void appello() {
		Classe classe = new Classe();
		Scanner scanner = new Scanner(System.in);

		System.out.println("rispondere con presente");
		for (Persona elemento : listaStudenti) {
			System.out.println("lo studente " + elemento.getCognome() + " è presente?");
			String risposta = scanner.next();

			if (risposta.equals("presente")) {
				classe.listaPresenze.add(elemento);
				System.out.println("presente");
			} else {
				classe.listassenze.add(elemento);
				System.out.println("assente");

			}
			scanner.nextLine();
		}
	}

	public void StampaListaPresenze() {
		Classe classe = new Classe();

		for (Persona elemento : classe.listaPresenze) {
			System.out.println(elemento);

		}

	}
}