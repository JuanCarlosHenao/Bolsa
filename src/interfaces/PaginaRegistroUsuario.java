package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PaginaRegistroUsuario {
	JFrame frame;
	JFrame frmLogginAcces;
	public static JTextField cajaUsuario;
	public static JPasswordField cajaContrasena;
    public static JButton btnLoggin;
    public static JButton btnRegister;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaRegistroUsuario window = new PaginaRegistroUsuario();
					window.frmLogginAcces.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PaginaRegistroUsuario() {
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
		
		JLabel lblWelcomToMarktrade = new JLabel("Registro de Usuarios");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(159, 50, 200, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Nombre: ");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(50, 150, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Cédula: ");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(50, 200, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Correo: ");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(50, 250, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		lblWelcomToMarktrade = new JLabel("Contraseña: ");
		lblWelcomToMarktrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomToMarktrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomToMarktrade.setBounds(43, 300, 212, 27);
		frmLogginAcces.getContentPane().add(lblWelcomToMarktrade);
		
		JButton btnLoggin = new JButton("Registrar");
		btnLoggin.setBounds(220, 350, 97, 25);
		frmLogginAcces.getContentPane().add(btnLoggin);
		
		
	}

}
