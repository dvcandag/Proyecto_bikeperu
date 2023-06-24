/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento.Menu;

/**
 *
 * @author efrai
 */
public class Permiso {
    private String rol;
    private Integer Leer;
    private Integer agregar; 
    private Integer Editar;
    private Integer eliminar;
    private Integer facturar;

    public Permiso() {
    }

    public Permiso(String rol, Integer Leer, Integer agregar, Integer Editar, Integer eliminar, Integer facturar) {
        this.rol = rol;
        this.Leer = Leer;
        this.agregar = agregar;
        this.Editar = Editar;
        this.eliminar = eliminar;
        this.facturar = facturar;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getLeer() {
        return Leer;
    }

    public void setLeer(Integer Leer) {
        this.Leer = Leer;
    }

    public Integer getAgregar() {
        return agregar;
    }

    public void setAgregar(Integer agregar) {
        this.agregar = agregar;
    }

    public Integer getEditar() {
        return Editar;
    }

    public void setEditar(Integer Editar) {
        this.Editar = Editar;
    }

    public Integer getEliminar() {
        return eliminar;
    }

    public void setEliminar(Integer eliminar) {
        this.eliminar = eliminar;
    }

    public Integer getFacturar() {
        return facturar;
    }

    public void setFacturar(Integer facturar) {
        this.facturar = facturar;
    }
    
}
