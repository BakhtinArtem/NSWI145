package com.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "IShipmentService", targetNamespace = "http://example.com/")
public interface IShipmentService {

	@WebMethod(operationName = "processShipmentRequest", action = "urn:ProcessShipmentRequest")
	ShipmentDetail processShipmentRequest(ShipmentRequest request);

}