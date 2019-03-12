package Principal;

import java.io.Serializable;

public class Usuario implements Serializable {


	private String nombre;
	private String correo;
	private String id;
	//private String contrasena;
	private CuentaBancaria cuentas;

	public Usuario(String nombre, String correo, String id) {
		this.nombre = nombre;
		this.correo = correo;
		this.id = id;
		cuentas=new CuentaBancaria(5000,id);;
	}
	


	// ----------- GETTERS & SETTERS ---------- //
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}



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
	public void setCuentas(CuentaBancaria cuenta) {
		this.cuentas = cuenta;
	}
	
	// ----- METODOS DE LA CLASE
	public double consultarSaldo() {
		return cuentas.getSaldo();
	}
	
	public double hacerDeposito(float monto) {
		float saldoAnterior = cuentas.getSaldo();
		if(monto > 0) {
			saldoAnterior += monto;
			cuentas.setSaldo(saldoAnterior);
		} else {
			System.out.println("Ingrese un valor positivo.");
		}
		return saldoAnterior;
	}
	
	
}
