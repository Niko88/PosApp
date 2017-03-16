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
import com.example.nicholasesposito.posapp.fragments.OptionsFragment;
import com.example.nicholasesposito.posapp.model.Option;

public class MainActivity extends AppCompatActivity {

    ImageButton coffeeButton, drinkButton, cakeButton, sandwichButton, menuButton;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        OptionsFragment coffeeFragment = (OptionsFragment) fm.findFragmentById(R.id.optionsFragment);

        if(coffeeFragment == null){
            coffeeFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_COFFEE);
            fm.beginTransaction().add(R.id.optionsFragment,coffeeFragment).commit();
        }

        coffeeButton = (ImageButton) findViewById(R.id.coffeesButton);
        drinkButton = (ImageButton) findViewById(R.id.drinksButton);
        cakeButton = (ImageButton) findViewById(R.id.cakesButton);
        sandwichButton = (ImageButton) findViewById(R.id.sandwichButton);
        menuButton = (ImageButton) findViewById(R.id.menuButton);

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

        sandwichButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments(OptionsFragment.OPTION_TYPE_SANDWICH);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragments(OptionsFragment.OPTION_TYPE_MENU);
            }
        });
    }

    public void swapFragments(int option){
        FragmentManager fm = getSupportFragmentManager();
        OptionsFragment currentFragment = (OptionsFragment) fm.findFragmentById(R.id.optionsFragment);

        switch (option){
            case OptionsFragment.OPTION_TYPE_COFFEE:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_COFFEE);
                break;
            case OptionsFragment.OPTION_TYPE_DRINK:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_DRINK);
                break;
            case OptionsFragment.OPTION_TYPE_SANDWICH:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_SANDWICH);
                break;
            case OptionsFragment.OPTION_TYPE_CAKE:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_CAKE);
                break;
            case OptionsFragment.OPTION_TYPE_MENU:
                currentFragment = OptionsFragment.newInstance(OptionsFragment.OPTION_TYPE_MENU);
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.optionsFragment,currentFragment)
                .commit();
    }

    public void loadDetailScreen(Option selectedOption){

        Context context = getApplicationContext();
        CharSequence text = "Hello "+selectedOption.getOptionTitle()+"!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container_main,new Details_fragment())
//                .addToBackStack(null)
//                .commit();
    }
}
