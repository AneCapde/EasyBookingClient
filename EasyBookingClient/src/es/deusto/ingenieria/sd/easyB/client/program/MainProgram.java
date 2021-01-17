package es.deusto.ingenieria.sd.easyB.client.program;

import es.deusto.ingenieria.sd.easyB.client.controller.AutorizacionController;
import es.deusto.ingenieria.sd.easyB.client.gui.LogInGUI;
import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		RMIServiceLocator serviceLocator = new RMIServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		AutorizacionController autController = new AutorizacionController(serviceLocator);
		new LogInGUI(autController);
	}
}
