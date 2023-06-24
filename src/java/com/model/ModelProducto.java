/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entidad.Categoria;
import com.entidad.Marca;
import com.entidad.Producto;
import com.entidad.Productoserie;
import com.response.ResponseProducto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author efrai
 */
public class ModelProducto {

    public List<Producto> ListarProductos() {
        List<Producto> listarProductoCategoria = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String sql = "From Producto p inner join p.categoria inner join p.marca order by p.codpro desc ";
        //String sql = "call SP_LISTAR_PRODUCTO_ALMACEN()";
//        String sql = "SELECT p, "
//                + " ifnull((SELECT stkfin FROM com.entidad.Kardexventas kv WHERE Secuencia = "
//                + " (SELECT MAX(secuencia) FROM com.entidad.Kardexventas kvs WHERE kvs.Codpro = p.Codpro)),0) AS Stkfin "
//                + "FROM Producto p "
//                + "ORDER BY p.Codpro";
        try {
            listarProductoCategoria = sesion.createQuery(sql).list();
            // Query query = sesion.createSQLQuery("CALL SP_LISTAR_PRODUCTO_ALMACEN()").addEntity(Producto.class);
            // listarProductoCategoria=  query.list();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sesion.clear();
        sesion.close();
        return listarProductoCategoria;
    }

    public List<Productoserie> ListarProductoSerie(Producto p) {
        List<Productoserie> lista = null;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Productoserie ps where Codpro =  '" + p.getCodpro() + "' and Estado= 'P' AND Disponible= 0";
        try {
            lista = (List<Productoserie>) sesion.createQuery(hql).list();

        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sesion.clear();
        sesion.close();

        return lista;
    }

    public ResponseProducto Guardar(Producto p, Categoria c, Marca m) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        ResponseProducto res = new ResponseProducto();
        try {
            String codpro = null;
            String codigo = "";
            String sql = "call SP_OPERACION_PRODUCTO (:p_codpro,:p_despro,:p_id_categoria,:p_id_marca,:p_especificacion,:p_precio,:p_imagen,:p_estado,:p_tipo_op) ";
            Query query = sesion.createSQLQuery(sql);
            query.setParameter("p_codpro", p.getCodpro());
            query.setParameter("p_despro", p.getDescripcion());
            query.setParameter("p_id_categoria", c.getId());
            query.setParameter("p_id_marca", m.getId());
            query.setParameter("p_especificacion", p.getEspecificacion());
            query.setParameter("p_precio", 0);
            query.setParameter("p_imagen", "");
            query.setParameter("p_estado", "P");
            query.setParameter("p_tipo_op", "SAVE");
            List<Object[]> response = query.list();
            Object[] resultArray = response.get(0);
            if (response.size() > 0) {
                System.out.println("Codigo: " + resultArray[0]);
                ResponseProducto result = new ResponseProducto();

                res.setCodigo(resultArray[0].toString());
                res.setCodpro(resultArray[1].toString());
                res.setMensaje(resultArray[2].toString());

                p.setCodpro(resultArray[1].toString());

            }

            t.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().
                    addMessage("Error", new FacesMessage("Se ha generado un error al registrar"));
        }
        sesion.clear();
        sesion.close();
        return res;
    }

    public void GuardarProductoSerie(Productoserie ps) {

        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        try {

            sesion.save(ps);
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

    public void EditarOnRow(Productoserie ps) {
        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        try {

            sesion.update(ps);
            t.commit();
            FacesContext.getCurrentInstance().
                    addMessage("Exitoso", new FacesMessage("Se ha actualizado el registro correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().
                    addMessage("Error", new FacesMessage("Se ha generado un error en la actualización"));
        }
        sesion.clear();
        sesion.close();
    }

    public void eliminarPserie(Productoserie ps) {

        Session sesion = null;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        try {
//            String sql= "Delete from Productoserie where id="+ps.getId()+ " and Codpro='"+ps.getProducto().getCodpro()+"'";
//            sesion.createSQLQuery(sql).executeUpdate();
            sesion.delete(ps);
            t.commit();
            FacesContext.getCurrentInstance().addMessage("Exitoso", new FacesMessage("El registro se ha eliminado correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Error", "Error generado " + e.getMessage()));
        }
        sesion.clear();
        sesion.close();
    }

    public Boolean GuardarProducto(String secuencia_temp, int p_usuario) {
        Boolean isRegister = false;
        Session sesion;
        sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        List<Object[]> obj = null;

        ResponseProducto resp = new ResponseProducto();
        Integer p_salida = 0;
        try {
            String sql = "call SP_ACTUALIZAR_STOCK_KARDEVENTAS_POR_PRODUCTO (:p_codpro_temp,:p_usuario) ";
            Query query = sesion.createSQLQuery(sql);
            
            query.setParameter("p_codpro_temp", secuencia_temp);
            query.setParameter("p_usuario", p_usuario);
            obj = query.list();
            t.commit();
            isRegister = true;

            FacesContext.getCurrentInstance().addMessage("Exitoso", new FacesMessage("Registro ingresado correctamente"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Salida: " + e.getStackTrace());
            t.rollback();
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Error", "Error generado " + e.getMessage()));
        }
        sesion.clear();
        sesion.close();

        return isRegister;
    }
}
