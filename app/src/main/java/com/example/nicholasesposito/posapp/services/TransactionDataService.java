package com.example.nicholasesposito.posapp.services;

import com.example.nicholasesposito.posapp.model.TransactionObject;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 17/03/2017.
 */

public class TransactionDataService {
    private static final TransactionDataService ourInstance = new TransactionDataService();

    public static TransactionDataService getInstance() {
        return ourInstance;
    }

    private TransactionDataService() {
    }

    private ArrayList<TransactionObject> list = new ArrayList<>();

    public ArrayList<TransactionObject> getTransactions(){
//        list.add(new TransactionObject(2.00,"Espresso"));
//        list.add(new TransactionObject(2.50,"Cappuccino"));
//        list.add(new TransactionObject(3.60,"Carrot Cake"));
//        list.add(new TransactionObject(2.00,"Espresso"));
        return list;
    }

    public void addiTem(double price,String name){
        list.add(new TransactionObject(price,name));
    }
    public void removeItems(){ list.clear();}
    public void removeItem(int position){ list.remove(position);}
    public double getItemPrice(int position){
        return list.get(position).getPrice();
    }
}
