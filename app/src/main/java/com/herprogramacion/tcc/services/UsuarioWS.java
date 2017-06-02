package com.herprogramacion.tcc.services;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TID01 on 06/01/2017.
 */
public class UsuarioWS extends AsyncTask<String,Integer,Boolean> {
    protected Boolean doInBackground(String... params) {

        boolean resul = true;
        HttpURLConnection con = null;
        String url= "http://181.120.188.210:9090/TicketRest/webresources/usuario/crear";
        URL object;
        try {
            object = new URL(url);
            con = (HttpURLConnection) object.openConnection();

            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("PUT");

            String pais = params[0];
            String nombre = params[1];
            String apellido = params[2];
            String sexo = params[3];
            String nacimiento = params[4];
            String codId = params[5];
            String numId = params[6];
            String direccion = params[7];
            String numeroTel = params[8];
            String user = params[9];
            String pass = params[10];
            String tipoUser = params[11];

            JSONObject cred = new JSONObject();
            cred.put("pais", pais);
            cred.put("nombre", nombre);
            cred.put("apellido", apellido);
            cred.put("sexo", sexo);
            cred.put("nacimiento", nacimiento);
            cred.put("codId", codId);
            cred.put("numeroId", numId);
            cred.put("direccion", direccion);
            cred.put("numTel", numeroTel);
            cred.put("usuario", user);
            cred.put("pass", pass);
            cred.put("tipoUsu", tipoUser);


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
