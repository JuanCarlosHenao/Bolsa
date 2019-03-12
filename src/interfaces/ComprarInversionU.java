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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Excepciones.EInversion;
import Principal.Mercado;
import Principal.Usuario;
import Principal.UtilidadesFicheros;

public class ComprarInversionU extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private Usuario usuario;
	private JTable tabloide;
	private JTextField idInversion;
	private JTextField fieldSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Usuario u = new Usuario();
					ComprarInversionU frame = new ComprarInversionU(m,u);
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
	public ComprarInversionU(Mercado m , Usuario u) {
		setTitle("Inversiones");
		mercado = m;
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.setBounds(10, 11, 110, 26);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaUsuario eu=new EntradaUsuario(mercado,usuario);
				eu.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnRegresar);
		
		JLabel lblComprarInversiones = new JLabel("Comprar Inversiones");
		lblComprarInversiones.setBounds(136, 47, 284, 26);
		lblComprarInversiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarInversiones.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblComprarInversiones);
		
		// para crear la tabla 
		
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
		Object datos [][]= new Object[m.getInversiones().length][4];
		for (int i=0;i<m.inversionesSinDueño().length;i++) {
			datos[i][0]=m.inversionesSinDueño()[i].getTipo();
			datos[i][1]=m.inversionesSinDueño()[i].getCodigo();
			datos[i][2]=m.inversionesSinDueño()[i].getIdProv();
			datos[i][3]=m.inversionesSinDueño()[i].getPrecioBase();
			
		}
		tabloide= new JTable(datos, columns);
		JScrollPane panel = new JScrollPane(tabloide);
		panel.setToolTipText("");
		panel.setBounds(37, 97, 587, 202);
		contentPane.add(panel);
		this.setTitle("Inversiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//--------------------------------
		
		
		
		
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversi\u00F3n que desea comprar :");
		lblIngreseElId.setBounds(48, 312, 284, 14);
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblIngreseElId);
		
		idInversion = new JTextField();
		idInversion.setBounds(342, 310, 139, 20);
		idInversion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(idInversion);
		idInversion.setColumns(10);
		
		JButton btnComprarInv = new JButton("Comprar Inversi\u00F3n");
		btnComprarInv.setBounds(199, 363, 166, 34);
		btnComprarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					m.realizarInversion(usuario.getId(), idInversion.getText());
					usuario.getCuentas().setSaldo((float) - m.buscarInversion(idInversion.getText()).getPrecioBase());
					UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
					ComprarInversionU ci=new ComprarInversionU(mercado, usuario);
					ci.setVisible(true);
					dispose();
				} catch (EInversion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnComprarInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnComprarInv);
		
		fieldSaldo = new JTextField(Float.toString(usuario.getCuentas().getSaldo()));
		fieldSaldo.setBounds(514, 76, 110, 20);
		fieldSaldo.setEditable(false);
		fieldSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSaldo.setBackground(Color.ORANGE);
		contentPane.add(fieldSaldo);
		fieldSaldo.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo :");
		lblSaldo.setBounds(474, 78, 57, 14);
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblSaldo);
		
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
