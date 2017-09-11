package br.ufrn.eaj.tads.exemploautocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Fruta> listafrutas = new ArrayList<>();

    //private static final String[] FRUTAS = new String[]{"Banana", "Maça", "Pera", "Abacaxi", "Tomate", "Uva", "Melão", "Goiaba", "Caja", "Caju", "Manga"};
    String[] FRUTAS;

    ArrayAdapter<String> adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preencheArray();

        AutoCompleteTextView autoCompleteFrutas = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FRUTAS);
        autoCompleteFrutas.setAdapter(adaptador);

        autoCompleteFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, ((TextView) view).getText().toString() +"item="+i+"col="+l   , Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,
                        adaptador.getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        MultiAutoCompleteTextView multiAutoCompleteFrutas = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteFrutas.setAdapter(adaptador);
        multiAutoCompleteFrutas.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString() +"item="+i+"col="+l   , Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString() +"item="+i+"col="+l   , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void preencheArray(){

        Fruta f1 = new Fruta("Maça", "Vermelha");
        Fruta f2 = new Fruta("Uva", "Verde");
        Fruta f3 = new Fruta("Goiaba", "Verde");
        Fruta f4 = new Fruta("Graviola", "Verde");
        Fruta f5 = new Fruta("Jambo", "Roxa");
        Fruta f6 = new Fruta("Melão", "Laranja");

        listafrutas.add(f1);
        listafrutas.add(f2);
        listafrutas.add(f3);
        listafrutas.add(f4);
        listafrutas.add(f5);
        listafrutas.add(f6);

        FRUTAS = new String[listafrutas.size()];

        int i = 0;
        for (Fruta l: listafrutas){
            FRUTAS[i] = l.getNome();
            i++;
        }

    }
}
