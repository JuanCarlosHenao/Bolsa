package principal;

public abstract class Inversion {
	protected String codigo;
	protected String tipo;
	private Proveedor proveedores;
	private Usuario[] usuarios;
	private double precioBase;
	
	public Inversion(String codigo, String tipo) {
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
	public Proveedor getProveedores() {
		return proveedores;
	}
	public void setProveedores(Proveedor proveedores) {
		this.proveedores = proveedores;
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	// ----------- METODOS DE LA CLASE ---------- // 
	
		// ----- METODO QUE CALCULA EL VALOR DE LA INVERSION CONSIDERANDO LAS VARIABLES DE CAMBIO 
	public double valorInversion() {
		double total=0;
		return total;
	}
	
	
}
