package com.herprogramacion.tcc.services;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TID01 on 22/03/2017.
 */
public class LogginWS extends AsyncTask<String,Integer,Boolean> {
    protected Boolean doInBackground(String... params) {

        boolean resul = true;
        HttpURLConnection con = null;
        String url= "http://181.120.212.172:9090/TicketRest/webresources/usuario/loggin";
        URL object;
        try {
            object = new URL(url);
            con = (HttpURLConnection) object.openConnection();

            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");

            String user = params[0];
            String pass = params[1];

            JSONObject cred = new JSONObject();
            cred.put("nomUser", user);
            cred.put("password", pass);


            System.out.println(cred);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(cred.toString());
            wr.close();

            int HttpResult = con.getResponseCode(); // aqui DEBE devolver 200 - OK

            System.out.println("Respuesta: " + HttpResult);

            if (HttpResult == 200) {
                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                System.out.println("" + sb.toString());
            } else {
                System.out.println(con.getResponseMessage());
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return resul;
    }

    /*protected void onPostExecute(Boolean result) {
        if (result)
        {
            lblResultado.setText("Insertado OK.");
        }
    }*/
}
