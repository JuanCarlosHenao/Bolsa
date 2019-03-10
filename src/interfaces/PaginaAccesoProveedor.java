package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PaginaAccesoProveedor {
	JFrame frmLogginAcces;
	public static JTextField cajaUsuario;
	public static JPasswordField cajaContrasena;
    public static JButton btnLoggin;
    public static JButton btnRegister;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaAccesoProveedor window = new PaginaAccesoProveedor();
					window.frmLogginAcces.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaginaAccesoProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogginAcces = new JFrame();
		frmLogginAcces.setTitle("Loggin Access");
		frmLogginAcces.setBounds(100, 100, 550, 700);
		frmLogginAcces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogginAcces.getContentPane().setLayout(null);
		
		JLabel lblWelcomToMarktrade = new JLabel("Bienvenidos a la Bolsa");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 50, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Plataforma para Proveedores");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 90, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		cajaUsuario = new JTextField();
		cajaUsuario.setBounds(210, 180, 116, 22);
		frmLogginAcces.getContentPane().add(cajaUsuario);
		cajaUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Identificación");
		lblUsuario.setBounds(230, 160, 84, 16);
		frmLogginAcces.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(235, 252, 68, 16);
		frmLogginAcces.getContentPane().add(lblPassword);
		
		cajaContrasena = new JPasswordField();
		cajaContrasena.setBounds(210, 270, 116, 22);
		frmLogginAcces.getContentPane().add(cajaContrasena);
		
		JButton btnLoggin = new JButton("Entrar");
		btnLoggin.setBounds(215, 350, 97, 25);
		frmLogginAcces.getContentPane().add(btnLoggin);
		
		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setBounds(210, 398, 110, 25);
		frmLogginAcces.getContentPane().add(btnRegister);
	}
}
