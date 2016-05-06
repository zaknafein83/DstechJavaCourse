/**
 * 
 */
package org.dstech.edoardo.Esercizio2Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dstech.fsisca.GestioneScuola.Classe;
import org.dstech.fsisca.GestioneScuola.GestioneArchivioClasse;
import org.dstech.fsisca.GestioneScuola.Registro;

/**
 * @author edoardopierguidi
 *
 */
public class Lottomatica {
	
public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
	
	public void numeriCasulai() {
		
		int a[] = new int [90];

		for ( int i = 1; i <= a.length; i++ )
			
		a[i-1]=i;
	
	int num;
	for ( int i=0; i < a.length; i++ ){ 
	num = ( int ) ( Math.random()* a.length );
	int hold;
	hold = a[i];
	a[i] = a[num];
	a[num] = hold;
	}
	
	}
	
	public static final String DD_MM_YYYY = "dd/mm/yyyy";

	
	public static String formatoDataEstrazione(Date data) {
		SimpleDateFormat dateFormat =  new SimpleDateFormat(DD_MM_YYYY);
		return dateFormat.format(data);
	}

	
	public static Date convertiDataInStringa(String data) throws ParseException {
		SimpleDateFormat dateFormat =  new SimpleDateFormat(DD_MM_YYYY);
		return dateFormat.parse(data);
	}
		
	public static boolean salvaEstrazione(int a[], String data) throws IOException {
		File fileSource = new File(                                                       );
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(                                                       );
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
		return true;

	}
}
