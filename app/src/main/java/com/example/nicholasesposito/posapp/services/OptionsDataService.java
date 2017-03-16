package com.example.nicholasesposito.posapp.services;

import com.example.nicholasesposito.posapp.model.Option;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class OptionsDataService {
    private static final OptionsDataService ourInstance = new OptionsDataService();

    public static OptionsDataService getInstance() {
        return ourInstance;
    }

    private OptionsDataService() {
    }

    public ArrayList<Option> getCoffeeOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Espresso","espresso"));
        list.add(new Option("Cappuccino","cappuccino"));
        list.add(new Option("Flat White","flatwhite"));
        list.add(new Option("Mocha","mocha"));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Beetroot Juice","beetrootjuice"));
        list.add(new Option("Carrot Juice","carrotjuice"));

        return list;
    }

    public ArrayList<Option> getCakesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Chocolate cake","chocolatecake"));
        list.add(new Option("Carrot cake","carrotcake"));
        list.add(new Option("Banana cake","bananacake"));

        return list;
    }
}
