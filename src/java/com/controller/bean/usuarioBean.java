/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller.bean;

/**
 *
 * @author LENOVO
 */
import com.complemento.Configuracion;
import com.entidad.Rol;
import com.entidad.Usuario;
import com.model.ModelUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class usuarioBean implements Serializable{
    
    private Usuario user=new Usuario();
    
    Configuracion conf = new Configuracion();
    private String token = "";
    private String Username = "";
    private String BaseApi = "";
 
 

    public usuarioBean() {
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public String registrarUsuario(){
        user.setEstado("S");
        ModelUsuario model=new ModelUsuario();
        boolean ok=model.agregar(user, BaseApi, token, Username);
        if(ok){
           limpiarUsuario(); 
           return "usuario.xhtml?faces-redirect=true"; 
        }
        return "";
    }
    public void limpiarUsuario(){
        user.getRol().setId(0);
        user.setNombre("");
        user.setApellidos("");
        user.setEmail("");
        user.setPassword("");
        
    }

}
