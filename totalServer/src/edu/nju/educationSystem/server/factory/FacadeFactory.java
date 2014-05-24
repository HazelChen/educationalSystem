package edu.nju.educationSystem.server.factory;

import edu.nju.educationSystem.server.service.ServiceFacade;

public class FacadeFactory {
	private static FacadeFactory self;

	private ServiceFacade serviceFacade;
	
	private FacadeFactory(){}
	
	public static FacadeFactory getInstance() {
		if (self == null) {
			self = new FacadeFactory();
		}
		return self; 
	}
	
	public ServiceFacade getServiceFacade() {
		if (serviceFacade == null) {
			serviceFacade = new ServiceFacade();
		}
		return serviceFacade;
	}
}
