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

public class InversionesUsuario extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private JTable table;
	private JScrollBar scrollBar;

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
		mercado = m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenDeInversiones = new JLabel("Men\u00FA de inversiones");
		lblMenDeInversiones.setBounds(177, 11, 171, 14);
		lblMenDeInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenDeInversiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMenDeInversiones);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(1, 1, 1), 2));
		table.setBounds(10, 58, 514, 192);
		contentPane.add(table);
		getContentPane().add(new JScrollPane(table));

		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(507, 58, 17, 192);
		contentPane.add(scrollBar);
	}
}
