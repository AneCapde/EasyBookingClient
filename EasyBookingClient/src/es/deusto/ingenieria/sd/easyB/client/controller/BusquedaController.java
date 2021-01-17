package es.deusto.ingenieria.sd.easyB.client.controller;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;

public class BusquedaController {

	public RMIServiceLocator serviceLocator;
	
	public BusquedaController(RMIServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	
}
