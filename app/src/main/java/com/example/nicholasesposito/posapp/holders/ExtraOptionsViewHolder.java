package com.example.nicholasesposito.posapp.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.model.ExtraOptions;

/**
 * Created by nicholasesposito on 18/03/2017.
 */

public class ExtraOptionsViewHolder extends RecyclerView.ViewHolder {

    TextView extraitemName;
    ImageView dot;

    public ExtraOptionsViewHolder(View itemView) {
        super(itemView);
        this.extraitemName = (TextView) itemView.findViewById(R.id.extraItemName);
        this.dot = (ImageView) itemView.findViewById(R.id.extraOptionsSelectedDot);
    }

    public void updateUI(ExtraOptions option){//In case a single view is modified, its data is updated here
        extraitemName.setText(option.getItemName());
    }

    public void ToggleGreenDotOn(){
        dot.setVisibility(View.VISIBLE);
    }

    public void ToggleGreenDotOff(){
        dot.setVisibility(View.INVISIBLE);
    }
}
