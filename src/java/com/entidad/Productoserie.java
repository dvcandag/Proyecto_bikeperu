package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Productoserie generated by hbm2java
 */
@Entity
@Table(name="productoserie"
    ,catalog="proyecto_uni"
)
public class Productoserie  implements java.io.Serializable {


     private Integer id;
     private Producto producto;
     private String nroSerie;
     private BigDecimal precioCompra;
     private Date fechaCreado;
     private int disponible;
     private String estado;
     private Set ventaDetalleTemps = new HashSet(0);
     private Set ventaDetalles = new HashSet(0);

    public Productoserie() {
    }

	
    public Productoserie(Date fechaCreado, int disponible, String estado) {
        this.fechaCreado = fechaCreado;
        this.disponible = disponible;
        this.estado = estado;
    }
    public Productoserie(Producto producto, String nroSerie, BigDecimal precioCompra, Date fechaCreado, int disponible, String estado, Set ventaDetalleTemps, Set ventaDetalles) {
       this.producto = producto;
       this.nroSerie = nroSerie;
       this.precioCompra = precioCompra;
       this.fechaCreado = fechaCreado;
       this.disponible = disponible;
       this.estado = estado;
       this.ventaDetalleTemps = ventaDetalleTemps;
       this.ventaDetalles = ventaDetalles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Codpro")
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    @Column(name="NroSerie", length=45)
    public String getNroSerie() {
        return this.nroSerie;
    }
    
    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    
    @Column(name="PrecioCompra", precision=18, scale=4)
    public BigDecimal getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FechaCreado", nullable=false, length=19)
    public Date getFechaCreado() {
        return this.fechaCreado;
    }
    
    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    
    @Column(name="Disponible", nullable=false)
    public int getDisponible() {
        return this.disponible;
    }
    
    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    
    @Column(name="Estado", nullable=false, length=1)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productoserie")
    public Set getVentaDetalleTemps() {
        return this.ventaDetalleTemps;
    }
    
    public void setVentaDetalleTemps(Set ventaDetalleTemps) {
        this.ventaDetalleTemps = ventaDetalleTemps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productoserie")
    public Set getVentaDetalles() {
        return this.ventaDetalles;
    }
    
    public void setVentaDetalles(Set ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }




}


