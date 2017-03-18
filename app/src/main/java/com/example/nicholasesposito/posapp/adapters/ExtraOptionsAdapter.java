package com.example.nicholasesposito.posapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.holders.ExtraOptionsViewHolder;
import com.example.nicholasesposito.posapp.model.ExtraOptions;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptionsAdapter extends RecyclerView.Adapter<ExtraOptionsViewHolder> {

    private ArrayList<ExtraOptions> extraOptions;

    public ExtraOptionsAdapter(ArrayList<ExtraOptions> extraOptions) {
        this.extraOptions = extraOptions;
    }

    @Override
    public ExtraOptionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.extra_options_layout,parent,false);
        return new ExtraOptionsViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ExtraOptionsViewHolder holder, int position) {
        final ExtraOptions option = extraOptions.get(position);
        holder.updateUI(option);

    }

    @Override
    public int getItemCount() {
        return extraOptions.size();
    }
}
