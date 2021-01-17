package es.deusto.ingenieria.sd.easyB.client.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JList;

public class ResultadoVuelosGUI {

	private JFrame frameResult;
	private JTable jTable;
	private DefaultTableModel tableModel;

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
		
		
	}
}
