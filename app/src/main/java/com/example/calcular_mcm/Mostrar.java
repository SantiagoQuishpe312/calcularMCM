package com.example.calcular_mcm;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calcular_mcm.databinding.ActivityMostrarBinding;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {

    TextView mostrarMcm, mostrarS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        mostrarMcm=findViewById(R.id.txtResultadoMcm);
        mostrarS=findViewById(R.id.txtResultadoSimplificado);
        mostrarS.setText(getIntent().getStringExtra("factores")+"----imprime");
        ArrayList<Integer> resultados=getIntent().getIntegerArrayListExtra("factores");
        String resultado="";
        for(int i=0;i<resultados.size();i++){
            resultado=resultado+resultados.get(i).toString()+",";
        }
        mostrarS.setText(resultado);
    }

}