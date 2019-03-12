package interfaces;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Principal.Mercado;
import Principal.UtilidadesFicheros;

public class Tabla extends JFrame implements Serializable  {
	private Mercado m; 
	
	
	
	public Tabla(Mercado m) {
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
		Object datos [][]= new Object[m.getInversiones().length][4];
		for (int i=0;i<m.getInversiones().length;i++) {
			datos[i][0]=m.getInversiones()[i].getTipo();
			datos[i][1]=m.getInversiones()[i].getCodigo();
			datos[i][2]=m.getInversiones()[i].getIdProv();
			datos[i][3]=m.getInversiones()[i].getPrecioBase();
			
			
		}
		
		
		/*Object data[][]= new Object[][] {
			{"bono","b0","prove1",4000},
			{"accion","a0","prove2",6000},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
			{"criptomoneda","cm0","prove3",2300},
		};*/
		
		 
		
		JTable table= new JTable(datos, columns);
		
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
				
				new Tabla(UtilidadesFicheros.leerDatosMercado("mercado.datos"));
			}
		});
		
		
	}	
		
	
	

}