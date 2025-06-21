package org.example.vista;

import org.example.controlador.clienteControlador;
import org.example.modelo.clienteModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

    private clienteModel clienteModel = new clienteModel();
    private clienteControlador clienteControlador = new clienteControlador();

    public clienteVista(){
        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
        agregarClientePanel.setVisible(false);
        editarClientePanel.setVisible(false);
        eliminarClientePanel.setVisible(false);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuVista menuVista = new menuVista();
                menuVista.setVisible(true);
                dispose();
            }
        });
        actualizarListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("id");
                    modelo.addColumn("nombre");
                    modelo.addColumn("correo");

                    if(clienteControlador.listarCliente() != null){
                        for(clienteModel fila : clienteControlador.listarCliente()){
                            modelo.addRow(new Object[] {
                                    fila.getId(),
                                    fila.getUsername(),
                                    fila.getCorreo()
                            });
                        }
                    }
                    clientesTable.setModel(modelo);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            });

        menuAgregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarClientePanel.setVisible(true);
                editarClientePanel.setVisible(false);
                eliminarClientePanel.setVisible(false);
            }
        });


        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clienteModel = new clienteModel();
                clienteModel.setUsername(nombreAgreTextField.getText());
                clienteModel.setCorreo(correoAgreTextField.getText());
                    clienteControlador.agregarCliente(clienteModel.getUsername(), clienteModel.getCorreo());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String [] args){
        clienteVista dialog = new clienteVista();
        dialog.setVisible(true);
    }

    }
