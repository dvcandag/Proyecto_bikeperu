package com.entidad;
// Generated 15-jun-2023 8:30:38 by Hibernate Tools 4.3.1



/**
 * Consultarucdni generated by hbm2java
 */
public class Consultarucdni  implements java.io.Serializable {


     private int tipoConsulta;
     private String numero;
     private Integer minChar;
     private Integer maxChar;

    public Consultarucdni() {
    }

	
    public Consultarucdni(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    public Consultarucdni(int tipoConsulta, String numero, Integer minChar, Integer maxChar) {
       this.tipoConsulta = tipoConsulta;
       this.numero = numero;
       this.minChar = minChar;
       this.maxChar = maxChar;
    }
   
    public int getTipoConsulta() {
        return this.tipoConsulta;
    }
    
    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Integer getMinChar() {
        return this.minChar;
    }
    
    public void setMinChar(Integer minChar) {
        this.minChar = minChar;
    }
    public Integer getMaxChar() {
        return this.maxChar;
    }
    
    public void setMaxChar(Integer maxChar) {
        this.maxChar = maxChar;
    }




}

