/**
 * 
 */
package org.dstech.edoardo.Esercizio2Test;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.dstech.vangelini.Agenda.Agenda;
import org.dstech.vangelini.Agenda.Persona;

/**
 * @author edoardopierguidi
 *
 */
public class LetturaSalvatagioFile {

	public void salvaFile(String filePath, ArrayList<Lottomatica>listaEstrazione) throws IOException {
		File file = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(listaEstrazione);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
	}
	public void creaFile(String pippo) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}	
	
	public Agenda leggiFile(String fileUrl) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*Agenda agenda = new Agenda();
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			//System.out.println(readLine);
			Persona persona = new Persona();
			String[] split = readLine.split(",");
			persona.setNome(split[0]);
			persona.setCognome(split[1]);
			int eta = Integer.parseInt(split[2]);
			persona.setEta(eta);
			if(!(Agenda.controlloTel(split[3]))){
				split[3] = "TelefonoErrato";
			} 
			persona.setNumero_telefono(split[3]);
			if(!(Agenda.controlloEmail(split[4]))){
				split[4] = "IndirizzoErrato";
			} 
			persona.setEmail(split[4]);
			@SuppressWarnings("deprecation")
			Date data = new Date(split[5]);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	String new_data = formatter.format(data);
        	persona.setData(new_data);
			agenda.aggiungiPersona(persona);
			readLine = buffereReader.readLine();
		}
		buffereReader.close();
		return agenda;*/
		Agenda agenda = new Agenda();
		ArrayList<Persona> listaOggetti = new ArrayList<Persona>();
		File fileSource = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Persona readObject;
		try {
			while ((readObject = (Persona) objectInputStream.readObject()) != null) {
				listaOggetti.add(readObject);
			}
		} catch (EOFException exp) {
			agenda.setListaPersone(listaOggetti);
		}
		inputStream.close();
		objectInputStream.close();
		return agenda;
	}
}
