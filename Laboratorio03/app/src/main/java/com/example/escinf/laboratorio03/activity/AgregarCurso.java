package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.escinf.laboratorio03.R;


public class AgregarCurso extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_curso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        agregar();
        cancelar();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_curso);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            private String nombre;
            private String codigo;
            private int creditos;
            private int horasSemanales;

            @Override
            public void onClick(View v) {
                nombre = ((EditText) findViewById(R.id.nombre_curso)).getText().toString();
                codigo = ((EditText) findViewById(R.id.codigo_curso)).getText().toString();
                try {
                    creditos = Integer.parseInt(((EditText) findViewById(R.id.creditos_curso)).getText().toString());
                    horasSemanales = Integer.parseInt(((EditText) findViewById(R.id.horas_semanales)).getText().toString());
                } catch (NumberFormatException e) { }

                Intent intent = new Intent(AgregarCurso.this, CursoListView.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("nombre", nombre);
                intent.putExtra("codigo", codigo);
                intent.putExtra("creditos", creditos);
                intent.putExtra("horasSemanales", horasSemanales);
                //startActivityIfNeeded(intent, 0);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_curso);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarCurso.this, CursoListView.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
