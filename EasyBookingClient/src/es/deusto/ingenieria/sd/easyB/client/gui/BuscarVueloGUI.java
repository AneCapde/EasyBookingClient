package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;

import es.deusto.ingenieria.sd.easyB.client.controller.BusquedaController;
import es.deusto.ingenieria.sd.easyB.client.controller.ReservaController;
import es.deusto.ingenieria.sd.easyB.client.program.MainProgram;
import es.deusto.ingenieria.sd.easyB.server.data.dto.AeropuertoDTO;
import es.deusto.ingenieria.sd.easyB.server.data.dto.VueloDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BuscarVueloGUI {

	private JFrame frameBuscador;
	private BusquedaController busController;
	private ReservaController resController;
	static BuscarVueloGUI window;
	int numPasajeros;
	ArrayList<VueloDTO> vuelosPasados = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the application.
	 * @param busController 
	 */
	public BuscarVueloGUI(BusquedaController busController) {
		initialize();
		window = this;
		this.busController = busController;
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
		lblApOrigen.setBounds(498, 103, 133, 13);
		frameBuscador.getContentPane().add(lblApOrigen);
		
		JComboBox<String> comboBoxApOrigen = new JComboBox<String>();
		comboBoxApOrigen.setBounds(490, 126, 167, 21);
		frameBuscador.getContentPane().add(comboBoxApOrigen);
		for (String s : busController.getAeropuertos()) {
			comboBoxApOrigen.addItem(s);
		}
		
		JLabel lblApDestino = new JLabel("Aeropuerto destino:");
		lblApDestino.setBounds(498, 248, 133, 13);
		frameBuscador.getContentPane().add(lblApDestino);
		
		JComboBox<String> comboBoxApDestino = new JComboBox<String>();
		comboBoxApDestino.setBounds(490, 271, 167, 21);
		frameBuscador.getContentPane().add(comboBoxApDestino);
		//CONTROLLER --> GETAEROPUERTOS
		for (String s : busController.getAeropuertos()) {
			comboBoxApDestino.addItem(s);
		}
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(1.0, 1.0, 3.0, 1.0);  
		JSpinner spinner = new JSpinner(model1);
		spinner.setBounds(44, 463, 99, 21);
		frameBuscador.getContentPane().add(spinner);
		numPasajeros = (Integer) spinner.getValue();
		
		JLabel lblNumPasajeros = new JLabel("N\u00FAmero de pasajeros:");
		lblNumPasajeros.setBounds(44, 440, 189, 13);
		frameBuscador.getContentPane().add(lblNumPasajeros);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AeropuertoDTO ao = busController.getAeropuetoDTO(comboBoxApOrigen.getSelectedItem().toString());
				AeropuertoDTO ad = busController.getAeropuetoDTO(comboBoxApDestino.getSelectedItem().toString());
				
				try {
					vuelosPasados = busController.buscarVuelos(ao, ad, calendar.getDate(), numPasajeros);
					ReservaController resController = new ReservaController(MainProgram.getServiceLocator());
					new ResultadoVuelosGUI(resController);
					frameBuscador.dispose();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnBuscar.setBounds(570, 495, 100, 30);
		frameBuscador.getContentPane().add(btnBuscar);
	}
}
