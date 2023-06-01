package Proyecto_Java_DesdeCero;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener {

    private JTextField textf1;
    private JLabel label1, label2, label3, label4;
    private JButton boton1;
    public static String Nombre = "";

    public Bienvenida() {
        setLayout(null);
        setTitle("bienvenido");
        getContentPane().setBackground(new Color(255, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        ImageIcon imagen = new ImageIcon("images/logo-coca.png");
        label1 = new JLabel(imagen);
        label1.setBounds(25, 15, 300, 150);
        add(label1);

        label2 = new JLabel("Sistema de control vacacional");
        label2.setBounds(35, 135, 300, 30);
        label2.setFont(new Font("Andale Mono", 3, 20));
        label2.setForeground(new Color(255, 255, 255));
        add(label2);

        label3 = new JLabel("Ingrese su nombre");
        label3.setBounds(45, 150, 150, 30);
        label3.setFont(new Font("Andalo Mono", 1, 14));
        label3.setForeground(new Color(255, 255, 255));
        add(label3);

        label4 = new JLabel("©2017 The Coca-Cola Company");
        label4.setBounds(85, 375, 300, 30);
        label4.setFont(new Font("Andalo Mono", 1, 14));
        label4.setForeground(new Color(255, 255, 255));
        add(label4);

        textf1 = new JTextField();
        textf1.setBounds(45, 240, 255, 25);
        textf1.setBackground(new Color(254, 254, 254));
        textf1.setFont(new Font("Andalo Mono", 1, 14));
        textf1.setForeground(new Color(255, 0, 0));
        add(textf1);

        boton1 = new JButton("Ingresar");
        boton1.setBounds(125, 280, 100, 30);
        boton1.setBackground(new Color(255, 255, 255));
        boton1.setFont(new Font("Andales Mono", 1, 14));
        boton1.setForeground(new Color(255, 0, 0));
        boton1.addActionListener(this);
        add(boton1);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == boton1) {
            Nombre = textf1.getText().trim();
                if(Nombre.equals("")) {
                    JOptionPane.showMessageDialog(null,"Ingrese un nombre");
                }   else {
                    Licencia output = new Licencia();
                    output.setBounds(0, 0, 610, 390);
                    output.setVisible(true);
                    output.setResizable(false);
                    output.setLocationRelativeTo(null);
                    this.setVisible(false);
                }
        }
    }

    public static void main(String args[]) {
        Bienvenida output = new Bienvenida();
        output.setBounds(0, 0, 370, 450);
        output.setVisible(true);
        output.setResizable(false);
        output.setLocationRelativeTo(null);
    }
}