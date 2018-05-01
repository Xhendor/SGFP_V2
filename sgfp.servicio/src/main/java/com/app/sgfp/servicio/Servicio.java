/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.servicio;

import com.app.sgfp.common.HibernateProxyTypeAdapter;
import com.app.sgfp.entidades.Contacto;
import com.app.sgfp.entidades.Vivienda;
import com.app.sgfp.negocios.integracion.ServiceFacadeLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author xhendor
 */
@Path("/prueba")
public class Servicio {

    @GET
    @Path("/hola")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {

        Contacto contacto=new Contacto();
        contacto.setPrimerNombre("Jaimito");
        contacto.setSegundoNombre("Anacleto");
        contacto.setApellidoMaterno("De la trinidad");
        return reponseOut(contacto, "", Status.OK);

    }

    @GET
    @Path("/vivienda")
    @Produces(MediaType.APPLICATION_JSON)
    public String viviendas() {

        List<Vivienda> lista = ServiceFacadeLocator.getInstanceContactoDAO().buscarTodasVivienda();
        
        return reponseOut(lista, "", Status.CREATED);

    }

    @GET
    @Path("/vivienda/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String viviendas(@PathParam("id")int id) {

        Vivienda vivienda = ServiceFacadeLocator.getInstanceContactoDAO().buscarViviendaByID(id);
        
        return reponseOut(vivienda, "", Status.CREATED);

    }
    
    
    @DELETE
    @Path("/vivienda/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteVivienda(@PathParam("id")int id) {

        Boolean vivienda = ServiceFacadeLocator.getInstanceContactoDAO().borrarViviendaByID(id);
        
        return reponseOut(vivienda, "", Status.CREATED);

    }
    
    
    @POST
    @Path("/vivienda/{id}/{saludo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String postVivienda(@PathParam("id")int id,@PathParam("saludo")String saludo) {

        Vivienda vivienda = ServiceFacadeLocator.getInstanceContactoDAO().buscarViviendaByID(id);
        
        return reponseOut("Valor:"+vivienda.getCalle()+"\n"+saludo, "", Status.CREATED);

    }
    

    private String reponseOut(Object lista, String mensaje, Status status) {

        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Gson gson = b.create();
        String returnData = gson.toJson(lista);
        return returnData;
    }
}
