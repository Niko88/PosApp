package com.example.nicholasesposito.posapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.holders.TransactionViewHolder;
import com.example.nicholasesposito.posapp.model.TransactionObject;
import com.example.nicholasesposito.posapp.services.TransactionDataService;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 17/03/2017.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {

    private ArrayList<TransactionObject> transactionObjects;

    public TransactionAdapter(ArrayList<TransactionObject> transactionObjects) {
        this.transactionObjects = transactionObjects;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_layout,parent,false);
        return new TransactionViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        final TransactionObject item = transactionObjects.get(position);
        holder.updateUI(item);

        //method link to mainActivity

    }

    @Override
    public int getItemCount() {
        return transactionObjects.size();
    }

}
