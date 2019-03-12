package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Inversion;
import Principal.Mercado;
import Principal.UtilidadesFicheros;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarInversion extends JFrame {

	private JPanel contentPane;
	private Mercado mercado;
	private Inversion inv;
	private JTextField codigo;
	private JTextField precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m = new Mercado();
					AgregarInversion frame = new AgregarInversion(m);
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
	public AgregarInversion(Mercado m) {
		mercado = m ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddAcc = new JButton("Agregar Accion");
		btnAddAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.addAccion(codigo.getText(), "idProv", "accion", Integer.parseInt(precio.getText()));
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				// POP-UP DE CREACION EXITOSA
				dispose();
			}
		});
		btnAddAcc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddAcc.setBounds(190, 306, 173, 55);
		contentPane.add(btnAddAcc);
		
		JButton btnAddBono = new JButton("Agregar Bono");
		btnAddBono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddBono.setBounds(190, 387, 173, 55);
		contentPane.add(btnAddBono);
		
		JButton btnAddCripto = new JButton("Agregar Criptomoneda");
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
		
		ImageIcon imagen = new ImageIcon("C:\\\\Users\\\\LUIS FELIPE\\\\estructuras\\\\Bolsa\\\\Icons\\\\back.png");
		ImageIcon img = new ImageIcon(imagen.getImage().getScaledInstance(23, 23, java.awt.Image.SCALE_DEFAULT));
		JButton btnRegresar = new JButton("Regresar", img);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRegresar.setBounds(10, 11, 110, 26);
		contentPane.add(btnRegresar);
	}
}
