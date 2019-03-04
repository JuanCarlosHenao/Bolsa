package Arteaga_Dennis;

public class Variable {
private double $dolar;
private double $petroleo;
private boolean pbPoliticos;
private double inflacion;

//GETTERS Y SETTER 
/**
 * @return the $dolar
 */
public double get$dolar() {
	return $dolar;
}
/**
 * @param $dolar the $dolar to set
 */
public void set$dolar(double $dolar) {
	this.$dolar = $dolar;
}
/**
 * @return the $petroleo
 */
public double get$petroleo() {
	return $petroleo;
}
/**
 * @param $petroleo the $petroleo to set
 */
public void set$petroleo(double $petroleo) {
	this.$petroleo = $petroleo;
}
/**
 * @return the pbPoliticos
 */
public boolean isPbPoliticos() {
	return pbPoliticos;
}
/**
 * @param pbPoliticos the pbPoliticos to set
 */
public void setPbPoliticos(boolean pbPoliticos) {
	this.pbPoliticos = pbPoliticos;
}
/**
 * @return the inflacion
 */
public double getInflacion() {
	return inflacion;
}
/**
 * @param inflacion the inflacion to set
 */
public void setInflacion(double inflacion) {
	this.inflacion = inflacion;
}
/**
 * @param $dolar
 * @param $petroleo
 * @param pbPoliticos
 * @param inflacion
 */

// CONSTRUCTOR DE LA CLASE 
public Variable(double $dolar, double $petroleo, boolean pbPoliticos, double inflacion) {
	super();
	this.$dolar = $dolar;
	this.$petroleo = $petroleo;
	this.pbPoliticos = pbPoliticos;
	this.inflacion = inflacion;
}

// ESTA CLASE NO PRESENTA METODOS

}
