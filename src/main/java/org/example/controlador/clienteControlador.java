package org.example.controlador;

import org.example.modelo.clienteModel;

import java.sql.SQLException;
import java.util.List;

public class clienteControlador {

    public List<clienteModel> listarCliente() throws SQLException {
        return clienteModel.listarCliente();
    }

    public void agregarCliente(String nombre, String correo) throws SQLException{
        clienteModel.agregarCliente(nombre, correo);
    }

    public void editarCliente(int id, String nombre, String correo) throws SQLException{
        clienteModel.editarCliente(id, nombre, correo);
    }

    public void eliminarCliente(int id) throws SQLException{
        clienteModel.eliminarCliente(id);
    }
}
