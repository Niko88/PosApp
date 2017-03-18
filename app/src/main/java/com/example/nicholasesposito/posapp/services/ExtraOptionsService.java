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

    public ArrayList<ExtraOptions> getExtraOptions(){
        ArrayList<ExtraOptions> list = new ArrayList<>();

        list.add(new ExtraOptions("Soy Milk",0.80));
        list.add(new ExtraOptions("Rice Milk",0.80));
        list.add(new ExtraOptions("Coconut Milk",0.80));
        list.add(new ExtraOptions("Oat Milk",0.80));

        return list;
    }
}
