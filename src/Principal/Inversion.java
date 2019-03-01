package Principal;

public abstract class Inversion {
	protected String codigo;
	protected String tipo;
	private Origen_Inv[] origenes;
	private Usuario[] usuarios;
	
	public Inversion(String codigo, String tipo) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
	}
	// ---------- GETTERS & SETTERS ---------- //
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Origen_Inv[] getOrigenes() {
		return origenes;
	}
	public void setOrigenes(Origen_Inv[] origenes) {
		this.origenes = origenes;
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
