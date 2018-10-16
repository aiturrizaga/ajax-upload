package com.vg.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.PrimeFaces;

@Named(value = "userController")
@SessionScoped
@Data
public class UserController implements Serializable {

    public void addUser() throws Exception {
        try {
            PrimeFaces.current().executeScript("cargarImagen()");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado correctamente"));
        } catch (Exception e) {
            throw e;
        }
    }

}
