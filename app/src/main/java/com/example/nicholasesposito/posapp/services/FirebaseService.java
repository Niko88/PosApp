package com.example.nicholasesposito.posapp.services;

/**
 * Created by nicholasesposito on 11/04/2017.
 */

public class FirebaseService {
    private static final FirebaseService ourInstance = new FirebaseService();

    public static FirebaseService getInstance() {
        return ourInstance;
    }

    private FirebaseService() {
    }
}
