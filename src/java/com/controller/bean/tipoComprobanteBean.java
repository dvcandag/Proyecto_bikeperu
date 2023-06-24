/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.entidad.Tipocomprobante;
import com.model.ModelComprobante;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@RequestScoped
public class tipoComprobanteBean {

    /**
     * Creates a new instance of tipoComprobanteBean
     */
    private List<Tipocomprobante> listarComprobantes;
    private Tipocomprobante comprobante;
    public tipoComprobanteBean() {
        comprobante = new Tipocomprobante();
    }

    public List<Tipocomprobante> getListarComprobantes() {
        ModelComprobante model = new ModelComprobante();
        listarComprobantes = model.listarComprobantes();
        return listarComprobantes;
    }

    public void setListarComprobantes(List<Tipocomprobante> listarComprobantes) {
        this.listarComprobantes = listarComprobantes;
    }

    public Tipocomprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Tipocomprobante comprobante) {
        this.comprobante = comprobante;
    }
    
    
    
}
