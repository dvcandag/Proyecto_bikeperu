/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.entidad.Tipodocumentoidentidad;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author efrai
 */
public class ModelIdentificacion {
    
    public List<Tipodocumentoidentidad> listarIdentificacion(String url, String token, String username){
        ArrayList<Tipodocumentoidentidad> lista = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "documentoidentidad")
                    .addHeader("Authorization", String.format("Bearer %s", token))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("username", username)
                    .build();

            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                Gson gson = new Gson();
                ApiResData respons = gson.fromJson(response.body().string(), ApiResData.class);
                JSONArray array = new JSONArray(respons.getBody());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Tipodocumentoidentidad m = new Tipodocumentoidentidad();
                    m.setId(object.getInt("id"));
                    m.setDescripcion(object.getString("descripcion"));
                    m.setCodigo(object.getInt("codigo"));
                    m.setEstado(object.getString("estado"));
                    lista.add(m);
                }
                return lista;
            }
        } catch (Exception e) {
        } 
        return lista;
        
    }
    
}
