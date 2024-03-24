package com.example;

public class ShipmentRequest {
    private String customerId;
    private ShipmentDetail shipmentDetail;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public ShipmentDetail getShipmentDetail() {
		return shipmentDetail;
	}
	public void setShipmentDetail(ShipmentDetail shipmentDetail) {
		this.shipmentDetail = shipmentDetail;
	}
}