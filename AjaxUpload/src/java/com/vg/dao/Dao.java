package com.vg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private Connection cn;

    public void Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Phishing", "root", "Servifast12345");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ajax", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    //Cerrar conexion con la bd
    public void Cerrar() throws SQLException {
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    //Getter and Setter
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

//    public static void main(String[] args) {
//        Dao dao = new Dao();
//        dao.Conexion();
//    }
}
