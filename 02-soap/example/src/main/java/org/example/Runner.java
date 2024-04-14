package org.example;

import jakarta.xml.ws.Endpoint;
import org.example.license.LicenseGeneratorImpl;
import org.example.robots.RobotRequestImpl;

public class Runner {
    public static void main(String[] args)
    {
        Endpoint.publish("http://127.0.0.1:8001/LICENSE", new LicenseGeneratorImpl());
        Endpoint.publish("http://127.0.0.1:8001/ROBOTS", new RobotRequestImpl());
    }
}