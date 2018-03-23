package com.example.escinf.laboratorio03;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by slon on 22/3/2018.
 */

public class TablaCarrera extends Tabla<Carrera> {

    public TablaCarrera(Activity actividad, TableLayout tabla) {
        super(actividad, tabla);
    }

    public void agregarFilaTabla(ArrayList<Carrera> elementos) {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        TextView texto = new TextView(actividad);
        TextView texto2 = new TextView(actividad);

        for(int i = 0; i< elementos.size(); i++) {

            texto.setText(elementos.get(i).getNombre());
            texto2.setText(elementos.get(i).getCodigo());
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividad, R.style.AppTheme);
            //texto.setBackgroundResource(R.drawable.ic_menu_gallery);
            layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
            //layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto2.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
            //fila.addView(texto2);
        }

        tabla.addView(fila);
        filas.add(fila);

        FILAS++;
    }
}
