package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tipodocumentoidentidad generated by hbm2java
 */
@Entity
@Table(name="tipodocumentoidentidad"
    ,catalog="proyecto_uni"
)
public class Tipodocumentoidentidad  implements java.io.Serializable {


     private Integer id;
     private String descripcion;
     private String estado;
     private Integer codigo;

    public Tipodocumentoidentidad() {
    }

	
    public Tipodocumentoidentidad(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public Tipodocumentoidentidad(String descripcion, String estado, Integer codigo) {
       this.descripcion = descripcion;
       this.estado = estado;
       this.codigo = codigo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="descripcion", nullable=false, length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="codigo")
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }




}


