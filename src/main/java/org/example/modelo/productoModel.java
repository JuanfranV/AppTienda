package org.example.modelo;

import org.example.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productoModel {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public productoModel(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public productoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static List<productoModel> listarProductos() throws SQLException{
        String sql = "SELECT id, nombre, precio, stock FROM productos WHERE eliminado = 0";
        List<productoModel> lista = new ArrayList<>();
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while (rs.next()){
                lista.add(new productoModel(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }
        }
        return lista;
    }

    public static void agregarProducto(String nombre, double precio, int stock) throws SQLException{
        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);

            ps.executeUpdate();
        }
    }

    public static void editarProducto(int id, String nombre, double precio, int stock) throws SQLException{
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);
            ps.setInt(4, id);

            ps.executeUpdate();
        }
    }

    public static void eliminarProducto(int id) throws SQLException{
        String sql = "UPDATE productos SET eliminado = 1 WHERE id = ?";
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }



}
