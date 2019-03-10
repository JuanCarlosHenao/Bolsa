package principal;

import java.text.DecimalFormat;
import java.util.Random;

public class Variable {

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
	public double get$petroleo() {
		return $petroleo;
	}
	public void set$petroleo() {
		Random r = new Random();
		double result =  r.nextDouble()*10 - 1; 
		$petroleo += result;
	}
	public double getInflacion() {
		return inflacion;
	}
	public void setInflacion() {
		Random r = new Random();
		double result =  r.nextDouble()*8 ; 
		inflacion += result;
	}
	
	
	// ------------ METODOS ----------- //
	
	
	
}
