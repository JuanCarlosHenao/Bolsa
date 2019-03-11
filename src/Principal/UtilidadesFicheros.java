package Principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class UtilidadesFicheros implements Serializable {
	
	/**
	 * Escribir archivo mercado
	 *
	 *  archivo El archivo
	 * mercado El mercado 
	 */
	public static void escribirDatosMercado(String archivo, Mercado mercado) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(mercado);
			} catch (IOException e) {
				System.out.println("Problema al crear las clases");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la direccion para crear el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problemas para crearse");
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}

			} catch (IOException e) {
				System.out.println("No se pudo cerrar el archivo");
			}
		}
	}
	
	
	
	/**
	 * Leer archivo de objeto empresa.
	 *
	 * archivo El archivo
	 *  La empresa
	 */
	public static Mercado leerDatosMercado(String archivo) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Mercado mercado = new Mercado();
		try {
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				Mercado mercado2 = (Mercado) ois.readObject();
				mercado= mercado2;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la ruta para leer el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problemas para ser leido");
		} catch (ClassNotFoundException e) {
			System.out.println("Problema al leer fichero");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("El fichero tiene problemas al leerlo");
			}
		}
		if (mercado==null) {
			return null;
		} else {
			return mercado;
		}
	}


}
