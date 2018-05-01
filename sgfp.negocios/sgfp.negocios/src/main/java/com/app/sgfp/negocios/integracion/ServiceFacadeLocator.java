/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios.integracion;

import com.app.sgfp.negocios.facade.UsuarioFacade;
import com.app.sgfp.negocios.facade.ViviendaFacade;

/**
 *
 * @author xhendor
 */
public class ServiceFacadeLocator {

    private static ViviendaFacade viviendaFacade;
    private static UsuarioFacade usuarioFacade;
    public static ViviendaFacade getInstanceContactoDAO() {
        if (viviendaFacade == null) {
            viviendaFacade = new ViviendaFacade();
            return viviendaFacade;
        } else {
            return viviendaFacade;
        }
    }
    
    public static UsuarioFacade getInstanceUsuarioFacade() {
        if (usuarioFacade == null) {
            usuarioFacade = new UsuarioFacade();
            return usuarioFacade;
        } else {
            return usuarioFacade;
        }
    }

}
