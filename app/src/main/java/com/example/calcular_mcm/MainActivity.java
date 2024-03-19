package com.example.calcular_mcm;



import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numFracc1, denFracc1, numFracc2, denFracc2;
    Button calcular;
    Spinner seleccion;
    TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numFracc1 = findViewById(R.id.txtNumeradorN1);
        numFracc2 = findViewById(R.id.txtDenominadorN1);
        denFracc1 = findViewById(R.id.txtNumeradorN2);
        denFracc2 = findViewById(R.id.txtDenominadadorN2);


        calcular = findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numerador1 = Integer.parseInt(numFracc1.getText().toString());
                int denominador1 = Integer.parseInt(numFracc2.getText().toString());
                int numerador2 = Integer.parseInt(denFracc1.getText().toString());
                int denominador2 = Integer.parseInt(denFracc2.getText().toString());

                int mcm = calcularMcm(denominador1, denominador2);

                Intent intent = new Intent(MainActivity.this, Mostrar.class);

                intent.putExtra("factores",simplificar(denominador1,denominador2));
                startActivity(intent);
            }
        });
    }

    private int calcularMcm(int denFracc1, int denFracc2) {
        int div = calcularMcd(denFracc1, denFracc2);
        return (denFracc1 * denFracc2) / div;
    }

    private int calcularMcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ArrayList simplificar(int nume, int deno){
        int divisor=2;
        ArrayList<Integer> factores = new ArrayList<>();
        while(nume>divisor || deno>divisor){
            while(nume%divisor == 0 && deno%divisor == 0){
                nume/=divisor;
                deno/=divisor;
                factores.add(divisor);
            }
            divisor++;
        }
        return factores;
    }
}
