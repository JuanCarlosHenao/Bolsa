package Principal;

public class Proveedor {

	private String nombre;
	private String id;
	private String tipo;
	private double precioBase;
	
	public Proveedor(String nombre, String id, String tipo, double precioBase) {
		this.nombre = nombre;
		this.id = id;
		this.tipo = tipo;
		this.precioBase = precioBase;
	}
	
	// ----------- GETTERS & SETTERS ----------- //
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
