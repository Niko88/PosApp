package com.example.nicholasesposito.posapp.model;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptions {

    private String itemName;
    private double itemPrice;

    public ExtraOptions(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
