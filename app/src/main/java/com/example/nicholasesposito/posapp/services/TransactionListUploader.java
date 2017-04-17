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
import java.util.Locale;

/**
 * Created by nicholasesposito on 11/04/2017.
 */

public class TransactionListUploader extends AsyncTask<ArrayList<TransactionObject>,Void,Void> {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private double sales = 0,grossProfit=0;
    private String passedPath = "";
    private String yyy,mmm,ddd,www;
    private ArrayList<TransactionObject> passed;
    private int counter = 0;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(ArrayList<TransactionObject>... arrayLists) {
        passed = arrayLists[0]; //get passed arraylist
        Calendar calendar = Calendar.getInstance();//get today's date to get year, month, week and day
        String year = new SimpleDateFormat("y", Locale.ENGLISH).format(calendar.getTime());
        String monthName = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(calendar.getTime());
        String weekInMonth = new SimpleDateFormat("W", Locale.ENGLISH).format(calendar.getTime());
        String dayName = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(calendar.getTime());
        yyy = year;mmm=monthName;www=weekInMonth;ddd=dayName;//set global variables to be used in inner functions

        for (final TransactionObject object:passed
             ) {//Loop through the transaction objects to be loaded on Firebase
            sales+=object.getPrice();//Calculate sales for the transaction to be uploaded
            myRef.child(year+'/'+monthName+'/'+weekInMonth+'/'+dayName+'/'+object.getName()).runTransaction(new Transaction.Handler() {
                @Override
                public Transaction.Result doTransaction(final MutableData currentData) {//Check if the item already exists for the day
                    if (currentData.getValue() == null) {// if it doesn't exist create an entry
                        currentData.setValue(1);
                    } else {
                        currentData.setValue((Long) currentData.getValue() + 1);//else add an entry to the count
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
                        grossProfitCalculator(value);//for each item get gross profit value and add it to the current sale gross profit

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            upload(sales,"Sales");//upload the current sale value
        return null;
    }

    private void grossProfitCalculator(double value){//Calculate and upload gross profit
        grossProfit+=value;
        counter++;
        if (counter == passed.size())
            upload(grossProfit ,"GrossProfit");
    }

    private void upload(double value,String type){//create the children path for year,month,week and day
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
                uploadGPSales(passedPath+'/'+type,value);//upload Sales/Gross profit to the given path
                if(i==3) passedPath = "";
            }
    }

    private void uploadGPSales(final String path, final double passedValue){//Upload values on Firebase
        myRef.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Double value = setValue(dataSnapshot.getValue());
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

    public Double setValue(Object value) {//If Firebase returns Long, Convert to Double
        Double val = 0.0;
        if (value instanceof Double) {
            val = (Double) value;
        } else if (value instanceof Long) {
            String longVal = value.toString();
            val = Double.parseDouble(longVal);
        }
        return val;
    }

}
