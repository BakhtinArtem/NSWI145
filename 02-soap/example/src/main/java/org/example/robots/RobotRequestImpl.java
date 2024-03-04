package org.example.robots;

import java.time.LocalDateTime;
import java.util.Random;

@jakarta.jws.WebService(endpointInterface = "org.example.robots.IRobotRequest")
public class RobotRequestImpl implements IRobotRequest {
    @Override
    public Invoice processRequest(RobotRequest robotRequest) {
        Random rand = new Random();
        return Invoice.builder()
                .model(robotRequest.getModel())
                .quantity(robotRequest.getQuantity())
                .toDate(LocalDateTime.now().plusMonths(1).toString())
                .accountNo(123456789)
                .amount(rand.nextInt(1_000_000))
                .build();
    }
}
