/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.KardexBusqueda;
import com.entidad.Kardexventas;
import com.entidad.Tipomovimiento;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author efrai
 */
public class ModelKardex {
    
    public List<Kardexventas> listKardexVentas(KardexBusqueda kb){
        List<Kardexventas> lista = null;
        if (kb.getFechaInicio() == null) {
             return lista;
        } 
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = 
                "From Kardexventas kv inner join kv.producto "
                + "where cast(kv.fechaRegistro as date) = cast(:fechaRegistro as date) and kv.idTipoMov= :tipoMovimiento "
                + "Order By Secuencia asc";
        try {
            lista = sesion.createQuery(hql).
                    setParameter("fechaRegistro",kb.getFechaInicio() ).
                    setParameter("tipoMovimiento", kb.getTipoMovimiento()).
                    list();
        } catch (HibernateException e) {
            System.out.println(""+ e.getMessage());
        }
        sesion.close();
        return lista;
    }
    
    public List<Tipomovimiento> listTipoMovimiento(){
        
        List<Tipomovimiento> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Tipomovimiento order by id desc";
        try {
            lista = sesion.createQuery(hql).list();
        } catch (HibernateException e) {
            System.out.println(""+ e.getMessage());
        }
        sesion.close();
        return lista;
        
    }
    
}
