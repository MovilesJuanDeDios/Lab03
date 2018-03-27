package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
        if(getIntent().getBooleanExtra("edit",false))
            editData();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_ciclo);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            private int anno;
            private String numero;
            private String fechaInicio;
            private String fechaFin;
            private int position;

            @Override
            public void onClick(View v) {
                try {
                    anno = Integer.parseInt(((EditText) findViewById(R.id.anno_ciclo)).getText().toString());
                } catch (NumberFormatException e) {

                }
                numero = ((Spinner) findViewById(R.id.spinner_numero_ciclo)).getSelectedItem().toString();
                fechaInicio = ((EditText) findViewById(R.id.fecha_inicio_ciclo)).getText().toString();
                fechaFin = ((EditText) findViewById(R.id.fecha_finalizacion_ciclo)).getText().toString();
                position = getIntent().getIntExtra("position",-1);

                Intent intent = new Intent(AgregarCiclo.this, CicloListView.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("anno", anno);
                intent.putExtra("numero", numero);
                intent.putExtra("fechaInicio", fechaInicio);
                intent.putExtra("fechaFin", fechaFin);
                intent.putExtra("position", position);
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

    public void editData() {
        ((EditText)findViewById(R.id.anno_ciclo)).setText(Integer.toString(getIntent().getIntExtra("anno",-1)));
        ((EditText)findViewById(R.id.anno_ciclo)).setEnabled(false);
        Spinner spinner = (Spinner)findViewById(R.id.spinner_numero_ciclo);
        if (spinner.getItemAtPosition(0).toString().equals(getIntent().getStringExtra("numero")))
            spinner.setSelection(0);
        else
            spinner.setSelection(1);
        ((Spinner)findViewById(R.id.spinner_numero_ciclo)).setEnabled(false);
        ((EditText)findViewById(R.id.fecha_inicio_ciclo)).setText(getIntent().getStringExtra("fechaInicio"));
        ((EditText)findViewById(R.id.fecha_finalizacion_ciclo)).setText(getIntent().getStringExtra("fechaFin"));
    }

}
