package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BuscarVuelo {

	private JFrame frameBuscador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVuelo window = new BuscarVuelo();
					window.frameBuscador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscarVuelo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameBuscador = new JFrame();
		frameBuscador.setTitle("Buscar Vuelo");
		frameBuscador.setBounds(100, 100, 800, 600);
		frameBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBuscador.getContentPane().setLayout(null);
	}

}
