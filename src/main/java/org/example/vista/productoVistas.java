package org.example.vista;

import javax.swing.*;

public class productoVistas extends JDialog{
    private JTable productosTable;
    private JButton actualizarListaButton;
    private JButton menuAgregarProductoButton;
    private JButton menuEditarProductoButton;
    private JButton menuEliminarProductoButton;
    private JTextField nombreAgreTextField;
    private JPanel agregarProductoPanel;
    private JTextField precioAgreTextField;
    private JTextField existenciaAgreTextField;
    private JButton agregarProductoButton;
    private JPanel panel1;
    private JPanel editarProductoPanel;
    private JTextField nombreEditTextField;
    private JTextField precioEditTextField;
    private JTextField existenciaEditTextField;
    private JButton actualizarProductoButton;
    private JTextField idEditTextField;
    private JButton volverButton;
    private JTextField idElimTextField;
    private JButton eliminarProductoButton;
    private JPanel eliminarProductoPanel;

    public productoVistas(){
        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
        agregarProductoPanel.setVisible(false);
        editarProductoPanel.setVisible(false);
        eliminarProductoPanel.setVisible(false);
    }

    public static void main(String [] args){
        productoVistas dialog = new productoVistas();
        dialog.setVisible(true);
    }
}
