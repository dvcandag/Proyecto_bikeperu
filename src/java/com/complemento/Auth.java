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
public class Auth {
    
    private Integer Id;
    private String nombre;
    private String email; 
    private Integer IdRol;    
    private String Estado; 
    private Integer iat;
    private Integer exp; 
    private String TipoRol;

    
    public Auth() {
    }

    public Auth(Integer Id, String nombre, Integer IdRol, String email, String Estado, Integer iat, Integer exp) {
        this.Id = Id;
        this.nombre = nombre;
        this.IdRol = IdRol;
        this.email = email;
        this.Estado = Estado;
        this.iat = iat;
        this.exp = exp;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Integer getIat() {
        return iat;
    }

    public void setIat(Integer iat) {
        this.iat = iat;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }
    
    public String getTipoRol() {
        return TipoRol;
    }

    public void setTipoRol(String TipoRol) {
        this.TipoRol = TipoRol;
    }
    
}

 