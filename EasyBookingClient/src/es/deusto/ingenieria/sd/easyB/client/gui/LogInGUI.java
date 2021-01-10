package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class LogInGUI {

	private JFrame frmLogIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public LogInGUI() {
		initialize();
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
		
		
		
		
	}
}
