package com.entidad;
// Generated 15-jun-2023 8:30:38 by Hibernate Tools 4.3.1



/**
 * VentaDetalleId generated by hbm2java
 */
public class VentaDetalleId  implements java.io.Serializable {


     private int secuencia;
     private int item;

    public VentaDetalleId() {
    }

    public VentaDetalleId(int secuencia, int item) {
       this.secuencia = secuencia;
       this.item = item;
    }
   
    public int getSecuencia() {
        return this.secuencia;
    }
    
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }
    public int getItem() {
        return this.item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VentaDetalleId) ) return false;
		 VentaDetalleId castOther = ( VentaDetalleId ) other; 
         
		 return (this.getSecuencia()==castOther.getSecuencia())
 && (this.getItem()==castOther.getItem());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSecuencia();
         result = 37 * result + this.getItem();
         return result;
   }   


}

