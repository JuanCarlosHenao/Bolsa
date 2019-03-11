package interfaces;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {
	
	
	
	public Tabla() {
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
	
	
	Object data[][]= new Object[][] {
		{"bono","b0","prove1",4000},
		{"accion","a0","prove2",6000},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
		{"criptomoneda","cm0","prove3",2300},
	};
	
	 
	
	JTable table= new JTable(data, columns);
	
	this.add(new JScrollPane(table));
	//table.setFillsViewportHeight(true);
	
	
	this.setTitle("Inversiones");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	
	
	
	}
	 
//-----------------------------------------------------------		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Tabla();
			}
		});
		
		
	}	
		
	
	

}