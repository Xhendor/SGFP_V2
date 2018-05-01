/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios.facade;

import com.app.sgfp.entidades.Vivienda;
import com.app.sgfp.negocios.delegate.ViviendaDelegate;
import java.util.List;

/**
 *
 * @author xhendor
 */
public class ViviendaFacade {

    private final ViviendaDelegate delegate;

    public ViviendaFacade() {

        delegate = new ViviendaDelegate();
    }

    public List<Vivienda> buscarTodasVivienda() {

        return delegate.obtenerViviendas();

    }

    public List<Vivienda> buscarViviendaByCalle(String calle) {

        return delegate.buscarViviendas(calle);

    }

    public Vivienda buscarViviendaByID(Integer id) {

        return delegate.buscarViviendas(id);

    }

    public Boolean borrarViviendaByID(Integer id) {

        return delegate.borrarViviendaByID(id);
    }

    public Boolean crearVivienda(String calle, String numeroExterior, Boolean habitada, Boolean renta) {

        Vivienda viviendaToCreate = new Vivienda(0, calle, numeroExterior, habitada, renta);

        return delegate.crearVivienda(viviendaToCreate);
    }

}
