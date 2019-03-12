package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Usuario;

public class VenderInversionU extends JFrame implements Serializable{

	private JPanel contentPane;
	private Mercado mercado;
	private Usuario usuario;
	private JTable table;
	private JTextField idInv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u = new Usuario();
					VenderInversionU frame = new VenderInversionU(m,u);
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
	public VenderInversionU(Mercado m , Usuario u) {
		setTitle("Inversiones");
		mercado = m ;
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaUsuario eu=new EntradaUsuario(mercado,usuario);
				eu.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblVenderMisInversiones = new JLabel("Vender mis Inversiones");
		lblVenderMisInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderMisInversiones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVenderMisInversiones.setBounds(136, 47, 284, 26);
		contentPane.add(lblVenderMisInversiones);
		
		table = new JTable();
		table.setBounds(10, 107, 514, 175);
		contentPane.add(table);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversi\u00F3n que desea vender :");
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElId.setBounds(48, 312, 284, 14);
		contentPane.add(lblIngreseElId);
		
		idInv = new JTextField();
		idInv.setHorizontalAlignment(SwingConstants.CENTER);
		idInv.setBounds(342, 310, 139, 20);
		contentPane.add(idInv);
		idInv.setColumns(10);
		
		JButton btnVenderInv = new JButton("Vender Inversi\u00F3n");
		btnVenderInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVenderInv.setBounds(199, 363, 166, 34);
		contentPane.add(btnVenderInv);
		
		
	}
}
