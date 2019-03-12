package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Mercado;
import Principal.Proveedor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ConsultarInversionesP extends JFrame implements Serializable{

	private JPanel contentPane;
	private Mercado mercado;
	private Proveedor proveedor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Proveedor p = new Proveedor();
					ConsultarInversionesP frame = new ConsultarInversionesP(m,p);
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
	public ConsultarInversionesP(Mercado m , Proveedor p) {
		mercado = m;
		proveedor = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaProveedor eu=new EntradaProveedor(mercado,proveedor);
				eu.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JLabel lblConsultarMisInversiones = new JLabel("Consultar mis Inversiones");
		lblConsultarMisInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarMisInversiones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultarMisInversiones.setBounds(137, 57, 254, 26);
		contentPane.add(lblConsultarMisInversiones);
		
		table = new JTable();
		table.setBounds(10, 118, 514, 179);
		contentPane.add(table);
		
		
	}

}
