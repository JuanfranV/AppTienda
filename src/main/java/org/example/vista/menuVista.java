package org.example.vista;

import javax.swing.*;

public class menuVista extends JDialog{
    private JPanel panel1;
    private JButton productosButton;
    private JButton ventasButton;
    private JButton reportesButton;

    public menuVista(){
        setContentPane(panel1);
        setSize(600, 300);
        setLocationRelativeTo(null);

    }

    public static void main(String [] args){
        menuVista dialog = new menuVista();
        dialog.setVisible(true);
    }
}
