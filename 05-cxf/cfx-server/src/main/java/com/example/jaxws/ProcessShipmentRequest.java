
package com.example.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.6.3
 * Sat Mar 23 16:46:36 CET 2024
 * Generated source version: 3.6.3
 */

@XmlRootElement(name = "processShipmentRequest", namespace = "http://example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processShipmentRequest", namespace = "http://example.com/")

public class ProcessShipmentRequest {

    @XmlElement(name = "arg0")
    private com.example.ShipmentRequest arg0;

    public com.example.ShipmentRequest getArg0() {
        return this.arg0;
    }

    public void setArg0(com.example.ShipmentRequest newArg0)  {
        this.arg0 = newArg0;
    }

}
