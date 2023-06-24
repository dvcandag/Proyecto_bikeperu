/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento;

import java.util.List;

/**
 *
 * @author efrai
 */
public class ApiResData {

    private Boolean error;
    private Integer status;
    private List body;

    public ApiResData() {
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

    public List getBody() {
        return body;
    }

    public void setBody(List body) {
        this.body = body;
    }

}
