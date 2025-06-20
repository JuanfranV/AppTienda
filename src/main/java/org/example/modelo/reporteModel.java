package org.example.modelo;

import org.example.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class reporteModel {

    private Date fecha;
    private String clienteNombre;
    private String productoNombre;
    private int detalleVentaCantidad;
    private double total;
    private int ventaId;
    private double precioUnitario;


    public reporteModel(Date fecha, String clienteNombre, String productoNombre, int detalleVentaCantidad, double total, int ventaId, double precioUnitario) {
        this.fecha = fecha;
        this.clienteNombre = clienteNombre;
        this.productoNombre = productoNombre;
        this.detalleVentaCantidad = detalleVentaCantidad;
        this.total = total;
        this.ventaId = ventaId;
        this.precioUnitario = precioUnitario;
    }

    public reporteModel(Date fecha, String clienteNombre, String productoNombre, int detalleVentaCantidad, double total) {
        this.fecha = fecha;
        this.clienteNombre = clienteNombre;
        this.productoNombre = productoNombre;
        this.detalleVentaCantidad = detalleVentaCantidad;
        this.total = total;
    }

    public reporteModel(String clienteNombre, Date fecha, double total) {
        this.clienteNombre = clienteNombre;
        this.fecha = fecha;
        this.total = total;
    }

    public reporteModel(int ventaId, String productoNombre, int detalleVentaCantidad, double precioUnitario) {
        this.ventaId = ventaId;
        this.productoNombre = productoNombre;
        this.detalleVentaCantidad = detalleVentaCantidad;
        this.precioUnitario = precioUnitario;
    }

    public reporteModel() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public int getDetalleVentaCantidad() {
        return detalleVentaCantidad;
    }

    public void setDetalleVentaCantidad(int detalleVentaCantidad) {
        this.detalleVentaCantidad = detalleVentaCantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public static List<reporteModel> reporteVentasPorMes() throws SQLException {
        String sql = "SELECT v.fecha, c.nombre AS cliente, p.nombre AS producto, d_v.cantidad, (p.precio * d_v.cantidad) AS total FROM venta v JOIN detalle_venta d_v ON v.id = d_v.venta_id JOIN productos p ON d_v.producto_id = p.id JOIN clientes c ON v.cliente_id = c.id WHERE v.fecha >= CURDATE() - INTERVAL 1 MONTH";
        List<reporteModel> reporte = new ArrayList<>();
        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){
            while (rs.next()){
                reporte.add(new reporteModel(
                        rs.getDate("fecha"),
                        rs.getString("cliente"),
                        rs.getString("producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("total")
                ));
            }
        }
        return reporte;
    }

    public static List<reporteModel> listarVentas() throws SQLException{
        String sql = "SELECT c.nombre AS cliente, fecha, total FROM ventas v JOIN clientes c ON v.cliente_id = c.id";
        List<reporteModel> lista = new ArrayList<>();

        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){
            while (rs.next()){
                lista.add(new reporteModel(
                        rs.getString("nombre"),
                        rs.getDate("fecha"),
                        rs.getDouble("total")
                ));
            }
        }
        return lista;
    }

    public static List<reporteModel> listarDetalleventa() throws SQLException{
        String sql = "SELECT venta_id AS venta, p.nombre AS producto, cantidad, precio_unitario FROM detalle_venta d_v JOIN productos p ON d_v.producto_id = p.id";
        List<reporteModel> lista = new ArrayList<>();

        try(
                Connection con = JDBCUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while (rs.next()){
                lista.add(new reporteModel(
                        rs.getInt("venta_id"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario")
                ));
            }
        }
        return lista;
    }


    }
