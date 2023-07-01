/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Configuracion;
import com.entidad.Marca;
import com.model.ModelMarca;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@ViewScoped

public class marcaBean implements Serializable{

    /**
     * Creates a new instance of marcaBean
     */
    private List<Marca> listarMarcas;
    private Marca marca;
    
    Configuracion conf = new Configuracion();
    private String token = "";
    private String Username = "";
    private String BaseApi = "";

    public marcaBean() {
        marca = new Marca();
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
    }

    public List<Marca> getListarMarcas() {
        ModelMarca ad = new ModelMarca();
        listarMarcas = ad.listarMarcas(this.BaseApi, this.token, this.Username);
        return listarMarcas;
    }

    public void setListarMarcas(List<Marca> listarMarcas) {
        this.listarMarcas = listarMarcas;
    }

    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
 
    public void limpiarMarca() {
        marca = new Marca();
    }

    public void agregarMarca() {
        ModelMarca ad = new ModelMarca();
        ad.agregar(marca, this.BaseApi, this.token, this.Username);
    }

    public void modificarMarca() {
        ModelMarca ad = new ModelMarca();
        ad.modificar(marca, this.BaseApi, this.token, this.Username);
        this.limpiarMarca();
    }

    public void eliminarMarca() {
        ModelMarca ad = new ModelMarca();
        ad.eliminar(marca,this.BaseApi, this.token, this.Username);
        this.limpiarMarca();
    }

}
