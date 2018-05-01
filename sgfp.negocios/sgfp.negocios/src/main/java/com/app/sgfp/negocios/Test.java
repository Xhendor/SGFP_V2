/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios;

import com.app.sgfp.entidades.Vivienda;
import com.app.sgfp.negocios.delegate.ViviendaDelegate;
import com.app.sgfp.negocios.facade.ViviendaFacade;

/**
 *
 * @author xhendor
 */
public class Test {

    public static void main(String[] args) {

        ViviendaFacade viviendaFacade = new ViviendaFacade();

        
        System.err.println("Se agrego:["+viviendaFacade.crearVivienda("DarkSideOfTheMoon", "1974", Boolean.TRUE, Boolean.FALSE)+"]");
        
        
        
    }
}
