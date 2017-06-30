package com.example.jose.proyecto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by jose on 29/06/2017.
 */

public class SecondFragment extends Fragment {

    public EditText etNombre, etApellido, etDireccion, etEdad, etDNI, etTipo, etFecha;
    public CheckBox chActivo;



    interface Callback {void onOneFragmentClick(Persona persona);}

    private Callback mCallback;

    public void setCallback(Callback callback){
        mCallback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        etNombre = (EditText) view.findViewById(R.id.etNombre);
        etApellido = (EditText) view.findViewById(R.id.etApellido);
        etDireccion = (EditText) view.findViewById(R.id.etDireccion);
        etEdad = (EditText) view.findViewById(Integer.valueOf(R.id.etEdad));
        chActivo = (CheckBox) view.findViewById(R.id.chActivo);
        etDNI = (EditText) view.findViewById(R.id.etDNI);
        etTipo = (EditText) view.findViewById(R.id.etTipo);
        etFecha = (EditText) view.findViewById(R.id.etFecha);
        return  view;
    }
}
