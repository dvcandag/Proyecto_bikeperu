package com.entidad;
// Generated 15-jun-2023 8:30:38 by Hibernate Tools 4.3.1



/**
 * Usuariorole generated by hbm2java
 */
public class Usuariorole  implements java.io.Serializable {


     private Integer idUsuarioRole;
     private Integer idRol;
     private Integer idUsuario;
     private String estado;

    public Usuariorole() {
    }

	
    public Usuariorole(String estado) {
        this.estado = estado;
    }
    public Usuariorole(Integer idRol, Integer idUsuario, String estado) {
       this.idRol = idRol;
       this.idUsuario = idUsuario;
       this.estado = estado;
    }
   
    public Integer getIdUsuarioRole() {
        return this.idUsuarioRole;
    }
    
    public void setIdUsuarioRole(Integer idUsuarioRole) {
        this.idUsuarioRole = idUsuarioRole;
    }
    public Integer getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


