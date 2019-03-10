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
	super();
	this.nombre = nombre;
	this.correo = correo;
	this.id = id;
	this.cuentas = cuentas;
	this.contrasena = contrasena;
}



	/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}



/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}



/**
 * @return the correo
 */
public String getCorreo() {
	return correo;
}



/**
 * @param correo the correo to set
 */
public void setCorreo(String correo) {
	this.correo = correo;
}



/**
 * @return the id
 */
public String getId() {
	return id;
}



/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}



/**
 * @return the cuentas
 */
public CuentaBancaria getCuentas() {
	return cuentas;
}



/**
 * @param cuentas the cuentas to set
 */
public void setCuentas(CuentaBancaria cuentas) {
	this.cuentas = cuentas;
}



/**
 * @return the contrasena
 */
public String getContrasena() {
	return contrasena;
}



/**
 * @param contrasena the contrasena to set
 */
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


