/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.herprogramacion.tcc.pager;

import android.content.Context;

import com.google.gson.Gson;
import com.herprogramacion.tcc.ejb.EventoDetalle;
import com.herprogramacion.tcc.pager.model.AbstractWizardModel;
import com.herprogramacion.tcc.pager.model.BranchPage;
import com.herprogramacion.tcc.pager.model.Datos;
import com.herprogramacion.tcc.pager.model.MultipleFixedChoicePage;
import com.herprogramacion.tcc.pager.model.PageList;
import com.herprogramacion.tcc.pager.model.SingleFixedChoicePage;
import com.herprogramacion.tcc.services.EventoDetWS;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class SandwichWizardModel extends AbstractWizardModel {
    String evento = null;
    private List<EventoDetalle> eventos = new ArrayList<EventoDetalle>();
    private EventoDetalle eventoDetalle = new EventoDetalle();

    public SandwichWizardModel(Context context) {
        super(context);
/*        evento = cod;
throws JSONException
        eventoDetalle = buscaEventosDet(Integer.valueOf(cod));*/

    }

    public List<EventoDetalle> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDetalle> eventos) {
        this.eventos = eventos;
    }

    public EventoDetalle getEventoDetalle() {
        return eventoDetalle;
    }

    public void setEventoDetalle(EventoDetalle eventoDetalle) {
        this.eventoDetalle = eventoDetalle;
    }

    @Override
    protected PageList onNewRootPageList() {
        List<Datos> sectores = new LinkedList<Datos>();
        List<Datos> horarios = new LinkedList<Datos>();
        try {
            eventoDetalle = buscaEventosDet(Integer.valueOf("61"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (EventoDetalle.Sectores temp : eventoDetalle.getSectores()) {
            Datos d = new Datos();
            d.setCodigo(temp.getCodSector());
            d.setDetalle(temp.getDescripcion());
            sectores.add(d);
        }
        for (EventoDetalle.Horarios temp : eventoDetalle.getHorarios()) {
            Datos d = new Datos();
            d.setCodigo(temp.getCodHorario());
            d.setDetalle(temp.getFecInicio());
            horarios.add(d);
        }
        return new PageList(
                new BranchPage(this, "Evento")
                        .addBranch(new Datos("01", "Entrada"),
                                new SingleFixedChoicePage(this, "Sectores")
                                        .setChoices(sectores)//(new Datos("White", "White"), new Datos("Wheat", "Wheat"))
                                        .setRequired(true),

                                new MultipleFixedChoicePage(this, "Horarios")
                                        .setChoices(horarios))//(new Datos("Pepperoni", "Pepperoni"), new Datos("Turkey", "Turkey")),

                                /*new MultipleFixedChoicePage(this, "Veggies")
                                        .setChoices(new Datos("Tomatoes", "Tomatoes"),
                                                new Datos("Lettuce", "Lettuce"),
                                                new Datos("Onions", "Onions")),

                                new MultipleFixedChoicePage(this, "Cheeses")
                                        .setChoices(new Datos("Swiss", "Swiss"),
                                                new Datos("American", "American"),
                                                new Datos("Pepperjack", "Pepperjack")),

                                new BranchPage(this, "Toasted?")
                                        .addBranch("Yes",
                                                new SingleFixedChoicePage(this, "Toast time")
                                                        .setChoices(new Datos("30 seconds", "30 seconds"), new Datos("2 minute",
                                                                "2 minutes")))
                                        .addBranch("No")
                                        .setValue("No"))

                        .addBranch("Salad",
                                new SingleFixedChoicePage(this, "Salad type")
                                        .setChoices(new Datos("Greek", "Greek"), new Datos("Caesar", "Caesar"))
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Dressing")
                                        .setChoices(new Datos("No dressing", "No dressing"), new Datos("Balsamic", "Balsamic"))
                                        .setValue("No dressing")
                        )
*/
                        .setRequired(true)/*,

                new CustomerInfoPage(this, "Your info")
                        .setRequired(true)*/
        );
    }

    public EventoDetalle buscaEventosDet(int cat) throws JSONException {//List<EventoDetalle>
        EventoDetalle t = null;
        try {
            String cab = "";
            EventoDetWS eventosWS = new EventoDetWS();
            try {
                cab = eventosWS.execute(String.valueOf(cat)).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (!cab.equals("") || cab.isEmpty()) {
                Gson gson = new Gson();
                //JSONArray jsonObj;
                JSONObject jsonObj;
                jsonObj = new JSONObject(cab);

                //for (int i = 0; i < jsonObj.length(); i++) {
                //JSONObject j = (JSONObject) jsonObj.get(0);
                t = gson.fromJson(String.valueOf(jsonObj), EventoDetalle.class);
                //EventoDetalle t = gson.fromJson(String.valueOf(j), EventoDetalle.class);
                //eventos.add(t);
                //}
            }

            return t;//eventos;
        } catch (JSONException e) {
            System.out.println(e);
        }
        return t;
    }
}
