package com.vg.dao;

import com.vg.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao {

    public void addUser(User usu) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO Usuario(id_user,nom_user,pass_user,img_user) VALUES(null, ?, ?, ?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, usu.getNomUser());
            ps.setString(2, usu.getPassUser());
            ps.setString(3, usu.getImgUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<User> listUser() throws SQLException {
        List<User> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM Usuario";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            User usu;
            while (rs.next()) {
                usu = new User();
                usu.setCodUser(rs.getString("id_user"));
                usu.setNomUser(rs.getString("nom_user"));
                usu.setPassUser(rs.getString("pass_user"));
                lista.add(usu);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
