package com.gilbert.easyCash.model;

public class Withdraw {

    public int getCustomer_id() {
        return customer_id;
    }

    public double getAmount() {
        return amount;
    }

    public Withdraw(int customer_id, double amount) {
        this.customer_id = customer_id;
        this.amount = amount;
    }

    int customer_id;
    double amount;

}
