
package com.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessShipmentRequest_QNAME = new QName("http://example.com/", "processShipmentRequest");
    private final static QName _ProcessShipmentRequestResponse_QNAME = new QName("http://example.com/", "processShipmentRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessShipmentRequest }
     * 
     */
    public ProcessShipmentRequest createProcessShipmentRequest() {
        return new ProcessShipmentRequest();
    }

    /**
     * Create an instance of {@link ProcessShipmentRequestResponse }
     * 
     */
    public ProcessShipmentRequestResponse createProcessShipmentRequestResponse() {
        return new ProcessShipmentRequestResponse();
    }

    /**
     * Create an instance of {@link ShipmentRequest }
     * 
     */
    public ShipmentRequest createShipmentRequest() {
        return new ShipmentRequest();
    }

    /**
     * Create an instance of {@link ShipmentDetail }
     * 
     */
    public ShipmentDetail createShipmentDetail() {
        return new ShipmentDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessShipmentRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProcessShipmentRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/", name = "processShipmentRequest")
    public JAXBElement<ProcessShipmentRequest> createProcessShipmentRequest(ProcessShipmentRequest value) {
        return new JAXBElement<ProcessShipmentRequest>(_ProcessShipmentRequest_QNAME, ProcessShipmentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessShipmentRequestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProcessShipmentRequestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.com/", name = "processShipmentRequestResponse")
    public JAXBElement<ProcessShipmentRequestResponse> createProcessShipmentRequestResponse(ProcessShipmentRequestResponse value) {
        return new JAXBElement<ProcessShipmentRequestResponse>(_ProcessShipmentRequestResponse_QNAME, ProcessShipmentRequestResponse.class, null, value);
    }

}
