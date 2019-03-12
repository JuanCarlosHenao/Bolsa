package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Principal.Mercado;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class InversionesUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					InversionesUsuario frame = new InversionesUsuario(m);
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
	public InversionesUsuario(Mercado m) {
		this.setTitle("Inversiones");
		mercado = m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				{"Tipo", "Código", "Proveedor", "Precio"},
			},
			new String[] {
				"Tipo", "Código", "Proveedor", "Precio"
			}
		) {
			/**
			 * 
			 */
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
