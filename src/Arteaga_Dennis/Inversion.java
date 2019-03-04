package Arteaga_Dennis;

// CLASE ABSTRACTA DE LA QUE HEREDARAN
public abstract class Inversion {
	//VARIABLES EN COMUN QUE TENDRAN LAS CLASES HIJAS
protected  String codigo;
protected String tipo;
protected Origen_inv[] origenes;
protected Usuario[] usuarios;

//GETTERS Y SETTERS DE LA CLASE 
/**
 * @return the codigo
 */
public String getCodigo() {
	return codigo;
}
/**
 * @param codigo the codigo to set
 */
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
/**
 * @return the tipo
 */
public String getTipo() {
	return tipo;
}
/**
 * @param tipo the tipo to set
 */
public void setTipo(String tipo) {
	this.tipo = tipo;
}
/**
 * @return the origenes
 */
public Origen_inv[] getOrigenes() {
	return origenes;
}
/**
 * @param origenes the origenes to set
 */
public void setOrigenes(Origen_inv[] origenes) {
	this.origenes = origenes;
}
/**
 * @return the usuarios
 */
public Usuario[] getUsuarios() {
	return usuarios;
}
/**
 * @param usuarios the usuarios to set
 */
public void setUsuarios(Usuario[] usuarios) {
	this.usuarios = usuarios;
}

// CONSTRUCTOR 
/**
 * @param codigo
 * @param tipo
 * @param origenes
 * @param usuarios
 */
public Inversion(String codigo, String tipo, Origen_inv[] origenes, Usuario[] usuarios) {
	super();
	this.codigo = codigo;
	this.tipo = tipo;
	this.origenes = origenes;
	this.usuarios = usuarios;
}
//LOS METODOS QUE SERAN REALIZADOS POR LAS CLASES HIJAS
public abstract double calcularPrecio();
public abstract double calcularVariacion();
}
