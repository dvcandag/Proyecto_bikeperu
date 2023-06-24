/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.complemento.Carrito;
import com.entidad.Cliente;
import com.entidad.Producto;
import com.entidad.VentaCabeceraTemp;
import com.entidad.VentaDetalleTemp;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author efrai
 */
public class ModelPuntoVenta {

    public List<Producto> buscarPorDescripcion(Producto p) {
        List<Producto> listarProductoCategoria = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Producto p inner join p.categoria inner join p.marca inner join p.productoseries";
        try {
            listarProductoCategoria = (List<Producto>) sesion.createQuery(hql).list();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listarProductoCategoria;
    }

    public List<Producto> buscarProductoAgregar(String txtBuscar) {
        List<Producto> listarProductoCategoria = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hqls = "From Producto p inner join p.categoria inner join  p.marca inner join p.productoseries ps"
                + " where (p.descripcion like '%" + txtBuscar + "%' or ps.nroSerie like '%" + txtBuscar + "%' )";
        String hql = "From Producto p inner join p.categoria inner join  p.marca inner join p.productoseries ps"
                + " where (p.descripcion like '" + txtBuscar + "' or ps.nroSerie like '" + txtBuscar + "' )";
        try {
            listarProductoCategoria = (List<Producto>) sesion.createQuery(hql).list();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listarProductoCategoria;
    }

    public VentaCabeceraTemp listarCabTemp(Integer Secuencia) {
        VentaCabeceraTemp cab = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
//            String sql = "From VentaCabeceraTemp cb join cb.cliente where cb.secuencia =" + Secuencia;
            String sql = "Select cb From VentaCabeceraTemp cb where cb.secuencia = " + Secuencia;
            cab = (VentaCabeceraTemp) sesion.createQuery(sql).uniqueResult();

            sesion.close();
        } catch (Exception e) {
            sesion.close();
        }
        return cab;
    }

    public List<VentaDetalleTemp> listarDetTemp(Integer Secuencia) {
        List<VentaDetalleTemp> det = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "From VentaDetalleTemp  dt  join dt.productoserie ps join ps.producto where dt.id.secuencia =" + Secuencia;
            det = (List<VentaDetalleTemp>) sesion.createQuery(sql).list();
            sesion.close();
        } catch (Exception e) {
            sesion.close();
        }
        return det;
    }

    public Carrito mdlListarCarrito(Integer secuencia) {
        Carrito cart = new Carrito();
        List<Carrito> listCarro = null;
        VentaCabeceraTemp cab = null;
        List<VentaDetalleTemp> det = null;
        cab = this.listarCabTemp(secuencia);
        det = this.listarDetTemp(secuencia);
        cart.setVentaCabTemp(cab);
        cart.setVentaDetTemp(det);
        return cart;
    }

    public Integer mdlAgregarCarritoCab(Object data, Cliente c, String serie_factura, String serie_boleta) {
        Session sesion = null;
        System.out.println("data: " + data);
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        Integer secuencia = -1;
        String sp = "call Sp_AgregarCarritoCabecera(:id_cliente, :serie_bol,:serie_fac)";
        try {
            Query query = sesion.createSQLQuery(sp); 

//            ProcedureCall call = sesion.createStoredProcedureCall("Sp_AgregarCarritoCabecera(?,?,?)");

            query.setParameter("id_cliente", c.getId());
            query.setParameter("serie_bol", serie_boleta);
            query.setParameter("serie_fac", serie_factura); 
             
//           
//            List<TblSecuencia> response = query.list(); 
            FacesContext.getCurrentInstance().addMessage("Exitoso", new FacesMessage("Se ha registrado correctamente")); 
            secuencia = 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace()); 
            secuencia = 0;
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Se ha generado un error al registrar"));
        }
        sesion.clear();
        sesion.close();
        return secuencia;
    }
    
    public Integer mdlAgregarCarritoDet(Object data, Integer secuencia) {
        Session sesion = null;
        System.out.println("--------INICIO---------"); 
         
         
        sesion = HibernateUtil.getSessionFactory().openSession();
        System.out.println("--------FIN---------");
        String sp = "call Sp_AgregarCarritoDetalle(:secuencia, :serie_producto,:precio_venta, :tipo_operacion)";
        try {
            Query query = sesion.createSQLQuery(sp); 

//            ProcedureCall call = sesion.createStoredProcedureCall("Sp_AgregarCarritoCabecera(?,?,?)");

            query.setParameter("secuencia", secuencia);
            query.setParameter("serie_producto", "");
            query.setParameter("precio_venta",""); 
            query.setParameter("tipo_operacion","ADD"); 
             
//           
//            List<TblSecuencia> response = query.list(); 
            FacesContext.getCurrentInstance().addMessage("Exitoso", new FacesMessage("Se ha registrado correctamente"));
          
            secuencia = 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace()); 
            secuencia = 0;
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Se ha generado un error al registrar"));
        }
        sesion.clear();
        sesion.close();
        return secuencia;
    }
    
    
}
