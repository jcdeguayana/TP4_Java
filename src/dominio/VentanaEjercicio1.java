package dominio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaEjercicio1 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblNombre, lblApellido, lblTelefono, lblFechaNac;
	JTextField txtNombre, txtApellido, txtTelefono, txtFechaNac;
	private JButton btnCerrar;
	
	public VentanaEjercicio1() {
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
	
		
		//Labels
		lblNombre = new JLabel("Nombre");
		
		lblApellido = new JLabel("Apellido");
		
		lblTelefono = new JLabel("Telefono");
		
		lblFechaNac = new JLabel("Fecha Nac.");
		
		//TextFields
		txtNombre = new JTextField();
		txtNombre.setColumns(30);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(30);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(30);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setColumns(30);
		
		
		JButton btnMostrar = new JButton("Mostrar");
		JLabel lblDatos = new JLabel("Los datos ingresados fueron:");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean datosValidos = true;
				if(txtApellido.getText().trim().isEmpty()) {
					txtApellido.setBackground(Color.red);
					datosValidos = false;
				}else {
					txtApellido.setBackground(Color.white);
				}
				
				if(txtFechaNac.getText().trim().isEmpty()) {
					txtFechaNac.setBackground(Color.red);
					datosValidos = false;
				}else {
					txtFechaNac.setBackground(Color.white);
				}
				
				if(txtNombre.getText().trim().isEmpty()) {
					txtNombre.setBackground(Color.red);
					datosValidos = false;
				}else {
					txtNombre.setBackground(Color.white);
				}
				
				if(txtTelefono.getText().trim().isEmpty()) {
					txtTelefono.setBackground(Color.red);
					datosValidos = false;
				}else {
					txtTelefono.setBackground(Color.white);
				}
				
				if (datosValidos) {
		            String nombre = txtNombre.getText().trim();
		            String apellido = txtApellido.getText().trim();
		            String fechaNac = txtFechaNac.getText().trim();
		            String telefono = txtTelefono.getText().trim();

		            lblDatos.setText("<html>Nombre: " + nombre + "<br>Apellido: " + apellido +
		                "<br>Fecha de Nac.: " + fechaNac + "<br>Teléfono: " + telefono + "</html>");
		            txtNombre.setText("");
		            txtApellido.setText("");
		            txtFechaNac.setText("");
		            txtTelefono.setText("");
		        } else {
		            lblDatos.setText("Faltan completar campos obligatorios.");
		        }
			}
		});
		
		
		//btnCerrar-------------->
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();//Cierra solo esta ventana.
			}
		});
	
		//-------------------------------------------
		
		
		
		
		/*lblDatos.setText("Los datos ingresados fueron:");*/
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatos, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblFechaNac, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtFechaNac, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(72)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(54, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(277, Short.MAX_VALUE)
					.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaNac, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addComponent(btnMostrar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDatos)
					.addGap(41)
					.addComponent(btnCerrar)
					.addGap(101))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
		
		
		
		
	}
	
	
	public void cambiarVisible(boolean estado) {
		setVisible(true);
	}
	
	
}
