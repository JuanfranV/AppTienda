package org.example.modelo;

import org.example.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioModel {

    private int id;
    private String username;
    private String contra;

    public usuarioModel(int id, String username, String contra) {
        this.id = id;
        this.username = username;
        this.contra = contra;
    }

    public usuarioModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public static void registrarUsuario(String username, String contra ) throws SQLException{
        String sql = "INSERT INTO usuarios VALUES username = ?, contraseña = ?";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, username);
            ps.setString(2, contra);

            ps.executeUpdate();
        }
    }

    public static boolean iniciarSesion(String username, String contra) throws SQLException{
        String sql = "SELECT * INTO usuarios WHERE username = ?, contraseña = ?";

        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, username);
            ps.setString(2, contra);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    }
