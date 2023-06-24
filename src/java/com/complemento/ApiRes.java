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
public class ApiRes {
    private Boolean error;
    private Integer status;
    private String body;

    public ApiRes() {
    }

    public ApiRes(Boolean error, Integer status, String body) {
        this.error = error;
        this.status = status;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
 
}
