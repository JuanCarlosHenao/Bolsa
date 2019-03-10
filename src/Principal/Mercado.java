package Principal;

import java.util.Arrays;

import Excepciones.EInversion;
import Excepciones.EProveedor;
import Excepciones.EUsuario;

public class Mercado {

	private Usuario[] usuarios;
	private Inversion[] inversiones;
	private Proveedor[] proveedores;
	private Variable[] variables=new Variable[2];
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
		throw new EProveedor("No se pudo eliminar el origen de la inversi�n.");
	}
		
			// ----- B�SQUEDA DE CLASES
	
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
		throw new EInversion("No se pudo encontrar la inversi�n.");
	}
	
	public Proveedor buscarProveedor(String id) throws EProveedor {
		int i = 0 ;
		while(i < proveedores.length) {
			if(proveedores[i].getId().compareTo(id)==0) {
				return proveedores[i];
			} else i++;
		}
		throw new EProveedor("No se encontr� el origen de la acci�n.");
	}
	
	
	
		// ----- TOTAL INVERSION POR USUARIO
	public double inversionTotalPorUsuario(String id) throws EInversion, EUsuario {
		double total = 0;
		for(int i = 0 ; i < inversiones.length ; i++) {
			if(inversiones[i].getIdUsu().compareTo(id)==0) {
				total += inversiones[i].valorInversion();
			}
		}
		return total;
	}
	
		// ----- TOTAL INVERSION DEL MERCADO
	public double inversionTotalMercado() throws EInversion {
		double total = 0 ;
		for(int i = 0 ; i < inversiones.length ; i++) {
			total += inversiones[i].valorInversion();		// CAMBIAR A GET PRECIO
		}
		return total;
	}

	public void actualizarPrecios() {
		//alterarPrecioAccion();
		alterarPrecioBono();
		//alterarPrecioCripto();
	}
	
		// ----- METODO PARA MODIFICAR EL PRECIO BASE DE UNA ACCION POR LAS VARIABLES QUE LA INFLUYEN
	public void alterarPrecioBono() {
		// si las dos suben 
		if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].getInflacion()<variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()*variables[1].getInflacion()/100;
					
					inversiones[i].setPrecioBase(1);
				}
			}
			
			// si las dos bajan 
		}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].getInflacion()>variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()*variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(2);
				}
			}
			
			//si dolar sube e inflacion baja 
		}else if (variables[0].get$dolar()<variables[1].get$dolar() && variables[0].getInflacion()>variables[1].getInflacion()) {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()+variables[1].get$dolar()-variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(3);
				}
			}
			
			
		}else if (variables[0].get$dolar()>variables[1].get$dolar() && variables[0].getInflacion()<variables[1].getInflacion()) {
			// si dolar baja e inlfacion sube 
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					double precioNuevo=inversiones[i].getPrecioBase()-variables[1].get$dolar()+variables[1].getInflacion()/100;
					inversiones[i].setPrecioBase(4);
				}
			}
			
		} else {
			for (int i=0;i<inversiones.length;i++) {
				if (inversiones[i] instanceof Bono ) {
					
					inversiones[i].setPrecioBase(5);
				}
			}
		}
			
 
	}
	
	public void alterarPrecioCripto() {
		if(variables.length==1) {
			for(int i =0; i<inversiones.length; i++) {
				if(inversiones[i] instanceof CriptoMoneda) {
					double a= inversiones[i].getPrecioBase() + variables[0].get$dolar()*0.1;
					inversiones[i].setPrecioBase(a);
				}//------------poner else if para las que no son acciones?
			}
		}else {
			//----- condicion para cuando el dolar baja
			if(variables[variables.length-1].get$dolar()<variables[variables.length-2].get$dolar() ) {
				for(int i =0; i<inversiones.length; i++) {
					if(inversiones[i] instanceof CriptoMoneda) {
						double a= inversiones[i].getPrecioBase() + variables[0].get$dolar()*0.5 ;
						inversiones[i].setPrecioBase(a);
					}
				}
			//----- cuando el dolar suben de precio
			}else if(variables[variables.length-1].get$dolar()>variables[variables.length-2].get$dolar() ) {
				for(int i =0; i<inversiones.length; i++) {
					if(inversiones[i] instanceof CriptoMoneda) {
						double a= inversiones[i].getPrecioBase() - variables[0].get$dolar()*0.5 ;
						inversiones[i].setPrecioBase(a);
					}//------------poner else if para las que no son acciones?
				}
			}
		}
	}
	
	public void alterarPrecioAccion() {
		if(variables.length==1) {
			for(int i =0; i<inversiones.length; i++) {
				if(inversiones[i] instanceof Accion) {
					double a= inversiones[i].getPrecioBase()+ variables[1].get$dolar()*0.1 + variables[1].get$petroleo()*0.1;
					inversiones[i].setPrecioBase(a);
				}//------------poner else if para las que no son acciones?
			}
		}else {
		
		//---condicion para cuando el dolar y el petroleo bajan de precio
		if(variables[variables.length-1].get$dolar()<variables[variables.length-2].get$dolar() && variables[variables.length-1].get$petroleo()<variables[variables.length-2].get$petroleo()) {
			for(int i =0; i<inversiones.length; i++) {
				if(inversiones[i] instanceof Accion) {
					double a= inversiones[i].getPrecioBase()- variables[1].get$dolar()*0.5 - variables[1].get$petroleo()*0.5;
					inversiones[i].setPrecioBase(a);
				}//------------poner else if para las que no son acciones?
			}
			//-----cuando ambas suben de precio
			}else if(variables[variables.length-1].get$dolar()>variables[variables.length-2].get$dolar() && variables[variables.length-1].get$petroleo()>variables[variables.length-2].get$petroleo()) {
				for(int i =0; i<inversiones.length; i++) {
					if(inversiones[i] instanceof Accion) {
						double a= inversiones[i].getPrecioBase()+ variables[1].get$dolar()*0.5 + variables[1].get$petroleo()*0.5;
						inversiones[i].setPrecioBase(a);
					}//------------poner else if para las que no son acciones?
				}
				
				//---dolar bajo, petroleo subio
			}else if(variables[variables.length-1].get$dolar()<variables[variables.length-2].get$dolar() && variables[variables.length-1].get$petroleo()>variables[variables.length-2].get$petroleo()) {
				for(int i =0; i<inversiones.length; i++) {
					if(inversiones[i] instanceof Accion) {
						double a= inversiones[i].getPrecioBase()- variables[1].get$dolar()*0.8 + variables[1].get$petroleo()*0.8;
						inversiones[i].setPrecioBase(a);
					}//------------poner else if para las que no son acciones?
				}
				//----dolar subio, petroleo bajo
			}else if(variables[variables.length-1].get$dolar()>variables[variables.length-2].get$dolar() && variables[variables.length-1].get$petroleo()<variables[variables.length-2].get$petroleo()) {
				for(int i =0; i<inversiones.length; i++) {
					if(inversiones[i] instanceof Accion) {
						double a= inversiones[i].getPrecioBase()+ variables[1].get$dolar()*0.8 - variables[1].get$petroleo()*0.8;
						inversiones[i].setPrecioBase(a);
					}//------------poner else if para las que no son acciones?
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
					System.out.println("El usuario no tiene inversiones a�n.");
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
			throw new EInversion("La inversion ya tiene due�o ");
			
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
	
	
	public Inversion[] inversionesSinDue�o() {
		Inversion[] sinComprar=new Inversion[0];
		for (int i=0;i<inversiones.length;i++) {
			if (inversiones[i].getIdUsu()==null) {
			sinComprar=Arrays.copyOf(sinComprar, sinComprar.length+1);
			sinComprar[sinComprar.length-1]=inversiones[i];

			}
		}
		return sinComprar;
	}
	
	
	
	
	
	
	
}