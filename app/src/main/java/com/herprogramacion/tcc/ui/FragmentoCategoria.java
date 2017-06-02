package com.herprogramacion.tcc.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.tcc.ejb.Evento;
import com.herprogramacion.tcc.services.EventosCatWS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Fragmento que representa el contenido de cada pestaña dentro de la sección "Categorías"
 */
public class FragmentoCategoria extends Fragment {

    private static final String INDICE_SECCION
            = "com.restaurantericoparico.FragmentoCategoriasTab.extra.INDICE_SECCION";

    private RecyclerView reciclador;
    private GridLayoutManager layoutManager;
    private AdaptadorCategorias adaptador;

    public static FragmentoCategoria nuevaInstancia(int indiceSeccion) {
        FragmentoCategoria fragment = new FragmentoCategoria();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_grupo_items, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        reciclador.setLayoutManager(layoutManager);

        int indiceSeccion = getArguments().getInt(INDICE_SECCION);
        List<Evento> eventos = new ArrayList<>();
        switch (indiceSeccion) {
            case 0:
                try {
                    eventos = buscaEventosCat(1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adaptador = new AdaptadorCategorias(eventos);
                break;
            case 1:
                try {
                    eventos = buscaEventosCat(2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adaptador = new AdaptadorCategorias(eventos);
                break;
            case 2:
                try {
                    eventos = buscaEventosCat(3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adaptador = new AdaptadorCategorias(eventos);
                break;
        }

        reciclador.setAdapter(adaptador);

        return view;
    }

    public List<Evento> buscaEventosCat(int cat) throws JSONException {

        String cab ="";
        EventosCatWS eventosWS = new EventosCatWS();
        List<Evento> eventos = new ArrayList<>();
        try {
            cab = eventosWS.execute(String.valueOf(cat)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (!cab.equals("") ||cab.isEmpty()) {
            Gson gson = new Gson();
            JSONArray jsonObj;
            jsonObj = new JSONArray(cab);

            for (int i = 0; i < jsonObj.length(); i++) {
                JSONObject j = (JSONObject) jsonObj.get(i);
                Evento t = gson.fromJson(String.valueOf(j), Evento.class);
                eventos.add(t);
            }
        }

        return eventos;
    }

}
