/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento.Menu;

import java.util.List;

/**
 *
 * @author efrai
 */
public class Body {
    private List<Serie> serie;
    private List<Permiso> permiso;
    private List<Menu> menu;    

    public Body() {
    }

    public Body(List<Serie> serie, List<Permiso> permiso, List<Menu> menu) {
        this.serie = serie;
        this.permiso = permiso;
        this.menu = menu;
    }

    public List<Serie> getSerie() {
        return serie;
    }

    public void setSerie(List<Serie> serie) {
        this.serie = serie;
    }

    public List<Permiso> getPermiso() {
        return permiso;
    }

    public void setPermiso(List<Permiso> permiso) {
        this.permiso = permiso;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
 
    
    
}
