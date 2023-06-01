package Proyecto_Java_DesdeCero;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton bt1, bt2;
    private JScrollPane scroll;
    private JTextArea txtarea;

    /**
     * 
     */
    public Licencia() {
        setLayout(null);
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        label1 = new JLabel("Términos y condiciones");
        label1.setBounds(215, 5, 200, 30);
        label1.setFont(new Font("Andale Mono", 1, 16));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        txtarea = new JTextArea();
        txtarea.setEditable(false);
        txtarea.setFont(new Font("Andale Mono", 0, 9));
        txtarea.setText("Términos y condiciones:\n\n" +
                "    \"1. Introducción\n\n" +
                "    \"Estos términos y condiciones rigen el uso del sitio web y aplicaciones móviles de nuestra empresa. Al acceder a nuestro sitio web o usar nuestras aplicaciones móviles, acepta estos términos y condiciones en su totalidad.\n\n" +
                "    \n" +
                "    \"2. Uso del sitio web y aplicaciones móviles\n\n" +
                "    \"El uso de nuestro sitio web y aplicaciones móviles está sujeto a las leyes y regulaciones aplicables, así como a estos términos y condiciones. No se permite el uso del sitio web y aplicaciones móviles para fines ilegales o no autorizados.\n\n" +
                "    \n" +
                "    \"3. Propiedad intelectual\n\n" +
                "    \"Todo el contenido de nuestro sitio web y aplicaciones móviles, incluidos, entre otros, los textos, gráficos, imágenes, diseños y software, es propiedad de nuestra empresa o de nuestros licenciantes y está protegido por las leyes de propiedad intelectual.\n\n" +
                "    \n" +
                "    \"4. Privacidad y protección de datos\n\n" +
                "    \"Nos tomamos muy en serio la privacidad de nuestros usuarios y cumplimos con las leyes y regulaciones aplicables en materia de protección de datos. Consulte nuestra política de privacidad para obtener más información sobre cómo recopilamos, utilizamos y protegemos sus datos personales.\n\n" +
                "    \n" +
                "    \"5. Exclusión de responsabilidad\n\n" +
                "    \"No seremos responsables de ningún daño directo, indirecto, incidental, especial o consecuente que surja del uso o la imposibilidad de usar nuestro sitio web o aplicaciones móviles, incluidos, entre otros, los daños por pérdida de beneficios, interrupción del negocio, pérdida de programas o información.\n\n" +
                "    \n" +
                "    \"6. Modificaciones de los términos y condiciones\n\n" +
                "    \"Nos reservamos el derecho de modificar estos términos y condiciones en cualquier momento y sin previo aviso. Por lo tanto, le recomendamos que revise estos términos y condiciones regularmente para asegurarse de estar al tanto de las actualizaciones.\n\n" +
                "    \n" +
                "    \"7. Ley aplicable y jurisdicción\n\n" +
                "    \"Estos términos y condiciones se regirán e interpretarán de acuerdo con las leyes de [inserte el nombre del país o estado], y cualquier disputa relacionada con estos términos y condiciones estará sujeta a la jurisdicción exclusiva de los tribunales de [inserte el nombre del país o estado].\n\n" +
                "\n");
        scroll = new JScrollPane(txtarea);
        scroll.setBounds(10, 40, 575, 200);
        add(scroll);

        check1 = new JCheckBox("Yo acepto");
        check1.setBounds(10, 260, 300, 30);
        check1.addChangeListener(this);
        add(check1);

        bt1 = new JButton("Continuar");
        bt1.setBounds(10, 300, 100, 30);
        bt1.addActionListener(this);
        bt1.setEnabled(false);
        add(bt1);

        bt2 = new JButton("No acepto");
        bt2.setBounds(120, 300, 100, 30);
        bt2.addActionListener(this);
        bt2.setEnabled(true);
        add(bt2);

        ImageIcon image = new ImageIcon("images/coca-cola.png");
        label2 = new JLabel(image);
        label2.setBounds(315, 135, 300, 300);
        add(label2);
    }

    public void actionPerformed(ActionEvent evento) {

    }

    public void stateChanged(ChangeEvent eventi) {

    }

    public static void main(String args[]) {
        Licencia output = new Licencia();

        output.setBounds(0, 0, 650, 450);
        output.setVisible(true);
        output.setResizable(false);
        output.setLocationRelativeTo(null);
    }
}