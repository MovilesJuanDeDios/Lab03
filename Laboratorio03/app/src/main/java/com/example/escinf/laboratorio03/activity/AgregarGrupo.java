package com.example.escinf.laboratorio03.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.escinf.laboratorio03.R;
import com.example.escinf.laboratorio03.modelo.Carrera;
import com.example.escinf.laboratorio03.modelo.Ciclo;
import com.example.escinf.laboratorio03.modelo.Curso;
import com.example.escinf.laboratorio03.modelo.Profesor;
import com.example.escinf.laboratorio03.utils.Data;

import java.util.ArrayList;
import java.util.List;


public class AgregarGrupo extends AppCompatActivity {

    private Button btn_agregar;
    private Button btn_cancelar;

    private Ciclo ciclo;
    private Curso curso;
    private int numero;
    private String horario;
    private Profesor profesor;
    private int position;

    ArrayAdapter<String> adapterCiclo;
    ArrayAdapter<String> adapterCurso;
    ArrayAdapter<String> adapterProfesor;

    Spinner spinnerCiclo;
    Spinner spinnerCurso;
    Spinner spinnerProfesor;

    List<String> listaCi = new ArrayList<>();
    List<String> listaCu = new ArrayList<>();
    List<String> listaPr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_grupo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerCiclo = (Spinner) findViewById(R.id.spinner_ciclo_grupo);
        spinnerCurso = (Spinner) findViewById(R.id.spinner_curso_grupo);
        spinnerProfesor = (Spinner) findViewById(R.id.spinner_asignar_profesor);


        for (int i = 0; i < Data.listaCiclo.size(); i++) {
            listaCi.add(Data.listaCiclo.get(i).toString());
        }

        for (int i = 0; i < Data.listaCurso.size(); i++) {
            listaCu.add(Data.listaCurso.get(i).getNombre());
        }

        for (int i = 0; i < Data.listaProf.size(); i++) {
            listaPr.add(Data.listaProf.get(i).getNombre());
        }

        adapterCiclo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listaCi);
        adapterCiclo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiclo.setAdapter(adapterCiclo);

        adapterCurso = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listaCu);
        adapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurso.setAdapter(adapterCurso);

        adapterProfesor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listaPr);
        adapterProfesor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProfesor.setAdapter(adapterProfesor);

        agregar();
        cancelar();

        if(getIntent().getBooleanExtra("edit",false))
            editData();
    }

    private void agregar() {
        btn_agregar = (Button) findViewById(R.id.button_aceptar_grupo);

        btn_agregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ciclo = getCiclo(spinnerCiclo.getSelectedItem().toString());
                curso = getCurso(spinnerCurso.getSelectedItem().toString());
                try {
                    numero = Integer.parseInt(((EditText) findViewById(R.id.numero_grupo)).getText().toString());
                } catch (NumberFormatException e) {
                }

                horario = ((EditText) findViewById(R.id.horario_grupo)).getText().toString();
                profesor = getProfesor(spinnerProfesor.getSelectedItem().toString());
                position = getIntent().getIntExtra("position",-1);

                if (validate()) {
                    Intent intent = new Intent(AgregarGrupo.this, GrupoListView.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    intent.putExtra("ciclo", ciclo);
                    intent.putExtra("curso", curso);
                    intent.putExtra("numero", numero);
                    intent.putExtra("horario", horario);
                    intent.putExtra("profesor", profesor);
                    intent.putExtra("position", position);
                    //startActivityIfNeeded(intent, 0);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void cancelar() {
        btn_cancelar = (Button) findViewById(R.id.button_cancelar_grupo);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarGrupo.this, GrupoListView.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void editData() {
        ((Spinner)findViewById(R.id.spinner_ciclo_grupo)).setSelection(adapterCiclo.getPosition(getIntent().getStringExtra("ciclo")));
        ((Spinner)findViewById(R.id.spinner_curso_grupo)).setSelection(adapterCurso.getPosition(getIntent().getStringExtra("curso")));
        ((EditText)findViewById(R.id.numero_grupo)).setText(getIntent().getStringExtra("numero"));
        ((EditText)findViewById(R.id.horario_grupo)).setText(getIntent().getStringExtra("horario"));
        ((Spinner)findViewById(R.id.spinner_asignar_profesor)).setSelection(adapterProfesor.getPosition(getIntent().getStringExtra("profesor")));
    }

    private Ciclo getCiclo(String param) {
        String [] arr = param.split(" ");

        String ciclo = arr[0];
        int anno = Integer.parseInt(arr[1]);

        for (int i = 0; i < Data.listaCiclo.size(); i++) {
            if ((Data.listaCiclo.get(i).getNumero().equals(ciclo)) &&
                    (Data.listaCiclo.get(i).getAnno() == anno)) {
                return Data.listaCiclo.get(i);
            }
        }
        return null;
    }

    private Curso getCurso(String nombre) {
        for (int i = 0; i < Data.listaCurso.size(); i++) {
            if ((Data.listaCurso.get(i).getNombre()).equals(nombre)){
                return Data.listaCurso.get(i);
            }
        }
        return null;
    }

    private Profesor getProfesor(String nombre) {
        for (int i = 0; i < Data.listaProf.size(); i++) {
            if ((Data.listaProf.get(i).getNombre()).equals(nombre)){
                return Data.listaProf.get(i);
            }
        }
        return null;
    }

    private boolean validate() {
        boolean go = true;

        if (Data.listaCiclo.isEmpty()) {
            go = false;
        }
        if (Data.listaCurso.isEmpty()) {
            go = false;
        }
        if (Data.listaProf.isEmpty()) {
            go = false;
        }
        if (TextUtils.isEmpty(horario)) {
            go = false;
        }
        if (TextUtils.isEmpty(((EditText) findViewById(R.id.numero_grupo)).getText().toString())) {
            go = false;
        }

        return go;
    }

}
