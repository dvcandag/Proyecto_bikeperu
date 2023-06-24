/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.entidad.Rol;
import com.entidad.Usuario;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.Serializable;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author efrai
 */
@ManagedBean(name="seguridadBean")
@ViewScoped
public class seguridadBean implements Serializable{

    private String usuarioCn;
    public String baseApi;

    /**
     * Creates a new instance of seguridadBean
     */
    public seguridadBean() {
    }

    public void verificarSesion() {
        try {
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_usuario");
            Rol rol = (Rol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_rol");
            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../login.xhtml");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String usuarioLogueado() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_usuario");
        Rol rol = (Rol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session_rol");
        this.usuarioCn = user.getNombre() + " - " + rol.getNombreRol();
        return usuarioCn;
    }

    public String getUsuarioCn() {
        return usuarioCn;
    }

    public void setUsuarioCn(String usuarioCn) {
        this.usuarioCn = usuarioCn;
    }

    public String getBaseApi() {
        try {
            //creating a constructor of file class and parsing an XML file  
            File file = new File("setting.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("settings");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    baseApi = eElement.getElementsByTagName("endPonint").item(0).getTextContent();
                    System.out.println("End point: " + eElement.getElementsByTagName("endPonint").item(0).getTextContent()); 
                }
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }
//        String api= 
        return baseApi;
    }

    public void setBaseApi(String baseApi) {
        this.baseApi = baseApi;
    }

}
