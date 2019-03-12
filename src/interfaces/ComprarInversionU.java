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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Excepciones.EInversion;
import Principal.Mercado;
import Principal.Usuario;
import Principal.UtilidadesFicheros;

public class ComprarInversionU extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private Usuario usuario;
	private JTable tabloide;
	private JTextField idInversion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u = new Usuario();
					ComprarInversionU frame = new ComprarInversionU(m,u);
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
	public ComprarInversionU(Mercado m , Usuario u) {
		setTitle("Inversiones");
		mercado = m;
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 598);
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
		
		JLabel lblComprarInversiones = new JLabel("Comprar Inversiones");
		lblComprarInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarInversiones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComprarInversiones.setBounds(136, 47, 284, 26);
		contentPane.add(lblComprarInversiones);
		
		// para crear la tabla 
		
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
		Object datos [][]= new Object[m.getInversiones().length][4];
		for (int i=0;i<m.inversionesSinDueño().length;i++) {
			datos[i][0]=m.inversionesSinDueño()[i].getTipo();
			datos[i][1]=m.inversionesSinDueño()[i].getCodigo();
			datos[i][2]=m.inversionesSinDueño()[i].getIdProv();
			datos[i][3]=m.inversionesSinDueño()[i].getPrecioBase();
			
		}
		tabloide= new JTable(datos, columns);
		JScrollPane panel = new JScrollPane(tabloide);
		panel.setBounds(37, 97, 587, 202);
		contentPane.add(panel);
		this.setTitle("Inversiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//--------------------------------
		
		
		
		
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversi\u00F3n que desea comprar :");
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElId.setBounds(48, 312, 284, 14);
		contentPane.add(lblIngreseElId);
		
		idInversion = new JTextField();
		idInversion.setHorizontalAlignment(SwingConstants.CENTER);
		idInversion.setBounds(342, 310, 139, 20);
		contentPane.add(idInversion);
		idInversion.setColumns(10);
		
		JButton btnComprarInv = new JButton("Comprar Inversi\u00F3n");
		btnComprarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					m.realizarInversion(usuario.getId(), idInversion.getText());
					usuario.getCuentas().setSaldo((float) -m.buscarInversion(idInversion.getText()).getPrecioBase());
					UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
					ComprarInversionU ci=new ComprarInversionU(mercado, usuario);
					ci.setVisible(true);
					dispose();
				} catch (EInversion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnComprarInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprarInv.setBounds(199, 363, 166, 34);
		contentPane.add(btnComprarInv);
		
	}

}
