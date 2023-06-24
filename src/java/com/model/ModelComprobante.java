/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entidad.Tipocomprobante;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author efrai
 */
public class ModelComprobante {
    
    public List<Tipocomprobante> listarComprobantes(){
        List<Tipocomprobante> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "From Tipocomprobante order by id asc";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
        } catch (HibernateException e) { 
            t.rollback(); 
        }
        sesion.close();
        return lista;
        
    }
}
