/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author franksisca
 *
 */
public class GestioneArchivioClasse {

	public static Registro recuperaRegistro(String filePath) throws ClassNotFoundException, IOException {
		Registro registro = null;
		File fileSource = new File(filePath);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		try {
			registro = (Registro) objectInputStream.readObject();

		} catch (EOFException exp) {
			inputStream.close();
			objectInputStream.close();
			return registro;
		}
		inputStream.close();
		objectInputStream.close();
		return registro;
	}

	public static boolean salvaRegistro(String filePath, Registro registro) throws IOException {
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(registro);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
		return true;

	}

	/**
	 * @param string
	 * @param registro
	 * @throws IOException 
	 */
	public static boolean salvaClasse(String filePath, Classe classe) throws IOException {
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(classe);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
		return true;

	}
	
	public static Classe recuperaClasse(String filePath) throws ClassNotFoundException, IOException {
		Classe classe = null;
		File fileSource = new File(filePath);
		if(!fileSource.exists())
			return null;
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		try {
			classe = (Classe) objectInputStream.readObject();

		} catch (EOFException exp) {
			inputStream.close();
			objectInputStream.close();
			return classe;
		}
		inputStream.close();
		objectInputStream.close();
		return classe;
	}

}
