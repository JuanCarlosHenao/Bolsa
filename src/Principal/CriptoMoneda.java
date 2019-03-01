package Principal;

public class CriptoMoneda extends Inversion {

	private Variable[] variables;
	private String idCripto;
	
	public CriptoMoneda(String codigo, String tipo, String idCripto) {
		super(codigo, tipo);
		this.idCripto = idCripto;
	}

	// ---------- GETTERS & SETTERS ---------- //
	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}

	public String getIdCripto() {
		return idCripto;
	}

	public void setIdCripto(String idCripto) {
		this.idCripto = idCripto;
	}
	
	
}
