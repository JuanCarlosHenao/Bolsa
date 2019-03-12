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
import Principal.Usuario;
import Principal.UtilidadesFicheros;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class DepositarCuentaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField muestraSaldo;
	private Mercado mercado;
	private JTextField deposito;
	private Usuario user;

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
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
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
		
		muestraSaldo = new JTextField(Float.toString(user.getCuentas().getSaldo()));
		muestraSaldo.setEditable(false);
		muestraSaldo.setBounds(256, 110, 117, 22);
		contentPane.add(muestraSaldo);
		muestraSaldo.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hacer deposito");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(168, 151, 134, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Actualizar y guardar cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.getCuentas().setSaldo(Integer.parseInt(deposito.getText()));
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", m);
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(127, 279, 197, 23);
		contentPane.add(btnNewButton);
		
		deposito = new JTextField();
		deposito.setBounds(168, 217, 117, 31);
		contentPane.add(deposito);
		deposito.setColumns(10);
		
		JLabel lblIngreseMontoA = new JLabel("Ingrese monto a depositar :");
		lblIngreseMontoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseMontoA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseMontoA.setBounds(146, 199, 167, 14);
		contentPane.add(lblIngreseMontoA);
		
	}
}
