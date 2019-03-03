package Principal;

public class Usuario {

	private String nombre;
	private String correo;
	private String id;
	private CuentaBancaria cuentas;

	public Usuario(String nombre, String correo, String id) {
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
	}
	
	public Usuario(String nombre, String correo, String id, CuentaBancaria cuentas) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		this.cuentas = cuentas;
	}

	// ----------- GETTERS & SETTERS ---------- //
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CuentaBancaria getCuentas() {
		return cuentas;
	}

	public void setCuentas(CuentaBancaria cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
}
