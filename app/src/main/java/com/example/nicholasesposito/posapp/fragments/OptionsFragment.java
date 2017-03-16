package com.example.nicholasesposito.posapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.adapters.OptionsAdapter;
import com.example.nicholasesposito.posapp.services.OptionsDataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionsFragment extends Fragment {

    private static final String ARG_OPTION_TYPE = "option_type";


    public static final int OPTION_TYPE_COFFEE = 0;
    public static final int OPTION_TYPE_DRINK = 1;
    public static final int OPTION_TYPE_CAKE = 2;
    public static final int OPTION_TYPE_SANDWICH = 3;
    public static final int OPTION_TYPE_MENU = 4;

    private int option_type;


    public OptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param option_type which options should be loaded.
     * @return A new instance of fragment OptionsFragment.
     */

    public static OptionsFragment newInstance(int option_type) {
        OptionsFragment fragment = new OptionsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_OPTION_TYPE,option_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            option_type = getArguments().getInt(ARG_OPTION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_options, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_options);
        recyclerView.setHasFixedSize(true);

        OptionsAdapter adapter;

        if(option_type == OPTION_TYPE_COFFEE){
            adapter = new OptionsAdapter(OptionsDataService.getInstance().getCoffeeOptions());
        }else if (option_type == OPTION_TYPE_DRINK)
        {adapter = new OptionsAdapter(OptionsDataService.getInstance().geDrinksOptions());}
        else if (option_type == OPTION_TYPE_CAKE)
        {adapter = new OptionsAdapter(OptionsDataService.getInstance().getCakesOptions());}
        else {adapter = new OptionsAdapter(OptionsDataService.getInstance().geDrinksOptions());}

        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),5);
        recyclerView.setLayoutManager(gridLayoutManager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

}
