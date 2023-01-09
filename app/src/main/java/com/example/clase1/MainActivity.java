package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonPreferencias = (Button) findViewById(R.id.botonPreferencias);
        botonPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Preferencias.class);
                startActivity(intent);
            }
        });

        Button botonMostrarPreferencias = (Button) findViewById(R.id.botonMostrarPreferencias);
        TextView texto = (TextView) findViewById(R.id.texto);

        botonMostrarPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<String> opciones = null;
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                texto.append("Opcion 1 "+pref.getBoolean("clave1", false));
                texto.append("Opcion 2 "+pref.getString("clave2", "No asignada"));
                texto.append("Opcion 3 "+pref.getString("clave3", "No asignada"));
                texto.append("Opcion 4 "+pref.getStringSet("clave4", opciones));

            }
        });

    }
}