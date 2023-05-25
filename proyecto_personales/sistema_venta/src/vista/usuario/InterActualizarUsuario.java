package vista.usuario;

import controlador.usuario.Ctrl_Usuario_Actualizar;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO_ImpActualizar;
import modelo.usuario.UsuarioDAO_Actualizar;

/**
 *
 * @author Guicho
 */
public class InterActualizarUsuario extends javax.swing.JInternalFrame {

    private int idUsuario = 0;
    private final UsuarioDAO_Actualizar usuarioDAO = new UsuarioDAO_ImpActualizar();

    public InterActualizarUsuario() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar usuarios");
        //Cargar tabla
        this.CargarTablaUsuarios();

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(195, 139, 11));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(69, 95, 95));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(89, 42, 67));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Usuario:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 90, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        //UsuarioDAO_Actualizar usuarioDAO_Actualizar = new UsuarioDAO_ImpActualizar();
        
        Usuario usuario = new Usuario();
        //Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();
        Ctrl_Usuario_Actualizar ctrl_Usuario_Actualizar = new Ctrl_Usuario_Actualizar(usuarioDAO);

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_usuario.getText().isEmpty() || txt_password.getText().isEmpty() || txt_telefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            } else {
                
               // this.obtenerDatosUsuario();
              usuario.setNombre(txt_nombre.getText().trim());
                usuario.setApellido(txt_apellido.getText().trim());
                usuario.setUsuario(txt_usuario.getText().trim());
                usuario.setPassword(txt_password.getText().trim());
                usuario.setTelefono(txt_telefono.getText().trim());
                usuario.setEstado(1);

                if (ctrl_Usuario_Actualizar.actualizar(usuario, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                    this.Limpiar();
                    this.CargarTablaUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar usuario");
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_usuario;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    //Método para limpiar campos
    private void Limpiar() {
        txt_nombre.setText("");
        txt_password.setText("");
        txt_apellido.setText("");
        txt_telefono.setText("");
        txt_usuario.setText("");
    }

    //Método para mostrar todos los usuario registrados
    /*
    private void CargarTablaUsuarios() {
        Connection con = Conexion.Conexion();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_usuarios";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterVisualizarUsuario.jTable_usuario = new JTable(model);
            InterVisualizarUsuario.jScrollPane1.setViewportView(InterVisualizarUsuario.jTable_usuario);

            model.addColumn("N°");//ID
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("usuario");
            model.addColumn("password");
            model.addColumn("telefono");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {

                    fila[i] = rs.getObject(i + 1);

                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        
             jTable_usuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuario.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);//metodo
                }
            }
        });
    }*/
//Método para cargar y mostrar todos los usuarios registrados en una tabla
    /*
        Connection con = Conexion.Conexion();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT * FROM tb_usuarios";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterVisualizarUsuario.jTable_usuario = new JTable(model);
            InterVisualizarUsuario.jScrollPane1.setViewportView(InterVisualizarUsuario.jTable_usuario);

            model.addColumn("N°");//ID
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("usuario");
            model.addColumn("password");
            model.addColumn("telefono");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }

        //Agregar evento de MouseListener a la tabla de usuarios
        AgregarEventoMouseListener(jTable_usuario, model);
    }
     */
    private void CargarTablaUsuarios() {
        DefaultTableModel model = new DefaultTableModel();
        InterActualizarUsuario.jTable_usuario.setModel(model);
        InterActualizarUsuario.jScrollPane1.setViewportView(InterActualizarUsuario.jTable_usuario);

        model.addColumn("N°");//ID
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("usuario");
        model.addColumn("password");
        model.addColumn("telefono");
        model.addColumn("estado");

        Ctrl_Usuario_Actualizar ctrl_Usuario_Actualizar = new Ctrl_Usuario_Actualizar(usuarioDAO);
        List<Usuario> usuarios = ctrl_Usuario_Actualizar.obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            Object fila[] = new Object[7];
            fila[0] = usuario.getIdUsuario();
            fila[1] = usuario.getNombre();
            fila[2] = usuario.getApellido();
            fila[3] = usuario.getUsuario();
            fila[4] = usuario.getPassword();
            fila[5] = usuario.getTelefono();
            fila[6] = usuario.getEstado();
            model.addRow(fila);
        }

        //Agregar evento de MouseListener a la tabla de usuarios
        AgregarEventoMouseListener(InterActualizarUsuario.jTable_usuario, model);
    }

//Método para agregar el evento de MouseListener a la tabla de usuarios
    private void AgregarEventoMouseListener(JTable tabla, DefaultTableModel model) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);
                }
            }
        });
    }

    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
 /*
    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {
        try {
            try ( Connection con = Conexion.Conexion()) {
                PreparedStatement pst = con.prepareStatement(
                        "select * from tb_usuarios where idUsuario = '" + idUsuario + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    txt_nombre.setText(rs.getString("nombre"));
                    txt_apellido.setText(rs.getString("apellido"));
                    txt_usuario.setText(rs.getString("usuario"));
                    txt_password.setText(rs.getString("password"));
                    txt_telefono.setText(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario: " + e);
        }
    }*/
    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {
        Ctrl_Usuario_Actualizar ctrl_Usuario_Actualizar = new Ctrl_Usuario_Actualizar(usuarioDAO);
        Usuario usuario = ctrl_Usuario_Actualizar.obtenerDatosUsuario(idUsuario);
        if (usuario != null) {
            txt_nombre.setText(usuario.getNombre());
            txt_apellido.setText(usuario.getApellido());
            txt_usuario.setText(usuario.getUsuario());
            txt_password.setText(usuario.getPassword());
            txt_telefono.setText(usuario.getTelefono());
        }
    }

    /*public Usuario obtenerDatosUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(txt_nombre.getText().trim());
        usuario.setApellido(txt_apellido.getText().trim());
        usuario.setUsuario(txt_usuario.getText().trim());
        usuario.setPassword(txt_password.getText().trim());
        usuario.setTelefono(txt_telefono.getText().trim());
        usuario.setEstado(1);
        return usuario;
    }*/

}
