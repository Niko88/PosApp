package com.example.nicholasesposito.posapp.model;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class Option {
    private String DRAWABLE = "drawable/";

    private String optionTitle;

    public String getOptionTitle() {
        return optionTitle;
    }

    public String getImgUri() {
        return DRAWABLE+imgUri;
    }

    private String imgUri;

    public Option(String optionTitle, String imgUri) {
        this.optionTitle = optionTitle;
        this.imgUri = imgUri;
    }
}
