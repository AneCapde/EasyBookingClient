package es.deusto.ingenieria.sd.easyB.client.program;

import es.deusto.ingenieria.sd.easyB.client.controller.AutorizacionController;
import es.deusto.ingenieria.sd.easyB.client.controller.BusquedaController;
import es.deusto.ingenieria.sd.easyB.client.controller.ReservaController;
import es.deusto.ingenieria.sd.easyB.client.gui.BuscarVueloGUI;
import es.deusto.ingenieria.sd.easyB.client.gui.LogInGUI;
import es.deusto.ingenieria.sd.easyB.client.gui.PagoGUI;
import es.deusto.ingenieria.sd.easyB.client.gui.RegistroGUI;
import es.deusto.ingenieria.sd.easyB.client.gui.ResultadoVuelosGUI;
import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;

public class MainProgram {

	private static RMIServiceLocator serviceLocator;
	
	public static void main(String[] args) {	
		
		serviceLocator = new RMIServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		AutorizacionController autController = new AutorizacionController(serviceLocator);
		new LogInGUI(autController);

	}
	
	public static RMIServiceLocator getServiceLocator() {
		return serviceLocator;
	}
}
