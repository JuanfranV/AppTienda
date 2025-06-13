package org.example.vista;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class loginVista extends JDialog{
    private JPanel panel1;
    private JTextField usernameITextField;
    private JTextField contraITextField;
    private JTextField usernameRTextField;
    private JTextField contraRTextField;
    private JButton iniciarSesiónButton;
    private JButton registrarseButton;

    public loginVista(){
        setContentPane(panel1);
        setSize(600, 450);
        setLocationRelativeTo(null);

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
