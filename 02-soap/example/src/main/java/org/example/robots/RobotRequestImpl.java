package org.example.robots;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

@jakarta.jws.WebService(endpointInterface = "org.example.robots.IRobotRequest")
public class RobotRequestImpl implements IRobotRequest {

    HashSet<Invoice> invoices = new HashSet<>();

    @Override
    public Invoice processRequest(RobotRequest robotRequest) {
        Random rand = new Random();
        final var invoice = Invoice.builder()
                .model(robotRequest.getModel())
                .quantity(robotRequest.getQuantity())
                .toDate(LocalDateTime.now().plusMonths(1).toString())
                .accountNo(123456789)
                .amount(rand.nextInt(1_000_000))
                .build();
        invoices.add(invoice);
        return invoice;
    }

    @Override
    public Invoice getInvoice(RobotRequest robotRequest) {
        return invoices.stream()
                .filter(it -> it.getQuantity() == robotRequest.getQuantity()
                        && it.getModel().equals(robotRequest.getModel()))
                .findAny()
                .orElse(Invoice.builder().build());
    }
}
