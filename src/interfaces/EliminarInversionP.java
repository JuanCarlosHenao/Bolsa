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
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Proveedor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EliminarInversionP extends JFrame implements Serializable{

	private JPanel contentPane;
	private Mercado mercado;
	private Proveedor proveedor;
	private JTable table;
	private JTextField IDinv;

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
		setBounds(100, 100, 550, 500);
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
		
		table = new JTable();
		table.setBounds(10, 107, 514, 182);
		contentPane.add(table);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversion que desea eliminar :");
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setBounds(41, 327, 273, 14);
		contentPane.add(lblIngreseElId);
		
		IDinv = new JTextField();
		IDinv.setBounds(324, 322, 154, 26);
		contentPane.add(IDinv);
		IDinv.setColumns(10);
		
		JButton btnEliminarInv = new JButton("Eliminar Inversion");
		btnEliminarInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarInv.setBounds(199, 384, 154, 38);
		contentPane.add(btnEliminarInv);
		
		
	}

}
