package com.example.nicholasesposito.posapp.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.model.TransactionObject;
import com.example.nicholasesposito.posapp.services.TransactionDataService;

/**
 * Created by nicholasesposito on 17/03/2017.
 */

public class TransactionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    //ViewHolder class for the transaction items, ViewHolder manages how the view its displayed

    private TextView name, price;
    private ImageView eraseButton;

    public TransactionViewHolder(View itemView) {//When the adapter creates a new ViewHolder this is its constructor
        super(itemView);

        this.name = (TextView) itemView.findViewById(R.id.itemName);
        this.price = (TextView) itemView.findViewById(R.id.itemPrice);
        this.eraseButton = (ImageView) itemView.findViewById(R.id.cancel_button);
        eraseButton.setOnClickListener(this);
    }

    public void updateUI(TransactionObject object){//In case a single view is modified, its data is updated here
        name.setText(object.getName());
        double objectPrice = object.getPrice();
        price.setText(String.format( "£ %.2f", objectPrice));
    }

    // onClick Listener for view
    @Override
    public void onClick(View v) {
        if (v.getId() == eraseButton.getId()){
            MainActivity.getMainActivity().RemoveTransactionItem(getAdapterPosition(),TransactionDataService.getInstance().getItemPrice(getAdapterPosition()));
        }
    }
}
