package org.example.robots;

@jakarta.jws.WebService
public interface IRobotRequest {

    @jakarta.jws.WebMethod
    Invoice processRequest(RobotRequest robotRequest);
}
