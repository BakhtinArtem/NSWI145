package org.example;

import jakarta.xml.soap.*;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

public class ClientSOAP {
    public static void main(String[] args) {
        try {
            final SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
            try (SOAPConnection soapc = soapcf.createConnection()) {
                MessageFactory mf = MessageFactory.newInstance();
                SOAPMessage soapm = mf.createMessage();

                SOAPPart soapp = soapm.getSOAPPart();
                SOAPEnvelope soape = soapp.getEnvelope();
                SOAPBody soapb = soape.getBody();

                soape.getHeader().detachNode();
                QName licenseReq = new QName("http://license.example.org/", "generateLicense", "temp");
                SOAPElement soapel = soapb.addBodyElement(licenseReq);

                final var arg0 = soapel.addChildElement(new QName(XMLConstants.NULL_NS_URI, "arg0"));
                arg0.addChildElement(new QName(XMLConstants.NULL_NS_URI, "fromDate")).addTextNode("2024-01-01");
                arg0.addChildElement(new QName(XMLConstants.NULL_NS_URI, "serialNumber")).addTextNode("1");
                arg0.addChildElement(new QName(XMLConstants.NULL_NS_URI, "toDate")).addTextNode("2024-01-10");

                final SOAPBody responseBody = soapc.call(soapm, "http://127.0.0.1:8000/LICENSE").getSOAPBody();
                if (responseBody.hasFault()) {
                    System.out.println(responseBody.getFault().getFaultString());
                } else {

                    final QName licenseResponseName =
                            new QName("http://license.example.org/", "generateLicenseResponse");
                    final QName finalResponseName = new QName(XMLConstants.NULL_NS_URI, "return");
                    final QName fromDateResponseName = new QName(XMLConstants.NULL_NS_URI, "fromDate");
                    final QName generatedResponseName = new QName(XMLConstants.NULL_NS_URI, "generated");
                    final QName licenseIdResponseName = new QName(XMLConstants.NULL_NS_URI, "licenseId");
                    final QName serialNumberResponseName = new QName(XMLConstants.NULL_NS_URI, "serialNumber");
                    final QName toDateResponseName = new QName(XMLConstants.NULL_NS_URI, "toDate");

                    final SOAPBodyElement licenseResponse = (SOAPBodyElement)
                            responseBody.getChildElements(licenseResponseName).next();
                    final SOAPBodyElement finalResponse = (SOAPBodyElement)
                            licenseResponse.getChildElements(finalResponseName).next();
                    final SOAPBodyElement fromDateResponse = (SOAPBodyElement)
                            finalResponse.getChildElements(fromDateResponseName).next();
                    final SOAPBodyElement generatedResponse = (SOAPBodyElement)
                            finalResponse.getChildElements(generatedResponseName).next();
                    final SOAPBodyElement licenseIdResponse = (SOAPBodyElement)
                            finalResponse.getChildElements(licenseIdResponseName).next();
                    final SOAPBodyElement serialNumberResponse = (SOAPBodyElement)
                            finalResponse.getChildElements(serialNumberResponseName).next();
                    final SOAPBodyElement toDateResponse = (SOAPBodyElement)
                            finalResponse.getChildElements(toDateResponseName).next();

                    System.out.println(fromDateResponse.getValue());
                    System.out.println(generatedResponse.getValue());
                    System.out.println(licenseIdResponse.getValue());
                    System.out.println(serialNumberResponse.getValue());
                    System.out.println(toDateResponse.getValue());
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SOAPException ex) {
            System.out.println(ex.getMessage());
        }

    }
}