package principal;

import java.util.Arrays;

public class Mercado {

	private Usuario[] usuarios;
	private Inversion[] inversiones;
	private Proveedor[] proveedores;
	private Variable[] variables;
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
	public Proveedor[] getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor[] proveedores) {
		this.proveedores = proveedores;
	}

	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
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
	
	public void addProveedor(Proveedor p) {
		if(proveedores == null) {
			proveedores = new Proveedor[1];
		} else {
			proveedores = Arrays.copyOf(proveedores, proveedores.length+1);
		}
		proveedores[proveedores.length-1] = p;
	}
	
		// ----- ELIMINACION DE CLASES
	
	public void eliminarUsuario(String id) throws EUsuario {
		Usuario[] usuarios2;
		usuarios2 = new Usuario[usuarios.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < usuarios.length; i++) {
			if(usuarios[i].getNombre().compareTo(id)!=0) {
				usuarios2[cont]=usuarios[i]; 
				cont++;
			}
		}
		usuarios = Arrays.copyOf(usuarios2, usuarios2.length);
		throw new EUsuario("No se pudo eliminar el usuario.");
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
	
		// ----- METODO PARA MODIFICAR EL PRECIO BASE DE UNA ACCION POR LAS VARIABLES QUE LA INFLUYEN
	public double alterarPrecio(Variable variables, double precioBase) {
		return 0;
	}
	
		// ----- USUARIO PRIORITARIO : EL QUE SUMA LA MAYOR INVERSION EN EL MERCADO
	public Usuario buscarUsuarioPrioritario() throws EUsuario, EInversion {
		double mayor = 0;
		for (int i = 0; i < usuarios.length ; i++) {
			if (inversionTotalPorUsuario(usuarios[i].getId()) > mayor) {
				mayor=inversionTotalPorUsuario(usuarios[i].getId());
			}
		}
		for (int i=0;i<usuarios.length;i++) {
			if (inversionTotalPorUsuario(usuarios[i].getId()) == mayor) {
				return usuarios[i];
			}
		}
		return null;
	}
		
		// ----- IMPRIMIR RECIBO : POR USUARIO DE CADA INVERSION QUE TIENE CON SU PRECIO
	public void imprimirRecibo(String codUsuario) {
		for(int i = 0 ; i < getUsuarios().length ; i++) {
			System.out.println("Codigo del usuario: "  + getUsuarios()[i].getId()
						     + "\nNombre: " + getUsuarios()[i].getNombre()
						     + "\nCorreo: " + getUsuarios()[i].getCorreo());
			System.out.println();
			for(int j = 0 ; j < inversiones.length ; j++) {
				if(inversiones[i].getCodigo() == usuarios[i].getId()) {
					System.out.println("\nInversion: " + inversiones[i].getCodigo()
									 + "\nPrecio: " );
				} else {
					System.out.println("El usuario no tiene inversiones aún.");
				}
			}
			System.out.println("---------------------------------------------------");
		}
	}
	
		// ----- HISTORIAL DE LAS INVERSIONES DEL USUARIO
	public void historialInversiones(String idUsuario) throws EInversion {
		Inversion [] invUsuario =new Inversion[0];
		for(int i = 0 ; i < inversiones.length ; i++ ) {
			if(inversiones[i].getIdUsu().compareTo(idUsuario)==0) {
				invUsuario=Arrays.copyOf(invUsuario, invUsuario.length+1);
				invUsuario[invUsuario.length-1]=inversiones[i];
				
				//return inversiones[i];
			} else i++; 
		}
		 imprimirInversiones(invUsuario);
	
	}
	
		// ----- IMPRIMIR INVERSIONES : imprime las inversiones con formato
	public void imprimirInversiones(Inversion[] invUsuario) throws EInversion {
			for(int i = 0 ; i < invUsuario.length ; i++) {
				System.out.println("Numero de la inversion:" + (i+1) 
								 + "\nCodigo de la inversion:" + inversiones[i].getCodigo()
								 + "\nCodigo del Proveedor: " + inversiones[i].getIdProv()
								 + "\nCodigo del Usuario Comprador: " + inversiones[i].getIdUsu()
								 + "\nTipo de inversion:" + inversiones[i].getTipo()
								 + "\nPrecio base: " + inversiones[i].getPrecioBase()
								 + "\nPrecio Real en Mercado: ");
				System.out.println("---------------------------------------------------");
			}
	}
	
		// ----- HACER UNA INVERSION
	public void realizarInversion(String idUsuario, String idInversion) {
		for(int i = 0 ; i < inversiones.length ; i++) {
			if(inversiones[i].getCodigo().compareTo(idInversion)==0) {
				inversiones[i].setIdUsu(idUsuario); 
			}
		}
	}
	
	
	
}
