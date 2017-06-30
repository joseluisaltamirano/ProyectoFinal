package com.example.jose.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jose on 28/06/2017.
 */

public class Login extends AppCompatActivity{

    EditText etUsuario, etPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsuario= (EditText) findViewById(R.id.etUsuario);
        etPass= (EditText) findViewById(R.id.etPass);
        Button boton = (Button) findViewById(R.id.btIngresar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario= etUsuario.getText().toString();
                String pass= etPass.getText().toString();

                if (validateFields()) {
                    if (usuario.equals("admin") && pass.equals("admin")) {
                        Intent intent = new Intent(Login.this,Principal.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean validateFields() {
        if (etUsuario.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese su usuario", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPass.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Ingrese su password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
