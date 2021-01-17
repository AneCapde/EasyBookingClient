package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DatosPasajerosGUI {

	private JFrame frmDatosPasajeros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosPasajerosGUI window = new DatosPasajerosGUI();
					window.frmDatosPasajeros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatosPasajerosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatosPasajeros = new JFrame();
		frmDatosPasajeros.setBounds(100, 100, 800, 600);
		frmDatosPasajeros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatosPasajeros.getContentPane().setLayout(null);
		
		JPanel panel_Pasajero2 = new JPanel();
		panel_Pasajero2.setBounds(61, 234, 533, 207);
		frmDatosPasajeros.getContentPane().add(panel_Pasajero2);
		panel_Pasajero2.setLayout(null);
	}
}
