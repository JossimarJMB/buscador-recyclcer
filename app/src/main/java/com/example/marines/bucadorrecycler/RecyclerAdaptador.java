package com.example.marines.bucadorrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder>{

    private  ArrayList<Notas> listanotas;
    private  OnItemClickListener listener;

    //Con interface podemos utilizar metodos y variables de manera polimorfica
    public interface OnItemClickListener {
        //metodo onclick donde retornaremos la posicion de cada elemento de la lista
        void onItemClick(int posicion);
    }
 //Constructor que recibe parametros y los agrega a los de esta clase
    public RecyclerAdaptador(ArrayList<Notas> lista, OnItemClickListener listener){
        this.listanotas = lista;
        this.listener = listener;
    }

    //ViewHolder obtenemos la vista de nuestro adaptador
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptador_nota,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        //Retornamos la vista
        return viewHolder;
    }

    //En este metodo recibimos la vista y la posicion del elemento de nuestro recycler
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //retornamos la posicion actual
        holder.bind(listanotas.get(position),position,listener);
    }

    @Override
    public int getItemCount() {
        return listanotas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnota;
        public ViewHolder(View itemView) {
            super(itemView);
            //llamamos el texview del xml
            txtnota=(TextView)itemView.findViewById(R.id.txtNota);

        }

        public void bind(final Notas nota, final int posicion, final OnItemClickListener listener) {
            //Agregamos la nota a nuestro texview del adaptador
            txtnota.setText(nota.getNota());

            //Metodo onclic cuando nosotros precionemos un elemento se retornara la posicion
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(posicion);
                }
            });

        }
    }


}
