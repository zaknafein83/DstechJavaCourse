/**
 * 
 */
package org.dstech.alejandro.esercizi;

import java.util.Scanner;

/**
 * @author Alejandro
 *
 */
public class EserciziTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contaPositivi();

	}
	
	
	public static void contaPositivi(){

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci sequenza");
		String s = sc.nextLine();
		String b=s.replace("X", "");
		String[] str=b.split(" ");
		
		System.out.println("I numeri positivi sono:");
		for(String i:str){
			
			if(Integer.parseInt(i)>0)
				System.out.println(i);
		}
		
//	public static void lottomatica(){
//		
//	}
		
		
	}

}
