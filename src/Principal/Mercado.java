package Principal;

import java.io.Serializable;
import java.util.Arrays;

import Excepciones.EInversion;
import Excepciones.EProveedor;
import Excepciones.EUsuario;

public class Mercado implements Serializable {

	private Usuario[] usuarios;
	private Inversion[] inversiones;
	private Proveedor[] proveedores;
	private Variable[] variables=new Variable[2];
	private String nombre;
	
	public Mercado(String nombre) {
		this.nombre = nombre;
		inversiones=new Inversion[0];
	}
	
	// ---------- GETTERS & SETTERS ---------- //
	
	public Mercado() {
		// TODO Auto-generated constructor stub
	}

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
	
	public void addAccion(String codigo, String idProv, String tipo, double precioBase) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = new Accion(codigo, idProv, tipo, precioBase);
	}
	
	public void addCriptoMoneda(String codigo, String idProv, String tipo, double precioBase) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = new CriptoMoneda(codigo, idProv, tipo, precioBase);
	}
	
	public void addBono(String codigo, String idProv, String tipo, double precioBase) {
		if(inversiones == null) {
			inversiones = new Inversion[1];
		} else {
			inversiones = Arrays.copyOf(inversiones, inversiones.length+1);
		}
		inversiones[inversiones.length-1] = new Bono(codigo, idProv, tipo, precioBase);
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
	
	public void eliminarProveedor(String id) throws EProveedor {
		Proveedor[] proveedores2;
		proveedores2 = new Proveedor[proveedores.length-1];
		int cont = 0 ;
		for(int i = 0 ; i < proveedores.length ; i++) {
			if(proveedores[i].getId().compareTo(id)!=0) {
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
		while(i<usuarios.length && usuarios[i].getId().compareTo(id)!=0) {
			i++;
		}
		if (i<usuarios.length) {
			return usuarios[i];
		}else {
			throw new EUsuario("No se pudo encontrar el usuario.");
		}
			
		
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
			if(inversiones[i].getIdUsu().compareTo(id)==0) {
				total += inversiones[i].getPrecioBase();
			}
		}
		return total;
	}
	
		// ----- TOTAL INVERSION DEL MERCADO
	public double inversionTotalMercado() throws EInversion {
		double total = 0 ;
		for(int i = 0 ; i < inversiones.length ; i++) {
			total += inversiones[i].getPrecioBase();		
		}
		return total;
	}

	public void actualizarPrecios() {
		alterarPrecioAccion();
		alterarPrecioBono();
		alterarPrecioCripto();
	}
	
		// ----- METODO PARA MODIFICAR EL PRECIO BASE DE UN BONO POR LAS VARIABLES QUE LA INFLUYEN
	public void alterarPrecioBono() {

		// si las dos suben 
		if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].getInflacion()<variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()*variables[1].getInflacion()/100;
					
					inversiones[i].setPrecioBase(precioNuevo);
				}
			}
			
			// si las dos bajan 
		}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].getInflacion()>variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()*variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(precioNuevo);
				}
			}
			
			//si dolar sube e inflacion baja 
		}else if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].getInflacion()>variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()-variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(precioNuevo);
				}
			}
		}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].getInflacion()<variables[1].getInflacion()) {
			// si dolar baja e inlfacion sube 
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()+variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(precioNuevo);
				}
			}
			
		} else {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase();
					inversiones[i].setPrecioBase(precioNuevo);
		
				}
			}
		}
	}
			
 
	

	// ----- METODO PARA MODIFICAR EL PRECIO BASE DE UNA CRIPTOMONEDA POR LAS VARIABLES QUE LA INFLUYEN
	public void alterarPrecioCripto() {
		// si el dolar sube 
				if (variables[0].get$dolar()<variables[1].get$dolar()) {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof CriptoMoneda ) {
							double 							precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar();
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
					// si el dolar baja 
				}else if (variables[0].get$dolar()>variables[1].get$dolar()) {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof CriptoMoneda ) {
							double 							precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar();
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
				}
		
		
		

	}
	
	// ----- METODO PARA MODIFICAR EL PRECIO BASE DE UNA ACCION POR LAS VARIABLES QUE LA INFLUYEN
	public void alterarPrecioAccion() {
		// si las dos suben 
				if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].get$petroleo()<variables[1].get$petroleo()) {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof Accion ) {
							double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()*variables[1].get$petroleo()/100;
							
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
					
					// si las dos bajan 
				}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].get$petroleo()>variables[1].get$petroleo()) {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof Accion ) {
							double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()*variables[1].get$petroleo()/100;
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
					
					//si dolar sube e petroleo baja 
				}else if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].get$petroleo()>variables[1].get$petroleo()) {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof Accion ) {
							double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()-variables[1].get$petroleo()/100;
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
				}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].get$petroleo()<variables[1].get$petroleo()) {
					// si dolar baja e petroleo sube 
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof Accion ) {
							double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()+variables[1].get$petroleo()/100;
							inversiones[i].setPrecioBase(precioNuevo);
						}
					}
				} else {
					for (int i=0;i<inversiones.length;i++) {
						if (inversiones[i] instanceof Accion ) {
							double precioNuevo=inversiones[i].getPrecioBase();
							inversiones[i].setPrecioBase(precioNuevo);
						}
		
					}
				}
					
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
	
		// ----- IMPRIMIR INVERSIONES : imprime las inversiones con formato
	public void imprimirInversiones() throws EInversion {
			for(int i = 0 ; i < inversiones.length ; i++) {
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
	public void realizarInversion(String idUsuario, String idInversion) throws EInversion {
		Inversion voyAComprar=buscarInversion(idInversion);
		voyAComprar.setIdUsu(idUsuario);
		if (voyAComprar.getIdUsu()==null) {
			voyAComprar.setIdUsu(idUsuario);
		}else {
			throw new EInversion("La inversion ya tiene dueño ");
		}
	}
	
	
	public void actualizarVariables() {
		
		
		
			variables[1]=new Variable();
			variables[1].set$dolar();
			variables[1].set$petroleo();
			variables[1].setInflacion();
			
			variables[0].recibeDolar(variables[1].get$dolar());
			variables[0].recibeInflacion(variables[1].getInflacion());
			variables[0].recibePetroleo(variables[1].get$petroleo());
			
			variables[1]=new Variable();
			variables[1].set$dolar();
			variables[1].set$petroleo();
			variables[1].setInflacion();
			

	}
	
	
	public Inversion[] inversionesSinDueño() {
		Inversion[] sinComprar=new Inversion[0];
		for (int i=0;i<inversiones.length;i++) {
			if (inversiones[i].getIdUsu()==null) {
			sinComprar=Arrays.copyOf(sinComprar, sinComprar.length+1);
			sinComprar[sinComprar.length-1]=inversiones[i];

			}
		}
		return sinComprar;
	}
	
	public Inversion[] inversionesPorUsuario(String idUsuario) {
		Inversion[] propias=new Inversion[0];
		for (int i=0;i<inversiones.length;i++) {
			if (inversiones[i].getIdUsu().compareTo(idUsuario)==0) {
				propias=Arrays.copyOf(propias, propias.length+1);
				propias[propias.length-1]=inversiones[i];

			}
		}
		return propias;
		
	}
	
	
	
	
	
	
	
}
