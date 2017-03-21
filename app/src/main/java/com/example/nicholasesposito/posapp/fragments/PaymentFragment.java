package com.example.nicholasesposito.posapp.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nicholasesposito.posapp.R;
import com.example.nicholasesposito.posapp.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentFragment extends DialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CHARGE = "import_to_be_charged";

    private double import_to_be_charged;


    public PaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param charge Import to be charged
     * @return A new instance of fragment PaymentFragment.
     */

    public static PaymentFragment newInstance(double charge) {
        PaymentFragment fragment = new PaymentFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_CHARGE,charge);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            import_to_be_charged = getArguments().getDouble(ARG_CHARGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_payment, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(String.format( "Import to be paid: £%.2f",import_to_be_charged)).setView(view);
        builder.setCancelable(false);

        Button paymentDismiss = (Button) view.findViewById(R.id.paymentDismiss);
        Button payButton = (Button) view.findViewById(R.id.paymentCashButton);
        Button payCardButton = (Button) view.findViewById(R.id.paymenCardtButton);

        paymentDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getMainActivity().pay("cash",import_to_be_charged);
                dismiss();
            }
        });

        payCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getMainActivity().pay("card",import_to_be_charged);
                dismiss();
            }
        });

        return builder.create();
    }


}
