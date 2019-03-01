package Principal;

public class Bono extends Inversion {

	private String idBono;
	private Variable[] variables;
	
	public Bono(String codigo, String tipo, String idBono) {
		super(codigo, tipo);
		this.idBono = idBono;
	}

	// ---------- GETTERS & SETTERS ---------- //
	public String getIdBono() {
		return idBono;
	}

	public void setIdBono(String idBono) {
		this.idBono = idBono;
	}

	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
	
	
}
