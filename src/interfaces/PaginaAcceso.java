package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class PaginaAcceso {

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
					PaginaAcceso window = new PaginaAcceso();
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
	public PaginaAcceso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogginAcces = new JFrame();
		frmLogginAcces.setTitle("Loggin Acces");
		frmLogginAcces.setBounds(100, 100, 550, 700);
		frmLogginAcces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogginAcces.getContentPane().setLayout(null);
		
		JLabel lblWelcomToMarktrade = new JLabel("Welcom To MarkTrade");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 70, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		cajaUsuario = new JTextField();
		cajaUsuario.setBounds(200, 168, 116, 22);
		frmLogginAcces.getContentPane().add(cajaUsuario);
		cajaUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("User / Mail");
		lblUsuario.setBounds(200, 139, 84, 16);
		frmLogginAcces.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(200, 241, 68, 16);
		frmLogginAcces.getContentPane().add(lblPassword);
		
		cajaContrasena = new JPasswordField();
		cajaContrasena.setBounds(200, 270, 116, 22);
		frmLogginAcces.getContentPane().add(cajaContrasena);
		
		JButton btnLoggin = new JButton("Loggin ");
		btnLoggin.setBounds(210, 341, 97, 25);
		frmLogginAcces.getContentPane().add(btnLoggin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(210, 398, 97, 25);
		frmLogginAcces.getContentPane().add(btnRegister);
	}
}
