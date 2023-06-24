/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento;

import java.util.Date;

/**
 *
 * @author efrai
 */
public class KardexBusqueda {

    private String fechaInicio;
    private String fechaFinal;
    private Integer tipoMovimiento;
    private Integer IdCategoria;
    private Integer IdMarca;

    public KardexBusqueda() {
    }

    public KardexBusqueda(String fechaInicio, String fechaFinal, Integer tipoMovimiento, Integer IdCategoria, Integer IdMarca) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.tipoMovimiento = tipoMovimiento;
        this.IdCategoria = IdCategoria;
        this.IdMarca = IdMarca;
    }
    

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
 
    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(Integer IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public Integer getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(Integer IdMarca) {
        this.IdMarca = IdMarca;
    }
    

}
