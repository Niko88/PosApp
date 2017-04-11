package com.example.nicholasesposito.posapp.services;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by nicholasesposito on 11/04/2017.
 */

public class FirebaseService {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Calendar calendar;
    private static final FirebaseService ourInstance = new FirebaseService();

    public static FirebaseService getInstance() {
        return ourInstance;
    }

    private FirebaseService() {
    }

    public void setVAlue(String message){
        calendar = Calendar.getInstance();
        String year = new SimpleDateFormat("y").format(calendar.getTime());
        String monthName = new SimpleDateFormat("MMMM").format(calendar.getTime());
        String weekInMonth = new SimpleDateFormat("W").format(calendar.getTime());
        String dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());
        final DatabaseReference myRef = database.getReference(year+'/'+monthName+'/'+weekInMonth+'/'+dayName+'/'+message);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long data = (Long) dataSnapshot.getValue();
                if(data!=null){
                    int value = dataSnapshot.getValue().hashCode();
                    myRef.setValue(value+1);
                }else {
                    myRef.setValue(1);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
