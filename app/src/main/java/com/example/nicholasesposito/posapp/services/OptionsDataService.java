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

        list.add(new Option("Espresso","espresso",2.00));
        list.add(new Option("Cappuccino","cappuccino",2.50));
        list.add(new Option("Flat White","flatwhite",2.70));
        list.add(new Option("Mocha","mocha",2.80));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Beetroot Juice","beetrootjuice",3.75));
        list.add(new Option("Carrot Juice","carrotjuice",3.50));

        return list;
    }

    public ArrayList<Option> getCakesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Chocolate cake","chocolatecake",4.25));
        list.add(new Option("Carrot cake","carrotcake",4.50));
        list.add(new Option("Banana cake","bananacake",3.25));

        return list;
    }

    public ArrayList<Option> getSandwichesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Club sandwich","panino",4.95));

        return list;
    }
}
