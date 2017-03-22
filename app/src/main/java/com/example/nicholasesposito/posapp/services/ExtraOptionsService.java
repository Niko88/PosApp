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

        list.add(new ExtraOptions("Hazelnut Milk",0.20));
        list.add(new ExtraOptions("Almond Milk",0.20));
        list.add(new ExtraOptions("Soya Milk",0.20));
        list.add(new ExtraOptions("Coconut Milk",0.20));
        list.add(new ExtraOptions("Oat Milk",0.20));
        list.add(new ExtraOptions("Rice Milk",0.20));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraPowderOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("Spirulina",0.50));
        list.add(new ExtraOptions("Chlorella",0.50));
        list.add(new ExtraOptions("Protein",0.50));
        list.add(new ExtraOptions("Chia Seeds",0.50));
        list.add(new ExtraOptions("Coconut Oil",0.50));
        list.add(new ExtraOptions("Goji Berry",0.50));
        list.add(new ExtraOptions("Banana Powder",0.50));
        list.add(new ExtraOptions("Agave",0.50));
        list.add(new ExtraOptions("Wheatgrass",0.50));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraChocolateOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("White",0.00));
        list.add(new ExtraOptions("Dark",0.00));
        list.add(new ExtraOptions("Milk",0.00));
        list.add(new ExtraOptions("Peanut Butter",0.30));
        list.add(new ExtraOptions("Banana",0.30));
        list.add(new ExtraOptions("Vegan",0.00));

        return list;
    }

    public ArrayList<ExtraOptions> getExtraTeaOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("Take Away",-0.20));

        return list;
    }
}
