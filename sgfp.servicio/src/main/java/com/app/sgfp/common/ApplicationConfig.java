/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.common;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author emmanuelle
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try {

            Class jacksonProvider = Class.forName("com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider");

            resources.add(jacksonProvider);
                        resources.add(JacksonConfigurator.class);

            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**com/fasterxml/jackson/databind/util/LRUMap
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(com.app.sgfp.common.JacksonConfigurator.class);
        resources.add(com.app.sgfp.common.JerseyObjectMapperProvider.class);
        resources.add(com.app.sgfp.servicio.Servicio.class);
    }

}
