package principal;

public class Bono extends Inversion {

	private String idBono;
	
	public Bono(String codigo, String idProv, String tipo, double precioBase, String idBono) {
		super(codigo, idProv, tipo, precioBase);
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
