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

        list.add(new Option("espresso","espressico",2.10));
        list.add(new Option("macchiato","macchiatico",2.30,true,"milk"));
        list.add(new Option("cappuccino","coffeeico",2.70,true,"milk"));
        list.add(new Option("flat white","coffeeico",2.70,true,"milk"));
        list.add(new Option("latte","latteico",2.70,true,"milk"));
        list.add(new Option("americano","americo",2.50));
        list.add(new Option("filter coffee","filterico",2.70));
        list.add(new Option("mocha","mochaico",3.00,true,"milk"));
        list.add(new Option("hot chocolate","chocolateico",2.70,true,"chocolate"));
        list.add(new Option("tea","teaico",2.30,true,"tea"));

        return list;
    }

    public ArrayList<Option> geDrinksOptions(){
        ArrayList<Option> list = new ArrayList<>();

        list.add(new Option("after gym","aico",3.80,true,"powder"));
        list.add(new Option("body detox","bico",3.80,true,"powder"));
        list.add(new Option("choco go","cico",3.80,true,"powder"));
        list.add(new Option("fancy beetroot","fico",3.80,true,"powder"));
        list.add(new Option("fit one","fico",3.80,true,"powder"));
        list.add(new Option("fresh start","fico",3.80,true,"powder"));
        list.add(new Option("mama love","mico",3.80,true,"powder"));
        list.add(new Option("naked green","nico",3.80,true,"powder"));
        list.add(new Option("simply orange","sico",3.80,true,"powder"));
        list.add(new Option("soo healthy","sico",3.80,true,"powder"));
        list.add(new Option("tree sweet","tico",3.80,true,"powder"));
        list.add(new Option("tropical boost","tico",3.80,true,"powder"));

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
