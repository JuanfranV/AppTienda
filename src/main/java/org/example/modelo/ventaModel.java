package org.example.modelo;

import org.example.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ventaModel {

    private int id;
    private int clienteId;
    private Date fecha;
    private double total;

    public ventaModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }








    }






