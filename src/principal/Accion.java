package principal;

public class Accion extends Inversion {

	private Variable[] variables;
	private String idAcc;
	
	public Accion(String codigo, String tipo, String idAcc) {
		super(codigo, tipo);
		this.idAcc = idAcc;
	}
	
	//------------ GETTERS & SETTERS ---------- //
	
	public Variable[] getVariables() {
		return variables;
	}
	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	
	
	
}
