package principal;

public class CriptoMoneda extends Inversion {

	private String idCripto;
	
	public CriptoMoneda(String codigo, String tipo, String idCripto) {
		super(codigo, tipo);
		this.idCripto = idCripto;
	}

	// ---------- GETTERS & SETTERS ---------- //
	public String getIdCripto() {
		return idCripto;
	}

	public void setIdCripto(String idCripto) {
		this.idCripto = idCripto;
	}
	
	
}
