/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entidad.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author efrai
 */
public class ModelCliente {
    
    public List<Cliente> ListarClientes(){
        List<Cliente> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "From Cliente order by id desc";
        try {
            
            lista = sesion.createQuery(hql).list();
            t.commit();
        } catch (HibernateException e) { 
            t.rollback(); 
        }
        sesion.close();
        return lista;
    }
    
    public void guardar(Cliente cliente) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t =sesion.beginTransaction();
        try {
            
            sesion.save(cliente);
            t.commit();
            FacesContext.getCurrentInstance().
            addMessage("Exitoso", new FacesMessage("Se ha registrado correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: "+ e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().
            addMessage("Error", new FacesMessage("Se ha generado un error al registrar"));
        }
        sesion.close();
         
    }

    public void actualizar(Cliente cliente) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.update(cliente);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        }
        sesion.close();
    }

    public void eliminar(Cliente cliente) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.delete(cliente);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } 
        sesion.close();
    }
    
}
