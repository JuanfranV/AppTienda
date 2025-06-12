package org.example.modelo;

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
}
