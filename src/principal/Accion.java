package principal;

public class Accion extends Inversion {
	// ES AFECTADA POR EL $DOLAR Y EL $PETROLEO.

	private String idAcc;
	private Variable[] variables;
	
	public Accion(String codigo,String idProv , String tipo, double precioBase, String idAcc) {
		super(codigo, idProv, tipo, precioBase);
		this.idAcc = idAcc;
	}
	
	//------------ GETTERS & SETTERS ---------- //
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}

	// ---------- METODOS ---------- //
	public void formulaCambio(double dolar , double petroleo) {
		double fomrmula=2*dolar;
		
	}
	
	
}
