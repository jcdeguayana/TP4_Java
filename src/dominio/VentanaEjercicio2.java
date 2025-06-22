package dominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEjercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	private JComboBox<String> comboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio2 frame = new VentanaEjercicio2();
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
	public VentanaEjercicio2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));

		panel.setBounds(36, 22, 296, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota = new JLabel("Nota 1:");
		lblNota.setBounds(48, 48, 46, 14);
		panel.add(lblNota);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setBounds(48, 87, 46, 14);
		panel.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setBounds(48, 124, 46, 14);
		panel.add(lblNota3);
		
		txtN1 = new JTextField();
		txtN1.setBounds(118, 45, 130, 20);
		panel.add(txtN1);
		txtN1.setColumns(10);
		
		txtN2 = new JTextField();
		txtN2.setColumns(10);
		txtN2.setBounds(118, 84, 130, 20);
		panel.add(txtN2);
		
		txtN3 = new JTextField();
		txtN3.setColumns(10);
		txtN3.setBounds(118, 121, 130, 20);
		panel.add(txtN3);
		
		JLabel lblNewLabel = new JLabel("TPS");
		lblNewLabel.setBounds(48, 172, 46, 14);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox<>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Aprobado", "Desaprobado"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(118, 168, 130, 22);
		panel.add(comboBox);
		
		JButton btnCalcular = new JButton("CALCULAR");
		//evento "click"
				btnCalcular.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(validarNotas()) {
							//txtPromedio.setText(String.valueOf(calcularPromedio()));
							txtPromedio.setText(String.format("%.2f", calcularPromedio()));
							txtCondicion.setText(validarCondicion());
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Es necesario completar todas las notas.");
							limpiarCampos();
						}
					}
				});
		btnCalcular.setBounds(353, 105, 118, 23);
		contentPane.add(btnCalcular);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
		panel2.setBounds(36, 270, 296, 108);
		contentPane.add(panel2);
		
		JLabel lblPromedio = new JLabel("Promedio: ");
		lblPromedio.setBounds(16, 30, 82, 14);
		panel2.add(lblPromedio);
		
		txtPromedio = new JTextField();
		txtPromedio.setColumns(10);
		txtPromedio.setBounds(108, 27, 159, 20);
		txtPromedio.setEditable(false);
		panel2.add(txtPromedio);
		
		JLabel lblNewLabel_1 = new JLabel("Condición:");
		lblNewLabel_1.setBounds(16, 66, 82, 14);
		panel2.add(lblNewLabel_1);
		
		txtCondicion = new JTextField();
		txtCondicion.setEditable(false);
		txtCondicion.setBounds(108, 63, 159, 20);
		panel2.add(txtCondicion);
		txtCondicion.setColumns(10);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(353, 150, 118, 23);
		contentPane.add(btnNuevo);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		btnCerrar.setBounds(434, 377, 89, 23);
		contentPane.add(btnCerrar);
		
		
	}
	
	
//----------------------------------------------------------
	
	private double calcularPromedio() {
		double res = 0;
		double nota1 = Double.parseDouble(txtN1.getText());
		double nota2 = Double.parseDouble(txtN2.getText());
		double nota3 = Double.parseDouble(txtN3.getText());
		res = (nota1 + nota2 + nota3) / 3;
		return res;
	}
	
//---------------------------------------------------------------	
	private boolean validarNotas() {
	  try {
		
		if (txtN1.getText().trim().isEmpty() || 
				txtN2.getText().trim().isEmpty() || 
				txtN3.getText().trim().isEmpty()) {
			return false;}
		
		
		Double.parseDouble(txtN1.getText().trim());
		Double.parseDouble(txtN2.getText().trim());
		Double.parseDouble(txtN3.getText().trim());
     	 
	  return true;
	  }
	  
	  catch(NumberFormatException e) {
		  return false;
	  }
		
			
		
	}
	
	
//---------------------------------------------------------	
	
	private void limpiarCampos() {
		    txtN1.setText("");
		    txtN2.setText("");
		    txtN3.setText("");
		    comboBox.setSelectedIndex(-1);
	}

	
	public void cambiarVisible(boolean estado) {
		setVisible(true);
	}
	
	public String validarCondicion() {
		
		// Siempre que el TP esté en condición Desaprobado, la condición es libre 
		if(comboBox.getSelectedItem().equals("Desaprobado")) return "Libre";
		
		// Si alguna de las tres notas del alumno es inferior a 6, 
		// la condición del alumno es libre independientemente de la nota del TP
		if (Double.parseDouble(txtN1.getText().trim()) < 6 || 
			Double.parseDouble(txtN2.getText().trim()) < 6 || 
			Double.parseDouble(txtN3.getText().trim()) < 6 ) return "Libre";
		
		// Si la nota de los tres parciales es superior o igual a 8 y 
		// el TP se encuentra aprobado, entonces la condición es promociona
		if (Double.parseDouble(txtN1.getText().trim()) >= 8 && 
			Double.parseDouble(txtN2.getText().trim()) >= 8 && 
			Double.parseDouble(txtN3.getText().trim()) >= 8 ) return "Promociona";
		
		// Si los tres parciales se encuentran en el rango de notas entre 6 y 8 y
		// el Tp se encuentra aprobado, entonces la condición es regular
		return "Regular";
	}
}
