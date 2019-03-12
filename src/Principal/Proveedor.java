package Principal;

import java.io.Serializable;
import java.util.Arrays;

public class Proveedor implements Serializable {

	private String nombre;			//nombre del proveedor
	private String id;				// codigo identificante del proveedor
	
	public Proveedor(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	// ----------- GETTERS & SETTERS ----------- //
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	// ---------- METODOS DE LA CLASE --------- //
	
		// ----- AGREGAR UNA POSIBLE INVERSION AL MERCADO
	
	
	// jc se debe hacer un agregar de cada tipo de inversion 
	
	/*public void addInversion(String codigo, String tipo, double precioBase) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = i;
	}*/
	
		
	
}
