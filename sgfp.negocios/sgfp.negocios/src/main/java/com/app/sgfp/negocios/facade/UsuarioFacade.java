/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.negocios.facade;

import com.app.sgfp.negocios.delegate.UsuarioDelegate;

/**
 *
 * @author xhendor
 */
public class UsuarioFacade {

    private final UsuarioDelegate delegate;

    public UsuarioFacade() {
        delegate = new UsuarioDelegate();

    }

    public boolean login(String user, String pass) {

        return delegate.login(user, pass);
    }
    
    public static void main(String[] args) {
        UsuarioDelegate delegate1=new UsuarioDelegate();
        delegate1.login("coco", "coco344");
    }

}
