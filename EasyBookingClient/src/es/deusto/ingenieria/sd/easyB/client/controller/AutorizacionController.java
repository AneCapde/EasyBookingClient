package es.deusto.ingenieria.sd.easyB.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;

public class AutorizacionController {
	
	public RMIServiceLocator serviceLocator;
	
	public AutorizacionController(RMIServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password) {
		try {
			return this.serviceLocator.getService().login(email, password);		
		} catch (RemoteException e) {
			System.err.println("# Error durante el LogIn: " + e);
			return false;
		}
	}

}
