package org.example.vista;

import javax.swing.*;

public class ventaVista extends JDialog{
    private JTable tableVentas;
    private JButton actualizarVentasButton;
    private JButton actualizarDetallesDeLasButton;
    private JPanel panel1;
    private JButton iniciarVentaButton;
    private JTextField idCllienteTextField;
    private JTable tableClientes;
    private JButton volverButton;
    private JButton clientesButton;
    private JTable tableProductos;
    private JButton productosButton;
    private JPanel panelIniciarVenta;
    private JTable tableDetallesDeLasVentas;
    private JTextField idProductoTextField;
    private JButton agreagarALaVentaButton;
    private JTable tableProductosFinales;
    private JButton totalButton;
    private JTable tableTotal;
    private JButton terminarVentaButton;

    public ventaVista(){
        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
        panelIniciarVenta.setVisible(false);
    }

    public static void main(String [] args){
        ventaVista dialog = new ventaVista();
        dialog.setVisible(true);
    }

}
