package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name="categoria"
    ,catalog="proyecto_uni"
)
public class Categoria  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private String estado;
     private Set productos = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String estado) {
        this.estado = estado;
    }
    public Categoria(String nombre, String descripcion, String estado, Set productos) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.estado = estado;
       this.productos = productos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="Descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="Estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


