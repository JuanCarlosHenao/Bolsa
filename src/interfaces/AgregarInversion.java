package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Accion;
import Principal.Inversion;
import Principal.Mercado;
import Principal.UtilidadesFicheros;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AgregarInversion extends JFrame {

	private JPanel contentPane;
	private Mercado mercado;
	private Inversion inv;
	private JTextField codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercado m= new Mercado();
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
		getContentPane().setLayout(null);
		
		JButton addBono = new JButton("añadir bono");
		addBono.setBounds(163, 77, 97, 25);
		getContentPane().add(addBono);
		mercado=m;
		getContentPane().setLayout(null);
		
		codigo = new JTextField();
		codigo.setBounds(91, 93, 116, 22);
		getContentPane().add(codigo);
		codigo.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addAccion = new JButton("agregar");
		addAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				m.addAccion(codigo, idProv, tipo, precioBase);
				UtilidadesFicheros.escribirDatosMercado("mercado.datos", mercado);
				Mensaje m=new mensaje;
				dispose();
			}
		});
		addAccion.setBounds(130, 190, 97, 25);
		contentPane.add(addAccion);
	}
}
