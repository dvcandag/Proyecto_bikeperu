/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Configuracion;
import com.complemento.ResAuth;
import com.entidad.Pagina;
import com.entidad.Rol;
import com.entidad.Usuario;
import com.google.gson.Gson;
import com.model.ModelAuth;
import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.Cookie;

/**
 *
 * @author efrai
 */
@ManagedBean(name = "authBean")
@ViewScoped
public class authBean implements Serializable{

    Configuracion conf; 
    private final String BaseApi = "http://localhost:5100/api/";
    private Usuario usuario;
    private Rol rol;
    private Pagina pagina;
    private List<Object[]> usuarioAuth;
    /**
     * Creates a new instance of AuthBean
     */
    public authBean() {
        usuario = new Usuario();
        rol = new Rol();
        pagina = new Pagina();

//        this.conf = new Configuracion(); 
//        this.BaseApi = this.conf.getBaseApi(); 
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

    /**
     *
     * @return
     */
    public String iniciarSesion() {
        ModelAuth model = new ModelAuth();
        String urlRedirect = "";
        try {
            String response = model.Login(usuario, this.BaseApi);

            if (!response.isEmpty()) {
                Usuario usuarios = new Usuario();
                Rol roles = new Rol();
                Gson g = new Gson();
                ResAuth res = g.fromJson(response, ResAuth.class);
                if (!res.getError()) {
                    String[] chunks = res.getBody().split("\\.");
                    Base64.Decoder decoder = Base64.getUrlDecoder();
                    String payload = new String(decoder.decode(chunks[1]));
                    Gson gson = new Gson();
                    usuarios = gson.fromJson(payload, Usuario.class);
                    JSONObject obj = new JSONObject(payload);
                    JSONObject role = obj.getJSONObject("Rol");
                    roles.setAgregar(role.getInt("Agregar"));
                    roles.setEditar(role.getInt("Editar"));
                    roles.setEliminar(role.getInt("Eliminar"));
                    roles.setFacturar(role.getInt("Facturar"));
                    roles.setId(role.getInt("Id"));
                    roles.setLeer(role.getInt("Leer"));
                    roles.setFlgEstado(role.getString("FlgEstado"));
                    roles.setTipRol(role.getString("TipRol"));
                    roles.setNombreRol(role.getString("NombreRol"));
                    FacesContext context = FacesContext.getCurrentInstance();
                    usuarios.setRol(roles);

                    Cookie miCookie = new Cookie("token", res.getBody());
                    miCookie.setDomain("http://localhost:8084/proyecto_univesidad_copia/");
                    miCookie.setPath("http://localhost:8084/proyecto_univesidad_copia/");
                    miCookie.setComment("Cookies de prueba");

                    context.getExternalContext().getSessionMap().put("session_usuario", usuarios);
                    context.getExternalContext().getSessionMap().put("token", res.getBody());
                    context.getExternalContext().getSessionMap().put("session_rol", roles);
                    urlRedirect = this.Redireccionar(roles.getTipRol());
                } else {
                    urlRedirect = "";
                }

            } else {
                addMessage(FacesMessage.SEVERITY_FATAL, "Adevertencia", "Usuario y/o contraseña incorrecta");
                urlRedirect = "";
            }
        } catch (JSONException e) {
            System.out.println("Error mensaje: " + e.getMessage());
            System.out.println(e);
            System.out.println("Fin de Error");
            urlRedirect = "";

        }
        return urlRedirect;
    }


    /**/
    /**
     *
     * @param tipo
     * @return
     */
    public String Redireccionar(String tipo) {
        System.out.println("Tipo: " + tipo);
        switch (tipo) {
            case "A":
                return "admin/dashboard.xhtml?faces-redirect=true";
            case "U":
                return "user/dashboard.xhtml?faces-redirect=true";
            default:
                return "user/dashboard.xhtml?faces-redirect=true";
        }
    }
 

    public String register() {
        return "register.xhml?faces-redirect=true";
    }

    public String forgetPassword() {
        return "forget-password.xhml?faces-redirect=true";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
