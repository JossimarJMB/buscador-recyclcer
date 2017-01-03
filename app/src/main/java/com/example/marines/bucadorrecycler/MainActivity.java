package com.example.marines.bucadorrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Notas> listaNotas;
    RecyclerAdaptador recyclerAdaptador;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llamamos el recyclerView del xml
        recyclerView = (RecyclerView) findViewById(R.id.rvNotas);
        //iniciar metodo cargarNotas
        cargarNotas();
    }

    public void cargarNotas(){
        //Llamamos el recycler iniciamos y declaramos la orientacion
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
      //llamamos el metodo  getlistaNotas de la clase Notas
        listaNotas = new Notas().getlistaNotas();


        //Verificamos que exista un valor en la lista
        if (listaNotas != null) {
            //creamos el adaptador del recycler agregamos la lista de notas y el onIntemClickListener
            recyclerAdaptador = new RecyclerAdaptador(listaNotas, new RecyclerAdaptador.OnItemClickListener() {
                @Override
                //Obtenemos la posicion
                public void onItemClick(final int position) {
                    Toast.makeText(getApplicationContext(),"posiciòn "+position,Toast.LENGTH_LONG).show();
                }
            });
            //Agregamos el adaptador al recycler
            recyclerView.setAdapter(recyclerAdaptador);
        }

    }
}
