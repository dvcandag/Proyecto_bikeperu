package com.model;

import com.complemento.ApiRes;
import com.complemento.ApiResData;
import com.entidad.Marca;
import com.entidad.Producto;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class ModelMarca {

    public ModelMarca() {
    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public ArrayList<Marca> listarMarcas(String url, String token, String username) {
        ArrayList<Marca> lista = new ArrayList<>();

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
                Producto p = new Producto();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Marca m = new Marca();
                    m.setId(object.getInt("Id"));
                    m.setNombre(object.getString("Nombre"));
                    m.setDescripcion(object.getString("Descripcion"));
                    m.setEstado(object.getString("Estado"));
                    lista.add(m);
                }
                return lista;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public void agregar(Marca marca, String url, String token, String username) {

        RequestBody body = new FormBody.Builder()
                .add("Id", "0")
                .add("Nombre", marca.getNombre())
                .add("Descripcion", marca.getDescripcion())
                .add("Estado", marca.getEstado())
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

    public void modificar(Marca marca, String url, String token, String username) {
        
        RequestBody body = new FormBody.Builder()
                .add("Id", marca.getId().toString())
                .add("Nombre", marca.getNombre())
                .add("Descripcion", marca.getDescripcion())
                .add("Estado", marca.getEstado())
                .build();
        
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca/"+ marca.getId())
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

    public void eliminar(Marca marca, String url, String token, String username) {
        
        RequestBody body = new FormBody.Builder()
                .add("Id", marca.getId().toString()) 
                .build();
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "marca/"+marca.getId())
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
