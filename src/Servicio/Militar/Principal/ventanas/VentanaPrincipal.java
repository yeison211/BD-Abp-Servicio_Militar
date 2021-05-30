
package Servicio.Militar.Principal.ventanas;


public class VentanaPrincipal extends javax.swing.JFrame {

  
    public VentanaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); 
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCuenta = new javax.swing.JMenu();
        menuCuerpoEjercito = new javax.swing.JMenu();
        menuArmada = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuCuarteles = new javax.swing.JMenu();
        menuSoldado = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuCompañia = new javax.swing.JMenu();
        menuServicio = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/Infantes_de_marina_colombia.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/LOGO-EJC-ROJO.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/127.jpg"))); // NOI18N

        menuCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/policia.png"))); // NOI18N
        menuCuenta.setText("Cuenta");
        jMenuBar1.add(menuCuenta);

        menuCuerpoEjercito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/helicoptero.png"))); // NOI18N
        menuCuerpoEjercito.setText("Cuerpo De Ejercito");
        menuCuerpoEjercito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCuerpoEjercitoActionPerformed(evt);
            }
        });

        menuArmada.setText("Armada");
        menuArmada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArmadaActionPerformed(evt);
            }
        });
        menuCuerpoEjercito.add(menuArmada);

        jMenuItem3.setText("jMenuItem3");
        menuCuerpoEjercito.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        menuCuerpoEjercito.add(jMenuItem4);

        jMenuBar1.add(menuCuerpoEjercito);

        menuCuarteles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/tienda.png"))); // NOI18N
        menuCuarteles.setText("Cuarteles");
        jMenuBar1.add(menuCuarteles);

        menuSoldado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/soldado_1.png"))); // NOI18N
        menuSoldado.setText("Soldado");
        menuSoldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSoldadoActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Ingresar Soldado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSoldado.add(jMenuItem1);

        jMenuBar1.add(menuSoldado);

        menuCompañia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/base.png"))); // NOI18N
        menuCompañia.setText("Compañia");
        jMenuBar1.add(menuCompañia);

        menuServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/cheuron.png"))); // NOI18N
        menuServicio.setText("Servicio");
        jMenuBar1.add(menuServicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(378, 378, 378))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSoldadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSoldadoActionPerformed
       
    }//GEN-LAST:event_menuSoldadoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      new Soldado().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuCuerpoEjercitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCuerpoEjercitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCuerpoEjercitoActionPerformed

    private void menuArmadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArmadaActionPerformed
      new armada().setVisible(true);
    }//GEN-LAST:event_menuArmadaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menuArmada;
    private javax.swing.JMenu menuCompañia;
    private javax.swing.JMenu menuCuarteles;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenu menuCuerpoEjercito;
    private javax.swing.JMenu menuServicio;
    private javax.swing.JMenu menuSoldado;
    // End of variables declaration//GEN-END:variables
}
