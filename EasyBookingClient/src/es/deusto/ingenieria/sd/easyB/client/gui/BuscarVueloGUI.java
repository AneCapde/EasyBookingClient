package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;

public class BuscarVueloGUI {

	private JFrame frameBuscador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVueloGUI window = new BuscarVueloGUI();
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
	public BuscarVueloGUI() {
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
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(50, 134, 372, 230);
		frameBuscador.getContentPane().add(calendar);
	}
}
