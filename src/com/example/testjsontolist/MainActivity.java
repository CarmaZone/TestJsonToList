
package com.example.testjsontolist;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.testjsontolist.util.ParseJson;
import com.example.testxml.R;

public class MainActivity extends ActionBarActivity {

    private List<Receta> re;
    private ParseJson parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener el fichero json desde la carpeta raw
        InputStream is = getResources().openRawResource(R.raw.entrantes);
        try {
            // re = readJsonStream(is);
            parse = new ParseJson();
            re = parse.readJsonStream(is);
            System.out.println("Lectura Json terminada");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView et = (TextView) findViewById(R.id.tv_test_json);

        StringBuilder receta = new StringBuilder();
        // Recorrer objeto List<Receta> y concatenarlo en una variable para
        // mostrarlo.
        for (Receta r : re) {
            receta.append("Nombre: " + r.getNombre());
            receta.append("\nPueblo: " + r.getPueblo());
            if (r.getIngredientes() != null) {
                receta.append("\nIngredientes:\n " + r.getIngredientes()
                        + "\n\n");
            }
        }

        et.setText(receta);

    }

}
