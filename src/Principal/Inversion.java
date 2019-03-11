package Principal;

import java.io.Serializable;

public abstract class Inversion implements Serializable {
	protected String codigo;
	protected String idProv;
	protected String idUsu = null;
	protected String tipo;
	private double precioBase;
	private Proveedor proveedor;
	private Usuario usuario;
	
	
	public Inversion(String codigo, String idProv, String tipo, double precioBase) {
		this.codigo = codigo;
		this.idProv = idProv;
		this.tipo = tipo;
		this.precioBase = precioBase;
	}
	// ---------- GETTERS & SETTERS ---------- //
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdProv() {
		return idProv;
	}
	public void setIdProv(String idProv) {
		this.idProv = idProv;
	}
	public String getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(String idUsu) {
		this.idUsu = idUsu;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Proveedor getProveedores() {
		return proveedor;
	}
	public void setProveedores(Proveedor proveedores) {
		this.proveedor = proveedores;
	}
	public Usuario getUsuarios() {
		return usuario;
	}
	public void setUsuarios(Usuario usuarios) {
		this.usuario = usuarios;
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
