package dominio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;


public class VentanaEjercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	
    private JRadioButton rbWindows_1, rbMac_1, rbLinux_1;  
	private ButtonGroup grupoSO;
	private JTextField txtHoras;
	private JCheckBox chckbxDiseno;
	private JCheckBox chckbxProgramacion;
	private JCheckBox chckbxAdministracion;
	

	public VentanaEjercicio3(){
		setTitle("Selección múltiple");
		setSize(537, 303);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		// Agrupo para que solo uno pueda seleccionarse
        grupoSO = new ButtonGroup();
        
        JPanel pnlSistemaOperativo = new JPanel();
        pnlSistemaOperativo.setBounds(14, 39, 476, 37);
        pnlSistemaOperativo.setBorder(new LineBorder(Color.black, 1));
        getContentPane().add(pnlSistemaOperativo);
        
        JLabel lblSistemaOperativo = new JLabel("Elije un Sistema Operativo");
        pnlSistemaOperativo.add(lblSistemaOperativo);
        
        rbMac_1 = new JRadioButton("Mac");
        pnlSistemaOperativo.add(rbMac_1);
        grupoSO.add(rbMac_1);
        
        rbLinux_1 = new JRadioButton("Linux");
        pnlSistemaOperativo.add(rbLinux_1);
        grupoSO.add(rbLinux_1);
        
        rbWindows_1 = new JRadioButton("Windows");
        pnlSistemaOperativo.add(rbWindows_1);
        grupoSO.add(rbWindows_1);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	
        	}
        });
        btnCerrar.setBounds(401, 232, 89, 23);
        getContentPane().add(btnCerrar);
        
        JPanel pnlEspecialidad = new JPanel();
        pnlEspecialidad.setLayout(null);
        pnlEspecialidad.setBounds(14, 94, 476, 87);
        pnlEspecialidad.setBorder(new LineBorder(Color.black, 1));
        getContentPane().add(pnlEspecialidad);
        
        JLabel lblEspecialidad = new JLabel("Elije una especialidad: ");
        lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEspecialidad.setBounds(71, 27, 138, 33);
        pnlEspecialidad.add(lblEspecialidad);
        
        chckbxDiseno = new JCheckBox("Diseño Gráfico");
        chckbxDiseno.setBounds(264, 57, 119, 23);
        pnlEspecialidad.add(chckbxDiseno);
        
        chckbxProgramacion = new JCheckBox("Programación");
        chckbxProgramacion.setBounds(264, 7, 119, 23);
        pnlEspecialidad.add(chckbxProgramacion);
        
        chckbxAdministracion = new JCheckBox("Administración");
        chckbxAdministracion.setBounds(264, 32, 119, 23);
        pnlEspecialidad.add(chckbxAdministracion);
        
        JLabel lblCantHoras = new JLabel("Cantidad de horas en el computador:");
        lblCantHoras.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCantHoras.setBounds(14, 194, 228, 15);
        getContentPane().add(lblCantHoras);
        
        txtHoras = new JTextField();
        txtHoras.setColumns(10);
        txtHoras.setBounds(305, 192, 146, 20);
        getContentPane().add(txtHoras);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(302, 232, 89, 23);
        getContentPane().add(btnAceptar);
        
        btnAceptar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mensajeValidacion = validarSeleccionMultiple();
				if(!mensajeValidacion.isBlank()) {
					JOptionPane.showMessageDialog(btnAceptar, mensajeValidacion, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String sOp = "";
				if(rbWindows_1.isSelected()) sOp = "Windows";
				else if(rbLinux_1.isSelected()) sOp = "Linux";
				else if(rbMac_1.isSelected()) sOp = "Mac";
				
				StringBuilder Especialidad = new StringBuilder();
				if (chckbxProgramacion.isSelected()) Especialidad.append("Programacion - ");
				if (chckbxAdministracion.isSelected()) Especialidad.append("Administracion - ");
				if (chckbxDiseno.isSelected()) Especialidad.append("Diseño grafico - ");
				String Horas = txtHoras.getText().trim() + "hs";
				String MensajeFinal = sOp + " - " + Especialidad + Horas;

				JOptionPane.showMessageDialog(btnAceptar, MensajeFinal, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				Limpiar();
			}
		});
		
	}
	
	public String validarSeleccionMultiple() {
		String mensaje = "";
		if(!validarSeleccionSO()) mensaje += "*Debe seleccionar un sistema operativo \n";
		if(!validarCantidadHoras()) mensaje += "*El campo de horas no puede estar vacío \n";
		if(!validarInputCantidadHoras()) mensaje += "*El campo de horas solo puede recibir numeros enteros \n";
		if (!ValidarEspecialidad()) mensaje += "*Debe seleccionar al menos una especialidad \n";
		
		return mensaje;
	}
	
	public boolean validarCantidadHoras(){
		if(txtHoras.getText().trim().isEmpty()) return false;
		return true;
	}
	public boolean validarInputCantidadHoras(){
		if(txtHoras.getText().trim().matches("\\d+")) return true;
		return false;
	}
	public boolean validarSeleccionSO() {
		if(!rbWindows_1.isSelected() && !rbMac_1.isSelected() && !rbLinux_1.isSelected() ) return false;
		return true;
	}
	public boolean ValidarEspecialidad() {
		if(!chckbxProgramacion.isSelected() && !chckbxAdministracion.isSelected() && !chckbxDiseno.isSelected()) return false;
		return true;
	}
	
	public void Limpiar() {
		txtHoras.setText("");
		chckbxProgramacion.setSelected(false);
		chckbxAdministracion.setSelected(false);
		chckbxDiseno.setSelected(false);
		grupoSO.clearSelection();
	}
}
