package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.easyB.client.controller.AutorizacionController;
import es.deusto.ingenieria.sd.easyB.client.controller.BusquedaController;
import es.deusto.ingenieria.sd.easyB.client.program.MainProgram;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroGUI {

	private JFrame frmRegistro;
	private JTextField textField;
	private JPasswordField passwordField;
	private ButtonGroup btnGroupSistAut = new ButtonGroup();
	private ButtonGroup btnGroupSistPago = new ButtonGroup();
	private AutorizacionController controller;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroGUI window = new RegistroGUI();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public RegistroGUI(AutorizacionController controller) {
		initialize();
		frmRegistro.setVisible(true);
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.setResizable(false);
		frmRegistro.setBounds(100, 100, 800, 600);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		JLabel lblReg = new JLabel("Registrarse usando...");
		lblReg.setBounds(175, 63, 200, 15);
		frmRegistro.getContentPane().add(lblReg);
		
		JRadioButton rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setBounds(175, 105, 103, 21);
		frmRegistro.getContentPane().add(rdbtnGoogle);
		rdbtnGoogle.setSelected(true);
		btnGroupSistAut.add(rdbtnGoogle);
		
		JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		rdbtnFacebook.setBounds(175, 146, 103, 21);
		frmRegistro.getContentPane().add(rdbtnFacebook);
		btnGroupSistAut.add(rdbtnFacebook);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(117, 207, 564, 2);
		frmRegistro.getContentPane().add(separator);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(69, 252, 96, 13);
		frmRegistro.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(175, 249, 228, 19);
		frmRegistro.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 306, 228, 19);
		frmRegistro.getContentPane().add(passwordField);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(69, 309, 84, 13);
		frmRegistro.getContentPane().add(lblPass);
		
		JLabel lblSistPago = new JLabel("Sistema de pago:");
		lblSistPago.setBounds(69, 378, 125, 15);
		frmRegistro.getContentPane().add(lblSistPago);
		
		JRadioButton rdbtnPayPal = new JRadioButton("PayPal");
		rdbtnPayPal.setSelected(true);
		rdbtnPayPal.setBounds(62, 418, 103, 21);
		frmRegistro.getContentPane().add(rdbtnPayPal);
		btnGroupSistPago.add(rdbtnPayPal);
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds(62, 448, 103, 21);
		frmRegistro.getContentPane().add(rdbtnVisa);
		btnGroupSistPago.add(rdbtnVisa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(510, 273, 209, 21);
		frmRegistro.getContentPane().add(comboBox);	
		//CONTROLLER --> GETAEROPUERTOS
		for (String s : controller.getAeropuertos()) {
			comboBox.addItem(s);
		}
		
		JLabel lblAeropuerto = new JLabel("Aeropuerto origen:");
		lblAeropuerto.setBounds(541, 239, 163, 13);
		frmRegistro.getContentPane().add(lblAeropuerto);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			//CONTROLLER --> REGISTRARUSUARIO	
				if(controller.registrarUsuario(textField.getText(), passwordField.getPassword().toString(), 
									btnGroupSistPago.getSelection().getActionCommand(), comboBox.getSelectedItem().toString())) {
					BusquedaController busController = new BusquedaController(MainProgram.getServiceLocator());
					new BuscarVueloGUI(busController);
					frmRegistro.dispose();
				} else {
					JOptionPane.showMessageDialog(frmRegistro, "Error. No se pudo completar el registro.");
					passwordField.setText("");
				}
			}
			
		});
		btnRegistrarse.setBounds(361, 515, 125, 30);
		frmRegistro.getContentPane().add(btnRegistrarse);
		
		
	}
}
