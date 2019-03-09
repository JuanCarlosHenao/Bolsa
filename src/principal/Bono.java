package principal;

public class Bono extends Inversion {
	// DEPENDE DE LA INFLACION Y DEL DOLAR

	private Variable[] variables ;
	
	public Bono(String codigo, String idProv, String tipo, double precioBase) {
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
