package org.dstech.vangelini.Agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LetturaSalvataggioFile {

	public void salvaFile(String nomeFile, Agenda agenda) throws IOException {
		File file = new File(nomeFile);
		FileWriter fileWriter = new FileWriter(file);
		ArrayList<Persona> liste = agenda.getListaPersone();
		for(Persona persona : liste){
			fileWriter.append(persona.toStringFile()+"\r\n");
		}
		fileWriter.flush();
		fileWriter.close();
	}

	public void creaFile(String pippo) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}	
	
	public Agenda leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		Agenda agenda = new Agenda();
		
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
		return agenda;
	}

}
