/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.persistencia.integracion;

import com.app.sgfp.dao.ContactoDAO;
import com.app.sgfp.dao.UsuarioDAO;
import com.app.sgfp.dao.ViviendaDAO;

/**
 *
 * @author xhendor
 */
public class ServiceLocator {

    private static ViviendaDAO viviendaDAO;

    private static UsuarioDAO usuarioDAO;

    private static ContactoDAO contactoDAO;

    public static ContactoDAO getInstanceContactoDAO() {
        if (contactoDAO == null) {
            contactoDAO = new ContactoDAO();
            return contactoDAO;
        } else {
            return contactoDAO;
        }
    }

    public static ViviendaDAO getInstanceViviendaDAO() {
        if (viviendaDAO == null) {
            viviendaDAO = new ViviendaDAO();
            return viviendaDAO;
        } else {
            return viviendaDAO;
        }
    }

    public static UsuarioDAO getInstanceUsuarioDAO() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else {
            return usuarioDAO;
        }
    }

}
