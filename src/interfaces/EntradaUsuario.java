package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Mercado;
import Principal.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntradaUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField muestraNombre;
	private JTextField muestraSaldo;
	private Mercado mercado;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u= new Usuario();
					EntradaUsuario frame = new EntradaUsuario(m,u);
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
	public EntradaUsuario(Mercado m, Usuario u) {
		mercado = m;
		usuario =u;
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
				AccesoUsuario eu=new AccesoUsuario(mercado);
				eu.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
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
		
		muestraNombre = new JTextField(usuario.getNombre());
		muestraNombre.setEditable(false);
		muestraNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		muestraNombre.setBounds(89, 9, 411, 40);
		panel.add(muestraNombre);
		muestraNombre.setColumns(10);
		
		JLabel lblSaldoEnLa = new JLabel("Saldo \r\nen la \r\ncuenta:");
		lblSaldoEnLa.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSaldoEnLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaldoEnLa.setBounds(10, 61, 106, 40);
		panel.add(lblSaldoEnLa);
		
		muestraSaldo = new JTextField("el saldo es "+ Float.toString(usuario.getCuentas().getSaldo()));
		muestraSaldo.setEditable(false);
		muestraSaldo.setBounds(126, 61, 374, 40);
		panel.add(muestraSaldo);
		muestraSaldo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pagina principal para Usuarios");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(127, 25, 273, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDepositarEnLa = new JButton("Depositar en la cuenta");
		btnDepositarEnLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositarCuentaUsuario du=new DepositarCuentaUsuario(m,usuario);
				du.setVisible(true);
				dispose();
				
			}
		});
		btnDepositarEnLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDepositarEnLa.setBounds(300, 254, 186, 61);
		contentPane.add(btnDepositarEnLa);
		
		JButton btnVerListaDe = new JButton("Inversiones de mercado\r\n");
		btnVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InversionesMercado im= new InversionesMercado(mercado,usuario);
				im.setVisible(true);
				dispose();
				
				
			}
		});
		btnVerListaDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerListaDe.setBounds(300, 384, 186, 55);
		contentPane.add(btnVerListaDe);
		
		JButton btnMisInversiones = new JButton("Consultar mis inversiones\r\n");
		btnMisInversiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InversionesUsuario iu= new InversionesUsuario(m,usuario);

				iu.setVisible(true);
				dispose();
			}
		});
		
		btnMisInversiones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMisInversiones.setBounds(45, 381, 186, 61);
		contentPane.add(btnMisInversiones);
		
		JButton btnEditarMiPerfil = new JButton("Editar mi perfil");
		btnEditarMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditarPerfilUsuario eu=new EditarPerfilUsuario(m,usuario);
				eu.setVisible(true);
				dispose();
				
			}
		});
		btnEditarMiPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditarMiPerfil.setBounds(45, 257, 186, 55);
		contentPane.add(btnEditarMiPerfil);
		
		JButton btnComprarInv = new JButton("Comprar Inversion\r\n");
		btnComprarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComprarInversionU ci = new ComprarInversionU(mercado,usuario);
				ci.setVisible(true);
				dispose();
			}
		});
		btnComprarInv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComprarInv.setBounds(45, 514, 186, 55);
		contentPane.add(btnComprarInv);
		
		JButton btnVenderInv = new JButton("Vender Inversion");
		btnVenderInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VenderInversionU vi = new VenderInversionU(mercado,usuario);
				vi.setVisible(true);
				dispose();
			}
		});
		btnVenderInv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVenderInv.setBounds(300, 511, 186, 61);
		contentPane.add(btnVenderInv);
	}
}
