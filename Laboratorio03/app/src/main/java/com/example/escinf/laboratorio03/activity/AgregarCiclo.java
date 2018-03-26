package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.escinf.laboratorio03.R;


public class AgregarCiclo extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ciclo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agregar();
        cancelar();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_ciclo);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            private int anno;
            private int numero;
            private String fechaInicio;
            private String fechaFin;

            @Override
            public void onClick(View v) {
                try {
                    anno = Integer.parseInt(((EditText) findViewById(R.id.anno_ciclo)).getText().toString());
                    numero = Integer.parseInt(((EditText) findViewById(R.id.numero_ciclo)).getText().toString());
                } catch (NumberFormatException e) {

                }
                fechaInicio = ((EditText) findViewById(R.id.fecha_inicio_ciclo)).getText().toString();
                fechaFin = ((EditText) findViewById(R.id.fecha_finalizacion_ciclo)).getText().toString();


                Intent intent = new Intent(AgregarCiclo.this, CicloListView.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("anno", anno);
                intent.putExtra("numero", numero);
                intent.putExtra("fechaInicio", fechaInicio);
                intent.putExtra("fechaFin", fechaFin);
                //startActivityIfNeeded(intent, 0);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_ciclo);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarCiclo.this, CicloListView.class);
                startActivity(intent);
                finish();
            }
        });
    }



}
