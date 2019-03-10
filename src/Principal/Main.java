package Principal;

import java.io.File;
import java.io.Serializable;

import Excepciones.EInversion;
import Excepciones.EProveedor;
import Excepciones.EUsuario;


public class Main implements Serializable {

	public static void main(String[] args) throws EInversion, EUsuario, EProveedor, InterruptedException {
		
			// TODO Auto-generated method stub
			/*File file = new File("mercado.datos");
			if(file.exists()) {
				Mercado merca = Recursos.ReadFileObjectEmpresa("mercado.datos");
				// se debe crear una nuve ventana de la principal del mercado y pasarle merca
				FormLogin inicio = new FormLogin(hotel);
				inicio.setVisible(true);
			}else {
				// se debe crear el inicio de todos los tiempos para colocarle el nombre a la bolsa
				FormZeroDay principal = new FormZeroDay();
				principal.setVisible(true);
			}*/
		

		
		Mercado m = new Mercado("Bolsa de Colombia");
		
		//-- CREACION DE USUARIOS Y CUENTAS BANCARIAS
		CuentaBancaria cb1 = new CuentaBancaria(1000000,"lucho1204");
		Usuario u1 = new Usuario("Luis Montoya", "correo@luisfe.com", "lucho1204", cb1);
		CuentaBancaria cb2 = new CuentaBancaria(100000,"henao7328");
		Usuario u2 = new Usuario("JuanCa Henao","correo@henao.com","henao7328", cb2);
		CuentaBancaria cb3 = new CuentaBancaria(10000,"aleman36");
		Usuario u3 = new Usuario("Camilo Arango","correo@arango.com","aleman36", cb3);
		CuentaBancaria cb4 = new CuentaBancaria(1000,"dennis52");
		Usuario u4 = new Usuario("Dennis Juilland","correo@dennis.com","dennis52", cb4);
		CuentaBancaria cb5 = new CuentaBancaria(100,"arteaga123");
		Usuario u5 = new Usuario("Mateo Arteaga","correo@artega.com","arteaga123", cb5);
		CuentaBancaria cb6 = new CuentaBancaria(10,"alejo987");
		Usuario u6 = new Usuario("Luis Gordillo","correo@alejo.com","alejo987", cb6);
		m.addUsuario(u1); m.addUsuario(u2);	m.addUsuario(u3); m.addUsuario(u4); m.addUsuario(u5); m.addUsuario(u6);
		
		Usuario[] usuarios = new Usuario[6];
		usuarios[0] = u1; usuarios[1] = u2; usuarios[2] = u3; usuarios[3] = u4; usuarios[4] = u5; usuarios[5] = u6;
		
		/*
		 for(int i = 0 ; i < usuarios.length ; i++ ) {
			System.out.println("Nombre: " + usuarios[i].getNombre() + "\tId: " + usuarios[i].getId()
							+ "\tCorreo: " + usuarios[i].getCorreo() + "\tSaldo: " + usuarios[i].getCuentas().getSaldo());
		} System.out.println();	
		*/

		//-- CREACION DE PROVEEDORES
		Proveedor p1 = new Proveedor("Nestle","N3sTl3");
		Proveedor p2 = new Proveedor("Russia","Russ14");
		Proveedor p3 = new Proveedor("Bancolombia","paisas123");
		m.addProveedor(p1); m.addProveedor(p2); m.addProveedor(p3);  
		Proveedor[] proveedores = new Proveedor[3];
		proveedores[0] = p1; proveedores[1] = p2; proveedores[2] = p3;
		
		/*
		 for(int i = 0 ; i < proveedores.length; i++) {
			System.out.println("Nombre: " + proveedores[i].getNombre() + "\tId: " + proveedores[i].getId()
								+ "\tTipo de accion: " + proveedores[i].getTipo());
		} System.out.println();
		*/
		
		//-- CREACION DE ACCIONES
		
		
		
		/*Inversion[] inv = new Inversion[1];
		inv[0]= a1;*/
		//m.setInversiones(inv);
		//m.realizarInversion("lucho1204", "idACCION-1");

		//System.out.println(inv.length);
		//m.imprimirInversiones();
		/*Accion a1 = new Accion(p1.getId(),p1.getTipo(),25000,"accion1");
		p1.addInversion(a1);
		Bono b1 = new Bono(p2.getNombre(),p2.getId(),10000,"accion2");
		p2.addInversion(b1);
		
		CriptoMoneda c1 = new CriptoMoneda(p3.getNombre(), p3.getId(), 50000, "accion3");
		p3.addInversion(c1);
		Inversion[] inv = new Inversion[3];
		inv[0] = a1; inv[1] = b1; inv[2] = c1;
		*/
		//for(Inversion i:inv)	System.out.println("La acción identificada por el codigo " + i.getTipo() );
	 	                 
		
		//-- METODOS 
		//System.out.println();
		System.out.println(m.buscarUsuario("lucho1204").getNombre());
		System.out.println(m.buscarProveedor("paisas123").getNombre());
		//System.out.println(m.buscarInversion("Nestle").getCodigo());
		System.out.println();
		
		System.out.println("El saldo inicial era de: " + u1.consultarSaldo());
		u1.hacerDeposito(1234);
		System.out.println("El saldo despues de cambios era de: " + u1.consultarSaldo());
		System.out.println();
		
		//m.historialInversiones("lucho1204");
		
		Variable v = new Variable();
		/*System.out.println(v.get$dolar());
		v.set$dolar();
		System.out.println(v.get$dolar());
		System.out.println();
		System.out.println(v.get$petroleo());
		v.set$petroleo();
		System.out.println(v.get$petroleo());
		System.out.println();
		System.out.println(v.getInflacion());
		v.setInflacion();
		System.out.println(v.getInflacion());*/
		
		m.addAccion("idACCION-1", "idPROV-1", "Accion", 10000);
		m.addBono("b1","idPROV-1","Bono",5000);
		m.addCriptoMoneda("cp1","idPROV-1","CriptoMoneda",4000);

		Variable[] vars=new Variable [2];
		vars[0]=v;
		
		vars[1]=v;
		m.setVariables(vars);
		/*System.out.println("dolar1---- "+m.getVariables()[0].get$dolar()); 
		System.out.println("inlfacion1---- "+m.getVariables()[0].getInflacion());*/
		
		System.out.println("bono1----- "+m.buscarInversion("cp1").getPrecioBase());
		m.actualizarVariables();
		
		
		System.out.println("dolar1 ---- "+m.getVariables()[0].get$dolar());
		System.out.println("inlfacion1---- "+m.getVariables()[0].getInflacion());
		System.out.println("Petroleo1---- "+m.getVariables()[0].get$petroleo());
		System.out.println();
		System.out.println();
		System.out.println("dolar2 ---- "+m.getVariables()[1].get$dolar());
		System.out.println("inlfacion2---- "+m.getVariables()[1].getInflacion());
		System.out.println("Petroleo2---- "+m.getVariables()[1].get$petroleo());
		
		
		m.actualizarPrecios();
		System.out.println();
		
		
		System.out.println("bono2---- "+m.buscarInversion("cp1").getPrecioBase());
		
		
		
		
		
		
		
		
		// jc 
		//v.escribirVariablesFichero();
		
		
		//m.imprimirInversiones();
		//m.imprimirRecibo("lucho1204");
	}
}
