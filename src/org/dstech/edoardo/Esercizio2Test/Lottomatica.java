/**
 * 
 */
package org.dstech.edoardo.Esercizio2Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author edoardopierguidi
 *
 */
public class Lottomatica {
	
	private Date dataEstrazione;
	
	private List <Integer> numeriEstratti = new ArrayList <Integer>();
	
	public Lottomatica(Date dataEstrazione) {
		
		this.dataEstrazione = dataEstrazione; 
		
		while(numeriEstratti.size()== 5){
			
			int numero = 0;
			do{
				numero = (int) ((Math.random()*90)+1);				
			}while(numeriEstratti.contains(numero));
			numeriEstratti.add(numero);
			
		}
	}

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	@Override
	public String toString() {
		return "Estrazione del "+dataEstrazione+"/n"+numeriEstratti.get(0)+" "+numeriEstratti.get(1)+" "+numeriEstratti.get(2)+" "+numeriEstratti.get(3)+" "+numeriEstratti.get(4)+" ";
	}

	public List<Integer> getNumeriEstratti() {
		return numeriEstratti;
	}

	public void setNumeriEstratti(List<Integer> numeriEstratti) {
		this.numeriEstratti = numeriEstratti;
	}
	
	
	
	
	
	
			}