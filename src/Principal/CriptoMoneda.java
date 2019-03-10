package Principal;

public class CriptoMoneda extends Inversion {
	// DEPENDE DEL DOLAR 

	private Variable[] variables ;
	
	public CriptoMoneda(String codigo, String idProv, String tipo, double precioBase) {
		super(codigo, idProv, tipo, precioBase);
	}

	// ---------- GETTERS & SETTERS ---------- //
	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
	
}