package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Excepciones.EProveedor;
import Principal.Mercado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccesoProveedor extends JFrame implements Serializable {

	private JPanel contentPane;
	public static JTextField cajaUsuario;
	public static JPasswordField cajaContrasena;
    public static JButton btnLoggin;
    public static JButton btnRegister;
    private JTextField identificacion;
    private Mercado mercado;
    private JPasswordField contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m=new Mercado();
					AccesoProveedor frame = new AccesoProveedor(m);
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
	public AccesoProveedor(Mercado m) {
		mercado=m;
		this.setTitle("Inversiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal p=new Principal(mercado);
				p.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("Identificaci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(220, 215, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenidos a la Bolsa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(140, 46, 240, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Plataforma para Proveedores");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(168, 120, 193, 27);
		contentPane.add(lblNewLabel_2);
		
		identificacion = new JTextField();
		identificacion.setBounds(210, 240, 121, 34);
		contentPane.add(identificacion);
		identificacion.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(215, 310, 111, 27);
		contentPane.add(lblContrasea);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntradaProveedor ep;
				try {
					ep = new EntradaProveedor(m,m.buscarProveedor(identificacion.getText()));
					ep.setVisible(true);
					dispose();
					
				} catch (EProveedor e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnNewButton.setBounds(227, 437, 89, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroProveedor rp=new RegistroProveedor(mercado);
				rp.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnNewButton_1.setBounds(218, 498, 113, 42);
		contentPane.add(btnNewButton_1);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(210, 348, 121, 34);
		contentPane.add(contraseña);
	}

}
