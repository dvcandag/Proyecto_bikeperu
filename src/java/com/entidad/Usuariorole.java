package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuariorole generated by hbm2java
 */
@Entity
@Table(name="usuariorole"
    ,catalog="proyecto_uni"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUsuarioRole", unique=true, nullable=false)
    public Integer getIdUsuarioRole() {
        return this.idUsuarioRole;
    }
    
    public void setIdUsuarioRole(Integer idUsuarioRole) {
        this.idUsuarioRole = idUsuarioRole;
    }

    
    @Column(name="IdRol")
    public Integer getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    
    @Column(name="IdUsuario")
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="Estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


