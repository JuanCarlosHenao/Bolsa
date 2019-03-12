package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Mercado;
import Principal.Usuario;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class InversionesUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private JTable tabla;
	private Usuario usuario;
	private JTable tabloide;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u=new Usuario();
					InversionesUsuario frame = new InversionesUsuario(m,u);
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
	public InversionesUsuario(Mercado m, Usuario user ) {
		this.setTitle("Inversiones");
		mercado = m;
		usuario=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 531);
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
		
		JLabel lblMenDeInversiones = new JLabel("Men\u00FA mis inversiones");
		lblMenDeInversiones.setBounds(177, 11, 171, 14);
		lblMenDeInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenDeInversiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMenDeInversiones);
		
		// para crear la tabla 
		
				String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
				Object datos [][]= new Object[m.getInversiones().length][4];
				for (int i=0;i<m.inversionesPorUsuario(usuario.getId()).length;i++) {
					datos[i][0]=m.inversionesPorUsuario(usuario.getId())[i].getTipo();
					datos[i][1]=m.inversionesPorUsuario(usuario.getId())[i].getCodigo();
					datos[i][2]=m.inversionesPorUsuario(usuario.getId())[i].getIdProv();
					datos[i][3]=m.inversionesPorUsuario(usuario.getId())[i].getPrecioBase();
					
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
