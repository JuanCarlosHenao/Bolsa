package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Principal.Main;
import Principal.Mercado;
import Principal.Usuario;
import Principal.UtilidadesFicheros;


import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class RegistroUsuario extends JFrame implements Serializable  {
	private JPanel contra;
	private JTextField nbEmpresa;
	private JTextField identi;
	private JTextField email;
	private JPasswordField passwordField;
	private Usuario user;
	private  Mercado mercado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m=new Mercado();
					RegistroUsuario frame = new RegistroUsuario(m);
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
	public RegistroUsuario(Mercado mercado) {
		this.setTitle("Inversiones");
		this.mercado=mercado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contra = new JPanel();
		contra.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contra);
		contra.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 100, 170, 36);
		contra.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(89, 220, 105, 20);
		contra.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00E9dula :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(116, 285, 59, 23);
		contra.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(108, 349, 86, 41);
		contra.add(lblNewLabel_3);
		
		nbEmpresa = new JTextField();
		nbEmpresa.setBounds(242, 213, 130, 36);
		contra.add(nbEmpresa);
		nbEmpresa.setColumns(10);
		
		identi = new JTextField();
		identi.setBounds(242, 279, 130, 36);
		contra.add(identi);
		identi.setColumns(10);
		
		email = new JTextField();
		email.setBounds(242, 352, 130, 36);
		contra.add(email);
		email.setColumns(10);
		
		JButton btnRegistroP = new JButton("Registrar");
		btnRegistroP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				user=new Usuario(nbEmpresa.getText(), email.getText(), identi.getText());
				mercado.addUsuario(user);
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				AccesoUsuario au=new AccesoUsuario(mercado);
				
				au.setVisible(true);
				dispose();
				}
			
		});
		btnRegistroP.setForeground(Color.BLACK);
		btnRegistroP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistroP.setBounds(211, 528, 105, 36);
		contra.add(btnRegistroP);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(108, 431, 105, 25);
		contra.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 426, 130, 36);
		contra.add(passwordField);
	}
}
