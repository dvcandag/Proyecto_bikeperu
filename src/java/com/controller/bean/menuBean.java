/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.complemento.Configuracion;
import com.complemento.Menu.Menu;
import com.complemento.Menu.SubMenu;
import com.model.ModelAuth;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author efrai
 */
@ManagedBean(name = "menuBean")
@SessionScoped
public class menuBean {

    private static final long serialVersionUID = 1L;

    private MenuModel model;

    public menuBean() {
    }

    public menuBean(MenuModel model) {

        this.model = model;
    }

    public MenuModel getModel() {

        Configuracion cn = new Configuracion();
        String url = cn.getBaseApi();
        String token = cn.getToken();
        String username = cn.getUsename();
        Integer idUser = cn.getUserId();
        Integer idRol = cn.getRolId();
        ModelAuth auth = new ModelAuth();

        model = new DefaultMenuModel();

        ArrayList<Menu> menu = auth.listarMenu(token, username, url, idUser, idRol);
        if (menu.size() > 0) { 
            MenuItem menuItem = null;
            for (int i = 0; i < menu.size(); i++) {
                Menu get = menu.get(i);
                if (get.getBaseurl().equals("#")) {
                    System.out.println("base url if: " + get.getBaseurl());
                    DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                            .label("  " + get.getPagina())   
                            .styleClass("layout-menu-tooltip-text")
                            
                            .build();
                    if (get.getSubmenu().size() > 0) {
                        for (int j = 0; j < get.getSubmenu().size(); j++) {
                            SubMenu sub = get.getSubmenu().get(j);
                            DefaultMenuItem item = DefaultMenuItem.builder()
                                    .value(" " + sub.getPagina())
                                    .icon(sub.getIcono())
                                    .url(sub.getBaseurl() + ".xhtml")
                                    .styleClass("layout-root-menuitem")
                                    .build();
                            firstSubmenu.getElements().add(item);
                        }

                    }
                    model.getElements().add(firstSubmenu);
                } else {
                    System.out.println("base url else: " + get.getBaseurl());
                    DefaultMenuItem item = DefaultMenuItem.builder()
                            .value(" " + get.getPagina())
                            .icon(get.getIcono())
                            .url(get.getBaseurl() + ".xhtml")
                            .styleClass("layout-menu-tooltip-text active-menuitem")
                            .build();
                    model.getElements().add(item);
                }

            }
        }

        return model;

    }

    public void save() {
        addMessage("Save", "Data saved");
    }

    public void update() {
        addMessage("Update", "Data updated");
    }

    public void delete() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete", "Data deleted");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void sleepAndSave() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        save();
    }

    public void sleepAndUpdate() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        update();
    }

    public void sleepAndDelete() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        delete();
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
