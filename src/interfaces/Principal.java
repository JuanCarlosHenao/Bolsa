package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Main;
import Principal.Mercado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado mercado=new Mercado();
					Principal frame = new Principal(mercado);
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
	public Principal(Mercado mercado ) {
		this.setTitle("Inversiones");
		this.mercado=mercado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos a la Bolsa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(122, 66, 221, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escoja la opci\u00F3n de cuenta :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(135, 150, 208, 17);
		contentPane.add(lblNewLabel_1);
		
		JButton btnUsu = new JButton("Usuarios");
		btnUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccesoUsuario au=new AccesoUsuario(mercado);
				au.setVisible(true);
				dispose();
				
			}
		});
		btnUsu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUsu.setBounds(100, 246, 117, 37);
		contentPane.add(btnUsu);
		
		JButton btnProv = new JButton("Proveedores");
		btnProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccesoProveedor ap=new AccesoProveedor(mercado);
				ap.setVisible(true);
				dispose();
			}
		});
		btnProv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProv.setBounds(274, 246, 117, 37);
		contentPane.add(btnProv);
	}

	
}
