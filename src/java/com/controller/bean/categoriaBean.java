/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Configuracion;
import com.entidad.Categoria;
import com.entidad.Marca;
import com.model.ModelCategoria;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@ViewScoped
public class categoriaBean {

    /**
     * Creates a new instance of categoriaBean
     */
    private List<Categoria> listarCategorias;
    private Categoria categoria;
    
    
    Configuracion conf = new Configuracion();
    private String token = "";
    private String Username = "";
    private String BaseApi = "";
 
 

    public categoriaBean() {
        categoria = new Categoria();
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
    }

    public List<Categoria> getListarCategorias() {
        ModelCategoria model = new ModelCategoria();
        listarCategorias = model.listarCategorias(this.BaseApi, this.token, this.Username);
        return listarCategorias;
    }

    public void setListarCategorias(List<Categoria> listarCategorias) {
        this.listarCategorias = listarCategorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void guardarRegistro() {
        ModelCategoria model = new ModelCategoria();
        model.agregar(categoria);
    }

    public void limpiarRegistro() {
        categoria = new Categoria();
    }

    public void actualizarRegistro() {
        ModelCategoria model = new ModelCategoria();
        model.modificar(categoria);
        this.limpiarRegistro();
    }

    public void eliminarRegistro() {
        ModelCategoria model = new ModelCategoria();
        model.eliminar(categoria);
        this.limpiarRegistro();
    }
}
