package org.example.robots;

@lombok.Data
@lombok.Builder
public class Invoice {
    private String model;
    private int quantity;
    private String toDate;
    private int amount;
    private int accountNo;
}
