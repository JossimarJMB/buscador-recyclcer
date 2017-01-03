package com.example.marines.bucadorrecycler;

import java.util.ArrayList;

/**
 * Created by Marines on 13/09/2016.
 */
public class Notas {
    //Creamos variables
    public String nota;
    public boolean realizado;

    public Notas(){

        //inicializamos las variables
        nota="";
        realizado=false;
    }

    public Notas(String nota,boolean realizado){
        //Recibimos parametros del constructor y los agregamos al nuestras variables
        this.nota=nota;
        this.realizado=realizado;
    }

    public String getNota() {
        return nota;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public ArrayList<Notas> getlistaNotas(){
        Notas objetoNota = null;
        ArrayList<Notas> lista = new ArrayList<Notas>();
        //Arreglo de notas
        String[] arrayNotas= new String[]{"Tener el primer lugar en el Top de CodigoFacilito","Aprender Android","Aprender nuevos lenguajes","Ser buena persona O:)","Bañar al perro","Terminar mi proyecto de android","Tomar cursos nuevos","etc..."};

        //Arreglo de si se realizo o no
        boolean[] arrayRealizado= new boolean[]{false,false,false,true,true,true,false,false};
        try {
            //El arrayNotas y el arrayRealizado tienen que tener la misma cantidad de elementos
            for(int i = 0; i <arrayNotas.length; i++) {
                String nota = arrayNotas[i];
                boolean realizado=arrayRealizado[i];
                //Agregamos los elementos al objeto
                objetoNota = new Notas(nota,realizado);
                //agregamos el objeto a nuesta lista asi hasta que se llene con todos los elementos
                lista.add(objetoNota);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Retornamos la lista
        return lista;
    }
}
