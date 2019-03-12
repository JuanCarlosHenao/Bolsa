package interfaces;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Principal.Inversion;
import Principal.Mercado;
import Principal.Proveedor;
import Principal.UtilidadesFicheros;

public class AgregarInversion extends JFrame implements Serializable {

	private JPanel contentPane;
	private Mercado mercado;
	private Inversion inv;
	private JTextField codigo;
	private JTextField precio;
	private Proveedor proveedor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					Proveedor p=new Proveedor();
					AgregarInversion frame = new AgregarInversion(m,p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param prov 
	 */
	public AgregarInversion(Mercado m, Proveedor prov) {
		mercado = m ;
		proveedor=prov;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntradaProveedor p=new EntradaProveedor(mercado,proveedor);
				p.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
		JButton btnAddAcc = new JButton("Agregar Accion");
		btnAddAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.addAccion(codigo.getText(), proveedor.getId(), "Accion", Integer.parseInt(precio.getText()));
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				AgregarInversion ai=new AgregarInversion(mercado,proveedor);
				ai.setVisible(true);
				dispose();
				// POP-UP DE CREACION EXITOSA
				
			}
		});
		btnAddAcc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddAcc.setBounds(190, 306, 173, 55);
		contentPane.add(btnAddAcc);
		
		JButton btnAddBono = new JButton("Agregar Bono");
		btnAddBono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//m.addBono(codigo.getText(), "idProv", "accion", Integer.parseInt(precio.getText()));
				//UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				dispose();
				mercado.addBono(codigo.getText(), proveedor.getId(), "Bono",Integer.parseInt(precio.getText()) );
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				AgregarInversion ai=new AgregarInversion(mercado,proveedor);
				ai.setVisible(true);
				dispose();
				
			}
		});
		btnAddBono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddBono.setBounds(190, 387, 173, 55);
		contentPane.add(btnAddBono);
		
		JButton btnAddCripto = new JButton("Agregar Criptomoneda");
		btnAddCripto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mercado.addCriptoMoneda(codigo.getText(), proveedor.getId(), "Criptomoneda",Integer.parseInt(precio.getText()) );
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				AgregarInversion ai=new AgregarInversion(mercado,proveedor);
				ai.setVisible(true);
				dispose();
				
			}
		});
		btnAddCripto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddCripto.setBounds(190, 473, 173, 55);
		contentPane.add(btnAddCripto);
		
		JLabel lblSeleccionarTipoDe = new JLabel("Seleccionar tipo de inversi\u00F3n :");
		lblSeleccionarTipoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeleccionarTipoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarTipoDe.setBounds(161, 255, 230, 14);
		contentPane.add(lblSeleccionarTipoDe);
		
		JLabel lblCdigoDeLa = new JLabel("C\u00F3digo de la inversi\u00F3n : ");
		lblCdigoDeLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigoDeLa.setBounds(78, 102, 140, 14);
		contentPane.add(lblCdigoDeLa);
		
		codigo = new JTextField();
		codigo.setBounds(253, 95, 110, 31);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblPrecioDeLa = new JLabel("Precio de la inversi\u00F3n : ");
		lblPrecioDeLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecioDeLa.setBounds(78, 186, 127, 14);
		contentPane.add(lblPrecioDeLa);
		
		precio = new JTextField();
		precio.setBounds(253, 178, 110, 31);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblAgregarUnaInversin = new JLabel("Agregar una inversi\u00F3n");
		lblAgregarUnaInversin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUnaInversin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarUnaInversin.setBounds(166, 31, 207, 26);
		contentPane.add(lblAgregarUnaInversin);
		
		imagen = new ImageIcon("Icons\\\\back.png");
		img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
		
	
	}
}
