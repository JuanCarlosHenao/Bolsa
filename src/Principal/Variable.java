package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

public class Variable implements Serializable {

	private double $dolar = 3.165;
	private double $petroleo = 208.116;
	private double inflacion = 3;
	
//	public Variable(double $dolar, double $petroleo, double inflacion) {
//		this.$dolar = $dolar;
//		this.$petroleo = $petroleo;
//		this.inflacion = inflacion;
//	}
	
	// ----------- GETTERS & SETTERS ---------- //
	public double get$dolar() {
		return $dolar;
	}
	public void set$dolar() {
		Random r = new Random();
		double result =  r.nextDouble()*2 - 1; 
		$dolar += result;
	}
	
	public void recibeDolar(double nuevoDolar) {
		$dolar=nuevoDolar;
		
	}
	
	public double get$petroleo() {
		return $petroleo;
	}
	public void set$petroleo() {
		Random r = new Random();
		double result =  r.nextDouble()*10 - 1; 
		$petroleo += result;
	}
	
	public void recibePetroleo(double nuevoPetroleo) {
		$petroleo=nuevoPetroleo;
		
	}
	public double getInflacion() {
		return inflacion;
	}
	public void setInflacion() {
		Random r = new Random();
		double result =  r.nextDouble()*8 ; 
		inflacion += result;
	}
	public void recibeInflacion(double nuevaInflacion) {
		inflacion=nuevaInflacion;
	}
	
	
	
	public void escribirVariablesFichero () throws InterruptedException {
			int i=4;
			int s=13;
		// LEER FICHERO ------------------------------------------
        // se crean estas variables afuera para que despues se puedan cerrar con el finally 
			
			String inicial=Integer.toString(i);
			String siguiente=Integer.toString(s);
			
		File archivo = new File ("C:\\Users\\Personal\\eclipse-workspace\\Bolsa\\src\\Principal\\Ficheros\\PruebaVariable.txt");
	      FileWriter fw = null;
	      BufferedWriter bw = null;

	      try {
	    	  Thread.sleep(3000);
	         fw = new FileWriter (archivo,true);
	         bw = new BufferedWriter(fw);
	         int contador=0;
	     
	         while(contador<5) {
	        		bw.write(inicial);
		         	System.out.println(inicial);
		         	bw.newLine();
		         	bw.write(siguiente);
		         	System.out.println(siguiente);
		         	bw.newLine();
		         	contador++;
	         }
	      }
	      catch (IOException e) {
	            System.out.println("no se puede abrir el fichero ");
	      } finally {
	    	  try {
	          // Nuevamente aprovechamos el finally para 
	          // asegurarnos que se cierra el fichero.
	        	bw.close();
	            fw.close();
	          } catch (IOException e2) {
	             System.out.println("no se pudo cerrar bien el fichero  ");
	          }
	      }
	}
	// ------------ METODOS ----------- //
	
	
	
}
