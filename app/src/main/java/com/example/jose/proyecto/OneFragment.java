package com.example.jose.proyecto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



/**
 * Created by jose on 29/06/2017.
 */

public class OneFragment extends SecondFragment {

    private RecyclerView rvMain;
    private Adaptador mAdaptador;
    Button btAgregar, btGuardar, btEditar, btElmininar;
    SecondFragment secondFragment;

    public final View.OnClickListener btGuardarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateFields()) {
                if (mCallback != null) {
                    Persona mPersona = new Persona();
                    mPersona.setNombre(etNombre.getText().toString());
                    mPersona.setApellido(etApellido.getText().toString());
                    mPersona.setDireccion(etDireccion.getText().toString());
                    mPersona.setEdad(Integer.valueOf(etEdad.getText().toString()));
                    mPersona.setActivo(chActivo.isChecked());
                    mPersona.setDNI(etDNI.getText().toString());
                    mPersona.setTipo(etTipo.getText().toString());
                    mPersona.setFecha(etFecha.getText().toString());
                    mCallback.onOneFragmentClick(mPersona);
                }
            }
        }
    };

    public  final View.OnClickListener btAgregarOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            secondFragment = (SecondFragment) SecondFragment.instantiate(getActivity(),SecondFragment.class.getName());
            getFragmentManager().beginTransaction().replace(R.id.flSecond,secondFragment).commit();
        }
    };



    interface Callback {void onOneFragmentClick(Persona persona);}

    private SecondFragment.Callback mCallback;

    public void setCallback(SecondFragment.Callback callback){
        mCallback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one,container,false);
        mAdaptador = new Adaptador();
        rvMain = (RecyclerView) view.findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMain.setAdapter(mAdaptador);
        btAgregar = (Button) view.findViewById(R.id.btAgregar);
        btGuardar = (Button) view.findViewById(R.id.btGuardar);
        btEditar = (Button) view.findViewById(R.id.btEditar);
        btElmininar = (Button) view.findViewById(R.id.btEliminar);
        btAgregar.setOnClickListener(btAgregarOnClickListener);
        btGuardar.setOnClickListener(btGuardarOnClickListener);
        //btEditar.setOnClickListener(btEditarOnClickListener);
        //btElmininar.setOnClickListener(btEliminarOnClickListener);
        return view;
    }

    public void add(Persona persona){
        mAdaptador.addOrUpdate(persona);
    }
    public void remove(Persona persona) { mAdaptador.remove(persona); }

    private boolean validateFields() {
        if (etNombre.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etApellido.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un apellido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etDireccion.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una direccion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etEdad.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una edad", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etDNI.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un DNI", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etTipo.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un Tipo de Documento", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etFecha.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una Fecha", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
