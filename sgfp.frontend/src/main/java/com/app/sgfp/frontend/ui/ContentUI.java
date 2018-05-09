package com.app.sgfp.frontend.ui;


import com.app.sgfp.entidades.Vivienda;
import com.app.sgfp.frontend.common.Car;
import com.app.sgfp.frontend.helper.ContentHelper;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "contentUI")
@ViewScoped
public class ContentUI implements Serializable {




    private Vivienda viviedaSelected;
    private List<Car> listaDeCarros;
    private ContentHelper helper;



    private Vivienda vivienda;
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

        helper=new ContentHelper();
        vivienda=new Vivienda();
    }

    public String getUserName(){


        return loginUI.getUser();
    }

    public boolean getIsLogged(){


        return loginUI.isLogged();
    }

    public List<Vivienda> getAllViviendas(){

        return helper.getAllViviendas();

    }
    public Vivienda getViviedaSelected() {
        return viviedaSelected;
    }

    public void setViviedaSelected(Vivienda viviedaSelected) {
        this.viviedaSelected = viviedaSelected;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }
    public void guardarVivienda(){

        System.err.println(vivienda.getCalle());
        System.err.println(vivienda.getNumeroExterior());

        listaDeCarros.remove(2);

    }

    public void onRowSelect(SelectEvent event) {

        System.err.println("He we!!! Fui presionado!!!");
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
