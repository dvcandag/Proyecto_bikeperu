/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Configuracion;
import com.entidad.Tipodocumentoidentidad;
import com.model.ModelIdentificacion;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class identificacionBean {

    Configuracion conf = new Configuracion();
    private String token = "";
    private String Username = "";
    private String BaseApi = "";
    private List<Tipodocumentoidentidad> listarDocumentos;
    private Tipodocumentoidentidad docidentidad;

    public identificacionBean() {
        docidentidad = new Tipodocumentoidentidad();
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
    }

    public List<Tipodocumentoidentidad> getListarDocumentos() {
        ModelIdentificacion model = new ModelIdentificacion();
        listarDocumentos = model.listarIdentificacion(this.BaseApi, this.token, this.Username);
        return listarDocumentos;
    }

    public void setListarDocumentos(List<Tipodocumentoidentidad> listarDocumentos) {
        this.listarDocumentos = listarDocumentos;
    }

    public Tipodocumentoidentidad getDocidentidad() {
        return docidentidad;
    }

    public void setDocidentidad(Tipodocumentoidentidad docidentidad) {
        this.docidentidad = docidentidad;
    }
}
