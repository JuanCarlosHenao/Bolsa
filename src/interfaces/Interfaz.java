package interfaces;
import javax.swing.*;

public class Interfaz {

	public static void main(String[] args) {
		
		PrimerMarco m1 = new PrimerMarco();
		m1.setVisible(true);								// Pone visible el marco creado.
		m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// Cuando se cierra la ventana, el proyecto se termina de correr.
		
	}
}

class PrimerMarco extends JFrame {
	
	public PrimerMarco() {
		setSize(1000,700);		// Determina el ancho y largo del marco.
	}
}