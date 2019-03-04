package Arteaga_Dennis;

public class CriptoMoneda extends Inversion{
private Variable[] variables;
private String idCript;

// GETTERS Y SETTERS 
/**
 * @return the variables
 */
public Variable[] getVariables() {
	return variables;
}
/**
 * @param variables the variables to set
 */
public void setVariables(Variable[] variables) {
	this.variables = variables;
}
/**
 * @return the idCript
 */
public String getIdCript() {
	return idCript;
}
/**
 * @param idCript the idCript to set
 */
public void setIdCript(String idCript) {
	this.idCript = idCript;
}




// CONSTRUCTOR CON LAS VARIABLES DE ESTA CLASE MAS LAS DE LA SUPERIOR
public CriptoMoneda(String codigo, String tipo, Origen_inv[] origenes, Usuario[] usuarios, Variable[] variables,
		String idCript) {
	super(codigo, tipo, origenes, usuarios);
	this.variables = variables;
	this.idCript = idCript;
}

//METODOS SOBRE ESCTRITOS DE LA CLASE PADRE 
@Override
public double calcularPrecio() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public double calcularVariacion() {
	// TODO Auto-generated method stub
	return 0;
}



}
