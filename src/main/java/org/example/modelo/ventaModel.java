package org.example.modelo;

import org.example.JDBCUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ventaModel {

    private int id;
    private int clienteId;
    private LocalDate fecha = LocalDate.now();
    private Date fechaSQL = Date.valueOf(fecha);
    private double total;

    private int productoCantidad;
    private int productoId;

    public ventaModel(int id, int clienteId, Date fechaSQL, LocalDate fecha, double total, int productoCantidad, int productoId) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaSQL = fechaSQL;
        this.fecha = fecha;
        this.total = total;
        this.productoCantidad = productoCantidad;
        this.productoId = productoId;
    }

    public ventaModel(int productoId, int productoCantidad) {
        this.productoId = productoId;
        this.productoCantidad = productoCantidad;

    }

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

    public double getTotal() {
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Date getFechaSQL() {
        return fechaSQL;
    }

    public void setFechaSQL(Date fechaSQL) {
        this.fechaSQL = fechaSQL;
    }

    public int getProductoCantidad() {
        return productoCantidad;
    }

    public void setProductoCantidad(int productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static void iniciarVenta(int clienteId, Date fechaSQL) throws SQLException{
        String sql = "INSERT INTO ventas (cliente_id, fecha) VALUES (?, ?)";

        try (
                Connection con = JDBCUtil.getConnection();
                PreparedStatement st = con.prepareStatement(sql)
                ){
            st.setInt(1, clienteId);
            st.setDate(2, fechaSQL);

            st.executeUpdate();
        }
    }

    private static List<ventaModel> carrito = new ArrayList<>();

    public static void agregarProductoALaVenta(int stock, int cantidad, int productoId) throws SQLException{
        if (stock >= cantidad) {
            carrito.add(new ventaModel(
                    productoId,
                    cantidad
                    ));
        }
    }








}






