package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import es.deusto.ingenieria.sd.easyB.client.controller.AutorizacionController;

import javax.swing.JPasswordField;

public class LogInGUI {

	private JFrame frmLogIn;
	private JTextField textFieldemail;
	private JPasswordField passwordField;
	private AutorizacionController controller;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInGUI window = new LogInGUI();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LogInGUI(AutorizacionController controller) {
		initialize();
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setResizable(false);
		frmLogIn.setTitle("Log In");
		frmLogIn.setBounds(100, 100, 800, 600);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(41, 34, 230, 140);
		Image logo = new ImageIcon("img" + File.separator + "logoEBooking.jpg").getImage();
		ImageIcon logoScaled =new ImageIcon(logo.getScaledInstance(230, 140, Image.SCALE_SMOOTH));
		lblLogo.setIcon(logoScaled);
		frmLogIn.getContentPane().add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("Plataforma para buscar y reservar vuelos.");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		lblNewLabel.setBounds(297, 50, 464, 140);
		frmLogIn.getContentPane().add(lblNewLabel);
		
		textFieldemail = new JTextField();
		textFieldemail.setBounds(230, 281, 220, 20);
		frmLogIn.getContentPane().add(textFieldemail);
		textFieldemail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(183, 284, 45, 13);
		frmLogIn.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(150, 328, 78, 13);
		frmLogIn.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Iniciar Sesi\u00F3n");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(controller.login(textFieldemail.getText(), passwordField.getPassword().toString())) {
					new BuscarVueloGUI();
					frmLogIn.dispose();
				} else {
					JOptionPane.showMessageDialog(frmLogIn, "LogIn incorrecto");
					passwordField.setText("");
				}
				
			}
		});
		btnLogIn.setBounds(274, 381, 129, 27);
		frmLogIn.getContentPane().add(btnLogIn);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(481, 212, 24, 234);
		frmLogIn.getContentPane().add(separator);
		
		JLabel lblRegistro = new JLabel("\u00BFNo tienes una cuenta creada?");
		lblRegistro.setBounds(542, 306, 204, 17);
		frmLogIn.getContentPane().add(lblRegistro);
		
		JButton btnRegistro = new JButton("Registrarse\r\n");
		btnRegistro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new RegistroGUI(controller);
				frmLogIn.dispose();
			}
		});
		btnRegistro.setBounds(577, 343, 105, 21);
		frmLogIn.getContentPane().add(btnRegistro);
		
		JLabel lblLogIn = new JLabel("Introduce tus datos para iniciar sesi\u00F3n:");
		lblLogIn.setBounds(217, 225, 254, 13);
		frmLogIn.getContentPane().add(lblLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 325, 220, 19);
		frmLogIn.getContentPane().add(passwordField);
		
		
		
		
	}
}
