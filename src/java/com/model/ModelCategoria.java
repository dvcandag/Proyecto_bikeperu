/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entidad.Categoria;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author efrai
 */
public class ModelCategoria {
    public List<Categoria> listarCategorias() {
        List<Categoria> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Categoria order by id desc";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit(); 
        } catch (HibernateException e) {
            t.rollback();
        }
        sesion.close();
        return lista;
    }

    public void agregar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {

            sesion.save(categoria);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        }
        sesion.close();
    }

    public void modificar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.update(categoria);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        }
        sesion.close();
    }

    public void eliminar(Categoria categoria) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            sesion.delete(categoria);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } 
        sesion.close();
    }
}
