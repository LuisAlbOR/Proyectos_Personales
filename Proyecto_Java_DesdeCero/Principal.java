package Proyecto_Java_DesdeCero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener {
    private JMenuBar MenuBar;
    private JMenu MenuOpciones, MenuCalcular, MenuAcercaDe, MenuFondo;
    private JMenuItem MitemCalculo, MitemRojo, MitemNegro, MitemMorado,MitemElCreador,MitemSalir, MitemNuevo;
    private JLabel LabelLogo, LabelBienvenido, LabelTitle, LabelNombre, LabelAPaterno, LabelAMaterno,
                    LabelDepartamento, LabelAntiguedad, LabelResultado, LabelFooter;
    private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
    private JComboBox comboDepartamento, comboAntiguedad;
    private JScrollPane ScrollPanel;
    private JTextArea TextArea;

    public Principal() {
        setLayout(null);
        setTitle("Pantalla principal");
        getContentPane().setBackground(new Color(255, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        MenuBar = new JMenuBar();
        MenuBar.setBackground(new Color(255, 0, 0));
        setJMenuBar(MenuBar);

        MenuOpciones = new JMenu("Opciones");
        MenuOpciones.setBackground(new Color(255, 0, 0));
        MenuOpciones.setFont(new Font("Andale Mono", 1, 14));
        MenuOpciones.setForeground(new Color(255, 255, 255));
        MenuBar.add(MenuOpciones);

        MitemNuevo = new JMenuItem("Nuevo");
        MitemNuevo.setBackground(new Color(255,0,0));
        MitemNuevo.setFont(new Font("Andale Mono", 1, 14));
        MitemNuevo.setForeground(new Color(255,255,255));
        MenuOpciones.add(MitemNuevo);
        MitemNuevo.addActionListener(this);

        MitemSalir = new JMenuItem("Salir");
        MitemSalir.setBackground(new Color(255,0,0));
        MitemSalir.setFont(new Font("Andale Mono", 1, 14));
        MitemSalir.setForeground(new Color(255,255,255));
        MenuOpciones.add(MitemSalir);
        MitemSalir.addActionListener(this);

        MenuCalcular = new JMenu("Calcular");
        MenuCalcular.setBackground(new Color(255, 0, 0));
        MenuCalcular.setFont(new Font("Andale Mono", 1, 14));
        MenuCalcular.setForeground(new Color(255, 255, 255));
        MenuBar.add(MenuCalcular);

        MitemCalculo = new JMenuItem("Vacaciones");
        MitemCalculo.setBackground(new Color(255,0,0));
        MitemCalculo.setFont(new Font("Andale Mono", 1, 14));
        MitemCalculo.setForeground(new Color(255,255,255));
        MenuCalcular.add(MitemCalculo);
        MitemCalculo.addActionListener(this);

        MenuAcercaDe = new JMenu("Acerca de");
        MenuAcercaDe.setBackground(new Color(255,0,0));
        MenuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
        MenuAcercaDe.setForeground(new Color(255,255,255));
        MenuBar.add(MenuAcercaDe);

        MitemElCreador = new JMenuItem("El creador");
        MitemElCreador.setBackground(new Color(255,0,0));
        MitemElCreador.setFont(new Font("Andale Mono", 1, 14));
        MitemElCreador.setForeground(new Color(255,255,255));
        MenuAcercaDe.add(MitemElCreador);
        MitemElCreador.addActionListener(this);

        MenuFondo = new JMenu("Color de fondo");
        MenuFondo.setBackground(new Color(255,0,0));
        MenuFondo.setFont(new Font("Andale Mono", 1, 14));
        MenuFondo.setForeground(new Color(0, 0, 0));
        MenuOpciones.add(MenuFondo);
        MenuFondo.addActionListener(this);

        MitemRojo = new JMenuItem("Rojo");
        MitemRojo.setBackground(new Color(255,0,0));
        MitemRojo.setFont(new Font("Andale Mono", 1, 14));
        MitemRojo.setForeground(new Color(255,255,255));
        MenuFondo.add(MitemRojo);
        MitemRojo.addActionListener(this);

        MitemNegro = new JMenuItem("Negro");
        MitemNegro.setBackground(new Color(255,0,0));
        MitemNegro.setFont(new Font("Andale Mono", 1, 14));
        MitemNegro.setForeground(new Color(255,255,255));
        MenuFondo.add(MitemNegro);
        MitemNegro.addActionListener(this);

        MitemMorado = new JMenuItem("Morado");
        MitemMorado.setBackground(new Color(255,0,0));
        MitemMorado.setFont(new Font("Andale Mono", 1, 14));
        MitemMorado.setForeground(new Color(255,255,255));
        MenuFondo.add(MitemMorado);
        MitemMorado.addActionListener(this);

        ImageIcon imagen = new ImageIcon("images/logo-coca.png");
        LabelLogo = new JLabel(imagen);
        LabelLogo.setBounds(5,5,250,100);
        add(LabelLogo);

        LabelBienvenido = new JLabel("Bienvenido");
        LabelTitle = new JLabel("Datos del trabajador para el cálculo de vacaciones");
        LabelTitle.setBounds(45,140,900,25);
        LabelTitle.setFont(new Font("Andale Mono",0,24));
        LabelTitle.setForeground(new Color(255,255,255));
        add(LabelTitle);

        LabelNombre = new JLabel("Nombre completo");
        LabelNombre.setBounds(25,188,180,25);
        LabelNombre.setFont(new Font("Andale Mono",1,12));
        LabelNombre.setForeground(new Color(255,255,255));
        add(LabelNombre);

        txtNombreTrabajador = new JTextField();
        txtNombreTrabajador.setBounds(25,213,150,25);
        txtNombreTrabajador.setBackground(new Color(224,224,244));
        txtNombreTrabajador.setFont(new Font("Andale Mono",1,14));
        txtNombreTrabajador.setForeground(new Color(255,0,0));
        add(txtNombreTrabajador);

        LabelAPaterno = new JLabel("Apellido paterno");
        LabelAPaterno.setBounds(25,248,180,25);
        LabelAPaterno.setFont(new Font("Andale Mono",1,12));
        LabelAPaterno.setForeground(new Color(255,255,255));
        add(LabelAPaterno);

        txtAPaternoTrabajador = new JTextField();
        txtAPaternoTrabajador.setBounds(25,273,150,25);
        txtAPaternoTrabajador.setBackground(new Color(224,224,244));
        txtAPaternoTrabajador.setFont(new Font("Andale Mono",1,14));
        txtAPaternoTrabajador.setForeground(new Color(255,0,0));
        add(txtAPaternoTrabajador);

        LabelAMaterno = new JLabel("Apellido materno");
        LabelAMaterno.setBounds(25,298,180,25);
        LabelAMaterno.setFont(new Font("Andale Mono",1,12));
        LabelAMaterno.setForeground(new Color(255,255,255));
        add(LabelAMaterno);

        txtAMaternoTrabajador = new JTextField();
        txtAMaternoTrabajador.setBounds(25,334,150,25);
        txtAMaternoTrabajador.setBackground(new Color(224,224,244));
        txtAMaternoTrabajador.setFont(new Font("Andale Mono",1,14));
        txtAMaternoTrabajador.setForeground(new Color(255,0,0));
        add(txtAMaternoTrabajador);

        LabelDepartamento = new JLabel("Selecciona el departamento");
        LabelDepartamento.setBounds(220,188,180,25);
        LabelDepartamento.setFont(new Font("Andale Mono",1,12));
        LabelDepartamento.setForeground(new Color(255,255,255));
        add(LabelDepartamento);

        comboDepartamento = new JComboBox();
        comboDepartamento.setBounds(220,213,220,25);
        comboDepartamento.setBackground(new Color(224,224,244));
        comboDepartamento.setFont(new Font("Andale Mono",1,14));
        comboDepartamento.setForeground(new Color(255,0,0));
        add(comboDepartamento);
        comboDepartamento.addItem("Atención al cliente");
        comboDepartamento.addItem("Departamento de logística");
        comboDepartamento.addItem("Departamento de gerencia");

        LabelAntiguedad = new JLabel("Selecciona la antiguedad");
        LabelAntiguedad.setBounds(220,248,180,25);
        LabelAntiguedad.setFont(new Font("Andale Mono",1,12));
        LabelAntiguedad.setForeground(new Color(255,255,255));
        add(LabelAntiguedad);

        comboAntiguedad = new JComboBox();
        comboAntiguedad.setBounds(220,273,220,25);
        comboAntiguedad.setBackground(new Color(224,224,244));
        comboAntiguedad.setFont(new Font("Andale Mono",1,14));
        comboAntiguedad.setForeground(new Color(255,0,0));
        add(comboAntiguedad);
        comboAntiguedad.addItem("Un año de servicio");
        comboAntiguedad.addItem("Dos a seis años de servicio");
        comboAntiguedad.addItem("siete o más años de servicio");

        LabelResultado = new JLabel("Selecciona la antiguedad");
        LabelResultado.setBounds(220,307,180,25);
        LabelResultado.setFont(new Font("Andale Mono",1,12));
        LabelResultado.setForeground(new Color(255,255,255));
        add(LabelResultado);

        TextArea = new JTextArea();
        TextArea.setEditable(false);
        TextArea.setBackground(new Color(224,224,244));
        TextArea.setFont(new Font("Andale Mono",1,11));
        TextArea.setForeground(new Color(255,0,0));
        TextArea.setText("\n Aquí aparece el resultado del cálculo de las vacaciones.");
        ScrollPanel = new JScrollPane(TextArea);
        ScrollPanel.setBounds(220,333,385,90);
        add(ScrollPanel);

        LabelFooter = new JLabel("©2017 The Coca-Cola Company | Todos los derechos reservados");
        LabelFooter.setBounds(135,445,500,30);
        LabelFooter.setFont(new Font("Andale Mono",1,12));
        LabelFooter.setForeground(new Color(255,255,255));
        add(LabelFooter);
    }

    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == MitemCalculo){

        }
        if (evento.getSource() == MitemRojo){

        }
        if(evento.getSource() == MitemNegro){

        }
        if(evento.getSource() == MitemMorado){

        }
        if(evento.getSource() == MitemNuevo){

        }
        if(evento.getSource() == MitemSalir){

        }
        if(evento.getSource() == MitemElCreador){

        }
    }

    public static void main(String args[]){
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0,0,640,535);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}
