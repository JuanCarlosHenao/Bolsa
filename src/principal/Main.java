package principal;

public class Main {

	public static void main(String[] args) throws EInversion, EUsuario, EProveedor {
		
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
		/*Accion a1 = new Accion(p1.getId(),p1.getTipo(),25000,"accion1");
		p1.addInversion(a1);
		Bono b1 = new Bono(p2.getNombre(),p2.getId(),10000,"accion2");
		p2.addInversion(b1);
		CriptoMoneda c1 = new CriptoMoneda(p3.getNombre(), p3.getId(), 50000, "accion3");
		p3.addInversion(c1);
		Inversion[] inv = new Inversion[3];
		inv[0] = a1; inv[1] = b1; inv[2] = c1;
		*/
		/*for(Inversion i:inv)
		System.out.println("La acción identificada por el codigo " + i.getTipo() );
	 	                 //   + ", fue depositada por la empresa " + a1.getCodigo());
		System.out.println("La acción identificada por el codigo " + b1.getIdBono() 
							+ ", fue depositada por la empresa " + b1.getCodigo());
		System.out.println("La acción identificada por el codigo " + c1.getIdCripto() 
         					+ ", fue depositada por la empresa " + c1.getCodigo());
		
		//-- METODOS 
		System.out.println();
		System.out.println(m.buscarUsuario("lucho1204").getNombre());
		System.out.println(m.buscarProveedor("Russ14").getNombre());
		//System.out.println(m.buscarInversion("Nestle").getCodigo());
		System.out.println();
		
		System.out.println("El saldo inicial era de: " + u1.consultarSaldo());
		u1.hacerDeposito(1234);
		System.out.println("El saldo despues de cambios era de: " + u1.consultarSaldo());
		*/
		
		//m.imprimirInversiones();
	}
}
