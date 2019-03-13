package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Proveedor;
import Principal.UtilidadesFicheros;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EliminarInversionP extends JFrame implements Serializable{

	private JPanel contentPane;
	private Mercado mercado;
	private Proveedor proveedor;
	private JTable tabloide;
	private JTextField IDinversion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Proveedor p = new Proveedor();
					EliminarInversionP frame = new EliminarInversionP(m,p);
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
	public EliminarInversionP(Mercado m , Proveedor p) {
		setTitle("Inversiones\r\n");
		mercado = m;
		proveedor = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaProveedor eu=new EntradaProveedor(mercado,proveedor);
				eu.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblEliminarInversionesDe = new JLabel("Eliminar inversiones de Proveedores");
		lblEliminarInversionesDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarInversionesDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminarInversionesDe.setBounds(100, 58, 355, 26);
		contentPane.add(lblEliminarInversionesDe);
		
		// para crear la tabla 
		
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
		Object datos [][]= new Object[m.getInversiones().length][4];
		for (int i=0;i<m.inversionesPorProveedor(proveedor.getId()).length;i++) {
			datos[i][0]=m.inversionesPorProveedor(proveedor.getId())[i].getTipo();
			datos[i][1]=m.inversionesPorProveedor(proveedor.getId())[i].getCodigo();
			datos[i][2]=m.inversionesPorProveedor(proveedor.getId())[i].getIdProv();
			datos[i][3]=m.inversionesPorProveedor(proveedor.getId())[i].getPrecioBase();
			
		}
		tabloide= new JTable(datos, columns);
		JScrollPane panel = new JScrollPane(tabloide);
		panel.setBounds(37, 97, 603, 209);
		contentPane.add(panel);
		this.setTitle("Inversiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//--------------------------------
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversion que desea eliminar :");
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setBounds(41, 327, 273, 14);
		contentPane.add(lblIngreseElId);
		
		IDinversion = new JTextField();
		IDinversion.setBounds(324, 322, 154, 26);
		contentPane.add(IDinversion);
		IDinversion.setColumns(10);
		
		JButton btnEliminarInv = new JButton("Eliminar Inversion");
		btnEliminarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.eliminarInversion(IDinversion.getText());
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", m);
				EliminarInversionP p= new EliminarInversionP(mercado, proveedor);
				p.setVisible(true);
				dispose();
			}
		});
		btnEliminarInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarInv.setBounds(199, 384, 154, 38);
		contentPane.add(btnEliminarInv);
		
		
	}

}
