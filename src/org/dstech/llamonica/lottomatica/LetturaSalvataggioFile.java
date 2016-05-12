/**
 * 
 */
package org.dstech.llamonica.lottomatica;

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

import org.dstech.vangelini.estrazioni.Estrazione;




/**
 * @author luca
 *
 */
public class LetturaSalvataggioFile {
	
	public void salvaFile(String filePath, ArrayList<Estrazione> lista_estrazione) throws IOException {
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(lista_estrazione);
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Estrazione> leggiFile(String fileUrl) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Estrazione> lista_estrazioni = new ArrayList<Estrazione>();
		File fileSource = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		ArrayList<Estrazione> readObject;
		try {
			if ((readObject = (ArrayList<Estrazione>) objectInputStream.readObject()) != null) {
				lista_estrazioni = readObject;
			}
		} catch (EOFException exp) {
			
		}
		inputStream.close();
		objectInputStream.close();
		return lista_estrazioni;
	}
}