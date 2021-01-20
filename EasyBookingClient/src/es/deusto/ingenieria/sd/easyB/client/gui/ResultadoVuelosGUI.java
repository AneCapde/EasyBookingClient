package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.deusto.ingenieria.sd.easyB.client.controller.BusquedaController;
import es.deusto.ingenieria.sd.easyB.client.controller.ReservaController;
import es.deusto.ingenieria.sd.easyB.server.data.dto.VueloDTO;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ResultadoVuelosGUI {

	private JFrame frameResult;
	private JTable jTable;
	private DefaultTableModel tableModel;
	private JButton btnSeleccionarVuelo;
	private int i;
	private ArrayList<String> nombre_pasajeros = new ArrayList<>();
	private VueloDTO vueloSeleccionado;
	private ReservaController resController;
	double precio;
	static ResultadoVuelosGUI window;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoVuelosGUI window = new ResultadoVuelosGUI();
					window.frameResult.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @param resController 
	 */
	public ResultadoVuelosGUI(ReservaController resController) {
		this.resController = resController;
		initialize();
		frameResult.setVisible(true);
		window = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameResult = new JFrame();
		frameResult.setBounds(100, 100, 800, 600);
		frameResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameResult.getContentPane().setLayout(null);
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] {"COD VUELO", "AEROLINEA", "ORIGEN", "DESTINO", "FECHA", "PRECIO"});
			
		for (VueloDTO v : BuscarVueloGUI.window.vuelosPasados) {
			String[] fila = {v.getCod_vuelo(), v.getAerolinea().getNombre(), v.getAero_origen().getCod_aeropuerto(), v.getAero_destino().getCod_aeropuerto(), v.getSalida().toString(), String.valueOf(v.getPrecio()) };	
			tableModel.addRow(fila);
			
		}
					
	
		jTable = new JTable(tableModel);
		jTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jTable.setBackground(SystemColor.activeCaption);
		jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(114,44, 418, 200);
		frameResult.getContentPane().add(scrollPane);
		
		btnSeleccionarVuelo = new JButton("Seleccionar Vuelo");
		btnSeleccionarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numPasajeros = BuscarVueloGUI.window.numPasajeros;
				for(i = 0; i <  numPasajeros; i++) {
					int pasajero = i+1;
					boolean ok = false;
					String nombre = JOptionPane.showInputDialog("Introduce el nombre del pasajero " + pasajero);	
					while(!ok) {
						if(nombre.equals("")) {
							nombre = JOptionPane.showInputDialog("Introduce el nombre del pasajero " + pasajero);
						}else {
							nombre_pasajeros.add(nombre);
							ok = true;
						}
					}
				}
				if(nombre_pasajeros.size() == numPasajeros) {
					//CONTROLLER --> HACER RESERVA
					vueloSeleccionado = BuscarVueloGUI.window.vuelosPasados.get(jTable.getSelectedRow());
					precio = vueloSeleccionado.getPrecio() * BuscarVueloGUI.window.numPasajeros;
					
					if(resController.reservaVuelos(vueloSeleccionado, precio, BuscarVueloGUI.window.numPasajeros, vueloSeleccionado.getSalida(), nombre_pasajeros)) {
						frameResult.dispose();
						new PagoGUI(resController);
					}else {
						JOptionPane.showMessageDialog(frameResult, "No se ha podido hacer la reserva");
					}
					
				}else {
					JOptionPane.showMessageDialog(frameResult, "Debes introducir el nombre de todos los pasajeros");
				}
			}
		});
		btnSeleccionarVuelo.setBounds(312, 489, 162, 31);
		frameResult.getContentPane().add(btnSeleccionarVuelo);
		
	}
}
