/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.complemento;

import com.entidad.VentaCabeceraTemp;
import com.entidad.VentaDetalleTemp;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author efrai
 */
public class Carrito implements Serializable{
    
    private VentaCabeceraTemp ventaCabTemp;
    private List<VentaDetalleTemp> ventaDetTemp;

    public VentaCabeceraTemp getVentaCabTemp() {
        return ventaCabTemp;
    }

    public void setVentaCabTemp(VentaCabeceraTemp ventaCabTemp) {
        this.ventaCabTemp = ventaCabTemp;
    }


     
    public List<VentaDetalleTemp> getVentaDetTemp() {
        return ventaDetTemp;
    }

    public void setVentaDetTemp(List<VentaDetalleTemp> ventaDetTemp) {
        this.ventaDetTemp = ventaDetTemp;
    }
 
    
}
