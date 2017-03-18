package com.example.nicholasesposito.posapp.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.model.ExtraOptions;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptionsViewHolder extends RecyclerView.ViewHolder {

    TextView extraitemName;

    public ExtraOptionsViewHolder(View itemView) {
        super(itemView);
        this.extraitemName = (TextView) itemView.findViewById(R.id.extraItemName);
    }

    public void updateUI(ExtraOptions option){//In case a single view is modified, its data is updated here
        extraitemName.setText(option.getItemName());
    }
}
