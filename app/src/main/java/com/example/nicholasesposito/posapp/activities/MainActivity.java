package com.example.nicholasesposito.posapp.activities;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.fragments.ExtraOptionsFragment;
import com.example.nicholasesposito.posapp.fragments.OptionsFragment;
import com.example.nicholasesposito.posapp.fragments.PaymentFragment;
import com.example.nicholasesposito.posapp.fragments.TransactionFragment;
import com.example.nicholasesposito.posapp.model.ExtraOptions;
import com.example.nicholasesposito.posapp.model.Option;
import com.example.nicholasesposito.posapp.model.TransactionObject;
import com.example.nicholasesposito.posapp.services.TransactionDataService;
import com.example.nicholasesposito.posapp.services.TransactionListUploader;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Global Variables
    private Button coffeeButton, drinkButton, cakeButton, sandwichButton, menuButton,chargeButton;
    private FragmentManager fm = getSupportFragmentManager();
    private ExtraOptionsFragment dialogFragment;
    double currentCharge = 0;
    private static MainActivity mainActivity;
    //Getter and setter for context reference to the Application
    public static MainActivity getMainActivity() {
        return mainActivity;
    }
    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);
        //On creating the activity the context is set and the coffee options are put in the view's fragment
        OptionsFragment coffeeFragment = (OptionsFragment) fm.findFragmentById(R.id.optionsFragment);
        TransactionFragment transactionFragment = (TransactionFragment) fm.findFragmentById(R.id.transactionDetailsFragment);
        if(coffeeFragment == null){
            coffeeFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_COFFEE);
            fm.beginTransaction().add(R.id.optionsFragment,coffeeFragment).commit();
        }
        //The Transaction details fragment is initialised
        if(transactionFragment == null){
            transactionFragment = TransactionFragment.newInstance();
            fm.beginTransaction().add(R.id.transactionDetailsFragment,transactionFragment).commit();
        }
        //References to UI Buttons
        coffeeButton = (Button) findViewById(R.id.coffeesButton);
        drinkButton = (Button) findViewById(R.id.drinksButton);
        cakeButton = (Button) findViewById(R.id.cakesButton);
        menuButton = (Button) findViewById(R.id.menuButton);
        chargeButton = (Button) findViewById(R.id.chargeButton);

        //Click event listeners for menu buttons set a call to the fragment manager to swap the views
        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments(OptionsFragment.OPTION_TYPE_COFFEE);
            }
        });
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments(OptionsFragment.OPTION_TYPE_DRINK);
            }
        });
        cakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments(OptionsFragment.OPTION_TYPE_CAKE);
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //swapFragments(OptionsFragment.OPTION_TYPE_MENU);
            }
        });
        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentCharge!=0){
                    PaymentFragment paymentFragment = PaymentFragment.newInstance(currentCharge);
                    paymentFragment.show(fm, "Payment Fragment");
                    paymentFragment.setCancelable(false);
                }
            }
        });
    }

    public void swapFragments(int option){//Method to swap fragment views based on selected menu option
        //A placeholder fragment is initialised here with reference to the "optionsFragment" FrameLayout
        OptionsFragment currentFragment = (OptionsFragment) fm.findFragmentById(R.id.optionsFragment);
        //Based on the selected option the corresponding fragment is instanciated here
        switch (option){
            case OptionsFragment.OPTION_TYPE_COFFEE:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_COFFEE);
                break;
            case OptionsFragment.OPTION_TYPE_DRINK:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_DRINK);
                break;
            case OptionsFragment.OPTION_TYPE_CAKE:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_CAKE);
                break;
            case OptionsFragment.OPTION_TYPE_MENU:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_MENU);
                break;
        }
        //The UI Fragment is then replaced here
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.optionsFragment,currentFragment)
                .commit();
    }

    public void AddTransactionItem(Option selectedOption){//Method to add items to the running sale
        //When an item is added to the running transaction, a reference to the TransactionDetailsFragment is created here
        TransactionDataService.getInstance().addiTem(selectedOption.getPrice(),selectedOption.getOptionTitle());
        UpdateDetail();
        //RunningTotal is calculated here and the button's displaying text is modified accordingly
        currentCharge+=selectedOption.getPrice();
        chargeButton.setText(String.format( "Charge: £ %.2f",currentCharge));
    }

    public void AddTransactionItem(ExtraOptions selectedOption){//Method to add extra items to the running sale
        //When an item is added to the running transaction, a reference to the TransactionDetailsFragment is created here
        TransactionDataService.getInstance().addiTem(selectedOption.getItemPrice(),selectedOption.getItemName());
        UpdateDetail();
        //RunningTotal is calculated here and the button's displaying text is modified accordingly
        currentCharge+=selectedOption.getItemPrice();
        chargeButton.setText(String.format( "Charge: £ %.2f",currentCharge));
    }

    public void RemoveTransactionItem(int position,double itemPrice){//Method to remove one item from the current transaction
        TransactionDataService.getInstance().removeItem(position);
        UpdateDetail();
        //RunningTotal is calculated here and the button's displaying text is modified accordingly
        currentCharge-=itemPrice;
        chargeButton.setText(String.format( "Charge: £ %.2f",currentCharge));
    }

    public void AddTransactionItemWithExtra(Option selectedOption){//Method to add items to the running sale on long click for extra
        //When an item is added to the running transaction, a reference to the TransactionDetailsFragment is created here
        TransactionDataService.getInstance().addiTem(selectedOption.getPrice(),selectedOption.getOptionTitle());
        currentCharge+=selectedOption.getPrice();
        //RunningTotal is calculated here and the button's displaying text is modified accordingly
        chargeButton.setText(String.format(Locale.ENGLISH,"Charge: £ %.2f",currentCharge));
    }

    public void showExtraOptions(String type){//Load the extra options fragment
        dialogFragment = ExtraOptionsFragment.newInstance(type);
        dialogFragment.show(fm, "Extra options Fragment");
        dialogFragment.setCancelable(false);
    }

    public void addExtra(ExtraOptions option){
        dialogFragment.addExtra(option);
    }
    public void voidExtra(ExtraOptions option){
        dialogFragment.voidExtra(option);
    }

    public void UpdateDetail(){
        TransactionFragment detailFragment = (TransactionFragment) fm.findFragmentById(R.id.transactionDetailsFragment);
        //The UI of TransactionDetailFragment is updated by notifying it's RecyclerView adapter here
        detailFragment.updateUI();
    }

    public void pay(String type,double amount){//Method to manage payments

        if (amount >= currentCharge){
            if(amount > currentCharge) {
                Toast.makeText(this,currentCharge+" paid in "+type+" Change to be given £"+(amount-currentCharge),Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,String.format(Locale.ENGLISH, "£%.2f",currentCharge)+" paid in "+type,Toast.LENGTH_SHORT).show();
            ArrayList<TransactionObject> oldTransaction = new ArrayList<>();
            oldTransaction.addAll(TransactionDataService.getInstance().getTransactions());
            new TransactionListUploader().execute(oldTransaction);
            TransactionDataService.getInstance().removeItems();
            TransactionFragment detailFragment = (TransactionFragment) fm.findFragmentById(R.id.transactionDetailsFragment);
            detailFragment.updateUI();
            chargeButton.setText("Charge: ");
            currentCharge=0;
        }else {
            Toast.makeText(this,currentCharge+" paid in "+type+" Still to be paid £"+(currentCharge-amount),Toast.LENGTH_SHORT).show();
        }

    }
}
