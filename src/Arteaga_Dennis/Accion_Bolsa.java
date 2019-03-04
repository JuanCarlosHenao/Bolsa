package Arteaga_Dennis;

public class Accion_Bolsa extends Inversion {
private Variable[] variables;
private String idAcc;

// LOS GETTER Y SETTER DE ESTA CLASE 
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
 * @return the idAcc
 */
public String getIdAcc() {
	return idAcc;
}
/**
 * @param idAcc the idAcc to set
 */
public void setIdAcc(String idAcc) {
	this.idAcc = idAcc;
}



//CONSTRUCTOR CON LAS VARIABLES DE ESTA CLASE MAS LAS DE LA SUPERIOR
public Accion_Bolsa(String codigo, String tipo, Origen_inv[] origenes, Usuario[] usuarios, Variable[] variables,
		String idAcc) {
	super(codigo, tipo, origenes, usuarios);
	this.variables = variables;
	this.idAcc = idAcc;
}

// METODOS SOBRESCRITOS DE LA CLASE PADRE
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
