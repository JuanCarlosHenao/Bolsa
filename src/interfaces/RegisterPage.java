package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterPage {

	JFrame frame;
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
					RegisterPage window = new RegisterPage();
					window.frmLogginAcces.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmLogginAcces = new JFrame();
		frmLogginAcces.setTitle("Bolsa de Colombia");
		frmLogginAcces.setBounds(80, 20, 550, 700);
		frmLogginAcces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogginAcces.getContentPane().setLayout(null);
		
		JLabel lblWelcomToMarktrade = new JLabel("Bienvenidos a la Bolsa");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 50, 200, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Escoja la opción de cuenta:");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 150, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		JButton btnLoggin = new JButton("Usuario");
		btnLoggin.setBounds(100, 300, 150, 50);
		frmLogginAcces.getContentPane().add(btnLoggin);
		
		JButton btnRegister = new JButton("Proveedor");
		btnRegister.setBounds(310, 300, 150, 50);
		frmLogginAcces.getContentPane().add(btnRegister);
		
		
		
	}

}
