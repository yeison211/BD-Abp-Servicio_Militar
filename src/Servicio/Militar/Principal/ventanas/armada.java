
package Servicio.Militar.Principal.ventanas;

import Servicio.Militar.Principal.crud.ArmadaJpaController;
import Servicio.Militar.Principal.crud.SoldadosJpaController;
import Servicio.Militar.Principal.tabla.Soldados;
import Servicio.Militar.Principal.tabla.Armada;
import Servicio.Militar.Principal.tabla.Armada_;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class armada extends javax.swing.JFrame {
    EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
    DefaultTableModel Table = new DefaultTableModel();
    ArmadaJpaController Armada=new ArmadaJpaController(conexion);
    Armada A = new Armada();
   
    public armada() {
        initComponents();
        actualizarTablasoldado();
        this.setLocationRelativeTo(this);
        ActualizarTablaArmada();
        actualizarTablasoldado();
    }
     public void actualizarTablasoldado()
     {
        //se realiza la conexion ala base de datos
        EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        //creamos una  instancia de la clase controller
        SoldadosJpaController tablasoldado= new SoldadosJpaController(conexion);
        //creamos una lista de soldados
        List<Soldados>listasoldado = tablasoldado.findSoldadosEntities();
        if(listasoldado==null || listasoldado.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Lista de Soldado Basia");
//            this.dispose();
        }
        Table =new DefaultTableModel();
        String Titulo[]={"Id","Nombre","Apellido","Rango","Cedula"};
        Table.setColumnIdentifiers(Titulo);

          for (Soldados s : listasoldado) {
              Vector Fila=new Vector();
              Fila.addElement(s.getIdSoldados());
              Fila.addElement(s.getNombre());
              Fila.addElement(s.getApellido());
              Fila.addElement(s.getRango());
              Fila.addElement(s.getCedula());
              Table.addRow(Fila);
          }
          TablaS.setModel(Table);
    }
     public void ActualizarTablaArmada(){
       EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        //creamos una  instancia de la clase controller
        ArmadaJpaController tablasArmada= new ArmadaJpaController(conexion);
        //creamos una lista de soldados
        List<Armada>listaArmada = tablasArmada.findArmadaEntities();
        if(listaArmada==null || listaArmada.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Lista de Armada Basia");
//            this.dispose();
        }
        Table =new DefaultTableModel();
        String Titulo[]={"IdArmada","IdSoldado","Nombre","Apellido","Rango","Cedula"};
        Table.setColumnIdentifiers(Titulo);

          for (Armada A : listaArmada) {
              Vector Fila=new Vector();
              Fila.addElement(A.getIdArmada());
              Fila.addElement(A.getIdSoldado());
              Fila.addElement(A.getNombre());
              Fila.addElement(A.getApellido());
              Fila.addElement(A.getRango());
              Fila.addElement(A.getCedula());
             
              Table.addRow(Fila);
          }
          Tabla.setModel(Table);
     }
     public void limpiar(){
        txtIdArmada.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        comboRango.setSelectedItem(0);
        txtCedula.setText("");
     }
     public void eliminarArmada(){
        // eliminamos los soldados con el metodo destroy
        try {
           Armada.destroy(Integer.parseInt(this.txtIdArmada.getText()));
           JOptionPane.showMessageDialog(this, "soldado eliminado de la tabla armada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"soldado no se epudo eliminar de la tabla armada","error",JOptionPane.WARNING_MESSAGE);
        }
        limpiar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        comboRango = new javax.swing.JComboBox<>();
        txtCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdArmada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnEliminarArmada = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaS = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Soldado:");

        comboRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sub Oficial", "Cadete", "Teniente", "Coronel", "Cabo" }));

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Rango:");

        jLabel5.setText("Cedula");

        jLabel6.setText("ID Armada:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboRango, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre)
                        .addComponent(txtApellido)
                        .addComponent(txtCedula))
                    .addComponent(txtIdArmada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtIdArmada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        jLabel8.setBackground(new java.awt.Color(0, 0, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(" INGRESANDO SOLDADO A UN CUERPO DE EJERCITO ");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)), "TABLA ARMADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla);

        btnEliminarArmada.setText("Eliminar");
        btnEliminarArmada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArmadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(480, Short.MAX_VALUE)
                .addComponent(btnEliminarArmada)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarArmada))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Tabla Soldado "));

        TablaS.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaS);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/armadadecolombia_website_1.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSMouseClicked
        this.txtId.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 0).toString());
        this.txtNombre.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 1).toString());
        this.txtApellido.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 2).toString());
        this.comboRango.setSelectedItem(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 3).toString());
        this.txtCedula.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_TablaSMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        
    String ID=txtId.getText();
    String IDAR=txtIdArmada.getText();
    String nombre=txtNombre.getText();
    String apellido=txtApellido.getText();
    String rango=comboRango.getSelectedItem().toString();
    String cedula=txtCedula.getText();
    
    // se realiza la conversion
    Integer IDA=Integer.parseInt(IDAR);
//    Integer SoldadoID=Integer.parseInt();
    // creamos la conexion con la base de datos
    EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
    
    //cre instanciamos un objeto tipo usuario
     Armada A = new Armada();
        A.setIdArmada(IDA);
        A.setIdSoldado(ID);
        A.setNombre(nombre);
        A.setApellido(apellido);
        A.setRango(rango);
        A.setCedula(cedula);
 
    //creamos una instancia de la clase contoller 
     ArmadaJpaController tablaArmada = new ArmadaJpaController(conexion);
    
        try {
            // insertamos usuario 
           tablaArmada.create(A);
           //obtenemos el total de usuario que se encuentrea en la base de datos
          int total=tablaArmada.getArmadaCount();
          
          JOptionPane.showMessageDialog(this, "soldado Guardado En la Tabla Armada  "+ total);
        } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "soldado No se Pudo Guardar En La Tabla Armada ");
        }
     ActualizarTablaArmada();
     limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarArmadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArmadaActionPerformed
     eliminarArmada();
     ActualizarTablaArmada();
    }//GEN-LAST:event_btnEliminarArmadaActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        this.txtIdArmada.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 0).toString());
        this.txtId.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 1).toString());
        this.txtNombre.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 2).toString());
        this.txtApellido.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 3).toString());
        this.comboRango.setSelectedItem(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 4).toString());
        this.txtCedula.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_TablaMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Armada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Armada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Armada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Armada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new armada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaS;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarArmada;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboRango;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdArmada;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
