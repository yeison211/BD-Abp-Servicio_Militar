package Servicio.Militar.Principal.ventanas;

import Servicio.Militar.Principal.crud.SoldadosJpaController;
import Servicio.Militar.Principal.tabla.Soldados;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Soldado extends javax.swing.JFrame {

    EntityManagerFactory conexion = Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
    SoldadosJpaController Soldado = new SoldadosJpaController(conexion);
    DefaultTableModel Table = new DefaultTableModel();
    Soldados S = new Soldados();

    public Soldado() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        actualizarTabla();
        

        EntityManagerFactory conexion = Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        SoldadosJpaController tablaSoldado = new SoldadosJpaController(conexion);
        List<Soldados> listasoldado = tablaSoldado.findSoldadosEntities();

        Table = new DefaultTableModel();
        String Titulo[] = {"Id", "Nombre", "Apellido", "Rango", "Cedula"};
        Table.setColumnIdentifiers(Titulo);

        for (Soldados s : listasoldado) {
            Vector Fila = new Vector();
            Fila.addElement(s.getIdSoldados());
            Fila.addElement(s.getNombre());
            Fila.addElement(s.getApellido());
            Fila.addElement(s.getRango());
            Fila.addElement(s.getCedula());
            Table.addRow(Fila);
        }
        Tabla.setModel(Table);
    }

    public List<Soldados> conectar(){
        //se realiza la conexion ala base de datos
        EntityManagerFactory conexion = Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        //creamos una  instancia de la clase controller
        SoldadosJpaController tablasoldado = new SoldadosJpaController(conexion);
        //creamos una lista de soldados
        List<Soldados> listasoldado = tablasoldado.findSoldadosEntities();
       
        return listasoldado;
    } 
    public void actualizarTabla() {
        List<Soldados> listasoldado = conectar(); 
        
        
        Table = new DefaultTableModel();
        String Titulo[] = {"Id", "Nombre", "Apellido", "Rango", "Cedula"};
        Table.setColumnIdentifiers(Titulo);
  
         
        for (Soldados s : listasoldado) {
            Vector Fila = new Vector();
            Fila.addElement(s.getIdSoldados());
            Fila.addElement(s.getNombre());
            Fila.addElement(s.getApellido());
            Fila.addElement(s.getRango());
            Fila.addElement(s.getCedula());
            Table.addRow(Fila);
        }
        Tabla.setModel(Table);
    }

    public void cargar() {

        S.setIdSoldados(this.txtId.getText());
        S.setNombre(this.txtNombre.getText());
        S.setApellido(this.txtApellido.getSelectedText());
        S.setRango(this.comboRango.getSelectedItem().toString());
        S.setCedula(this.txtcedula.getText());

    }

    public void eliminar() {
        List<Soldados> listasoldado = conectar();
        if(listasoldado == null || listasoldado.isEmpty()){
            JOptionPane.showMessageDialog(this, "La Lista está vacia", "Aviso",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el soldado seleccionado?",
        "Aviso", JOptionPane.YES_NO_OPTION);
        
        
        if (opcion != 0) {
            return;
           
        }
            
        // eliminamos los soldados con el metodo destroy
        try {
            Soldado.destroy(txtId.getText());
            JOptionPane.showMessageDialog(this, "Soldado eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El Soldado no se pudo eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }

            actualizarTabla();
            limpiar();
    }

    public void limpiar() {
        //limpiamos los campos 
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        comboRango.setSelectedIndex(0);
        txtcedula.setText("");
    }

    private Boolean vacio() {
        boolean vacio = false;

        if (txtId.getText().isEmpty()) {
            txtId.setBackground(new java.awt.Color(255, 0, 0));
            vacio = true;

        }

        if (txtNombre.getText().isEmpty()) {
            txtNombre.setBackground(new java.awt.Color(255, 0, 0));
            vacio = true;
        }

        if (txtApellido.getText().isEmpty()) {
            txtApellido.setBackground(new java.awt.Color(255, 0, 0));
            vacio = true;
        }

        if (txtcedula.getText().isEmpty()) {
            txtcedula.setBackground(Color.red);
            vacio = true;
        }

        return vacio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        comboRango = new javax.swing.JComboBox<>();
        txtcedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Rango", "Cedula"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/agregar-archivo.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(btnEditar.getBorder());
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 204));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/documentos.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 204));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/error.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdMouseClicked(evt);
            }
        });

        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });

        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMouseClicked(evt);
            }
        });

        comboRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Un...", "Sub Oficial", "Cadete", "Teniente", "Coronel", "Cabo" }));

        txtcedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcedulaMouseClicked(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido: ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Rango: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cedula");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Control De Soldados");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 204));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboRango, 0, 1, Short.MAX_VALUE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellido))))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        boolean vacio = vacio();
        if (vacio) {
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (comboRango.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un Rango", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // se obtienen los datos de los campos
        String ID = txtId.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String rango = comboRango.getSelectedItem().toString();
        String cedula = txtcedula.getText();

        // se realiza la conversion
        // creamos la conexion con la base de datos
        EntityManagerFactory conexion = Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");

        // instanciamos un objeto tipo usuario
        Soldados S = new Soldados();

        //al usuario le innsertamos los datos ingresados en el formulario 
        S.setIdSoldados(ID);
        S.setNombre(nombre);
        S.setApellido(apellido);
        S.setRango(rango);
        S.setCedula(cedula);

        //creamos una instancia de la clase contoller 
        SoldadosJpaController tablaSoldado = new SoldadosJpaController(conexion);

        try {
            // insertamos usuario 
            tablaSoldado.create(S);
            //obtenemos el total de usuario que se encuentrea en la base de datos
            int total = tablaSoldado.getSoldadosCount();

            JOptionPane.showMessageDialog(this, "Soldado Guardado Exitosamente " + "\nTotal Guardados: " + total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Soldado No  Guardado  ");
        }
        actualizarTabla();
        limpiar();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        List<Soldados> listasoldado = conectar();
        if(listasoldado == null || listasoldado.isEmpty()){
            JOptionPane.showMessageDialog(this, "La Lista está vacia", "Aviso",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int opc = JOptionPane.showConfirmDialog(this, "¿Seguro que desea editar los datos del soldado seleccionado?",
                "Mensaje", JOptionPane.YES_NO_OPTION);

        if (opc == 0) {
            // se obtienen los datos de los campos
            String Id = txtId.getText();
            String Nombre = txtNombre.getText();
            String Apellido = txtApellido.getText();
            String Rango = comboRango.getSelectedItem().toString();
            String Cedula = txtcedula.getText();
            // se realiza la conversion

            // Integer cc=Integer.parseInt(cedula);
            // creamos la conexion con la base de datos
            EntityManagerFactory conexion = Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
            //creamos una instancia de la clase contoller 
            SoldadosJpaController tablaSoldados = new SoldadosJpaController(conexion);
           
            try {//al usuario le innsertamos los datos ingresados en el formulario 
                S.setIdSoldados(Id);
                S.setNombre(Nombre);
                S.setApellido(Apellido);
                S.setRango(Rango);
                S.setCedula(Cedula);

                tablaSoldados.edit(S);
                JOptionPane.showMessageDialog(this, "El Soldado con ID: " + S.getIdSoldados() + ", Fue editado Exitosamente");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "El Soldado con ID: " + S.getIdSoldados() + ", No se púdo editar");
            }
            //al usuario le innsertamos los datos ingresados en el formulario 
            actualizarTabla();
            limpiar();
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        List<Soldados> listasoldado = conectar();
        eliminar();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        this.txtId.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 0).toString());
        this.txtNombre.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 1).toString());
        this.txtApellido.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 2).toString());
        this.comboRango.setSelectedItem(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 3).toString());
        this.txtcedula.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_TablaMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        if (Character.isLetter(caracter)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMouseClicked
        txtId.setBackground(Color.white);
    }//GEN-LAST:event_txtIdMouseClicked

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        txtNombre.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMouseClicked
        txtApellido.setBackground(Color.white);
    }//GEN-LAST:event_txtApellidoMouseClicked

    private void txtcedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcedulaMouseClicked
        txtcedula.setBackground(Color.white);
    }//GEN-LAST:event_txtcedulaMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Soldado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soldado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soldado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soldado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soldado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboRango;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
