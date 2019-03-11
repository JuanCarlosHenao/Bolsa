package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Proveedor;
import Principal.UtilidadesFicheros;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroProveedor extends JFrame implements Serializable {

	private JPanel contra;
	private JTextField nbEmpresa;
	private JTextField identi;
	private JPasswordField passwordField;
	private Mercado mercado;
	private Proveedor prove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m=new Mercado();
					RegistroProveedor frame = new RegistroProveedor(m);
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
	public RegistroProveedor(Mercado m) {
		mercado=m;
		this.setTitle("Inversiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contra = new JPanel();
		contra.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contra);
		contra.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 100, 170, 36);
		contra.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la empresa: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 220, 144, 20);
		contra.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(116, 285, 59, 23);
		contra.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(89, 349, 86, 41);
		contra.add(lblNewLabel_3);
		
		nbEmpresa = new JTextField();
		nbEmpresa.setBounds(242, 213, 130, 36);
		contra.add(nbEmpresa);
		nbEmpresa.setColumns(10);
		
		identi = new JTextField();
		identi.setBounds(242, 279, 130, 36);
		contra.add(identi);
		identi.setColumns(10);
		
		JButton btnRegistroP = new JButton("Registrar");
		btnRegistroP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prove=new Proveedor(nbEmpresa.getText(),identi.getText());
				mercado.addProveedor(prove);
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				AccesoProveedor ap=new AccesoProveedor(mercado);
				ap.setVisible(true);
				dispose();
				
				
			}
		});
		btnRegistroP.setForeground(Color.BLACK);
		btnRegistroP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistroP.setBounds(215, 460, 105, 36);
		contra.add(btnRegistroP);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 349, 130, 36);
		contra.add(passwordField);
	}
}
