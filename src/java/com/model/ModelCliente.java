/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiRes;
import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.entidad.Cliente;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
public class ModelCliente {

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public List<Cliente> ListarClientes(String url, String token, String username) {
//        List<Cliente> lista = null;
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction t = sesion.beginTransaction();
//        String hql = "From Cliente order by id desc";
//        try {
//            
//            lista = sesion.createQuery(hql).list();
//            t.commit();
//        } catch (HibernateException e) { 
//            t.rollback(); 
//        }
//        sesion.close();
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "cliente")
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
                    Cliente m = new Cliente();
                    m.setId(object.getInt("Id"));
                    m.setRazonSocial(object.getString("RazonSocial"));
                    m.setDocumento(object.getString("Documento"));
                    m.setDireccion(object.getString("Direccion"));
                    m.setTipo(object.getString("Tipo"));
                    lista.add(m);
                }
                return lista;
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public void guardar(Cliente cliente,String url, String token, String username) {
         RequestBody body = new FormBody.Builder()
                .add("Id", "0")
                .add("RazonSocial", cliente.getRazonSocial())
                .add("Documento", cliente.getDocumento())
                .add("Direccion", cliente.getDireccion())
                .add("Tipo", cliente.getTipo())
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "cliente")
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

    public void actualizar(Cliente cliente,String url, String token, String username) {
        
        RequestBody body = new FormBody.Builder()
                .add("Id", cliente.getId().toString())
                .add("RazonSocial", cliente.getRazonSocial())
                .add("Documento", cliente.getDocumento())
                .add("Direccion", cliente.getDireccion())
                .add("Tipo", cliente.getTipo())
                .build();
        
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "cliente/"+ cliente.getId())
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

    public void eliminar(Cliente cliente,String url, String token, String username) {
        RequestBody body = new FormBody.Builder()
                .add("Id", cliente.getId().toString()) 
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "cliente/"+cliente.getId())
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
