package com.example.yaelhuerta.calculadoradefisica;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;


public class Aceleracion extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText edVf, edVi, edT;
    TextView txR1;
    Button buC1, buL1;

    public Aceleracion() {

    }

    // TODO: Rename and change types and number of parameters
    public static Aceleracion newInstance(String param1, String param2) {
        Aceleracion fragment = new Aceleracion();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_aceleracion, container, false);

        initUI(view);

        return view;
    }

    private void initUI(View view) {
        final EditText edVf = (EditText) view.findViewById(R.id.edVf);
        final EditText edVi = (EditText) view.findViewById(R.id.edVi);
        final EditText edT = (EditText) view.findViewById(R.id.edT1);
        Button buC1 = (Button) view.findViewById(R.id.buC1);
        Button buL1 = (Button) view.findViewById(R.id.buL1);
        final TextView txR1 = (TextView) view.findViewById(R.id.txR1);

        buC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = edVf.getText().toString();
                String i = edVi.getText().toString();
                String t = edT.getText().toString();
                Double ti = Double.parseDouble(t);
                Double vf = Double.parseDouble(f);
                Double vi = Double.parseDouble(i);
                txR1(vf, vi, ti);
            }
            private void txR1 (Double vf, Double vi, Double ti){
                if (vf > 0 & vi > 0 & ti > 0) {

                    Double RV = (vf-vi)/ti;
                    double rp = Math.abs(RV);
                    txR1.setText(""+rp);

                } else {
                    txR1.setText("No puedes ingresar numeros negativos o 0");
                }
            }
        });
        buL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edVf.setText("0");
                edVi.setText("0");
                edT.setText("0");
                txR1.setText("Resultado");
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
