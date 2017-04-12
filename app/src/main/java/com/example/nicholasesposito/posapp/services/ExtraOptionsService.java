package com.example.nicholasesposito.posapp.services;

import com.example.nicholasesposito.posapp.model.ExtraOptions;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptionsService {
    private static final ExtraOptionsService ourInstance = new ExtraOptionsService();

    public static ExtraOptionsService getInstance() {
        return ourInstance;
    }

    private ExtraOptionsService() {
    }

    public ArrayList<ExtraOptions> getExtraMilkOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("hazelnut milk",0.20));
        list.add(new ExtraOptions("almond milk",0.20));
        list.add(new ExtraOptions("soya milk",0.20));
        list.add(new ExtraOptions("coconut milk",0.20));
        list.add(new ExtraOptions("oat milk",0.20));
        list.add(new ExtraOptions("rice milk",0.20));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraPowderOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("spirulina",0.50));
        list.add(new ExtraOptions("chlorella",0.50));
        list.add(new ExtraOptions("protein",0.50));
        list.add(new ExtraOptions("chia seeds",0.50));
        list.add(new ExtraOptions("coconut oil",0.50));
        list.add(new ExtraOptions("goji berries",0.50));
        list.add(new ExtraOptions("banana powder",0.50));
        list.add(new ExtraOptions("agave",0.50));
        list.add(new ExtraOptions("wheatgrass powder",0.50));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraChocolateOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("white",0.00));
        list.add(new ExtraOptions("dark",0.00));
        list.add(new ExtraOptions("peanut butter",0.30));
        list.add(new ExtraOptions("banana",0.30));
        list.add(new ExtraOptions("vegan",0.00));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraTeaOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("take away",-0.20));

        return list;
    }
}
