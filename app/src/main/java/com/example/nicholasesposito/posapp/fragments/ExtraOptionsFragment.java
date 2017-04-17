package com.example.nicholasesposito.posapp.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.adapters.ExtraOptionsAdapter;
import com.example.nicholasesposito.posapp.model.ExtraOptions;
import com.example.nicholasesposito.posapp.services.ExtraOptionsService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExtraOptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExtraOptionsFragment extends DialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EXTRA_OPTIONS_TYPE = "extra_options_type";

    private ExtraOptionsAdapter adapter;
    private ExtraOptions extraOption;
    private Button ok;
    private ImageView imageV;
    private String optionsType;
    private double charge;


    public ExtraOptionsFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param optionsType the type of options to be shown.
     * @return A new instance of fragment ExtraOptionsFragment.
     */
    public static ExtraOptionsFragment newInstance(String optionsType) {
        ExtraOptionsFragment fragment = new ExtraOptionsFragment();

        Bundle args = new Bundle();
        args.putString(EXTRA_OPTIONS_TYPE, optionsType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            optionsType = getArguments().getString(EXTRA_OPTIONS_TYPE);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_extra_options, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_extra_options);
        recyclerView.setHasFixedSize(true);
        imageV = (ImageView) view.findViewById(R.id.image);

        if(optionsType.equals("milk")){
            adapter = new ExtraOptionsAdapter(ExtraOptionsService.getInstance().getExtraMilkOptions());
        }else if(optionsType.equals("powder")) {
            adapter = new ExtraOptionsAdapter(ExtraOptionsService.getInstance().getExtraPowderOptions());
            imageV.setImageResource(R.drawable.powder);
        }else if(optionsType.equals("tea")) {
            adapter = new ExtraOptionsAdapter(ExtraOptionsService.getInstance().getExtraTeaOptions());
            imageV.setImageResource(R.drawable.takeawayico);
        }else {
            adapter = new ExtraOptionsAdapter(ExtraOptionsService.getInstance().getExtraChocolateOptions());
            imageV.setImageResource(R.drawable.chocoextra);
        }

        recyclerView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Select "+optionsType+" type:").setView(view);
        builder.setCancelable(false);

        Button dismiss = (Button) view.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().UpdateDetail();
                dismiss();
            }
        });

        ok = (Button) view.findViewById(R.id.accept);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(extraOption!=null){
                    MainActivity.getMainActivity().AddTransactionItem(extraOption);
                    dismiss();
                }
            }
        });


        return builder.create();
    }

    public void addExtra(ExtraOptions extraOptionPassed){
        this.extraOption = extraOptionPassed;
        ok.setEnabled(true);
    }
    public void voidExtra(ExtraOptions extraOptionPassed){
        ok.setEnabled(false);
    }

}
