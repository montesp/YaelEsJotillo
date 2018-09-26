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


public class Velocidad extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView txR;
    EditText edD, edT;
    Button buC , buL;

    public Velocidad() {
    }

    // TODO: Rename and change types and number of parameters
    public static Velocidad newInstance(String param1, String param2) {
        Velocidad fragment = new Velocidad();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_velocidad, container, false);

        initIU(view);

        return view;
    }

    private void initIU(View view) {
        Button buC = (Button) view.findViewById(R.id.buC);
        Button buL = (Button) view.findViewById(R.id.buL);
        final TextView txR = (TextView) view.findViewById(R.id.txR);
        final EditText edD = (EditText) view.findViewById(R.id.edD);
        final EditText edT = (EditText) view.findViewById(R.id.edT);

        buC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d = edD.getText().toString();
                Double di = Double.parseDouble(d);
                String t =edT.getText().toString();
                Double ti = Double.parseDouble(t);
                settxR(ti, di);

            }  private void settxR( double ti, double di){
                if (ti > 0 & di > 0) {

                    Double RV = di / ti;
                    txR.setText(""+RV);

                } else {
                    txR.setText("No puedes ingresar numeros negativos o 0");
                }

            }
        });
        buL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edD.setText("0");
                edT.setText("0");
                txR.setText("Resultado");
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
