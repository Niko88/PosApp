package com.example.nicholasesposito.posapp.model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by nicholasesposito on 17/03/2017.
 */

public class TransactionObject {

    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactionObject(double price, String name) {
        this.price = price;
        if(name.contains("Cake"))
            name = "Cake";
        this.name = name;
    }
}
