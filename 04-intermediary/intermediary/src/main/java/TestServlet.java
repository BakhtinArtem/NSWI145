

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.soap.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.xml.namespace.QName;


@WebServlet("TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ns = "http://127.0.0.1:8000/LICENSE";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private static String calculateChecksum(String content) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(content.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			final MessageFactory mf = MessageFactory.newInstance();
            final SOAPMessage soapm = mf.createMessage(null, request.getInputStream());
            final SOAPEnvelope envelope = soapm.getSOAPPart().getEnvelope();
            if (envelope.getHeader() == null) {
            	envelope.addHeader();
            }
            final SOAPHeader header = soapm.getSOAPHeader();
            final SOAPBody body = soapm.getSOAPBody();
            
            if (body.hasChildNodes()) {
            	final var checksum = calculateChecksum(body.toString());
            	header.addChildElement(new QName(ns, "checksum")).setTextContent(checksum);
            }
            
            final SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
            try (SOAPConnection soapc = soapcf.createConnection()) {
            	final SOAPMessage soapResponse = soapc.call(soapm, "http://127.0.0.1:8000/LICENSE");
            	final SOAPEnvelope envelopeResponse = soapResponse.getSOAPPart().getEnvelope();
                if (envelopeResponse.getHeader() == null) {
                	envelopeResponse.addHeader();
                }
            	final var checksum = calculateChecksum(soapResponse.getSOAPBody().toString());
            	soapResponse.getSOAPHeader().addChildElement(new QName(ns, "cheksum")).setTextContent(checksum);
            	soapResponse.writeTo(response.getOutputStream());
            }
            catch (Exception ex) {
            	System.out.println(ex.getMessage());
            }            
            
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
