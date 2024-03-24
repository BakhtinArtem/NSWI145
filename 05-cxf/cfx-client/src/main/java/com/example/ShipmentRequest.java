
package com.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shipmentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipmentRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipmentDetail" type="{http://example.com/}shipmentDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipmentRequest", propOrder = {
    "customerId",
    "shipmentDetail"
})
public class ShipmentRequest {

    protected String customerId;
    protected ShipmentDetail shipmentDetail;

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the shipmentDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentDetail }
     *     
     */
    public ShipmentDetail getShipmentDetail() {
        return shipmentDetail;
    }

    /**
     * Sets the value of the shipmentDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentDetail }
     *     
     */
    public void setShipmentDetail(ShipmentDetail value) {
        this.shipmentDetail = value;
    }

}
