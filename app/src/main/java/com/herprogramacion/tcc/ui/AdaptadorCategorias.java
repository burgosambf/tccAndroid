package com.herprogramacion.tcc.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.tcc.ejb.Evento;
import com.herprogramacion.tcc.services.EventosCatWS;

import java.util.LinkedList;
import java.util.List;

/**
 * Adaptador para comidas usadas en la sección "Categorías"
 */
public class AdaptadorCategorias
        extends RecyclerView.Adapter<AdaptadorCategorias.ViewHolder> {
    EventosCatWS eventosCatWS = new EventosCatWS();

    private List<Evento> items = new LinkedList<>();//final


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);

            nombre = (TextView) v.findViewById(R.id.nombre_comida);
            precio = (TextView) v.findViewById(R.id.precio_comida);
            imagen = (ImageView) v.findViewById(R.id.miniatura_comida);
        }
    }

    /*public AdaptadorCategorias() throws JSONException {

        String cab = "";
        try {
            cab = eventosCatWS.execute().get();
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
            items.add(t);
        }

    }*/

    public AdaptadorCategorias(List<Evento> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        if (items.equals(null)) {
            return 0;
        } else {
            return items.size();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_categorias, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Evento item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(R.drawable.cafe)
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(item.getNomeven());
        viewHolder.precio.setText(item.getFecInicio());

    }


}