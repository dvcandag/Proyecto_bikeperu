/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import okhttp3.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
 
public class ModelCategoria {
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

    public void agregar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {

            sesion.save(categoria);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        }
        sesion.close();
    }

    public void modificar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.update(categoria);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        }
        sesion.close();
    }

    public void eliminar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.delete(categoria);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } 
        sesion.close();
    }
}
