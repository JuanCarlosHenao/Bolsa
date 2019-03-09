package principal;

import java.util.Arrays;

public class Proveedor {

	private String nombre;			//nombre del proveedor
	private String id;				// codigo identificante del proveedor
	private Inversion[] inversiones;
	
	public Proveedor(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public Proveedor(String nombre, String id, Inversion[] inversiones) {
		this.nombre = nombre;
		this.id = id;
		this.inversiones = inversiones;
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
	public Inversion[] getInversiones() {
		return inversiones;
	}

	public void setInversiones(Inversion[] inversiones) {
		this.inversiones = inversiones;
	}
	
	
	// ---------- METODOS DE LA CLASE --------- //
	
		// ----- AGREGAR UNA POSIBLE INVERSION AL MERCADO
	public void addInversion(String codigo, String tipo, double precioBase) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = i;
	}
	
		// ----- ELIMINAR UNA INVERSION EXISTENTE DEL MERCADO
	public void eliminarInversion(String codigo) throws EInversion {
		Inversion[] inversiones2;
		inversiones2 = new Inversion[inversiones.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < inversiones.length ; i++) {
			if(inversiones[i].getCodigo().compareTo(codigo)!=0) {
				inversiones2[cont]=inversiones[i];
				cont++;
			}
		}
		inversiones = Arrays.copyOf(inversiones2, inversiones2.length);
		throw new EInversion("No se pudo eliminar la inversión.");
	}
	
}
