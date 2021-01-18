package es.deusto.ingenieria.sd.easyB.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.easyB.server.data.dto.AeropuertoDTO;

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
	
	public boolean registrarUsuario(String email, String password, String sistemePago, String cod_aeropueto) {
		try {
			return this.serviceLocator.getService().registrarUsuario(email, password, sistemePago, cod_aeropueto);
		} catch (RemoteException e) {
			System.err.println("# Error durante el registro: " + e);
			return false;
		}
	}
	
	public String[] getAeropuertos(){
		try {
			String[] aeropuertos = new String[50];
			int i = 0;
			for (AeropuertoDTO a : this.serviceLocator.getService().getAeropuertos()) {
				aeropuertos[i] = a.getCod_aeropuerto();
				i++;
			}
			return aeropuertos;
		} catch (RemoteException e) {
			return null;
		}
		
	}
	
	

}
