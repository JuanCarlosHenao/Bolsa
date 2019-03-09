package principal;

public class Usuario {

	private String nombre;
	private String correo;
	private String id;
	private CuentaBancaria cuenta;
	

	public Usuario(String nombre, String correo, String id) {
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
	}
	
	public Usuario(String nombre, String correo, String id, CuentaBancaria cuentas) {
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		this.cuenta = cuentas;
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
		return cuenta;
	}
	public void setCuentas(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
	// ----- METODOS DE LA CLASE
	

	public double consultarSaldo() {
		return cuenta.getSaldo();
	}
	
	public double hacerDeposito(float monto) {
		float saldoAnterior = cuenta.getSaldo();
		if(monto > 0) {
			saldoAnterior += monto;
			cuenta.setSaldo(saldoAnterior);
		} else {
			System.out.println("Ingrese un valor positivo.");
		}
		return saldoAnterior;
	}
	
	
}
