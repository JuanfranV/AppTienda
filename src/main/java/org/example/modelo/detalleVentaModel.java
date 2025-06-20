package org.example.modelo;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class detalleVentaModel {

    private int idVentaDetalle;
    private int ventaId;
    private int productoId;
    private int cantidad;
    private double precioUnitario;

    public detalleVentaModel(int idVentaDetalle, int ventaId, int productoId, int cantidad, double precioUnitario) {
        this.idVentaDetalle = idVentaDetalle;
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public detalleVentaModel() {
    }

    public int getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(int idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }


    public BigDecimal calcularTotal() {

        return total;
    }


}
