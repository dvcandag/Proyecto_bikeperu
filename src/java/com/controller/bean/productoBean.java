/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.entidad.Categoria;
import com.entidad.Kardexventas;
import com.entidad.Marca;
import com.entidad.Producto;
import com.entidad.Productoserie;
import com.entidad.Rol;
import com.entidad.Usuario;
import com.model.ModelCategoria;
import com.model.ModelMarca;
import com.model.ModelProducto;
import com.response.ResponseProducto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author efrai
 */
@ManagedBean
@ViewScoped
public class productoBean {

    /**
     * Creates a new instance of productoBean
     */
    //private List<Producto> listarProductos;
    private List<Producto> listarProductos;
    private Producto producto;
    private Categoria categoria;
    private List<Categoria> listaCategorias;
    private Marca marca;
    private List<Marca> listaMarcas;
    private Productoserie productoserie;
    private List<Productoserie> listarProductoseries;
    private ResponseProducto response;
    ModelProducto model = new ModelProducto();
    private Kardexventas kardexventases;

    public productoBean() {
        producto = new Producto();
        marca = new Marca();
        categoria = new Categoria();
        productoserie = new Productoserie(); 
        kardexventases = new Kardexventas();
    }

    public Productoserie getProductoserie() {
        return productoserie;
    }

    public void setProductoserie(Productoserie productoserie) {
        this.productoserie = productoserie;
    }

    public List<Productoserie> getListarProductoseries() {
        String sesiones = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("codpro_temp");
        if (sesiones != null) {
            producto.setCodpro(sesiones);
            listarProductoseries = new ModelProducto().ListarProductoSerie(producto);
        }
        return listarProductoseries;
    }

    public void setListarProductoseries(List<Productoserie> listarProductoseries) {
        this.listarProductoseries = listarProductoseries;
    }

    public List<Producto> getListarProductos() {
        model = new ModelProducto();
        listarProductos = model.ListarProductos();
        return listarProductos;
    }

    public void setListarProductos(List<Producto> listarProductos) {
        this.listarProductos = listarProductos;
    }

    public List<Categoria> getListaCategorias() {
        listaCategorias = new ModelCategoria().listarCategorias();
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public List<Marca> getListaMarcas() {
        //listaMarcas = new ModelMarca().listarMarcas();
        return listaMarcas;
    }

    public void setListaMarcas(List<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void guardaProducto() {
        ModelProducto p = new ModelProducto();
        String sesiones = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("codpro_temp");
        FacesContext context = FacesContext.getCurrentInstance();
        if (sesiones == null) {
            response = p.Guardar(producto, categoria, marca);
            if (response.getCodigo() != null) {
                producto.setCodpro(response.getCodpro());
                context.getExternalContext().getSessionMap().put("codpro_temp", producto.getCodpro());
                addMessage(FacesMessage.SEVERITY_INFO, "Aviso", response.getMensaje());
            }
        } else {
            producto.setCodpro(sesiones);
            addMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El producto " + sesiones + " ya se encuentra en proceso de registro");
        }
    }

    public void destroyCodproTemp() {
        System.out.println("Llego aqui");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public void nuevaSerieProducto() {
        productoserie = new Productoserie();
    }

    public void agregarProductoSerie() {
        ModelProducto m = new ModelProducto();
        productoserie.setProducto(producto);
        String estado = "P";
        productoserie.setEstado(estado);
        productoserie.setDisponible(0);
        m.GuardarProductoSerie(productoserie);
    }

    public void onRowEdit(RowEditEvent<Productoserie> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getNroSerie()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        model.GuardarProductoSerie(event.getObject());
    }

    public void onRowCancel(RowEditEvent<Productoserie> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getNroSerie()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void eliminarFilaserie() {
        model.eliminarPserie(productoserie);
        this.limpiarProductoSerie();
    }

    public void limpiarProductoSerie() {
        productoserie = new Productoserie();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void veficarHabilitar() {

    }

    public void guardarProductoFinal() {

        String sesiones = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("codpro_temp");
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_usuario");
        Rol rol = (Rol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_rol");
        if (sesiones != null) {
            if (model.GuardarProducto(sesiones, user.getId())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("codpro_temp", null);
            }
        }

    }

}
