package com.entidad;
// Generated 29-jun-2023 22:51:21 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VentaDetalle generated by hbm2java
 */
@Entity
@Table(name="venta_detalle"
    ,catalog="proyecto_uni"
)
public class VentaDetalle  implements java.io.Serializable {


     private VentaDetalleId id;
     private Productoserie productoserie;
     private VentaCabecera ventaCabecera;
     private BigDecimal precioVenta;
     private String afecto;

    public VentaDetalle() {
    }

	
    public VentaDetalle(VentaDetalleId id, VentaCabecera ventaCabecera) {
        this.id = id;
        this.ventaCabecera = ventaCabecera;
    }
    public VentaDetalle(VentaDetalleId id, Productoserie productoserie, VentaCabecera ventaCabecera, BigDecimal precioVenta, String afecto) {
       this.id = id;
       this.productoserie = productoserie;
       this.ventaCabecera = ventaCabecera;
       this.precioVenta = precioVenta;
       this.afecto = afecto;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="secuencia", column=@Column(name="secuencia", nullable=false) ), 
        @AttributeOverride(name="item", column=@Column(name="item", nullable=false) ) } )
    public VentaDetalleId getId() {
        return this.id;
    }
    
    public void setId(VentaDetalleId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdSerieProducto")
    public Productoserie getProductoserie() {
        return this.productoserie;
    }
    
    public void setProductoserie(Productoserie productoserie) {
        this.productoserie = productoserie;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="secuencia", nullable=false, insertable=false, updatable=false)
    public VentaCabecera getVentaCabecera() {
        return this.ventaCabecera;
    }
    
    public void setVentaCabecera(VentaCabecera ventaCabecera) {
        this.ventaCabecera = ventaCabecera;
    }

    
    @Column(name="precio_venta", precision=18, scale=3)
    public BigDecimal getPrecioVenta() {
        return this.precioVenta;
    }
    
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    
    @Column(name="afecto", length=1)
    public String getAfecto() {
        return this.afecto;
    }
    
    public void setAfecto(String afecto) {
        this.afecto = afecto;
    }




}


