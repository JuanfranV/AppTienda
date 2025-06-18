package org.example.modelo;

import org.example.JDBCUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clienteModel {

    private int id;
    private String nombre;
    private String correo;

    public clienteModel(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public clienteModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return nombre;
    }

    public void setUsername(String username) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static List<clienteModel> listarCliente() throws SQLException{
        String sql = "SELECT id, nombre, correo FROM clientes WHERE eliminado = 0";
        List<clienteModel> lista = new ArrayList<>();

        try (
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while (rs.next()){
                lista.add(new clienteModel(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo")
                ));
            }
        }
        return lista;
    }

    public static void agregarCliente(String nombre, String correo) throws SQLException{
        String sql = "INSERT INTO clientes (nombre, correo) VALUES (?, ?)";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, nombre);
            ps.setString(2, correo);

            ps.executeUpdate();
        }
    }

    public static void editarCliente(int id, String nombre, String correo) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, correo = ? WHERE id = ?";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, id);

            ps.executeUpdate();
        }
    }

    public static void eliminarCliente(int id) throws SQLException{
        String sql = "UPDATE clientes SET eliminado = 1 WHERE id = ?";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setInt(1, id);

            ps.executeUpdate();
        }

    }


    }
