package dominio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//como dice en el texto autogenerado, sirve para ejecutar la ventana principal
	public static void ejecutarVentanaPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("TP4 - Laboratorio IV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupo = new JLabel("Grupo 14");
		lblGrupo.setBounds(49, 29, 74, 20);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblGrupo);
		
		
		
		
		//-----------------------------------------------------
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio1 ventana1 = new VentanaEjercicio1();
				ventana1.setVisible(true);
			}
				
		});
		btnEjercicio1.setBounds(153, 66, 142, 23);
		contentPane.add(btnEjercicio1);
		//-----------------------------------------------------------
	
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio2 ventana2 = new VentanaEjercicio2();
				ventana2.setVisible(true);
			}
		});
		btnEjercicio2.setBounds(153, 102, 142, 23);
		contentPane.add(btnEjercicio2);
				
		//------------------------------------------------------------
		
		
		
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEjercicio3 ventana3 = new VentanaEjercicio3();
				ventana3.setVisible(true);
				
			}
		});
		btnEjercicio3.setBounds(153, 136, 142, 23);
		contentPane.add(btnEjercicio3);
		
		
		
	}

}
