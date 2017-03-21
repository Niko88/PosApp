package com.example.nicholasesposito.posapp.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.fragments.ExtraOptionsFragment;
import com.example.nicholasesposito.posapp.holders.ExtraOptionsViewHolder;
import com.example.nicholasesposito.posapp.model.ExtraOptions;

import java.util.ArrayList;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptionsAdapter extends RecyclerView.Adapter<ExtraOptionsViewHolder> {

    private ArrayList<ExtraOptions> extraOptions;
    private int toggledOption;
    ExtraOptionsViewHolder previous;
    private boolean toggled;

    public ExtraOptionsAdapter(ArrayList<ExtraOptions> extraOptions) {
        this.extraOptions = extraOptions;
        toggled= false;
    }

    @Override
    public ExtraOptionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.extra_options_layout,parent,false);
        return new ExtraOptionsViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final ExtraOptionsViewHolder holder, final int position) {
        final ExtraOptions option = extraOptions.get(position);
        holder.updateUI(option);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!toggled){
                    holder.ToggleGreenDotOn();
                    toggledOption = position;
                    previous = holder;
                    MainActivity.getMainActivity().addExtra(option);
                    toggled = true;
                }else {
                    previous.ToggleGreenDotOff();
                    holder.ToggleGreenDotOn();
                    previous=holder;
                    MainActivity.getMainActivity().voidExtra(extraOptions.get(toggledOption));
                    MainActivity.getMainActivity().addExtra(option);
                    toggledOption = position;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return extraOptions.size();
    }

}
