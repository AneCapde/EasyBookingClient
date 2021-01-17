package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;

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
		calendar.setBounds(44, 143, 372, 230);
		frameBuscador.getContentPane().add(calendar);
		
		JLabel lblFechaSalida = new JLabel("Fecha de salida del vuelo:");
		lblFechaSalida.setBounds(47, 120, 186, 13);
		frameBuscador.getContentPane().add(lblFechaSalida);
		
		JLabel lblBuscador = new JLabel("Buscador de vuelos. Introduce los siguientes datos:");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscador.setBounds(44, 27, 502, 57);
		frameBuscador.getContentPane().add(lblBuscador);
		
		JLabel lblApOrigen = new JLabel("Aeropuerto origen:");
		lblApOrigen.setBounds(480, 94, 133, 13);
		frameBuscador.getContentPane().add(lblApOrigen);
	}
}
