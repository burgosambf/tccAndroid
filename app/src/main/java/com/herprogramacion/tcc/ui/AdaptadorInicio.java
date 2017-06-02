package com.herprogramacion.tcc.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.tcc.ejb.Evento;
import com.herprogramacion.tcc.services.EventosWS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * Adaptador para mostrar las comidas más pedidas en la sección "Inicio"
 */
public class AdaptadorInicio
        extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {
    public static Context context;
    List<Evento> eventos = new ArrayList<>();
    EventosWS eventosWS = new EventosWS();


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);

            nombre = (TextView) v.findViewById(R.id.nombre_comida);
            precio = (TextView) v.findViewById(R.id.precio_comida);
            imagen = (ImageButton) v.findViewById(R.id.miniatura_comida);
            imagen.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Toast.makeText(arg0.getContext(),nombre.getText(), Toast.LENGTH_SHORT).show();
                    //arg0.getContext().startActivity(new Intent(arg0.getContext(), ReservarEvento.class));
                    Intent intent = new Intent(arg0.getContext(), ComprarEvento.class);//ReservarEvento.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 1); //Your id
                    intent.putExtras(b);
                    arg0.getContext().startActivity(intent);
                    //Intent comprar =new Intent(arg0.getContext(),FragmentoCategorias.class);
                    //arg0.getContext().startActivity(comprar);

                }

            });

        }
    }

    public AdaptadorInicio() throws JSONException {
        String cab = "";
        try {
            cab = eventosWS.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JSONArray jsonObj = new JSONArray(cab);

        for (int i = 0; i < jsonObj.length(); i++) {
            JSONObject j = (JSONObject) jsonObj.get(i);
            Evento t = gson.fromJson(String.valueOf(j), Evento.class);
            eventos.add(t);
        }

    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_inicio, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //Comida item = Comida.COMIDAS_POPULARES.get(i);
        Evento evento = eventos.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(R.drawable.futbol)
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(evento.getNomeven());
        viewHolder.precio.setText(evento.getFecInicio());

    }


}