/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiRes;
import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import okhttp3.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
 
public class ModelCategoria {

    public ModelCategoria() {
    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    public List<Categoria> listarCategorias(String url, String token, String username) {
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca")
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
                    Categoria m = new Categoria();
                    m.setId(object.getInt("Id"));
                    m.setNombre(object.getString("Nombre"));
                    m.setDescripcion(object.getString("Descripcion"));
                    m.setEstado(object.getString("Estado"));
                    lista.add(m);
                }
                return lista;
            }
        } catch (Exception e) {
        } 
        return lista;
    }

    public void agregar(Categoria categoria, String url, String token, String username) {
        RequestBody body = new FormBody.Builder()
                .add("Id", "0")
                .add("Nombre", categoria.getNombre())
                .add("Descripcion", categoria.getDescripcion())
                .add("Estado", categoria.getEstado())
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca")
                    .post(body)
                    .addHeader("Authorization", String.format("Bearer %s", token))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("username", username)
                    .build();

            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            String res = response.body().string();
            ApiRes respons = gson.fromJson(res,  ApiRes.class);
            if (response.code() == 201) {
                System.out.println("response: " + response);
                addMessage(FacesMessage.SEVERITY_INFO, "Exitoso", respons.getBody());
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error", respons.getBody());
            }
        } catch (IOException e) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error fatal", e.getMessage());
        }
    }

    public void modificar(Categoria categoria, String url, String token, String username) {
        RequestBody body = new FormBody.Builder()
                .add("Id", categoria.getId().toString())
                .add("Nombre", categoria.getNombre())
                .add("Descripcion", categoria.getDescripcion())
                .add("Estado", categoria.getEstado())
                .build();
        
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca/"+ categoria.getId())
                    .put(body)
                    .addHeader("Authorization", String.format("Bearer %s", token))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("username", username)
                    .build();

            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            String res = response.body().string();
            ApiRes respons = gson.fromJson(res,  ApiRes.class);
            if (response.code() == 200) {
                System.out.println("response: " + response);
                addMessage(FacesMessage.SEVERITY_INFO, "Exitoso", respons.getBody());
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error", respons.getBody());
            }
        } catch (IOException e) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error fatal", e.getMessage());
        } 
    }

    public void eliminar(Categoria categoria, String url, String token, String username) {
        RequestBody body = new FormBody.Builder()
                .add("Id", categoria.getId().toString()) 
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca/"+categoria.getId())
                    .delete(body)
                    .addHeader("Authorization", String.format("Bearer %s", token))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("username", username)
                    .build();

            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            String res = response.body().string();
            ApiRes respons = gson.fromJson(res,  ApiRes.class);
            if (response.code() == 200) {
                System.out.println("response: " + response);
                addMessage(FacesMessage.SEVERITY_INFO, "Exitoso", respons.getBody());
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error", respons.getBody());
            }
        } catch (IOException e) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error fatal", e.getMessage());
        }
    }
}
