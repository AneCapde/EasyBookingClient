package es.deusto.ingenieria.sd.easyB.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import es.deusto.ingenieria.sd.easyB.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.easyB.server.data.dto.VueloDTO;

public class ReservaController {

	public RMIServiceLocator serviceLocator;
	
	public ReservaController(RMIServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean realizarPago(String email, String password, double cantidad) {
		try {
			return this.serviceLocator.getService().realizarPago(email, password, cantidad);
		} catch (RemoteException e) {
			System.err.println("# Error durante el pago: " + e);
			return false;
		}
	}
	
	/*public boolean reservaVuelos(VueloDTO vuelo, double importe, int num_pasajeros, Date fecha, ArrayList<String> nombre_pasajeros) {
		try {
			//return this.serviceLocator.getService().reservaVuelos(null, importe, num_pasajeros, fecha, nombre_pasajeros)
			
		} catch (RemoteException e) {
			System.err.println("# Error durante la reserva: " + e);
			return false;
		}
	}*/
}
