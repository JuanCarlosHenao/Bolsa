package principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class prueba {
	public static void main(String[] args) throws InterruptedException {
		int range=(100-80)-1;
		int[] variables= null;
		double precioBase=100;
		double accion=precioBase;
		System.out.println("Precio Base de la accion:"+ precioBase);
		
		
		
		
		
		while(true) {
			
			Thread.sleep(3000);
			int variable= (int) (Math.random()*range)+80;
			
			
			if(variables==null) {
				variables=new int[1];
			}else {
				variables= Arrays.copyOf(variables, variables.length+1);
			}
			variables[variables.length-1]=variable;
			
			if(variables.length==1) {
				accion= accion+(variables[0]*0.01);
			}else if(variables[variables.length-1]>variables[variables.length-2]) {
				accion=accion+(variables[variables.length-1]*0.05);
			}else if(variables[variables.length-1]<variables[variables.length-2]) {
				accion=accion-(variables[variables.length-1]*0.05);
			}
			
			System.out.println("accion: "+accion);
			System.out.println("Petroleo: "+variable);
			
			
			String cadena2= Integer.toString(variable);
			String cadena= Double.toString(accion);
			FileWriter f= null;
			FileWriter f2= null;
			BufferedWriter b= null;
			BufferedWriter c= null;
			
			try {
				f = new FileWriter("C:\\Users\\LUIS FELIPE\\Documents\\TRABAJOS\\UNIVERSIDAD\\2019\\6to semestre\\Estructura de Datos\\texto.txt", true);
				f2= new FileWriter("C:\\Users\\LUIS FELIPE\\Documents\\TRABAJOS\\UNIVERSIDAD\\2019\\6to semestre\\Estructura de Datos\\texto.txt", true);
				b= new BufferedWriter(f);
				c= new BufferedWriter(f2);
				
				b.write(cadena);
				b.newLine();
				c.write(cadena2);
				c.newLine();
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("No se puede abrir el fichero");
			}finally {
				try {
					b.close();
					f.close();
					c.close();
					f2.close();
				} catch (IOException e2) {
					// TODO: handle exception
					System.out.println("no se pudo cerrar el fichero");
				}
			}
			
		}
		
		
		
	}

}


