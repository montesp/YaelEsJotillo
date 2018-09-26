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

public class CaidaLibre extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView txR2;
    EditText edT2, edVf2, edH;
    Button buC2, buL2;

    public CaidaLibre() {
    }

    // TODO: Rename and change types and number of parameters
    public static CaidaLibre newInstance(String param1, String param2) {
        CaidaLibre fragment = new CaidaLibre();
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

        view = inflater.inflate(R.layout.fragment_caida_libre, container, false);

        initUI(view);

        return view ;
    }

    private void initUI(View view) {
        final EditText edH = (EditText) view.findViewById(R.id.edH);
        final EditText edVf2 = (EditText)view.findViewById(R.id.edVf2);
        final EditText edT2 = (EditText)view.findViewById(R.id.edT2);
        Button buC2 = (Button) view.findViewById(R.id.buC2);
        Button buL2 = (Button) view.findViewById(R.id.buL2);
        final TextView txR2 = (TextView) view.findViewById(R.id.txR2);

        buC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h = edH.getText().toString();
                String f = edVf2.getText().toString();
                String t = edT2.getText().toString();
                Double ha = Double.parseDouble(h);
                Double vf = Double.parseDouble(f);
                Double ti = Double.parseDouble(t);
                txR(ha,vf,ti);

            }
            private void txR (Double ha, Double vf, Double ti) {
                if (ti > 0 & vf ==0 & ha == 0) {


                    vf= 9.803*ti;
                    edVf2.setText(""+vf);
                    ha= ti + ((9.803/2)*(ti*ti));
                    edH.setText(""+ha);

                    txR2.setText("El objeto callo de una altura de: " + ha +
                    "con una velocidad final de: " + vf +
                    "y en un tiempo de " + ti);

                } else if (vf > 0 & ti == 0 & ha == 0) {

                    ti = vf/9.803;
                    edT2.setText(""+ti);
                    ha= ti + ((9.803/2)*(ti*ti));
                    edH.setText(""+ha);

                    txR2.setText("El objeto callo de una altura de: " + ha +
                            "con una velocidad final de: " + vf +
                            "y en un tiempo de " + ti);
                }else if (vf > 0 & ti > 0 & ha == 0) {

                    ha= ti + ((9.803/2)*(ti*ti));
                    edH.setText(""+ha);

                    txR2.setText("El objeto callo de una altura de: " + ha +
                            "con una velocidad final de: " + vf +
                            "y en un tiempo de " + ti);

                }else if (vf > 0 & ti > 0 & ha > 0){
                    txR2.setText("El objeto callo de una altura de: " + ha +
                            "con una velocidad final de: " + vf +
                            "y en un tiempo de " + ti);
                }else{
                    txR2.setText("Tienes que ingresar o la Velocidad final o el tiempo y dejar lo que no sepas en 0");
                }
            }
        });
        buL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edH.setText("0");
                edT2.setText("0");
                edVf2.setText("0");
                txR2.setText("Resultado");
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
