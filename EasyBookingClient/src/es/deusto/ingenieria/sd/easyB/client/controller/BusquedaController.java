package es.deusto.ingenieria.sd.easyB.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.easyB.server.data.dto.AeropuertoDTO;

public class BusquedaController {

	public RMIServiceLocator serviceLocator;
	
	public BusquedaController(RMIServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public String[] getAeropuertos(){
		try {
			String[] aeropuertos = new String[50];
			int i = 0;
			for (AeropuertoDTO a : serviceLocator.getService().getAeropuertos()) {
				aeropuertos[i] = a.getCod_aeropuerto();
				i++;
			}
			return aeropuertos;
		} catch (RemoteException e) {
			return null;
		}
		
	}
	
	/*public ArrayList<Vuelo> buscarVuelos(Aeropuerto origen, Aeropuerto destino, Date fecha, int num_pasajeros){
		
	}*/
}
