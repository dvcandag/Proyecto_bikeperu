/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.response;

/**
 *
 * @author efrai
 */
public class ResponseProducto  implements java.io.Serializable {
    private  String codigo;
    private  String codpro;
    private  String mensaje;

    public ResponseProducto() {
    }

    public ResponseProducto(String codigo, String codpro, String mensaje) {
        this.codigo = codigo;
        this.codpro = codpro;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
 
}
