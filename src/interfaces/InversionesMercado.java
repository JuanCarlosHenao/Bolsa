package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Usuario;
import javax.swing.table.DefaultTableModel;

public class InversionesMercado extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado ;
	private JTable tabla;
	private Usuario usuario;
	private  JTable tabloide;
	/**
	 * @wbp.nonvisual location=113,84
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u=new Usuario();
					InversionesMercado frame = new InversionesMercado(m,u);
					frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InversionesMercado(Mercado m, Usuario user) {
		mercado = m ;
		usuario=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaUsuario eu=new EntradaUsuario(mercado,usuario);
				eu.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblInversionesDelMercado = new JLabel("Inversiones del Mercado");
		lblInversionesDelMercado.setHorizontalAlignment(SwingConstants.CENTER);
		lblInversionesDelMercado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInversionesDelMercado.setBounds(212, 59, 268, 26);
		contentPane.add(lblInversionesDelMercado);
		
		
		
		
		// para crear la tabla 
		
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio", " id User"};
		Object datos [][]= new Object[m.getInversiones().length][5];
		
		for (int i=0;i<m.getInversiones().length;i++) {
			datos[i][0]=m.getInversiones()[i].getTipo();
			datos[i][1]=m.getInversiones()[i].getCodigo();
			datos[i][2]=m.getInversiones()[i].getIdProv();
			datos[i][3]=m.getInversiones()[i].getPrecioBase();
			datos[i][4]=m.getInversiones()[i].getIdUsu();
			
		}
		
		tabloide= new JTable(datos, columns);
		
		JScrollPane panel = new JScrollPane(tabloide);
		panel.setBounds(37, 97, 590, 322);
		contentPane.add(panel);
		this.setTitle("Inversiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//--------------------------------
		
		
		
		

		
		
	}
}
