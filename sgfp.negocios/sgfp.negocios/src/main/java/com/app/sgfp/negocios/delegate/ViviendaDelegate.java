/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios.delegate;

import com.app.sgfp.entidades.Vivienda;
import com.app.sgfp.persistencia.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author xhendor
 */
public class ViviendaDelegate {

    public ViviendaDelegate() {
    }

    /**
     * @return listado de viviendas
     *
     */
    public List<Vivienda> obtenerViviendas() {

        return ServiceLocator.getInstanceViviendaDAO().findAll();

    }

    /**
     * @param id Identificador de vivienda
     * @return objeto de vivienda
     *
     */
    public Vivienda buscarViviendas(Integer id) {

        return ServiceLocator.getInstanceViviendaDAO().find(id);
    }

    /**
     * @param calle calle de viviendas
     * @return Lista de viviendas
     *
     */
    public List<Vivienda> buscarViviendas(String calle) {

        return ServiceLocator.getInstanceViviendaDAO().findByOneParameter(calle, "calle");

    }

    /**
     * *
     *
     * @param vivienda vivienda para actualizar
     * @return Si fue realizado elcambio
     */
    public Boolean actualizarVivienda(Vivienda vivienda) {

        try {
            ServiceLocator.getInstanceViviendaDAO().update(vivienda);

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            return false;
        }

        return true;
    }

    public Boolean borrarViviendaByID(Integer id) {
        try {

            Vivienda viviendaToDelete = ServiceLocator.getInstanceViviendaDAO().find(id);

            ServiceLocator.getInstanceViviendaDAO().delete(viviendaToDelete);

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
        return true;
    }

    public Boolean borrarVivienda(Vivienda vivienda) {

        try {

            ServiceLocator.getInstanceViviendaDAO().delete(vivienda);

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
        return true;
    }

    public Boolean crearVivienda(Vivienda viviendaToCreate) {

        try {

            ServiceLocator.getInstanceViviendaDAO().save(viviendaToCreate);

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
        return true;

    }



}
