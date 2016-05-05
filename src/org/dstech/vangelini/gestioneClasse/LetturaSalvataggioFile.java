package org.dstech.vangelini.gestioneClasse;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.dstech.fsisca.serializzaione.ItemSerializable;
import org.dstech.vangelini.Agenda.Agenda;
import org.dstech.vangelini.Agenda.Persona;

@SuppressWarnings("unused")
public class LetturaSalvataggioFile {

	public void salvaFileClasse(String filePath, Classe classe) throws IOException {
		ArrayList<Studente> liste = classe.getLista_studenti();
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		for (Studente persona : liste) {
			objectOutputStream.writeObject(persona);
		}
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
	}

	public void creaFileClasse(String pippo) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}	
	
	public ArrayList<Classe> leggiFileClasse(String fileUrl) throws FileNotFoundException, IOException, ClassNotFoundException {
		Classe classe = new Classe();
		ArrayList<Classe> listaOggetti = new ArrayList<Classe>();
		File fileSource = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Classe readObject;
		try {
			while ((readObject = (Classe) objectInputStream.readObject()) != null) {
				listaOggetti.add(readObject);
			}
		} catch (EOFException exp) {
			
		}
		inputStream.close();
		objectInputStream.close();
		return listaOggetti;
	}
	
	public void salvaFileRegistro(String filePath, Registro registro) throws IOException {
		HashMap<Date, PresenzeAssenze> liste = registro.getMappaRegistro();
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		for (Date lista_date : liste.keySet()) {
			objectOutputStream.writeObject(lista_date);
		}
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
	}

	public void creaFileRegistro(String pippo) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}	
	
	public Registro leggiFileRegistro(String fileUrl) throws FileNotFoundException, IOException, ClassNotFoundException {
		Registro registro = new Registro();
		HashMap<Date, PresenzeAssenze> listaOggetti = new HashMap<Date, PresenzeAssenze>();
		File fileSource = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Date readObject;
		//Bisogna vedere come leggere la mappa.
		try {
			while ((readObject = (Date) objectInputStream.readObject()) != null) {
				listaOggetti.put(readObject, null );
			}
		} catch (EOFException exp) {
			registro.setMappaRegistro(listaOggetti);
		}
		inputStream.close();
		objectInputStream.close();
		return registro;
	}

}
