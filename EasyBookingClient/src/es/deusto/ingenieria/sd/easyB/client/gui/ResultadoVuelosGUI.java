package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ResultadoVuelosGUI {

	private JFrame frameResult;
	private JTable jTable;
	private DefaultTableModel tableModel;
	private JButton btnSeleccionarVuelo;
	private int i;
	private ArrayList<String> nombre_pasajeros = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public ResultadoVuelosGUI() {
		initialize();
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
		tableModel.setColumnIdentifiers(new String[] {"Aerolínea", "Fecha", "Hora", "Precio"});
			

		String[] fila = {"Iberia", "12/12/2020", "12:32", "50"};
		String[] fila2 = {"Vueling", "12/12/2020", "12:32", "50"};
		tableModel.addRow(fila);
		tableModel.addRow(fila2);
					
	
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
				//int numPasajeros = BuscarVueloGUI.window.numPasajeros;
				for(i = 0; i <  4; i++) {
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
				if(nombre_pasajeros.size() == 4) {
					//CONTROLLER --> HACER RESERVA
					
				}else {
					JOptionPane.showMessageDialog(frameResult, "Debes introducir el nombre de todos los pasajeros");
				}
			}
		});
		btnSeleccionarVuelo.setBounds(312, 489, 162, 31);
		frameResult.getContentPane().add(btnSeleccionarVuelo);
		
	}
}
