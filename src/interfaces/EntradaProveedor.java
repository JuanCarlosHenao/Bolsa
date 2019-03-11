package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class EntradaProveedor extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField textField;
	private Mercado mercado ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					EntradaProveedor frame = new EntradaProveedor(m);
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
	public EntradaProveedor(Mercado m) {
		mercado = m;
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
		panel.setBounds(10, 90, 514, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 21, 67, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(89, 9, 411, 66);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pagina principal para Proveedores\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(127, 25, 273, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnMisInversiones = new JButton("Consultar mis inversiones ");
		btnMisInversiones.setForeground(Color.BLACK);
		btnMisInversiones.setBackground(Color.WHITE);
		btnMisInversiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMisInversiones.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMisInversiones.setBounds(176, 241, 202, 61);
		contentPane.add(btnMisInversiones);
		
		JButton btnAadirInversion = new JButton("A\u00F1adir inversion");
		btnAadirInversion.setBackground(Color.WHITE);
		btnAadirInversion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAadirInversion.setBounds(176, 351, 202, 61);
		contentPane.add(btnAadirInversion);
		
		JButton btnEliminarInversion = new JButton("Eliminar inversion");
		btnEliminarInversion.setBackground(Color.WHITE);
		btnEliminarInversion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminarInversion.setBounds(176, 464, 202, 61);
		contentPane.add(btnEliminarInversion);
	}

}
