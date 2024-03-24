package com.example;

public class BankServiceStub {

    public boolean processPayment(String customerId) {
        // Simulating processing delay
        try {
            Thread.sleep(2000); // Simulating a delay of 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Payment processed successfully");
        return true;
    }
}