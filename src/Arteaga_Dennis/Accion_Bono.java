package Arteaga_Dennis;

public class Accion_Bono extends Inversion{
	private Variable[] variables;
	private String idBono;
	
	
	// LOS GETTER Y SETTER DE ESTA CLASE 
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
	 * @return the idBono
	 */
	public String getIdBono() {
		return idBono;
	}
	/**
	 * @param idBono the idBono to set
	 */
	public void setIdBono(String idBono) {
		this.idBono = idBono;
	}
	/**
	 * 
	 */
	
	// CONSTRUCTOR CON LAS VARIABLES DE ESTA CLASE MAS LAS DE LA SUPERIOR
	public Accion_Bono(String codigo, String tipo, Origen_inv[] origenes, Usuario[] usuarios, Variable[] variables,
			String idBono) {
		super(codigo, tipo, origenes, usuarios);
		this.variables = variables;
		this.idBono = idBono;
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
