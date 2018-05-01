/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios.delegate;

import com.app.sgfp.entidades.Usuario;
import com.app.sgfp.persistencia.integracion.ServiceLocator;

/**
 *
 * @author xhendor
 */
public class UsuarioDelegate {
    
    
    public boolean login(String user, String pass){
        Usuario u=ServiceLocator.getInstanceUsuarioDAO().findByOneParameterUnique(user, "usuario");
         if(u!=null){
             if(u.getPassword().equals(pass)){
                     return true;
             }
         }
      return  false;
    }
    
}
