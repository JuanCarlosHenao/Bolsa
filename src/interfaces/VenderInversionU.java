package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
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
		setBounds(100, 100, 900, 500);
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
		table.setBounds(46, 99, 514, 175);
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
		
		JLabel lblVariablesDelMercado = new JLabel("VARIABLES DEL MERCADO : ");
		lblVariablesDelMercado.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariablesDelMercado.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblVariablesDelMercado.setBounds(647, 36, 197, 14);
		contentPane.add(lblVariablesDelMercado);
		
		JLabel lblPrecioDelDlar = new JLabel("Precio del d\u00F3lar :");
		lblPrecioDelDlar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDelDlar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioDelDlar.setBounds(697, 103, 110, 14);
		contentPane.add(lblPrecioDelDlar);
		
		JEditorPane dolarViejo = new JEditorPane();
		dolarViejo.setEditable(false);
		dolarViejo.setBounds(653, 130, 80, 20);
		contentPane.add(dolarViejo);
		
		JEditorPane dolarNuevo = new JEditorPane();
		dolarNuevo.setEditable(false);
		dolarNuevo.setBounds(764, 130, 80, 20);
		contentPane.add(dolarNuevo);
		
		JEditorPane petroViejo = new JEditorPane();
		petroViejo.setEditable(false);
		petroViejo.setBounds(653, 204, 80, 20);
		contentPane.add(petroViejo);
		
		JEditorPane petroNuevo = new JEditorPane();
		petroNuevo.setEditable(false);
		petroNuevo.setBounds(764, 204, 80, 20);
		contentPane.add(petroNuevo);
		
		JEditorPane inflaViejo = new JEditorPane();
		inflaViejo.setEditable(false);
		inflaViejo.setBounds(653, 279, 80, 20);
		contentPane.add(inflaViejo);
		
		JEditorPane inflaNuevo = new JEditorPane();
		inflaNuevo.setEditable(false);
		inflaNuevo.setBounds(764, 279, 80, 20);
		contentPane.add(inflaNuevo);
		
		
		JLabel lblPrecioDelPetrleo = new JLabel("Precio del petr\u00F3leo :");
		lblPrecioDelPetrleo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDelPetrleo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioDelPetrleo.setBounds(684, 175, 127, 14);
		contentPane.add(lblPrecioDelPetrleo);
		
		JLabel lblInflacin = new JLabel("Inflaci\u00F3n (%) :");
		lblInflacin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInflacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInflacin.setBounds(697, 254, 93, 14);
		contentPane.add(lblInflacin);
		
		JLabel lblAntes = new JLabel("ANTERIOR");
		lblAntes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntes.setForeground(Color.RED);
		lblAntes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAntes.setBounds(663, 76, 57, 14);
		contentPane.add(lblAntes);
		
		JLabel lblNewLabel = new JLabel("ACTUAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(778, 76, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnActualizarVariables = new JButton("Actualizar Variables");
		btnActualizarVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.actualizarVariables();
				ComprarInversionU ci = new ComprarInversionU(m,u);
				ci.setVisible(true);
				dispose();
			}
		});
		btnActualizarVariables.setBounds(685, 315, 127, 23);
		contentPane.add(btnActualizarVariables);
	}
}
