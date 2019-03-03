package Principal;

public class Main {

	public static void main(String[] args) {
		
		Mercado m = new Mercado("Bolsa de Colombia");
		
		CuentaBancaria cb1 = new CuentaBancaria(1000000,"lucho1204");
		Usuario u1 = new Usuario("Luis Montoya", "correo@luis.com", "lucho1204", cb1);
		CuentaBancaria cb2 = new CuentaBancaria(100000,"henao7328");
		Usuario u2 = new Usuario("JuanCarlos Henao","correo@henao.com","henao7328", cb2);
		CuentaBancaria cb3 = new CuentaBancaria(10000,"aleman36");
		Usuario u3 = new Usuario("Camilo Arango","correo@arango.com","aleman36", cb3);
		CuentaBancaria cb4 = new CuentaBancaria(1000,"dennis52");
		Usuario u4 = new Usuario("Dennis Juilland","correo@dennis.com","dennis52", cb4);
		CuentaBancaria cb5 = new CuentaBancaria(100,"arteaga123");
		Usuario u5 = new Usuario("Mateo Arteaga","correo@artega.com","arteaga123", cb5);
		CuentaBancaria cb6 = new CuentaBancaria(10,"alejo987");
		Usuario u6 = new Usuario("Alejandro Gordillo","correo@alejo.com","alejo987", cb6);
		m.addUsuario(u1); m.addUsuario(u2);	m.addUsuario(u3); m.addUsuario(u4); m.addUsuario(u5); m.addUsuario(u6);
		
		
		
	}
}
