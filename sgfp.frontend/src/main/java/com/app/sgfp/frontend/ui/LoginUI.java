/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.frontend.ui;

import com.app.sgfp.frontend.helper.LoginHelper;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author xhendor
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginUI implements Serializable {

    private String user;
    private String password;
    private LoginHelper helper;
    private boolean logged;

    /**
     * Creates a new instance of LoginUI
     */
    public LoginUI() {

    }

    @PostConstruct
    public void init(){

        helper = new LoginHelper();
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    
    public void loginUser() {

        System.err.println("User: " + this.user);

        logged = helper.login(user, password);

        if (logged) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/app/content");
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("username", user);
            } catch (IOException ex) {
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Nop, no se pudo ingresar");
        }

    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the logged
     */
    public boolean isLogged() {
        return logged;
    }

    /**
     * @param logged the logged to set
     */
    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
