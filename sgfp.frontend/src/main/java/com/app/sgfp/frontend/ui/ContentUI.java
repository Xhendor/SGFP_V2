package com.app.sgfp.frontend.ui;


import com.app.sgfp.frontend.common.Car;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "contentUI")
@ViewScoped
public class ContentUI implements Serializable {




    private List<Car> listaDeCarros;

    //Injectar un Bean de Session
    @ManagedProperty("#{loginUI}")
    private LoginUI loginUI;

    public ContentUI() {

    }


    @PostConstruct
    public void init(){

        listaDeCarros=new ArrayList<>();
        listaDeCarros.add(new Car("Camry","2005"));
        listaDeCarros.add(new Car("Camry","2006"));

        listaDeCarros.add(new Car("Camry","2007"));

        listaDeCarros.add(new Car("Camry","2008"));
        listaDeCarros.add(new Car("Camry","2009"));

        listaDeCarros.add(new Car("Camry","2010"));

    }

    public String getUserName(){


        return loginUI.getUser();
    }

    public boolean getIsLogged(){


        return loginUI.isLogged();
    }


    //OBLIGATORIO TENER SUS GETTER Y SETTERS
    public LoginUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }


    public List<Car> getListaDeCarros() {
        return listaDeCarros;
    }

    public void setListaDeCarros(List<Car> listaDeCarros) {
        this.listaDeCarros = listaDeCarros;
    }

}
