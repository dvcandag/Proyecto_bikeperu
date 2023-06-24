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
public class SubMenu {
    private Integer id;
    private String pagina;
    private String baseurl;
    private String icono; 

    public SubMenu() {
    }

    public SubMenu(Integer id, String pagina, String baseurl, String icono) {
        this.id = id;
        this.pagina = pagina;
        this.baseurl = baseurl;
        this.icono = icono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
}
