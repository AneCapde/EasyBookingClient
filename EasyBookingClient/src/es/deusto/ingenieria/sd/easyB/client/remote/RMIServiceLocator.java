package es.deusto.ingenieria.sd.easyB.client.remote;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.easyB.server.remote.IEasyBookingRemoteFacade;

public class RMIServiceLocator {
	
	private IEasyBookingRemoteFacade service;

	public RMIServiceLocator() {     
    	if (System.getSecurityManager() == null) {
    		System.setSecurityManager(new SecurityManager());
    	}
    }
	
   public void setService(String ip, String port, String serviceName) { 
    	try {
    		String name = "//" + ip + ":" + port + "/" + serviceName;
    		this.service = (IEasyBookingRemoteFacade) Naming.lookup(name);
     	} catch (Exception ex) {
    		System.err.println("#ERROR looking up for the remote service: " + ex);
    	}
    }
   
   public IEasyBookingRemoteFacade getService() {
	   return this.service;
   }
   
}