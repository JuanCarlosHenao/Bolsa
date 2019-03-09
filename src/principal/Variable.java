package principal;

public class Variable {

	private double $dolar;
	private double $petroleo;
	private double inflacion;
	
	public Variable(double $dolar, double $petroleo, double inflacion) {
		this.$dolar = $dolar;
		this.$petroleo = $petroleo;
		this.inflacion = inflacion;
	}
	
	// ----------- GETTERS & SETTERS ---------- //
	public double get$dolar() {
		return $dolar;
	}
	public void set$dolar(double $dolar) {
		this.$dolar = $dolar;
	}
	public double get$petroleo() {
		return $petroleo;
	}
	public void set$petroleo(double $petroleo) {
		this.$petroleo = $petroleo;
	}
	public double getInflacion() {
		return inflacion;
	}
	public void setInflacion(double inflacion) {
		this.inflacion = inflacion;
	}
	
	
	
	
}
