package org.example.controlador;


import org.example.modelo.usuarioModel;

import java.sql.SQLException;

public class loginControlador {

    public void registrarUsuario(String username, String contra) throws SQLException {
        usuarioModel.registrarUsuario(username, contra);
    }

    public boolean iniciarSesion(String username, String contra) throws SQLException{
        return usuarioModel.iniciarSesion(username, contra);
    }




}
