/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.entidad.MantenimientoPrecio;
import com.model.ModelPrecios;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@RequestScoped
public class preciosBean {

    /**
     * Creates a new instance of preciosBean
     */
    private MantenimientoPrecio mprecio;
    private List<MantenimientoPrecio> listPrecio;
    private String tipoRegistro;
    private String textButton;

    public preciosBean() {
        mprecio = new MantenimientoPrecio();
            TimeZone zone = TimeZone.getTimeZone("America/Lima");
        this.tipoRegistro = "NEW";
        this.textButton= "Guardar";
    }

    public MantenimientoPrecio getMprecio() {
        return mprecio;
    }

    public void setMprecio(MantenimientoPrecio mprecio) {
        this.mprecio = mprecio;
    }

    public List<MantenimientoPrecio> getListPrecio() {
        ModelPrecios model = new ModelPrecios();
        listPrecio = model.listarPrecios();
        return listPrecio;
    }

    public void setListPrecio(List<MantenimientoPrecio> listPrecio) {
        this.listPrecio = listPrecio;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }
    

    public void guardar() {
        if (tipoRegistro.equals("NEW")) {
            mprecio.setFecRegistro(new Date());
            ModelPrecios model = new ModelPrecios();
            model.mdlGuardar(mprecio);
        } else {
            mprecio.setFecActualizado(new Date());
            ModelPrecios model = new ModelPrecios();
            model.mdlUpdate(mprecio);
        }
        this.limpiarClase();
    }

    public void actualizar() {

    }
    

    public void cambiarTipo() {
        this.textButton= "Actualizar";
        this.tipoRegistro = "UPD";
    }

    public void limpiarClase() {
        mprecio = new MantenimientoPrecio();
        this.textButton = "Guardar";
        this.tipoRegistro = "NEW";
    }
}
