/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.entidad.Cliente;
import com.model.ModelCliente;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author efrai
 */
@ManagedBean
@ViewScoped
public class clienteBean implements Serializable {

    private int number;
    private Cliente cliente;
    private List<Cliente> listarClientes;
    private String razonSocial;
    private String direccion;

    /**
     * Creates a new instance of clienteBean
     */
    public clienteBean() {
        cliente = new Cliente();
    }

    public List<Cliente> getListarClientes() {
        ModelCliente model = new ModelCliente();
        listarClientes = model.ListarClientes();
        return listarClientes;
    }

    public void setListarClientes(List<Cliente> listarClientes) {
        this.listarClientes = listarClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    } 
     
    public void limpiarCliente(){
        cliente = new Cliente();
    }

}
