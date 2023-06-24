/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento;

/**
 *
 * @author efrai
 */
public class TblSecuencia implements java.io.Serializable{
 
    private Integer Secuencia;

    public TblSecuencia() {
    }

    public TblSecuencia(Integer Secuencia) {
        this.Secuencia = Secuencia;
    }

    public Integer getSecuencia() {
        return Secuencia;
    }

    public void setSecuencia(Integer Secuencia) {
        this.Secuencia = Secuencia;
    }
 
        
}
