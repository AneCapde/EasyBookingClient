package es.deusto.ingenieria.sd.easyB.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.easyB.server.data.dto.AeropuertoDTO;
import es.deusto.ingenieria.sd.easyB.server.data.dto.VueloDTO;

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
	
	//HACER ESTE METODO EN EL SERVIDOR
	public ArrayList<VueloDTO> buscarVuelos(AeropuertoDTO origen, AeropuertoDTO destino, Date fecha, int num_pasajeros){
		return null;
	}
}
