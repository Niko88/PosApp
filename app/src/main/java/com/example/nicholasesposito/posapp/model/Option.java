package com.example.nicholasesposito.posapp.model;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class Option {
    private String DRAWABLE = "drawable/";

    private String optionTitle;
    double price;

    public boolean isExtraAvailable() {
        return extraAvailable;
    }

    boolean extraAvailable;

    public double getPrice() {
        return price;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public String getImgUri() {
        return DRAWABLE+imgUri;
    }

    private String imgUri;

    public Option(String optionTitle, String imgUri,double itemPrice) {
        this.optionTitle = optionTitle;
        this.imgUri = imgUri;
        this.price = itemPrice;
        this.extraAvailable = false;
    }

    public Option(String optionTitle, String imgUri,double itemPrice, boolean extraAvailable) {
        this.optionTitle = optionTitle;
        this.price = itemPrice;
        this.extraAvailable = extraAvailable;
        this.imgUri = imgUri;
    }
}
