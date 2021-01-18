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
			for (AeropuertoDTO a : this.serviceLocator.getService().getAeropuertos()) {
				aeropuertos[i] = a.getCod_aeropuerto();
				i++;
			}
			return aeropuertos;
		} catch (RemoteException e) {
			return null;
		}
		
	}
	
	public AeropuertoDTO getAeropuetoDTO(String cod_Aeropueto) {
		try {
			for (AeropuertoDTO a : this.serviceLocator.getService().getAeropuertos()) {
				if(a.getCod_aeropuerto().equals(cod_Aeropueto)) {
					return a;
				}
			}
		} catch (RemoteException e) {
			return null;
		}
		return null;
	}
	
	public ArrayList<VueloDTO> buscarVuelos(AeropuertoDTO origen, AeropuertoDTO destino, Date fecha, int num_pasajeros) throws RemoteException{
		try {
			return this.serviceLocator.getService().buscarVuelos(origen, destino, fecha, num_pasajeros);
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return null;		
	}

}
