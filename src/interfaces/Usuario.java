package interfaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Principal.CuentaBancaria;

public class Usuario {
	private String nombre;
	private String correo;
	private String id;
	private CuentaBancaria cuentas;
	private String contrasena;

	
public Usuario(String nombre, String correo, String id, CuentaBancaria cuentas, String contrasena) {
	this.nombre = nombre;
	this.correo = correo;
	this.id = id;
	this.cuentas = cuentas;
	this.contrasena = contrasena;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCorreo() {
	return correo;
}


public void setCorreo(String correo) {
	this.correo = correo;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public CuentaBancaria getCuentas() {
	return cuentas;
}


public void setCuentas(CuentaBancaria cuentas) {
	this.cuentas = cuentas;
}


public String getContrasena() {
	return contrasena;
}


public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}



	public void registrarUsuario(String nombre, String correo, String contrasena) {
		FileWriter f=null;
		BufferedWriter b=null;
		try {
			f= new FileWriter("D:\\desktop\\Universidad\\ficheros\\fichero 1.txt",true);
			b=new BufferedWriter(f);
			
			
		}catch (IOException e) {
			System.out.println("No se puede abrir el fichero");
			
		} finally {
			try {
				b.close();
				f.close();
				
			}catch (Exception e){
				System.out.println("No se pudo cerrar bien el fivhero");
			}
	}
}}


