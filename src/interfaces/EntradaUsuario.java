package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Mercado;

public class EntradaUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Mercado mercado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					EntradaUsuario frame = new EntradaUsuario(m);
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
	public EntradaUsuario(Mercado m) {
		mercado = m;
		this.setTitle("Inversiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 90, 514, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 21, 67, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(89, 9, 411, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSaldoEnLa = new JLabel("Saldo \r\nen la \r\ncuenta:");
		lblSaldoEnLa.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSaldoEnLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaldoEnLa.setBounds(10, 61, 106, 40);
		panel.add(lblSaldoEnLa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 61, 374, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pagina principal para Usuarios");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(127, 25, 273, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDepositarEnLa = new JButton("Depositar en la cuenta");
		btnDepositarEnLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDepositarEnLa.setBounds(176, 343, 186, 61);
		contentPane.add(btnDepositarEnLa);
		
		JButton btnVerListaDe = new JButton("Inversiones de mercado\r\n");
		btnVerListaDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerListaDe.setBounds(176, 529, 186, 55);
		contentPane.add(btnVerListaDe);
		
		JButton btnMisInversiones = new JButton("Consultar mis inversiones\r\n");
		btnMisInversiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMisInversiones.setBounds(176, 438, 186, 61);
		contentPane.add(btnMisInversiones);
		
		JButton btnEditarMiPerfil = new JButton("Editar mi perfil");
		btnEditarMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditarMiPerfil.setBounds(176, 257, 186, 55);
		contentPane.add(btnEditarMiPerfil);
	}
}
