package Principal;

import java.io.Serializable;

public class CuentaBancaria implements Serializable {

	private float saldo;
	private String id;
	
	public CuentaBancaria(float saldo, String id) {
		this.saldo = saldo;
		this.id = id;
	}
	
	// ---------- GETTERS & SETTERS ---------- //
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo += saldo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
	