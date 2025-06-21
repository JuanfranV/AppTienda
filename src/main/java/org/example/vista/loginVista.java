package org.example.vista;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.controlador.loginControlador;
import org.example.modelo.usuarioModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class loginVista extends JDialog{
    private JPanel panel1;
    private JTextField usernameITextField;
    private JTextField contraITextField;
    private JTextField usernameRTextField;
    private JTextField contraRTextField;
    private JButton iniciarSesiónButton;
    private JButton registrarseButton;

    private loginControlador loginControlador = new loginControlador();
    private usuarioModel usuarioModel = new usuarioModel();

    public loginVista(){
        setContentPane(panel1);
        setSize(600, 450);
        setLocationRelativeTo(null);

        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioModel.setUsername(usernameITextField.getText());
                usuarioModel.setContra(contraITextField.getText());
                try {
                    loginControlador.iniciarSesion(usuarioModel.getUsername(), usuarioModel.getContra());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                menuVista menuVista = new menuVista();
                menuVista.setVisible(true);
                dispose();
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioModel.setUsername(usernameRTextField.getText());
                usuarioModel.setContra(contraRTextField.getText());
                try {
                    loginControlador.registrarUsuario(usuarioModel.getUsername(), usuarioModel.getContra());
                } catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                menuVista menuVista = new menuVista();
                menuVista.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String [] args) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            e.printStackTrace();
        }

        loginVista dialog = new loginVista();
        dialog.setVisible(true);

    }

    }
