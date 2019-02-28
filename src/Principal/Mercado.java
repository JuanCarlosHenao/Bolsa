package Principal;

import java.util.Arrays;

public class Mercado {

	private Usuario[] usuarios;
	private Inversion[] inversiones;
	private Origen_Inv[] origenes;
	private String nombre;
	
	public Mercado(String nombre) {
		this.nombre = nombre;
	}
	
	// ---------- GETTERS & SETTERS ---------- //
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public Inversion[] getInversiones() {
		return inversiones;
	}
	public void setInversiones(Inversion[] inversiones) {
		this.inversiones = inversiones;
	}
	public Origen_Inv[] getOrigenes() {
		return origenes;
	}
	public void setOrigenes(Origen_Inv[] origenes) {
		this.origenes = origenes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre ;
	}
	
	
	//---------- METODOS DE LA CLASE ---------- //
	
		// ----- AGREGACION DE CLASES
	
	public void addUsuario(Usuario u) {
		if(usuarios == null) {
			usuarios = new Usuario[1];
		} else {
			usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		}
		usuarios[usuarios.length-1] = u ;
	}
	
	public void addInversion(Inversion i) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = i;
	}
	
	public void addOrigen(Origen_Inv origen) {
		if(origenes == null) {
			origenes = new Origen_Inv[1];
		} else {
			origenes = Arrays.copyOf(origenes, origenes.length+1);
		}
		origenes[origenes.length-1] = origen;
	}
	
		// ----- ELIMINACION DE CLASES
	
	public void eliminarUsuario(String nombre) throws EUsuario {
		Usuario[] usuarios2;
		usuarios2 = new Usuario[usuarios.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < usuarios.length; i++) {
			if(usuarios[i].getNombre().compareTo(nombre)!=0) {
				usuarios2[cont]=usuarios[i]; 
				cont++;
			}
		}
		usuarios = Arrays.copyOf(usuarios2, usuarios2.length);
		throw new EUsuario("No se pudo eliminar el usuario.");
	}
	
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
	
	public void eliminarOrigen(String nombre) throws EOrigen {
		Origen_Inv[] origenes2;
		origenes2 = new Origen_Inv[origenes.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < origenes.length ; i++) {
			if(origenes[i].getNombre().compareTo(nombre)!=0) {
				origenes2[cont] = origenes[i];
				cont++;
			}
		}
		origenes = Arrays.copyOf(origenes2, origenes2.length);
		throw new EOrigen("No se pudo eliminar el origen de la inversión.");
	}
}
