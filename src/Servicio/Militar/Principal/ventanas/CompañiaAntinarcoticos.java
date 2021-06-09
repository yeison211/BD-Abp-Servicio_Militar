
package Servicio.Militar.Principal.ventanas;

import Servicio.Militar.Principal.crud.CompañiaAntinarcoticoJpaController;
import Servicio.Militar.Principal.crud.SoldadosJpaController;
import Servicio.Militar.Principal.tabla.CompañiaAntinarcotico;
import Servicio.Militar.Principal.tabla.Soldados;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CompañiaAntinarcoticos extends javax.swing.JFrame {
    EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
    DefaultTableModel Table = new DefaultTableModel();
    CompañiaAntinarcoticoJpaController CompañiaAntinarcotico =new CompañiaAntinarcoticoJpaController(conexion);
    CompañiaAntinarcotico A = new CompañiaAntinarcotico();
    public CompañiaAntinarcoticos() {
        initComponents();
        this.setLocationRelativeTo(this);
        ActualizarTablaCompañiaAntinarcotico();
        actualizarTablasoldado();
        //CAMBIAR ICONO DE LA VENTANA
        try{
            setIconImage(new ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/IconoPrincipal.png")).getImage());
        }catch(Exception e){
            
        }
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
            JOptionPane.showMessageDialog(this, "Lista de Soldado vacia");
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
    public void ActualizarTablaCompañiaAntinarcotico(){
       EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        //creamos una  instancia de la clase controller
        CompañiaAntinarcoticoJpaController tablasCompañiaAntinarcotico= new CompañiaAntinarcoticoJpaController(conexion);
        //creamos una lista de soldados
        List<CompañiaAntinarcotico>listaCompañiaAntinarcotico = tablasCompañiaAntinarcotico.findCompañiaAntinarcoticoEntities();
        if(listaCompañiaAntinarcotico==null || listaCompañiaAntinarcotico.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Lista de Antinarcoticos vacia");
//            this.dispose();
        }
        Table =new DefaultTableModel();
        String Titulo[]={"IdFudra","IdSoldado","Nombre","Apellido","Rango","Cedula"};
        Table.setColumnIdentifiers(Titulo);

          for (CompañiaAntinarcotico A : listaCompañiaAntinarcotico) {
              Vector Fila=new Vector();
              Fila.addElement(A.getIdCompañoaAntinarcotico());
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
        txtIdAntionarcoticos.setText("");
        txtIdSoldado.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        comboRango.setSelectedItem(0);
        txtCedula.setText("");
     }
     public void eliminarCompañiaAntinarcotico(){
        // eliminamos los soldados con el metodo destroy
        try {
           CompañiaAntinarcotico.destroy(Integer.parseInt(this.txtIdAntionarcoticos.getText()));
           JOptionPane.showMessageDialog(this, "soldado eliminado de la tabla Antinarcoticos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"soldado no se epudo eliminar de la tabla antinarcoticos ","error",JOptionPane.WARNING_MESSAGE);
        }
        limpiar();
     }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaS = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        adsad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        asdsd = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdAntionarcoticos = new javax.swing.JTextField();
        txtIdSoldado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        comboRango = new javax.swing.JComboBox<>();
        txtCedula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Tabla Soldado"));

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
        TablaS.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaSAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TablaS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaS);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)), "Compañia AntiNarcoticos"));

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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/hombre_2.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(182, 182, 182))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adsad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        adsad.setText("ID Antinarcoticos");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID Soldados:");

        asdsd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        asdsd.setText("Nombre");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Apellido:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Rango");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cedula:");

        comboRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Un...", "Sub Oficial", "Cadete", "Teniente", "Coronel", "Cabo" }));
        comboRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRangoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/limpiar.png"))); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/cerrar.png"))); // NOI18N
        jButton2.setText("cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido)
                            .addComponent(comboRango, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(adsad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(asdsd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdAntionarcoticos, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtIdSoldado)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtNombre)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adsad)
                    .addComponent(txtIdAntionarcoticos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdSoldado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asdsd)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Antinarcoticos ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRangoActionPerformed
        
    }//GEN-LAST:event_comboRangoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String ID=txtIdSoldado.getText();
    String IDAR=txtIdAntionarcoticos.getText();
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
     CompañiaAntinarcotico A = new CompañiaAntinarcotico();
        A.setIdCompañoaAntinarcotico(IDA);
        A.setIdSoldado(ID);
        A.setNombre(nombre);
        A.setApellido(apellido);
        A.setRango(rango);
        A.setCedula(cedula);
 
    //creamos una instancia de la clase contoller 
    CompañiaAntinarcoticoJpaController tablaCompañiaAntinarcotico = new CompañiaAntinarcoticoJpaController(conexion);
    
        try {
            // insertamos usuario 
           tablaCompañiaAntinarcotico.create(A);
           //obtenemos el total de usuario que se encuentrea en la base de datos
          int total=tablaCompañiaAntinarcotico.getCompañiaAntinarcoticoCount();
          
          JOptionPane.showMessageDialog(this, "soldado Guardado En la Tabla Antinarcoticos  "+ total);
        } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "soldado No se Pudo Guardar En La Tabla Antinarcoticos ");
        }
     ActualizarTablaCompañiaAntinarcotico();
     limpiar(); 
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     eliminarCompañiaAntinarcotico();
     ActualizarTablaCompañiaAntinarcotico();
     
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
       this.txtIdAntionarcoticos.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 0).toString());
        this.txtIdSoldado.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 1).toString());
        this.txtNombre.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 2).toString());
        this.txtApellido.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 3).toString());
        this.comboRango.setSelectedItem(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 4).toString());
        this.txtCedula.setText(this.Tabla.getValueAt(this.Tabla.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_TablaMouseClicked

    private void TablaSAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaSAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaSAncestorAdded

    private void TablaSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSMouseClicked
        this.txtIdSoldado.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 0).toString());
        this.txtNombre.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 1).toString());
        this.txtApellido.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 2).toString());
        this.comboRango.setSelectedItem(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 3).toString());
        this.txtCedula.setText(this.TablaS.getValueAt(this.TablaS.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_TablaSMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jPanel3.disable();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CompañiaAntinarcoticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompañiaAntinarcoticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompañiaAntinarcoticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompañiaAntinarcoticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompañiaAntinarcoticos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaS;
    private javax.swing.JLabel adsad;
    private javax.swing.JLabel asdsd;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboRango;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtIdAntionarcoticos;
    private javax.swing.JTextField txtIdSoldado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
