package com.example.jose.proyecto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by jose on 29/06/2017.
 */

public class Principal extends AppCompatActivity implements SecondFragment.Callback {

    OneFragment oneFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Bundle arg = new Bundle();

        oneFragment = (OneFragment) OneFragment.instantiate(Principal.this,OneFragment.class.getName());
        getFragmentManager().beginTransaction().replace(R.id.flMain,oneFragment).commit();

        secondFragment = (SecondFragment) SecondFragment.instantiate(Principal.this,SecondFragment.class.getName());
        secondFragment.setCallback(Principal.this);
        getFragmentManager().beginTransaction().replace(R.id.flSecond,secondFragment).commit();

    }

    @Override
    public void onOneFragmentClick(Persona persona) {

    }
}
