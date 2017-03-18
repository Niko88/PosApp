package com.example.nicholasesposito.posapp.holders;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.model.Option;

/**
 * Created by nicholasesposito on 16/03/2017.
 */

public class OptionsViewHolder extends RecyclerView.ViewHolder{
    //ViewHolder class for the options items, ViewHolder manages how the view its displayed

    private ImageView mainImage;
    private TextView TitleTextView;

    public OptionsViewHolder(View itemView) {//When the adapter creates a new ViewHolder this is its constructor
        super(itemView);

        this.mainImage = (ImageView) itemView.findViewById(R.id.main_image);
        this.TitleTextView = (TextView) itemView.findViewById(R.id.main_text);
    }

    public void updateUI(Option option){//In case a single view is modified, its data is updated here
        String uri = option.getImgUri();
        int resource = mainImage.getResources().getIdentifier(uri,null,mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);
        TitleTextView.setText(option.getOptionTitle());
    }

}
