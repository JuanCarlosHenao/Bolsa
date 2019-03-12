package interfaces;

import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Principal.Mercado;
import Principal.Usuario;

public class InversionesUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private Usuario usuario;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u = new Usuario();
					InversionesUsuario frame = new InversionesUsuario(m,u);
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
	public InversionesUsuario(Mercado m , Usuario u) {
		this.setTitle("Inversiones");
		mercado = m;
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
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
		
		JLabel lblMenDeInversiones = new JLabel("Men\u00FA mis inversiones");
		lblMenDeInversiones.setBounds(177, 11, 171, 14);
		lblMenDeInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenDeInversiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMenDeInversiones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 514, 201);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setFont(new Font("Tahoma", Font.ITALIC, 12));
		tabla.setSurrendersFocusOnKeystroke(true);
		tabla.setForeground(new Color(0, 0, 0));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tipo", "C\u00F3digo", "Proveedor", "Precio"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Tipo", "C\u00F3digo", "Proveedor", "Precio"
			}
		));
		scrollPane.setColumnHeaderView(tabla);
		
		
		
	}
}
