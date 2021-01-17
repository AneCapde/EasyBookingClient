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
	
	/*public boolean registrarUsuario(String email, String password, String sistemePago, String aeropueto) {
		try {
			//return this.serviceLocator.getService()	....Falta en el método en el IEasyBookingRemoteFacade
		} catch (RemoteException e) {
			System.err.println("# Error durante el registro: " + e);
			return false;
		}
	}*/
	
	

}
