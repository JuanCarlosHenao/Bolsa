package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

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
import Excepciones.EUsuario;
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
	private JTextField dolarviejo;
	private JTextField dolarnuevo;
	private JTextField petroviejo;
	private JTextField petronuevo;
	private JTextField inflavieja;
	private JTextField inflanueva;

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
	 * @throws IOException 
	 */
	public ComprarInversionU(Mercado m , Usuario u) throws IOException {
		setTitle("Inversiones");
		mercado = m;
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 578);
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
					mercado.actualizarVariables();
					mercado.actualizarPrecios();
					UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
					ComprarInversionU ci;
					try {
						ci = new ComprarInversionU(mercado, usuario);
						ci.setVisible(true);
						dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
				} catch (EInversion e) {
					// TODO Auto-generated catch block
					e.getMessage()
				} catch (EUsuario e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		JButton actualizaVariables = new JButton("Actualizar Variables");
		actualizaVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mercado.actualizarVariables();
				mercado.actualizarPrecios();
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				ComprarInversionU ci;
				
				try {
					ci = new ComprarInversionU(mercado, usuario);
					ci.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		actualizaVariables.setBounds(661, 323, 183, 26);
		contentPane.add(actualizaVariables);
		DecimalFormat df = new DecimalFormat("#.0000");
		
		dolarviejo = new JTextField(df.format(mercado.getVariables()[0].get$dolar()));
		dolarviejo.setEditable(false);
		dolarviejo.setBounds(663, 140, 77, 22);
		contentPane.add(dolarviejo);
		dolarviejo.setColumns(10);
		
		dolarnuevo = new JTextField(df.format(mercado.getVariables()[1].get$dolar()));
		dolarnuevo.setEditable(false);
		dolarnuevo.setColumns(10);
		dolarnuevo.setBounds(767, 140, 77, 22);
		contentPane.add(dolarnuevo);
		
		petroviejo = new JTextField(df.format(mercado.getVariables()[0].get$petroleo()));
		petroviejo.setEditable(false);
		petroviejo.setColumns(10);
		petroviejo.setBounds(663, 212, 77, 22);
		contentPane.add(petroviejo);
		
		petronuevo = new JTextField(df.format(mercado.getVariables()[1].get$petroleo()));
		petronuevo.setEditable(false);
		petronuevo.setColumns(10);
		petronuevo.setBounds(767, 212, 77, 22);
		contentPane.add(petronuevo);
		
		inflavieja = new JTextField(df.format(mercado.getVariables()[0].getInflacion()));
		inflavieja.setEditable(false);
		inflavieja.setColumns(10);
		inflavieja.setBounds(663, 281, 77, 22);
		contentPane.add(inflavieja);
		
		inflanueva = new JTextField(df.format(mercado.getVariables()[1].getInflacion()));
		inflanueva.setEditable(false);
		inflanueva.setColumns(10);
		inflanueva.setBounds(767, 281, 77, 22);
		contentPane.add(inflanueva);
		
	}
}
