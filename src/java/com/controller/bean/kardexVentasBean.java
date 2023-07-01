/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.KardexBusqueda;
import com.entidad.Categoria;
import com.entidad.Kardexventas;
import com.entidad.Marca;
import com.entidad.Producto;
import com.entidad.Tipomovimiento;
import com.model.ModelCategoria;
import com.model.ModelKardex;
import com.model.ModelMarca;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@RequestScoped
public class kardexVentasBean {

    private Kardexventas kventas;
    private Producto producto;
    private Tipomovimiento tipoMovimiento;
    private Categoria categoria;
    private Marca marca; 

    private List<Kardexventas> listKventas;
    private List<Tipomovimiento> listTMovimiento;
    private List<Categoria> listCategoria;
    private List<Marca> listMarca;

    private KardexBusqueda kardexBuscador;

    public kardexVentasBean() {
        kventas = new Kardexventas();
        producto = new Producto();
        tipoMovimiento = new Tipomovimiento();
        marca = new Marca();
        categoria = new Categoria();  
        kardexBuscador = new KardexBusqueda();
    }

    public KardexBusqueda getKardexBuscador() {
        return kardexBuscador;
    }

    public void setKardexBuscador(KardexBusqueda kardexBuscador) {
        this.kardexBuscador = kardexBuscador;
    }

    
    public Kardexventas getKventas() {
        return kventas;
    }

    public void setKventas(Kardexventas kventas) {
        this.kventas = kventas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tipomovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Tipomovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    public List<Categoria> getListCategoria() {
        ModelCategoria model = new ModelCategoria();
//        listCategoria = model.listarCategorias();
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public List<Marca> getListMarca() {
        ModelMarca model = new ModelMarca();
        //listMarca = model.listarMarcas();
        return listMarca;
    }

    public void setListMarca(List<Marca> listMarca) {
        this.listMarca = listMarca;
    }

    public List<Tipomovimiento> getListTMovimiento() {
        ModelKardex model = new ModelKardex();
        listTMovimiento = model.listTipoMovimiento();
        return listTMovimiento;
    }

    public void setListTMovimiento(List<Tipomovimiento> listTMovimiento) {
        this.listTMovimiento = listTMovimiento;
    }

    public List<Kardexventas> getListKventas() {
        ModelKardex model = new ModelKardex();
        System.out.println("Salida: "+ kardexBuscador.getFechaFinal()+" - "+ kardexBuscador.getTipoMovimiento());
        listKventas = model.listKardexVentas(kardexBuscador);
        return listKventas;
    }

    public void setListKventas(List<Kardexventas> listKventas) {
        this.listKventas = listKventas;
    }
    
    public void eventosBusqueda(){
        System.out.println("Salida: "+ kardexBuscador.getFechaFinal()+" - "+ kardexBuscador.getTipoMovimiento());
        this.getListKventas();
    }
    
    public void buscarconFiltro(){
        
        kardexBuscador.getFechaInicio();
        System.out.println(""+ kardexBuscador.getFechaInicio());
        ModelKardex m= new ModelKardex();
        
        
    }

}
