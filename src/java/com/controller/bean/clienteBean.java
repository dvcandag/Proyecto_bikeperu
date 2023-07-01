/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.ApiResDni;
import com.complemento.Configuracion;
import com.entidad.Cliente;
import com.entidad.Consultarucdni;
import com.github.lbovolini.mapper.ObjectMapper;
import com.google.gson.Gson;
import com.model.ModelCliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author efrai
 */
@ManagedBean
@ViewScoped
public class clienteBean implements Serializable {

    private Cliente cliente;
    private List<Cliente> listarClientes;
    private Consultarucdni consulta;

    Configuracion conf = new Configuracion();
    private String token = "";
    private String Username = "";
    private String BaseApi = "";
    private Integer minChar=11;

    public clienteBean() {
        cliente = new Cliente();
        this.token = conf.getToken();
        this.BaseApi = conf.getBaseApi();
        this.Username = conf.getUsename();
        this.consulta = new Consultarucdni();
        this.minChar = 11;
    }

    public Integer getMinChar() {
        return minChar;
    }

    public void setMinChar(Integer minChar) {
        this.minChar = minChar;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public List<Cliente> getListarClientes() {
        ModelCliente model = new ModelCliente();
        listarClientes = model.ListarClientes(this.BaseApi, this.token, this.Username);
        return listarClientes;
    }

    public void setListarClientes(List<Cliente> listarClientes) {
        this.listarClientes = listarClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void limpiarCliente() {
        cliente = new Cliente();
    }

    public void guardarRegistro() {
        ModelCliente model = new ModelCliente();
        model.guardar(cliente, this.BaseApi, this.token, this.Username);

    }

    public void modificarRegistro() {

        ModelCliente model = new ModelCliente();
        model.actualizar(cliente, this.BaseApi, this.token, this.Username);
        this.limpiarCliente();
    }

    public void eliminarRegistro() {

        ModelCliente model = new ModelCliente();
        model.eliminar(cliente, this.BaseApi, this.token, this.Username);
        this.limpiarCliente();
    }

    public Consultarucdni getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultarucdni consulta) {
        this.consulta = consulta;
    }

    public void cambiarTipodocumento() {
        this.limpiarCliente();
        switch (consulta.getTipoConsulta()) {
            case 1:
                minChar = 11;
                consulta.setNumero("");
                cliente.setTipo("1");
                cliente.setDocumento("");
                cliente.setRazonSocial("");
                break;
            case 3:
                minChar = 8;
                consulta.setNumero("");
                cliente.setTipo("3");
                cliente.setRazonSocial("");
                cliente.setDocumento("");
                break;
            default:
                minChar = 8;
                consulta.setNumero("");
                cliente.setTipo("3");
                cliente.setDocumento("");
                cliente.setRazonSocial("");
                break;
        }
    }

    public void buscarPersona() {
        String dir = null;
        this.limpiarCliente();
        if (consulta != null) {
            try {
                Integer tipo = consulta.getTipoConsulta();
                System.out.println("Tipo post: " + tipo);
                String urlPath = urlConsultar(tipo);
                if (urlPath != null) {
                    URL url = new URL(urlPath);
                    HttpURLConnection api = (HttpURLConnection) url.openConnection();
                    api.setDoOutput(true);
                    api.setInstanceFollowRedirects(false);
                    api.setRequestMethod("GET");
                    api.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    api.setRequestProperty("charset", "utf-8");
                    api.setUseCaches(false);
                    api.connect();
                    Integer responseCode = api.getResponseCode();
                    if (responseCode == 200) {
                        InputStreamReader response = new InputStreamReader(api.getInputStream());
                        BufferedReader reader = new BufferedReader(response);
                        String json = reader.readLine();
                        Object info = json;
                        ObjectMapper map = new ObjectMapper();
                        JSONObject obj = new JSONObject(json);

                        if (tipo == 3) {

                            if (obj.has("success")) {
                                String status =   (String) obj.get("success");
                                if (status == "false") {
                                    addMessage(FacesMessage.SEVERITY_INFO, "Exitoso", obj.getString("message"));
                                } else {
                                    Gson gson = new Gson();
                                    ApiResDni respons = gson.fromJson(json, ApiResDni.class);
                                    cliente.setRazonSocial(respons.getData().getNombres() + " "
                                            + respons.getData().getApellidoPaterno() + " "
                                            + respons.getData().getApellidoMaterno());
                                    cliente.setDocumento(respons.getData().getDni());
                                    cliente.setDireccion("-");
                                    cliente.setTipo("3");
                                }
                            }

                        } else {

                            if (obj.has("success")) {
                                Boolean status = (Boolean) obj.get("success");
                                if (status == false) {
                                    this.limpiarCliente();
                                    String mensaje = obj.getString("message");
                                    FacesContext.getCurrentInstance().addMessage("Error de catch", new FacesMessage(mensaje));
                                } else {
                                    FacesContext.getCurrentInstance().addMessage("Error de catch", new FacesMessage("Error else"));
                                }
                            } else {
                                if (tipo == 1) {
                                    cliente.setRazonSocial(obj.getString("razonSocial"));
                                    cliente.setDocumento(obj.getString("ruc"));
                                    if (obj.isNull("direccion")) {
                                        dir = "-";
                                    } else {
                                        dir = obj.getString("direccion");
                                    }
                                    cliente.setDireccion(dir);
                                    cliente.setTipo("1");
                                } else {
                                    cliente.setRazonSocial(obj.getString("nombres") + " "
                                            + obj.getString("apellidoPaterno") + " "
                                            + obj.getString("apellidoMaterno"));
                                    cliente.setDocumento(obj.getString("dni"));
                                    cliente.setDireccion("-");
                                    cliente.setTipo("3");
                                    System.out.println(cliente.getRazonSocial());
                                }
                            }
                        }

                    } else {
                        FacesContext.getCurrentInstance().
                                addMessage("Error de respuesta", new FacesMessage(responseCode + " - " + api.getResponseMessage()));
                    }
                    api.disconnect();
                } else {
                    FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Error al obtener la url del API"));
                }

            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage("Error de catch", new FacesMessage(e.getMessage()));
            }
        }
    }

    public String urlConsultar(Integer tipo) {
        String token
                = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImVmcmFpbnJjYTE5OTVAZ21haWwuY29tIn0._lcv0WMKiWSDpoeC8FB7QHEYSNfLMHJKoWF4HEEBSpA";
        switch (tipo) {
            case 1:
                return "https://dniruc.apisperu.com/api/v1/ruc/" + consulta.getNumero() + "?token=" + token;
            case 3:
                return "http://apisrca.net.ti/api/dni/" + consulta.getNumero();
            default:
                return "http://apisrca.net.ti/api/dni/" + consulta.getNumero();
        }
    }

}
