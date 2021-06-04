
package Servicio.Militar.Principal.ventanas;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;


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
        itemArmada = new javax.swing.JMenuItem();
        itemArtilleria = new javax.swing.JMenuItem();
        itemInfanteria = new javax.swing.JMenuItem();
        menuCuarteles = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuSoldado = new javax.swing.JMenu();
        itemIngresarSoldado = new javax.swing.JMenuItem();
        menuCompañia = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuServicio = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        itemGenerarReporte = new javax.swing.JMenuItem();

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

        itemArmada.setText("Armada");
        itemArmada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArmadaActionPerformed(evt);
            }
        });
        menuCuerpoEjercito.add(itemArmada);

        itemArtilleria.setText("Artilleria");
        itemArtilleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArtilleriaActionPerformed(evt);
            }
        });
        menuCuerpoEjercito.add(itemArtilleria);

        itemInfanteria.setText("Infanteria");
        itemInfanteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInfanteriaActionPerformed(evt);
            }
        });
        menuCuerpoEjercito.add(itemInfanteria);

        jMenuBar1.add(menuCuerpoEjercito);

        menuCuarteles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/tienda.png"))); // NOI18N
        menuCuarteles.setText("Cuarteles");

        jMenuItem2.setText("Escuela  Naval");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCuarteles.add(jMenuItem2);

        jMenuItem5.setText("Batallon Operativo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuCuarteles.add(jMenuItem5);

        jMenuItem6.setText("Batallon De Comando");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuCuarteles.add(jMenuItem6);

        jMenuBar1.add(menuCuarteles);

        menuSoldado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/soldado_1.png"))); // NOI18N
        menuSoldado.setText("Soldado");
        menuSoldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSoldadoActionPerformed(evt);
            }
        });

        itemIngresarSoldado.setText("Ingresar Soldado");
        itemIngresarSoldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIngresarSoldadoActionPerformed(evt);
            }
        });
        menuSoldado.add(itemIngresarSoldado);

        jMenuBar1.add(menuSoldado);

        menuCompañia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/base.png"))); // NOI18N
        menuCompañia.setText("Compañia");

        jMenuItem7.setText("Compañia Antinarcoticos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuCompañia.add(jMenuItem7);

        jMenuItem8.setText("Compañia De Rescate ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuCompañia.add(jMenuItem8);

        jMenuBar1.add(menuCompañia);

        menuServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/cheuron.png"))); // NOI18N
        menuServicio.setText("Servicio");

        jMenuItem9.setText("Servicio");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuServicio.add(jMenuItem9);

        jMenuBar1.add(menuServicio);

        menuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/email.enviar.png"))); // NOI18N
        menuReporte.setText("Reporte");

        itemGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/gmail.png"))); // NOI18N
        itemGenerarReporte.setText("Generar Reporte");
        itemGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGenerarReporteActionPerformed(evt);
            }
        });
        menuReporte.add(itemGenerarReporte);

        jMenuBar1.add(menuReporte);

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

    private void itemIngresarSoldadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIngresarSoldadoActionPerformed
      new Soldado().setVisible(true);
    }//GEN-LAST:event_itemIngresarSoldadoActionPerformed

    private void menuCuerpoEjercitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCuerpoEjercitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCuerpoEjercitoActionPerformed

    private void itemArmadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArmadaActionPerformed
      new armada().setVisible(true);
    }//GEN-LAST:event_itemArmadaActionPerformed

    private void itemInfanteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInfanteriaActionPerformed
     new infanteria().setVisible(true);
    }//GEN-LAST:event_itemInfanteriaActionPerformed

    private void itemArtilleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArtilleriaActionPerformed
    new artilleria().setVisible(true);
    }//GEN-LAST:event_itemArtilleriaActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    new tercera_Brogada().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    new segunda_brigada().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     new primera_Brigada().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       new CompañiaAntinarcoticos().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
      new compañiaRescate().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       new servicios().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void itemGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGenerarReporteActionPerformed
        new Reporte().setVisible(true);
    }//GEN-LAST:event_itemGenerarReporteActionPerformed

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
                try {
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
               }
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemArmada;
    private javax.swing.JMenuItem itemArtilleria;
    private javax.swing.JMenuItem itemGenerarReporte;
    private javax.swing.JMenuItem itemInfanteria;
    private javax.swing.JMenuItem itemIngresarSoldado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu menuCompañia;
    private javax.swing.JMenu menuCuarteles;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenu menuCuerpoEjercito;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JMenu menuServicio;
    private javax.swing.JMenu menuSoldado;
    // End of variables declaration//GEN-END:variables
}
