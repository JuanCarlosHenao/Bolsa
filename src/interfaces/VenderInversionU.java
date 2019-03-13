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
import javax.swing.text.JTextComponent;

import Excepciones.EInversion;
import Excepciones.EUsuario;
import Principal.Mercado;
import Principal.Usuario;
import Principal.UtilidadesFicheros;

public class VenderInversionU extends JFrame implements Serializable{

	private JPanel contentPane;
	private Mercado mercado;
	private Usuario usuario;
	private JTable tabloide;
	private JTextField recibeIdInversion;
	private JTextField inflanueva;
	private JTextComponent inflavieja;
	private JTextField petronuevo;
	private JTextComponent petroviejo;
	private JTextField dolarnuevo;
	private JTextComponent dolarviejo;

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
		
		// para crear la tabla 
		
		String [] columns= new String[] {"Tipo", "Codigo", "Proveedor", "Precio"};
		Object datos [][]= new Object[m.getInversiones().length][4];
		for (int i=0;i<m.inversionesPorUsuario(usuario.getId()).length;i++) {
			datos[i][0]=m.inversionesPorUsuario(usuario.getId())[i].getTipo();
			datos[i][1]=m.inversionesPorUsuario(usuario.getId())[i].getCodigo();
			datos[i][2]=m.inversionesPorUsuario(usuario.getId())[i].getIdProv();
			datos[i][3]=m.inversionesPorUsuario(usuario.getId())[i].getPrecioBase();
			
		}
		tabloide= new JTable(datos, columns);
		JScrollPane panel = new JScrollPane(tabloide);
		panel.setBounds(37, 97, 604, 202);
		contentPane.add(panel);
		this.setTitle("Inversiones");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//--------------------------------
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la inversi\u00F3n que desea vender :");
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElId.setBounds(48, 312, 284, 14);
		contentPane.add(lblIngreseElId);
		
		recibeIdInversion = new JTextField();
		recibeIdInversion.setHorizontalAlignment(SwingConstants.CENTER);
		recibeIdInversion.setBounds(342, 310, 139, 20);
		contentPane.add(recibeIdInversion);
		recibeIdInversion.setColumns(10);
		
		JButton vendeInversion = new JButton("Vender Inversi\u00F3n");
		vendeInversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					mercado.venderInversion(recibeIdInversion.getText(), usuario.getId());
					mercado.actualizarVariables();
					mercado.actualizarPrecios();
					UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
					VenderInversionU vi=new VenderInversionU(mercado,usuario);
					vi.setVisible(true);
					dispose();
					
				} catch (EInversion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EUsuario e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			}
		});
		vendeInversion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vendeInversion.setBounds(199, 363, 166, 34);
		contentPane.add(vendeInversion);
		
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
		
		JButton btnActualizarVariables = new JButton("Actualizar Variables");
		btnActualizarVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mercado.actualizarVariables();
				mercado.actualizarPrecios();
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				VenderInversionU ci;
				
				ci = new VenderInversionU(mercado, usuario);
				ci.setVisible(true);
				dispose();
				
			}
		});
		btnActualizarVariables.setBounds(685, 315, 185, 26);
		contentPane.add(btnActualizarVariables);
		
		DecimalFormat df = new DecimalFormat("#.0000");
		
		dolarviejo = new JTextField(df.format(mercado.getVariables()[0].get$dolar()));
		dolarviejo.setEditable(false);
		dolarviejo.setBounds(663, 140, 77, 22);
		contentPane.add(dolarviejo);
		((JTextField) dolarviejo).setColumns(10);
		
		dolarnuevo = new JTextField(df.format(mercado.getVariables()[1].get$dolar()));
		dolarnuevo.setEditable(false);
		dolarnuevo.setColumns(10);
		dolarnuevo.setBounds(767, 140, 77, 22);
		contentPane.add(dolarnuevo);
		
		petroviejo = new JTextField(df.format(mercado.getVariables()[0].get$petroleo()));
		petroviejo.setEditable(false);
		((JTextField) petroviejo).setColumns(10);
		petroviejo.setBounds(663, 212, 77, 22);
		contentPane.add(petroviejo);
		
		petronuevo = new JTextField(df.format(mercado.getVariables()[1].get$petroleo()));
		petronuevo.setEditable(false);
		petronuevo.setColumns(10);
		petronuevo.setBounds(767, 212, 77, 22);
		contentPane.add(petronuevo);
		
		inflavieja = new JTextField(df.format(mercado.getVariables()[0].getInflacion()));
		inflavieja.setEditable(false);
		((JTextField) inflavieja).setColumns(10);
		inflavieja.setBounds(663, 281, 77, 22);
		contentPane.add(inflavieja);
		
		inflanueva = new JTextField(df.format(mercado.getVariables()[1].getInflacion()));
		inflanueva.setEditable(false);
		inflanueva.setColumns(10);
		inflanueva.setBounds(767, 281, 77, 22);
		contentPane.add(inflanueva);
	}
}
