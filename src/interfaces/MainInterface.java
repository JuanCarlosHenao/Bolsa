package interfaces;

import java.awt.EventQueue;

public class MainInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PaginaAcceso logginWindow = new PaginaAcceso();
						logginWindow.frmLogginAcces.setVisible(true);
						// buscar como hacer bien para cuando unda un boton se cierre esa ventana y se abra la otra
						//RegisterPage registerWindow = new RegisterPage();
						//registerWindow.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}


