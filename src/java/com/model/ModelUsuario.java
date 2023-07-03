/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.ApiRes;
import com.complemento.ApiResData;
import com.entidad.Categoria;
import com.entidad.Usuario;
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
 
public class ModelUsuario {
    private String endPoint="user";
    public ModelUsuario() {
    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    } 
    public boolean agregar(Usuario usuario, String url, String token, String username) {
       
        
        RequestBody body = new FormBody.Builder()
                .add("Nombre", usuario.getNombre())
                .add("Email", usuario.getEmail())
                .add("Password", usuario.getPassword())
                .add("IdRol", String.valueOf(usuario.getRol().getId()))
                .add("Estado", usuario.getEstado())
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + endPoint)
                    .post(body)
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
                return true;
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error", respons.getBody());
            }
        } catch (IOException e) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error fatal", e.getMessage());
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error fatal", e.getMessage());
        }
        return false;
    }

    
}
