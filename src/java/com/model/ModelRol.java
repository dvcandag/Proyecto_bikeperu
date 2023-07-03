/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiRes;
import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.entidad.Rol;
import com.entidad.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.AbstractList;
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
 
public class ModelRol {
    private String endPoint="rol";
    public ModelRol() {
    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    } 
   public List<Rol> ListarClientes(String url, String token, String username) {

       ArrayList<Rol> lista = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + endPoint)
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
                    Rol m = new Rol();
                   m.setId(object.getInt("Id"));
                   m.setNombreRol(object.getString("NombreRol"));
                    lista.add(m);
                } 
                return lista;
            }else{
                lista.addAll(getListaRollDefault(response.body().string()));
            }
        } catch (Exception e) {
            System.out.println("error lista rol "+e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
   private List<Rol> getListaRollDefault(String mensajeAdd){
       //response.body().string();
       List<Rol> lista=new ArrayList<>();
       Rol role1 = new Rol();
        role1.setId(1);
        role1.setNombreRol("Administrador");
        lista.add(role1);
        
        role1 = new Rol();
        role1.setId(2);
        role1.setNombreRol("Vendedor");
        lista.add(role1);
        
        role1 = new Rol();
        role1.setId(3);
        role1.setNombreRol("Cliente");
        lista.add(role1);
        return lista;
        
   }
    
}
