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
public class Serie {
    private String NroSerie;
    private String Nombre; 

    public Serie() {
    }

    public Serie(String NroSerie, String Nombre) {
        this.NroSerie = NroSerie;
        this.Nombre = Nombre;
    }

    public String getNroSerie() {
        return NroSerie;
    }

    public void setNroSerie(String NroSerie) {
        this.NroSerie = NroSerie;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
