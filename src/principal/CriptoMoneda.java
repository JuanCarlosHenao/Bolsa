package principal;

public class CriptoMoneda extends Inversion {

	private String idCripto;
	
	public CriptoMoneda(String codigo, String idProv, String tipo, double precioBase, String idCripto) {
		super(codigo, idProv, tipo, precioBase);
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
