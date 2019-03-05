package principal;

public class Variable {

	private double $dolar;
	private double $petroleo;
	private double inflacion;
	private boolean pbPoliticos;
	
	public Variable(double $dolar, double $petroleo, double inflacion, boolean pbPoliticos) {
		this.$dolar = $dolar;
		this.$petroleo = $petroleo;
		this.inflacion = inflacion;
		this.pbPoliticos = pbPoliticos;
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
	public boolean isPbPoliticos() {
		return pbPoliticos;
	}
	public void setPbPoliticos(boolean pbPoliticos) {
		this.pbPoliticos = pbPoliticos;
	}
	
	
	
}
