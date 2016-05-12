/**
 * 
 */
package org.dstech.vangelini.diverlotto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Valerio
 *
 */
@SuppressWarnings("serial")
public class Estrazione implements Serializable{
	private Date data_estrazione;
	private List<Integer> numeri_estratti = new ArrayList<Integer>();
	
	public Estrazione(Date data_estrazione){
		this.data_estrazione = data_estrazione;
		while(numeri_estratti.size() != 5){
			int numero = 0;
			do {
				numero = (int) ((Math.random()*90)+1);
			} while(numeri_estratti.contains(numero));
			numeri_estratti.add(numero);
		}
	}

	public Date getData_estrazione() {
		return data_estrazione;
	}

	public void setData_estrazione(Date data_estrazione) {
		this.data_estrazione = data_estrazione;
	}

	public List<Integer> getNumeri_estratti() {
		return numeri_estratti;
	}

	public void setNumeri_estratti(List<Integer> numeri_estratti) {
		this.numeri_estratti = numeri_estratti;
	}

	@Override
	public String toString() {
		return (numeri_estratti.get(0)+" "+numeri_estratti.get(1)+" "+numeri_estratti.get(2)+" "+numeri_estratti.get(3)+" "+numeri_estratti.get(4));
	}
	
}
