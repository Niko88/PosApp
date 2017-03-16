package com.example.nicholasesposito.posapp.services;

import com.example.nicholasesposito.posapp.model.Option;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Option> getCoffeeOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Club Sandwich","panino"));
        list.add(new Option("BLT Sandwich","panino"));
        list.add(new Option("Spanish Sandwich","panino"));
        list.add(new Option("Italian Sandwich","panino"));
        list.add(new Option("Banana Sandwich","panino"));
        list.add(new Option("Club Sandwich","panino"));
        list.add(new Option("Club Sandwich","panino"));
        list.add(new Option("Club Sandwich","panino"));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Coke","panino"));
        list.add(new Option("Fanta","panino"));
        list.add(new Option("Sprite","panino"));

        return list;
    }
}
