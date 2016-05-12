/**
 * 
 */
package org.dstech.llamonica.lottomatica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luca
 *
 */
public class Estrazione{

   private Date dataEstrazione;
   
	private List<Integer>numeriEstratti=new ArrayList();
	public Estrazione(Date dataEstrazione) {
		
		this.dataEstrazione=dataEstrazione;
		
		while(numeriEstratti.size()==5){
			int num=0;
	      
	       do{
	    	   num=((int) Math.random()*90)+1;
	           
	       }while(numeriEstratti.contains(num));
	       
		}
		}
	public Date getDataEstrazione() {
		return dataEstrazione;
	}
	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}
	public List<Integer> getNumeriEstratti() {
		return numeriEstratti;
	}
	public void setNumeriEstratti(List<Integer> numeriEstratti) {
		this.numeriEstratti = numeriEstratti;
	}
	@Override
	public String toString() {
		return "Estrazione del"+dataEstrazione+"/n"+numeriEstratti.get(0)+" "+numeriEstratti.get(1)+" "+ numeriEstratti.get(2)+"  "+numeriEstratti.get(3)+"  "+numeriEstratti.get(4);
	}
	

}
	
   
	
   

