package com.app.sgfp.frontend.util;

import com.sun.faces.component.visit.FullVisitContext;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class Util {


    public static FacesContext obtenerContexto(){

        FacesContext context = FacesContext.getCurrentInstance();
            return context;
    }

    public static Map<String, Object> obtenerMapaDeSession(){

        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getSessionMap();
    }

    public static void redireccionar(String pagina) throws IOException {

        HttpServletRequest reqt =
                (HttpServletRequest) FacesContext.getCurrentInstance().
                        getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().
                redirect(reqt.getContextPath()+pagina);
    }

    public static UIComponent findComponent(final String id) {

        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        final UIComponent[] found = new UIComponent[1];

        root.visitTree(new FullVisitContext(context), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent component) {
                if(component.getId().equals(id)){
                    found[0] = component;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });

        return found[0];

    }

}
