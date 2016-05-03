package org.dstech.vangelini.Agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LetturaSalvataggioFile {

	public void salvaFile(String pippo) throws IOException {
		String contenutoDaSalvare = "";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}

	public void leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			System.out.println(readLine);
			readLine = buffereReader.readLine();
		}
		buffereReader.close();
	}

}
