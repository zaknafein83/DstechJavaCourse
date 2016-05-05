package org.dstech.lulizi.registroClasse;

import java.util.List;

public class StudentiServices {

	
	public static void stampaListaStudenti(List<Studente> listaStudenti ){
		
		System.out.println("-------LISTA STUDENTI----------");
	
		for (Studente s: listaStudenti )
		{
			System.out.println(s);
		}
		
	}
}
