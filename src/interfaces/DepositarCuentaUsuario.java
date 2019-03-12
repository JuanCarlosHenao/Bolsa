package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class DepositarCuentaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Mercado mercado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m=new Mercado();
					DepositarCuentaUsuario frame = new DepositarCuentaUsuario(m);
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
	public DepositarCuentaUsuario(Mercado m) {
		mercado=m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
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
		
		JLabel lblDepositoEnLa = new JLabel("Deposito en la Cuenta Bancaria");
		lblDepositoEnLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositoEnLa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepositoEnLa.setBounds(77, 48, 339, 26);
		contentPane.add(lblDepositoEnLa);
		
		JLabel lblSaldoActual = new JLabel("Saldo Actual : ");
		lblSaldoActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaldoActual.setBounds(97, 107, 99, 26);
		contentPane.add(lblSaldoActual);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(256, 110, 117, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hacer deposito");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(168, 151, 134, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(186, 280, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
