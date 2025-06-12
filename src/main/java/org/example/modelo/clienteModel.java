package org.example.modelo;

public class clienteModel {

    private int idCliente;
    private String username;
    private String contreaseña;

    public clienteModel(int idCliente, String username, String contreaseña) {
        this.idCliente = idCliente;
        this.username = username;
        this.contreaseña = contreaseña;
    }

    public clienteModel() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContreaseña() {
        return contreaseña;
    }

    public void setContreaseña(String contreaseña) {
        this.contreaseña = contreaseña;
    }
}
