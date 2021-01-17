package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagoGUI {

	private JFrame frmPagoPaypal;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoGUI window = new PagoGUI();
					window.frmPagoPaypal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PagoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPagoPaypal = new JFrame();
		frmPagoPaypal.setTitle("Pago PayPal");
		frmPagoPaypal.setBounds(100, 100, 600, 600);
		frmPagoPaypal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPagoPaypal.getContentPane().setLayout(null);
		
		JLabel lblPago = new JLabel("Introduce los datos para realizar el pago");
		lblPago.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPago.setBounds(143, 76, 378, 30);
		frmPagoPaypal.getContentPane().add(lblPago);
		
		JLabel lblN = new JLabel("Email:");
		lblN.setBounds(177, 172, 45, 13);
		frmPagoPaypal.getContentPane().add(lblN);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(177, 195, 220, 20);
		frmPagoPaypal.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 289, 220, 20);
		frmPagoPaypal.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(176, 266, 104, 13);
		frmPagoPaypal.getContentPane().add(lblPassword);
		
		JButton btnConfirmar = new JButton("Confirmar Pago");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//CONTROLLER --> PAGAR
				
			}
		});
		btnConfirmar.setBounds(223, 418, 127, 30);
		frmPagoPaypal.getContentPane().add(btnConfirmar);
	}
}
