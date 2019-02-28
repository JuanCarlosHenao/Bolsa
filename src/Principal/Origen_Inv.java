package Principal;

public class Origen_Inv {

	private String nombre;
	private String tipo;
	private double precioBase;
	
	public Origen_Inv(String nombre, String tipo, double precioBase) {
		super();
		this.nombre = nombre;
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
	
}
