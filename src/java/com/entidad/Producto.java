package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name="producto"
    ,catalog="proyecto_uni"
)
public class Producto  implements java.io.Serializable {


     private String codpro;
     private Categoria categoria;
     private Marca marca;
     private String descripcion;
     private String especificacion;
     private BigDecimal precioCompra;
     private String imagen;
     private Date fechaCreado;
     private String estado;
     private Set productoseries = new HashSet(0);

    public Producto() {
    }

	
    public Producto(String codpro, Date fechaCreado, String estado) {
        this.codpro = codpro;
        this.fechaCreado = fechaCreado;
        this.estado = estado;
    }
    public Producto(String codpro, Categoria categoria, Marca marca, String descripcion, String especificacion, BigDecimal precioCompra, String imagen, Date fechaCreado, String estado, Set productoseries) {
       this.codpro = codpro;
       this.categoria = categoria;
       this.marca = marca;
       this.descripcion = descripcion;
       this.especificacion = especificacion;
       this.precioCompra = precioCompra;
       this.imagen = imagen;
       this.fechaCreado = fechaCreado;
       this.estado = estado;
       this.productoseries = productoseries;
    }
   
     @Id 

    
    @Column(name="Codpro", unique=true, nullable=false, length=6)
    public String getCodpro() {
        return this.codpro;
    }
    
    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdCategoria")
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdMarca")
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    @Column(name="Descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="Especificacion", length=500)
    public String getEspecificacion() {
        return this.especificacion;
    }
    
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    
    @Column(name="PrecioCompra", precision=18, scale=4)
    public BigDecimal getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    
    @Column(name="Imagen", length=500)
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FechaCreado", nullable=false, length=19)
    public Date getFechaCreado() {
        return this.fechaCreado;
    }
    
    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    
    @Column(name="Estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    public Set getProductoseries() {
        return this.productoseries;
    }
    
    public void setProductoseries(Set productoseries) {
        this.productoseries = productoseries;
    }




}


