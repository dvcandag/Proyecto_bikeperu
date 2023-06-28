/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.Menu.Menu;
import com.complemento.Menu.SubMenu;
import com.entidad.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author efrai
 */
public class ModelAuth {

    public String Login(Usuario usuario, String url) {
        String lista = "";
        try {

            RequestBody body = new FormBody.Builder()
                    .add("email", usuario.getEmail())
                    .add("password", usuario.getPassword())
                    .build();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "auth/signin")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            String res = response.body().string();
            if (response.code() == 200) {
                lista = res;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Menu> listarMenu(String token, String username, String url, Integer IdUser, Integer IdRol) {
        ArrayList<Menu> lista = new ArrayList<>();
        
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "user/" + IdUser + "/" + username + "/" + IdRol)
                    .get()
                    .addHeader("Authorization", String.format("Bearer %s", token))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("username", username)
                    .build();

            Response response = client.newCall(request).execute();
            String res = response.body().string();
            if (response.code() == 200) {
                Gson gson = new Gson();
                JSONObject obj = new JSONObject(res);
                JSONObject menus = obj.getJSONObject("body");
                JSONArray objs = menus.getJSONArray("menu");
                Menu mn = new Menu();               
                


                for (Object ob : objs) {
                    JSONObject data = new JSONObject(ob.toString());
                    mn.setPagina(data.getString("pagina"));
                    mn.setBaseurl(data.getString("baseurl"));
                    mn.setIcono(data.getString("icono"));
                    mn.setId(data.getInt("id"));

                    ArrayList<SubMenu> listSub = new ArrayList<>();
                    
                    JSONArray array = new JSONArray(data.getJSONArray("submenu"));
                    if (array.toList().size() > 0) {
                        for (Object obj1 : array) {
                            SubMenu subn = new SubMenu();
                            SubMenu submenu = gson.fromJson(obj1.toString(), SubMenu.class);
                            listSub.add(submenu);
                        }
                        mn.setSubmenu(listSub);
                    } else {
                        mn.setSubmenu(listSub);
                    }
                    lista.add(mn);
                    mn = new Menu(); 

                }

//                lista = md.fromJson(json, classOfT)
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

}
