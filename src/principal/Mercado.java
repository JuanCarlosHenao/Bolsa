package principal;

import java.util.Arrays;

public class Mercado {

	private Usuario[] usuarios;
	private Inversion[] inversiones;
	private Proveedor[] proveedores;
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
	public Proveedor[] getProveedor() {
		return proveedores;
	}
	public void setProveedor(Proveedor[] proveedores) {
		this.proveedores = proveedores;
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
	
	public void addProveedor(Proveedor p) {
		if(proveedores == null) {
			proveedores = new Proveedor[1];
		} else {
			proveedores = Arrays.copyOf(proveedores, proveedores.length+1);
		}
		proveedores[proveedores.length-1] = p;
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
	
	public void eliminarProveedor(String nombre) throws EProveedor {
		Proveedor[] proveedores2;
		proveedores2 = new Proveedor[proveedores.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < proveedores.length ; i++) {
			if(proveedores[i].getNombre().compareTo(nombre)!=0) {
				proveedores2[cont] = proveedores[i];
				cont++;
			}
		}
		proveedores = Arrays.copyOf(proveedores2, proveedores2.length);
		throw new EProveedor("No se pudo eliminar el origen de la inversión.");
	}
		
			// ----- BÚSQUEDA DE CLASES
	
	public Usuario buscarUsuario(String id) throws EUsuario {
		int i = 0 ;
		while(i < usuarios.length) {
			if(usuarios[i].getId().compareTo(id)==0) {
				return usuarios[i];
			}
			else i++;
		}
		throw new EUsuario("No se pudo encontrar el usuario.");
	}
	
	public Inversion buscarInversion(String codigo) throws EInversion {
		int i = 0;
		while(i < inversiones.length) {
			if(inversiones[i].getCodigo().compareTo(codigo)==0) {
				return inversiones[i];
			} else i++; 
		}
		throw new EInversion("No se pudo encontrar la inversión.");
	}
	
	public Proveedor buscarProveedor(String id) throws EProveedor {
		int i = 0 ;
		while(i < proveedores.length) {
			if(proveedores[i].getId().compareTo(id)==0) {
				return proveedores[i];
			} else i++;
		}
		throw new EProveedor("No se encontró el origen de la acción.");
	}
	
		// ----- ESTADO DE UNA INVERSION: determina la fase en la cual se encuentra la inversion (PLANEACION , EJECUCION , FINALIZACION)
	
	
	
		// ----- TOTAL INVERSION POR USUARIO
	public double inversionTotalPorUsuario(String id) throws EInversion, EUsuario {
		double total = 0;
		for(int i = 0 ; i < inversiones.length ; i++) {
			if(inversiones[i].getCodigo().compareTo(id)==0) {
				total += inversiones[i].valorInversion();
			}
		}
		return total;
	}
	
	
		// ----- TOTAL INVERSION DEL MERCADO
	public double inversionTotalMercado() throws EInversion {
		double total = 0 ;
		for(int i = 0 ; i < inversiones.length ; i++) {
			total += inversiones[i].valorInversion();
		}
		return total;
	}
	
	
	
	
}
