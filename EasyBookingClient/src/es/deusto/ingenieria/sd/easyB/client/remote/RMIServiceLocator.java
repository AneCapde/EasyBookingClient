package es.deusto.ingenieria.sd.easyB.client.remote;

public class RMIServiceLocator {

	public RMIServiceLocator() {     
    	if (System.getSecurityManager() == null) {
    		System.setSecurityManager(new SecurityManager());
    	}
    }
	
	   public void setService(String ip, String port, String serviceName) { 
	    	try {
	    		String name = "//" + ip + ":" + port + "/" + serviceName;
	    		//
	    	} catch (Exception ex) {
	    		System.err.println("#ERROR looking up for the remote service: " + ex);
	    	}
	    }
}
