package org.example.controlador;

import org.example.modelo.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class ventaControlador {

    public void iniciarVenta(int cliente, Date fechaSQl) throws SQLException {
        ventaModel.iniciarVenta(cliente, fechaSQl);
    }

    public void agregarProductoAVenta( int stock,int productoId, int cantidad) throws SQLException{
        ventaModel.agregarProductoALaVenta(stock, cantidad, productoId);
    }

    public BigDecimal calcularTotal() throws SQLException{

    }

    public void finalizarVenta() throws SQLException{

    }

    private void actualizarStock(productoModel producto, int cantidadVendida) throws SQLException{

    }

}
