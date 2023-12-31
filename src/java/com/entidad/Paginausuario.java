package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Paginausuario generated by hbm2java
 */
@Entity
@Table(name="paginausuario"
    ,catalog="proyecto_uni"
)
public class Paginausuario  implements java.io.Serializable {


     private Integer idPaginaUsuario;
     private Integer idPagina;
     private Integer idUsuario;
     private String estado;

    public Paginausuario() {
    }

	
    public Paginausuario(String estado) {
        this.estado = estado;
    }
    public Paginausuario(Integer idPagina, Integer idUsuario, String estado) {
       this.idPagina = idPagina;
       this.idUsuario = idUsuario;
       this.estado = estado;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPaginaUsuario", unique=true, nullable=false)
    public Integer getIdPaginaUsuario() {
        return this.idPaginaUsuario;
    }
    
    public void setIdPaginaUsuario(Integer idPaginaUsuario) {
        this.idPaginaUsuario = idPaginaUsuario;
    }

    
    @Column(name="IdPagina")
    public Integer getIdPagina() {
        return this.idPagina;
    }
    
    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
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


