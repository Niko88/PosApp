package com.example.nicholasesposito.posapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.holders.OptionsViewHolder;
import com.example.nicholasesposito.posapp.model.Option;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class OptionsAdapter extends RecyclerView.Adapter<OptionsViewHolder> {

    private ArrayList<Option> options;

    public OptionsAdapter(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    public OptionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View optionCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_option,parent,false);
        return new OptionsViewHolder(optionCard);
    }

    @Override
    public void onBindViewHolder(OptionsViewHolder holder, int position) {
        final Option option = options.get(position);
        holder.updateUI(option);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailScreen(option);
}
        });
                }

    @Override
    public int getItemCount() {
        return options.size();
    }
}
