package principal;

public class Bono extends Inversion {

	private String idBono;
	
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

	
	
}
