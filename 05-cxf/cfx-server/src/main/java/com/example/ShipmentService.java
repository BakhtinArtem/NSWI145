package com.example;

import javax.jws.WebService;

@WebService(targetNamespace = "http://example.com/", endpointInterface = "com.example.IShipmentService", portName = "ShipmentServicePort", serviceName = "ShipmentService")
public class ShipmentService implements IShipmentService {
	
	private BankServiceStub bankServiceStud;
	
	public ShipmentService() {
		this.bankServiceStud = new BankServiceStub();
	}
	
    @Override
	public ShipmentDetail processShipmentRequest(ShipmentRequest request) {
    	this.bankServiceStud.processPayment(request.getCustomerId());
    	return request.getShipmentDetail();
    }
}
