package principal;

public class CriptoMoneda extends Inversion {

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
