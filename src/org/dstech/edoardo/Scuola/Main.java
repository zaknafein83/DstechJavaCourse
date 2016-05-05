package org.dstech.edoardo.Scuola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) throws FileNotFoundException, IOException{
				
	leggiFile("/Users/edoardopierguidi/git/DstechJavaCourse/src/org/dstech/edoardo/Scuola/Registro.txt");
		

		private static void leggiFile(String fileUrl) throws FileNotFoundException, IOException {
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