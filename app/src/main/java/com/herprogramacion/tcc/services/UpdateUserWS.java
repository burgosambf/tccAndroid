package com.herprogramacion.tcc.services;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by TID01 on 10/01/2017.
 */
public class UpdateUserWS extends AsyncTask<String,Integer,Boolean> {
    protected Boolean doInBackground(String... params) {

        boolean resul = true;
        HttpsURLConnection con = null;
        String url= "";
        URL object;
        try {
        object = new URL(url);
        con = (HttpsURLConnection) object.openConnection();

        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("PUT");

        JSONObject cred = new JSONObject();
        /*cred.put("codIdPer", clave);
        cred.put("numId", cedula);
        cred.put("codPer", monto);
        cred.put("codTel", idTransaccion);
        cred.put("numTel", numeroOperacion);
        cred.put("codCliente", cuota);
        cred.put("tipoCliente", numeroDePagare);
        cred.put("usuario", numeroDePagare);
        cred.put("numTel", numeroDePagare);
        cred.put("pass", numeroDePagare);
        cred.put("codDireccion", numeroDePagare);
        cred.put("direccion", numeroDePagare);
        cred.put("estadoCliente", numeroDePagare);
        */

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
