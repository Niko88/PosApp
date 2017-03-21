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

        list.add(new Option("Espresso","espresso",2.10));
        list.add(new Option("Macchiato","macchiato",2.30,true));
        list.add(new Option("Cappuccino","cappuccino",2.70,true));
        list.add(new Option("Flat White","flatwhite",2.70,true));
        list.add(new Option("Latte","cappuccino",2.70,true));
        list.add(new Option("Americano","espresso",2.50));
        list.add(new Option("Filter","macchiato",2.70));
        list.add(new Option("Mocha","mocha",3.00,true));
        list.add(new Option("Hot chocolate","mocha",2.70,true));
        list.add(new Option("Peanut Butter chocolate","mocha",3.00,true));
        list.add(new Option("Banana chocolate","mocha",3.00,true));
        list.add(new Option("Vegan chocolate","mocha",2.70,true));
        list.add(new Option("Tea","mocha",3.00,true));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Soo healthy","beetrootjuice",3.80));
        list.add(new Option("Mama Love","carrotjuice",3.80));
        list.add(new Option("Tropical Boost","beetrootjuice",3.80));
        list.add(new Option("Body Detox","carrotjuice",3.80));
        list.add(new Option("After Gym","beetrootjuice",3.80));
        list.add(new Option("Fit One","carrotjuice",3.80));
        list.add(new Option("Choco Go","beetrootjuice",3.80));
        list.add(new Option("Naked Green","carrotjuice",3.80));
        list.add(new Option("Simply Orange","beetrootjuice",3.80));
        list.add(new Option("Fresh Start","carrotjuice",3.80));
        list.add(new Option("Fancy Beetroot","carrotjuice",3.80));
        list.add(new Option("Tree Sweet","beetrootjuice",3.80));

        return list;
    }

    public ArrayList<Option> getCakesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Cake £1.50","chocolatecake",1.50));
        list.add(new Option("Cake £1.80","chocolatecake",1.80));
        list.add(new Option("Cake £2.00","chocolatecake",2.00));
        list.add(new Option("Cake £2.30","chocolatecake",2.30));
        list.add(new Option("Cake £2.50","chocolatecake",2.50));
        list.add(new Option("Cake £3.00","chocolatecake",3.00));
        list.add(new Option("Cake £3.20","chocolatecake",3.20));
        list.add(new Option("Cake £3.30","chocolatecake",3.30));
        list.add(new Option("Cake £3.50","chocolatecake",3.50));

        return list;
    }

    public ArrayList<Option> getSandwichesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Club sandwich","panino",4.95));

        return list;
    }
}
