package org.example.vista;

import javax.swing.*;

public class reporteVista extends JDialog{
    private JTable reporteTable;
    private JButton reporteDelUltimoMesButton;
    private JPanel panel1;
    private JButton volverButton;

    public reporteVista(){
        setContentPane(panel1);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String [] args){
        reporteVista dialog = new reporteVista();
        dialog.setVisible(true);
    }
}
