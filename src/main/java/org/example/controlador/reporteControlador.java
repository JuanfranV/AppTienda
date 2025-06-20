package org.example.controlador;


import org.example.modelo.detalleVentaModel;
import org.example.modelo.reporteModel;
import java.sql.SQLException;
import java.util.List;

public class reporteControlador {

    public List<reporteModel> generarReporteVentasPorMes() throws SQLException {
        return reporteModel.reporteVentasPorMes();
    }

    public List<reporteModel> listarVenta() throws Exception{
        return reporteModel.listarVentas();
    }

    public List<reporteModel> listarDetalleVenta() throws Exception{
        return reporteModel.listarDetalleventa();
    }

}
