package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

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

import Principal.Inversion;
import Principal.Mercado;
import javax.swing.border.LineBorder;

public class InversionesMercado extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado ;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					InversionesMercado frame = new InversionesMercado(m);
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
	public InversionesMercado(Mercado m) {
		mercado = m ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
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
		
		JLabel lblInversionesDelMercado = new JLabel("Inversiones del Mercado");
		lblInversionesDelMercado.setHorizontalAlignment(SwingConstants.CENTER);
		lblInversionesDelMercado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInversionesDelMercado.setBounds(129, 55, 268, 26);
		contentPane.add(lblInversionesDelMercado);
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 514, 201);
		contentPane.add(scrollPane);
		
		ArrayList<Inversion> lista = new ArrayList<Inversion>();
		
		
		tabla = new JTable();
		tabla.setEnabled(false);
		tabla.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabla.setFillsViewportHeight(true);
		tabla.setToolTipText("");
		tabla.setColumnSelectionAllowed(true);
		tabla.setCellSelectionEnabled(true);
		tabla.setFont(new Font("Tahoma", Font.ITALIC, 12));
		tabla.setSurrendersFocusOnKeystroke(true);
		tabla.setForeground(new Color(0, 0, 0));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tipo", "Código", "Proveedor", "Precio"},
				{"Tipo", "Código", "Proveedor", "Precio"},
			},
			new String[] {
				"Tipo", "Código", "Proveedor", "Precio"
			}
		){
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setColumnHeaderView(tabla);
		
	}

}
