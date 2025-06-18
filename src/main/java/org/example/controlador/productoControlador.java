package org.example.controlador;

import org.example.modelo.productoModel;

import java.sql.SQLException;
import java.util.List;

public class productoControlador {

    public List<productoModel> listarProductos() throws SQLException {
        return productoModel.listarProductos();
    }

    public void agregarProducto(String nombre, double precio, int stock) throws SQLException{
        productoModel.agregarProducto(nombre, precio, stock);
    }

    public void editarProducto(int id, String nombre, double precio, int stock) throws SQLException{
        productoModel.editarProducto(id, nombre, precio, stock);
    }

    public void eliminarProducto(int id) throws SQLException{
        productoModel.eliminarProducto(id);
    }


}
