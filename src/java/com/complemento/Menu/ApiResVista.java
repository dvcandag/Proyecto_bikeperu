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
public class ApiResVista {
    private Boolean error;
    private Integer status;
//    private Body body;

    public ApiResVista() {
    }

    public ApiResVista(Boolean error, Integer status) {
        this.error = error;
        this.status = status;
    }

    

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    } 
}
