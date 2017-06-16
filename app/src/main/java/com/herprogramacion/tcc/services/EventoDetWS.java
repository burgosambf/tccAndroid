package com.herprogramacion.tcc.services;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TID01 on 28/04/2017.
 */
public class EventoDetWS extends AsyncTask<String, Void,String> {
    protected String doInBackground(String... params) {

        boolean resul = true;
        HttpURLConnection con = null;
        String id = "";
        int le = params.length;
        if (le>0){
            id = params[0];
        }
        String url = "http://181.120.212.172:9090/TicketRest/webresources/eventocab/eventosDet/" + id;
        URL object;
        String json = "";
        try {
            object = new URL(url);
            con = (HttpURLConnection) object.openConnection();

            //con.setRequestProperty("Content-Type", "application/json");
            con.setRequestMethod("GET");

            int HttpResult = con.getResponseCode(); // aqui DEBE devolver 200 - OK

            System.out.println("Respuesta: " + HttpResult);

            if (HttpResult == 200) {
                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                int car = br.read();
                while (car != -1) {
                    json = json + (char) car;
                    car = br.read();
                }
                System.out.println("" + json);
                //br.close();

                return json;


            } else {
                System.out.println(con.getResponseMessage());
            }
            return json;
        } catch (Exception e) {
            System.out.println("Respuesta: " + e);
            return null;
        }
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }

}
