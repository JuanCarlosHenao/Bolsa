package Principal;

public class Accion extends Inversion {
	// ES AFECTADA POR EL $DOLAR Y EL $PETROLEO.

	private Variable[] variables;
	
	public Accion(String codigo,String idProv , String tipo, double precioBase) {
		super(codigo, idProv, tipo, precioBase);
	}
	
	//------------ GETTERS & SETTERS ---------- //
	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}

	// ---------- METODOS ---------- //
	
	
	
}
