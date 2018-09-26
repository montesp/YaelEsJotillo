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
import android.widget.Toast;

import org.w3c.dom.Text;


public class TiroVertical extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText edVi3,edH3, edHi3, edT3;
    Button buC3, buL3;
    TextView txR3;

    public TiroVertical() {

    }

    // TODO: Rename and change types and number of parameters
    public static TiroVertical newInstance(String param1, String param2) {
        TiroVertical fragment = new TiroVertical();
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
        View v;

        v = inflater.inflate(R.layout.fragment_tiro_vertical, container, false);

        unitUI(v);

        return v;
    }

    private void unitUI(View v) {
        final EditText edVi3 = (EditText) v.findViewById(R.id.edVi3);
        final EditText edH3 = (EditText)v.findViewById(R.id.edH3);
        final EditText edHi3 = (EditText)v.findViewById(R.id.edHi3);
        final EditText edT3 = (EditText) v.findViewById(R.id.edT3);
        Button buC3 = (Button) v.findViewById(R.id.buC3);
        Button buL3 = (Button) v.findViewById(R.id.buL3);
        final TextView txR3 = (TextView) v.findViewById(R.id.txR3);

        buC3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String vi = edVi3.getText().toString();
                String h = edH3.getText().toString();
                String hi = edHi3.getText().toString();
                String t = edT3.getText().toString();
                Double vin = Double.parseDouble(vi);
                Double ha = Double.parseDouble(h);
                Double hai = Double.parseDouble(hi);
                Double ti = Double.parseDouble(t);
                txr (vin, ha, hai, ti);
            }
            private void txr (Double vin, Double ha, Double hai, Double ti){
                if (vin>0 & ha==0 & ti==0){
                     ti = vin/9.803;
                     ha = (vin*ti)-((9.803/2)*(ti*ti));

                    Double haf = hai + ha;
                    Double tin = (Math.sqrt(2*ha))/9.803;
                    Double vef = 9.803*ti;

                    Double tif = ti + tin;

                    txR3.setText("El objeto callo de una altura de: " + haf +
                    "Con una velocidad final de: " + vef +
                    "Y un tiempo de: " + tif);

                }else if ( ti>0 & vin==0 & ha==0 ){
                    vin=ti*9.803;
                    ha = (vin*ti)-((9.803/2)*(ti*ti));

                    Double haf = hai + ha;
                    Double tin = (Math.sqrt(2*ha))/9.803;
                    Double vef = 9.803*ti;

                    Double tif = ti + tin;

                    txR3.setText("El objeto callo de una altura de: " + haf +
                            "Con una velocidad final de: " + vef +
                            "Y un tiempo de: " + tif);
                }else if (ti>0 & vin>0 & ha==0){
                    ha = (vin*ti)-((9.803/2)*(ti*ti));

                    Double haf = hai + ha;
                    Double tin = (Math.sqrt(2*ha))/9.803;
                    Double vef = 9.803*ti;

                    Double tif = ti + tin;

                    txR3.setText("El objeto callo de una altura de: " + haf +
                            "Con una velocidad final de: " + vef +
                            "Y un tiempo de: " + tif);

                }else if (ti>0 & vin>0 & ha>0){
                    Double haf = hai + ha;
                    Double tin = (Math.sqrt(2*ha))/9.803;
                    Double vef = 9.803*ti;

                    Double tif = ti + tin;

                    txR3.setText("El objeto callo de una altura de: " + haf +
                            "Con una velocidad final de: " + vef +
                            " Y un tiempo de: " + tif);

                }else if (ha > 0 & ti==0 & vin==0){
                    txR3.setText("Debes ingresar la velocidad inicial o tiempo");

                }else{
                    txR3.setText("Debes ingresar la velocidad inicial o tiempo");

                }

            }
        });
        buL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edH3.setText("0");
                edHi3.setText("0");
                edT3.setText("0");
                edVi3.setText("0");
                txR3.setText("Resultado");
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
