package com.example.nicholasesposito.posapp.model;

/**
 * Created by nicholasesposito on 17/03/2017.
 */

public class TransactionObject {

    String SYMBOL = "£ ";

    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactionObject(double price, String name) {
        this.price = price;
        this.name = name;
    }
}
