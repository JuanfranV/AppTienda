package org.example.vista;

import javax.swing.*;

public class clienteVista extends JDialog{
    private JButton actualizarListaButton;
    private JButton menuAgregarClienteButton;
    private JButton menuEditarClienteButton;
    private JButton menuEliminarClienteButton;
    private JPanel agregarClientePanel;
    private JTextField nombreAgreTextField;
    private JTextField correoAgreTextField;
    private JButton agregarClienteButton;
    private JPanel editarClientePanel;
    private JTextField nombreEditTextField;
    private JTextField correoEditTextField;
    private JButton actualizarClienteButton;
    private JTextField idEditTextField;
    private JPanel eliminarClientePanel;
    private JTextField idElimTextField;
    private JButton eliminarClienteButton;
    private JButton volverButton;
    private JTable clientesTable;
    private JPanel panel1;

    public clienteVista(){
        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
        agregarClientePanel.setVisible(false);
        editarClientePanel.setVisible(false);
        eliminarClientePanel.setVisible(false);

    }

    public static void main(String [] args){
        clienteVista dialog = new clienteVista();
        dialog.setVisible(true);
    }

    }
