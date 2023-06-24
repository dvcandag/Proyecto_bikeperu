/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entidad.MantenimientoPrecio;
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
public class ModelPrecios {
    
    
    public List<MantenimientoPrecio> listarPrecios() {
        List<MantenimientoPrecio> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM MantenimientoPrecio Order By Secuencia desc";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit(); 
        } catch (HibernateException e) {
            t.rollback();
        }
        sesion.close();
        return lista;
    }
    public void mdlGuardar(MantenimientoPrecio mp){
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        try {

            sesion.save(mp);
            t.commit();
            FacesContext.getCurrentInstance().
                    addMessage("Exitoso", new FacesMessage("Se ha registrado correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().
                    addMessage("Error", new FacesMessage("Se ha generado un error al registrar"));
        }
        sesion.clear();
        sesion.close();
    }
    
     public void mdlUpdate(MantenimientoPrecio mp){
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        try {

            sesion.update(mp);
            t.commit();
            FacesContext.getCurrentInstance().
                    addMessage("Exitoso", new FacesMessage("Se ha registrado se ha actualizado correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().
                    addMessage("Error", new FacesMessage("Se ha generado un error al actualizar el registro"));
        }
        sesion.clear();
        sesion.close();
    }
     
     
}
