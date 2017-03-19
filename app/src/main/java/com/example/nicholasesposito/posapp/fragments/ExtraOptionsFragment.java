package com.example.nicholasesposito.posapp.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;
import com.example.nicholasesposito.posapp.adapters.ExtraOptionsAdapter;
import com.example.nicholasesposito.posapp.model.ExtraOptions;
import com.example.nicholasesposito.posapp.services.ExtraOptionsService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExtraOptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExtraOptionsFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ExtraOptionsAdapter adapter;
    ExtraOptions extraOption;
    Button ok;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ExtraOptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExtraOptionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExtraOptionsFragment newInstance(String param1, String param2) {
        ExtraOptionsFragment fragment = new ExtraOptionsFragment();


        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_extra_options, container, false);
//        getDialog().setTitle("Milk options");
//
//
//        Button dismiss = (Button) view.findViewById(R.id.dismiss);
//        dismiss.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//
//        return view;
//    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_extra_options, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_extra_options);
        recyclerView.setHasFixedSize(true);


        adapter = new ExtraOptionsAdapter(ExtraOptionsService.getInstance().getExtraOptions());
        recyclerView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Select Milk type:").setView(view);

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
