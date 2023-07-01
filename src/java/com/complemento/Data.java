/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complemento;

/**
 *
 * @author efrai
 */
public class Data {
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private long codVerificador;

    public String getDni() { return dni; }
    public void setDni(String value) { this.dni = value; }

    public String getNombres() { return nombres; }
    public void setNombres(String value) { this.nombres = value; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String value) { this.apellidoPaterno = value; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String value) { this.apellidoMaterno = value; }

    public long getCodVerificador() { return codVerificador; }
    public void setCodVerificador(long value) { this.codVerificador = value; }
}