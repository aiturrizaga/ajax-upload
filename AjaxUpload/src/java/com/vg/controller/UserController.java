package com.vg.controller;

import com.vg.dao.UserDao;
import com.vg.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.PrimeFaces;

@Named(value = "userController")
@SessionScoped
@Data
public class UserController implements Serializable {

    private User usu = new User();
    private List<User> listaUser;

    @PostConstruct
    public void init() {
        try {
            listUser();
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUser() throws Exception {
        UserDao dao;
        try {
            dao = new UserDao();
            PrimeFaces.current().executeScript("cargarImagen()");
            dao.addUser(usu);
            clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado correctamente"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void clear() {
        usu = new User();
    }

    public void listUser() throws Exception {
        UserDao dao;
        try {
            dao = new UserDao();
            listaUser = dao.listUser();
        } catch (SQLException e) {
            throw e;
        }
    }
}
