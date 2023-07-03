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
import com.model.ModelRol;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class rolBean implements Serializable{
    public ArrayList<Rol>  listaRoles=new ArrayList<>();
    
    
    Configuracion conf =null;
    private String token = "";
    private String Username = "";
    private String BaseApi = "";
 
 

    public rolBean() {
        conf = new Configuracion();
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
    }
    

    
    public void setListaRoles(ArrayList<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }
   
    
    public ArrayList<Rol> getListaRoles() {

        /*Rol role1 = new Rol();
        role1.setId(1);
        role1.setNombreRol("Administrador");
        this.listaRoles.add(role1);
        
        role1 = new Rol();
        role1.setId(2);
        role1.setNombreRol("Vendedor");
        this.listaRoles.add(role1);
        
        role1 = new Rol();
        role1.setId(3);
        role1.setNombreRol("Cliente");
        this.listaRoles.add(role1);
        */
        ModelRol model=new ModelRol();
        listaRoles.addAll(model.ListarClientes(BaseApi,token , Username));
        return listaRoles;
    }

}
