package principal;

public class Accion extends Inversion {

	private String idAcc;
	
	public Accion(String codigo, String tipo, String idAcc) {
		super(codigo, tipo);
		this.idAcc = idAcc;
	}
	
	//------------ GETTERS & SETTERS ---------- //
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	
	
	
}
