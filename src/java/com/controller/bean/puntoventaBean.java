/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Carrito;
import com.entidad.Categoria;
import com.entidad.Cliente;
import com.entidad.Consultarucdni;
import com.entidad.Marca;
import com.entidad.Producto;
import com.entidad.Productoserie;
import com.entidad.Tipocomprobante;
import com.entidad.VentaCabeceraTemp;
import com.entidad.VentaDetalleTemp;
import com.model.ModelPuntoVenta;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@SessionScoped
public class puntoventaBean implements Serializable {

    /**
     * Creates a new instance of puntoventaBean
     */
    private Integer tipoDoc;
    private Tipocomprobante tipocomprobante;
    private Cliente cliente;
    private String mensaje;
    private String txtBuscar;
    private Productoserie productoSerie;
    private List<Productoserie> listarProductoSerie;
    private Producto producto;
    private Marca marca = new Marca();
    private Categoria categoria = new Categoria();
    private List<Producto> listarProducto;
    private List<Producto> listarProductoAgregar;
    private Carrito carrito = new Carrito();
    private List<Carrito> listarCarrito;
    private Object ObjCarrito;
    
    
    private Consultarucdni consulta;
    private Integer minChar = 8; 

    private VentaCabeceraTemp ventaCabecera;
    private List<VentaCabeceraTemp> listaCabecera;

    private VentaDetalleTemp ventaDetalle;
    private List<VentaDetalleTemp> listaDetalle;

    public puntoventaBean() {
        tipocomprobante = new Tipocomprobante();
        cliente = new Cliente();
        productoSerie = new Productoserie();
        producto = new Producto(); 
        consulta = new Consultarucdni();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public String getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(String txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public Integer getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(Integer tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Tipocomprobante getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(Tipocomprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Productoserie getProductoSerie() {
        return productoSerie;
    }

    public void setProductoSerie(Productoserie productoSerie) {
        this.productoSerie = productoSerie;
    }

    public List<Productoserie> getListarProductoSerie() {
        return listarProductoSerie;
    }

    public void setListarProductoSerie(List<Productoserie> listarProductoSerie) {
        this.listarProductoSerie = listarProductoSerie;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListarProducto() {
        return listarProducto;
    }

    public void setListarProducto(List<Producto> listarProducto) {
        this.listarProducto = listarProducto;
    }

    public void buscarProducto() {
        System.out.println("txtBuscar: " + txtBuscar);
        ModelPuntoVenta mdl = new ModelPuntoVenta();
        listarProductoAgregar = mdl.buscarProductoAgregar(txtBuscar);
    }

    public List<Producto> getListarProductoAgregar() {
        System.out.println("Listar producto agregar: " + listarProductoAgregar);
        return listarProductoAgregar;
    }

    public void setListarProductoAgregar(List<Producto> listarProductoAgregar) {
        this.listarProductoAgregar = listarProductoAgregar;
    }

    public void agregarCarrito() {
        System.out.println("-----------------Inicio Carrito------------");
        System.out.println("" + ObjCarrito);

        ModelPuntoVenta mdl = new ModelPuntoVenta();
        System.out.println("-----------------Final Carrito------------");
        cliente.setId(2);
       String serie_factura="FE01";
       String serie_boleta="BE01";
       Integer secuencia = mdl.mdlAgregarCarritoCab(ObjCarrito, cliente, serie_factura, serie_boleta);
       if(secuencia == 1){
            mdl.mdlAgregarCarritoDet(ObjCarrito, secuencia);
       }
        System.out.println("Secuencia Temporal: "+ secuencia);

    }

    public void buscarPorDescripcion() { 
        
        System.out.println("Producto: " + producto.getDescripcion());
    }

    public Object getObjCarrito() {
        return ObjCarrito;
    }

    public void setObjCarrito(Object ObjCarrito) {
        this.ObjCarrito = ObjCarrito;
    }

    public VentaCabeceraTemp getVentaCabecera() {
        return ventaCabecera;
    }

    public void setVentaCabecera(VentaCabeceraTemp ventaCabecera) {
        this.ventaCabecera = ventaCabecera;
    }

    public List<VentaCabeceraTemp> getListaCabecera() {
        return listaCabecera;
    }

    public void setListaCabecera(List<VentaCabeceraTemp> listaCabecera) {
        this.listaCabecera = listaCabecera;
    }

    public VentaDetalleTemp getVentaDetalle() {
        return ventaDetalle;
    }

    public void setVentaDetalle(VentaDetalleTemp ventaDetalle) {
        this.ventaDetalle = ventaDetalle;
    }

    public List<VentaDetalleTemp> getListaDetalle() {
        ModelPuntoVenta mdl = new ModelPuntoVenta();
        listaDetalle = mdl.listarDetTemp(1);
        
        ventaCabecera = mdl.listarCabTemp(1);
        
        return listaDetalle;
    }

    public void setListaDetalle(List<VentaDetalleTemp> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    
}
