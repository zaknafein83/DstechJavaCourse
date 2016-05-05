/**
 * 
 */
package org.dstech.alejandro.scuola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Alejandro
 *
 */
public class Registro {
	
	private Map<Date,List<String>> registro = new HashMap<Date, List<String>>();

	public Map<Date, List<String>> getRegistro() {
		return registro;
	}

	public void setRegistro(Map<Date, List<String>> registro) {
		this.registro = registro;
	}
	
	public List<String> getPresenze(Date data){
		return registro.get(data);
	}
	
	public void appello(Classe c,Date data){
		List<String> presenze = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		try{
			for(Studente s:c.getListaStudenti()){
				System.out.println(s.getNome()+" "+s.getCognome()+" "+"è presente? s/n");
				char risposta = sc.next().charAt(0);
				switch(risposta){
				case 's':
					presenze.add(s.getNome()+" "+s.getCognome()+" presente");
					break;
				case 'n':
					presenze.add(s.getNome()+" "+s.getCognome()+" assente");
					break;
				}
				
			}
			registro.put(data, presenze);
		}catch(Exception e){
			e.getMessage();
		}
			
	}
	
	public void save() throws IOException {
		try{
			FileOutputStream fout = new FileOutputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\scuola\\registro.jjj");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(this);
			oos.close();
			System.out.println("Done");
	
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public Classe read() {

		try {

			FileInputStream fin = new FileInputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\scuola\\registro.jjj");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Classe classe = (Classe) ois.readObject();
			ois.close();

			return classe;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}


