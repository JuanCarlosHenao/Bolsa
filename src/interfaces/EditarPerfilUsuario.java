package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;

public class EditarPerfilUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField cedula;
	private JTextField correo;
	private JTextField pass1;
	private JTextField pass2;
	private Mercado mercado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					EditarPerfilUsuario frame = new EditarPerfilUsuario(m);
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
	public EditarPerfilUsuario(Mercado m) {
		mercado = m ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("C:\\\\Users\\\\LUIS FELIPE\\\\estructuras\\\\Bolsa\\\\Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("Editar mi perfil");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(167, 69, 212, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreCompleto = new JLabel("Nombre y apellido: ");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreCompleto.setBounds(71, 153, 110, 37);
		contentPane.add(lblNombreCompleto);
		
		nombre = new JTextField();
		nombre.setBounds(243, 156, 136, 33);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula :");
		lblCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdula.setBounds(94, 237, 79, 26);
		contentPane.add(lblCdula);
		
		cedula = new JTextField();
		cedula.setBounds(243, 235, 136, 33);
		contentPane.add(cedula);
		cedula.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo : ");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(94, 308, 79, 37);
		contentPane.add(lblCorreo);
		
		JButton btnGuardar = new JButton("Guardar y actualizar datos");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(167, 554, 189, 37);
		contentPane.add(btnGuardar);
		
		correo = new JTextField();
		correo.setBounds(243, 311, 136, 33);
		contentPane.add(correo);
		correo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a : ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasea.setBounds(94, 397, 79, 26);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirmarContrasea.setBounds(50, 471, 123, 26);
		contentPane.add(lblConfirmarContrasea);
		
		pass1 = new JTextField();
		pass1.setBounds(243, 395, 136, 33);
		contentPane.add(pass1);
		pass1.setColumns(10);
		
		pass2 = new JTextField();
		pass2.setBounds(243, 469, 136, 33);
		contentPane.add(pass2);
		pass2.setColumns(10);
		
	}

}
