package com.example.nicholasesposito.posapp.services;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.model.TransactionObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by nicholasesposito on 11/04/2017.
 */

public class TransactionListUploader extends AsyncTask<ArrayList<TransactionObject>,Void,Void> {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    Calendar calendar;
    double sales = 0,grossProfit=0;
    String passedPath = "";
    String yyy,mmm,ddd,www;
    ArrayList<TransactionObject> passed;
    int counter = 0;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(MainActivity.getMainActivity(),"Uploading Data",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(ArrayList<TransactionObject>... arrayLists) {
        passed = arrayLists[0]; //get passed arraylist
        calendar = Calendar.getInstance();
        String year = new SimpleDateFormat("y").format(calendar.getTime());
        String monthName = new SimpleDateFormat("MMMM").format(calendar.getTime());
        String weekInMonth = new SimpleDateFormat("W").format(calendar.getTime());
        String dayName = new SimpleDateFormat("EEEE").format(calendar.getTime());
        yyy = year;mmm=monthName;www=weekInMonth;ddd=dayName;

        for (final TransactionObject object:passed
             ) {
            sales+=object.getPrice();
            myRef.child(year+'/'+monthName+'/'+weekInMonth+'/'+dayName+'/'+object.getName()).runTransaction(new Transaction.Handler() {
                @Override
                public Transaction.Result doTransaction(final MutableData currentData) {
                    if (currentData.getValue() == null) {
                        currentData.setValue(1);
                    } else {
                        currentData.setValue((Long) currentData.getValue() + 1);
                    }
                    return Transaction.success(currentData);
                }

                @Override
                public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                    if (databaseError != null) {
                        Log.d("Firebase fail","");
                    } else {
                        Log.d("Firebase success","");
                    }
                }
            });

            myRef.child("products/"+object.getName()+"/CostProfit/GrossProfit").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Double value = (Double) dataSnapshot.getValue();
                        grossProfitCalculator(value);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            upload(sales,"Sales");
        return null;
    }

    private void grossProfitCalculator(double value){
        grossProfit+=value;
        counter++;
        if (counter == passed.size())
            upload(grossProfit ,"GrossProfit");
    }

    private void upload(double value,String type){
            for(int i = 0; i<4;i++){
                switch (i){
                    case 0:
                        passedPath+=yyy;
                        break;
                    case 1:
                        passedPath+='/'+mmm;
                        break;
                    case 2:
                        passedPath+='/'+www;
                        break;
                    case 3:
                        passedPath+='/'+ddd;
                }
                uploadGPSales(passedPath+'/'+type,value);
                if(i==3) passedPath = "";
                Log.d("Upload",passedPath+'/'+type+" val "+value);
            }
    }

    private void uploadGPSales(final String path, final double passedValue){
        myRef.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Double value = (Double) dataSnapshot.getValue();
                    if(value!=null){
                        myRef.child(path).setValue(value+passedValue);
                    }else {
                        myRef.child(path).setValue(passedValue);
                    }
                }catch (Exception e){
                    Log.d("Error catched",e.toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
