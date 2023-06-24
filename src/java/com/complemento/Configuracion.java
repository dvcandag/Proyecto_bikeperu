/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento;

import com.entidad.Rol;
import com.entidad.Usuario;
import javax.faces.context.FacesContext;

/**
 *
 * @author efrai
 */
public class Configuracion {

    private final String baseApi = "http://localhost:5100/api/";
    private final String usename = "";
    private final String token = "";
    private final Integer UserId = 0;
    private final Integer RolId = 0; 
    

    public Configuracion() {
    }

    public String getBaseApi() {
        return baseApi;
    } 
    public String getUsename() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_usuario");
        Rol rol = (Rol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_rol");
        return user.getEmail();
    }

    public String getToken() {
           
        return  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("token");
    }

    public Integer getUserId() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_usuario");
         return user.getId();
    }

    public Integer getRolId() {
        Rol rol = (Rol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_rol");
        return rol.getId();
    }
    
 

}
