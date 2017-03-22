package com.example.nicholasesposito.posapp.services;

import com.example.nicholasesposito.posapp.model.Option;

import java.util.ArrayList;
import java.util.Collections;

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

        list.add(new Option("Espresso","espressico",2.10));
        list.add(new Option("Macchiato","macchiatico",2.30,true,"milk"));
        list.add(new Option("Cappuccino","coffeeico",2.70,true,"milk"));
        list.add(new Option("Flat White","coffeeico",2.70,true,"milk"));
        list.add(new Option("Latte","latteico",2.70,true,"milk"));
        list.add(new Option("Americano","americo",2.50));
        list.add(new Option("Filter","filterico",2.70));
        list.add(new Option("Mocha","mochaico",3.00,true,"milk"));
        list.add(new Option("chocolate","chocolateico",2.70,true,"chocolate"));
        list.add(new Option("Tea","teaico",2.30,true,"tea"));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("After Gym","aico",3.80,true,"powder"));
        list.add(new Option("Body Detox","bico",3.80,true,"powder"));
        list.add(new Option("Choco Go","cico",3.80,true,"powder"));
        list.add(new Option("Fancy Beetroot","fico",3.80,true,"powder"));
        list.add(new Option("Fit One","fico",3.80,true,"powder"));
        list.add(new Option("Fresh Start","fico",3.80,true,"powder"));
        list.add(new Option("Mama Love","mico",3.80,true,"powder"));
        list.add(new Option("Naked Green","nico",3.80,true,"powder"));
        list.add(new Option("Simply Orange","sico",3.80,true,"powder"));
        list.add(new Option("Soo healthy","sico",3.80,true,"powder"));
        list.add(new Option("Tree Sweet","tico",3.80,true,"powder"));
        list.add(new Option("Tropical Boost","tico",3.80,true,"powder"));

        return list;
    }

    public ArrayList<Option> getCakesOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("Cake £1.50","cakeico",1.50));
        list.add(new Option("Cake £1.80","cakeico",1.80));
        list.add(new Option("Cake £2.00","cakeico",2.00));
        list.add(new Option("Cake £2.30","cakeico",2.30));
        list.add(new Option("Cake £2.50","cakeico",2.50));
        list.add(new Option("Cake £3.00","cakeico",3.00));
        list.add(new Option("Cake £3.20","cakeico",3.20));
        list.add(new Option("Cake £3.30","cakeico",3.30));
        list.add(new Option("Cake £3.50","cakeico",3.50));

        return list;
    }
}
