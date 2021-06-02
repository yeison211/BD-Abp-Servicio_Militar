/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal.ventanas;

import Servicio.Militar.Principal.crud.ArmadaJpaController;
import Servicio.Militar.Principal.crud.ArtilleriaJpaController;
import Servicio.Militar.Principal.crud.CompañiaAntinarcoticoJpaController;
import Servicio.Militar.Principal.crud.CompañiaRescateJpaController;
import Servicio.Militar.Principal.crud.InfanteriaJpaController;
import Servicio.Militar.Principal.crud.PrimeraBrigadaJpaController;
import Servicio.Militar.Principal.crud.SegundaBrigadaJpaController;
import Servicio.Militar.Principal.crud.ServiciosJpaController;
import Servicio.Militar.Principal.crud.SoldadosJpaController;
import Servicio.Militar.Principal.crud.TerceraBrigadaJpaController;
import Servicio.Militar.Principal.tabla.Soldados;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Servicio.Militar.Principal.ventanas.Soldado;


public class Reporte extends javax.swing.JFrame {
     EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
     DefaultTableModel Table = new DefaultTableModel();
    
    public Reporte() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    public void actualizarTablasoldado()
     {
        //se realiza la conexion ala base de datos
        EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
        //creamos una  instancia de la clase controller
        SoldadosJpaController tablasoldado= new SoldadosJpaController(conexion);
        //creamos una lista de soldados
        List<Soldados>listasoldado = tablasoldado.findSoldadosEntities();
        
      
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Reporte de Soldados ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Servicio/Militar/Principal/ventanas/imagenes/gmail.png"))); // NOI18N
        jLabel3.setText("Correo del Destinatario: ");

        jLabel4.setText("Asunto:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 156, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
     EntityManagerFactory conexion=Persistence.createEntityManagerFactory("ABP_Servicio_MilitarPU");
     SoldadosJpaController tablaSoldado = new SoldadosJpaController(conexion);
     int total=tablaSoldado.getSoldadosCount();
     
     ArmadaJpaController tablaArmada = new ArmadaJpaController(conexion);
     int totaA=tablaArmada.getArmadaCount();
     
     ArtilleriaJpaController tablaArtilleria = new  ArtilleriaJpaController(conexion);
     int totaART=tablaArtilleria.getArtilleriaCount();
     
     InfanteriaJpaController tablaInfanteria = new  InfanteriaJpaController(conexion);
     int totaInt=tablaInfanteria.getInfanteriaCount();
     
     PrimeraBrigadaJpaController tablaPrimeraBrigada = new PrimeraBrigadaJpaController(conexion);
     int totalES=tablaPrimeraBrigada.getPrimeraBrigadaCount();
    
     CompañiaAntinarcoticoJpaController tablaCompañiaAntinarcotico = new CompañiaAntinarcoticoJpaController(conexion);
     int totalAnt=tablaCompañiaAntinarcotico.getCompañiaAntinarcoticoCount();
     
     ServiciosJpaController tablaServicios = new ServiciosJpaController(conexion);
     int totalServ=tablaServicios.getServiciosCount();
     
     SegundaBrigadaJpaController tablaSegundaBrigada = new SegundaBrigadaJpaController(conexion);
      int totalBaOP=tablaSegundaBrigada.getSegundaBrigadaCount();
      
      CompañiaRescateJpaController tablaCompañiaRescate = new CompañiaRescateJpaController(conexion);
      int totalREsca=tablaCompañiaRescate.getCompañiaRescateCount();
      
       TerceraBrigadaJpaController tablaTerceraBrigada = new TerceraBrigadaJpaController(conexion);
       int totalBaCOO=tablaTerceraBrigada.getTerceraBrigadaCount();
     
        try {
        Properties Propiedad = new Properties();
       // String host="localhost";
     
     Propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
     Propiedad.setProperty("mail.smtp.starttls.enable", "true");
     Propiedad.setProperty("mail.smtp.port", "587");
     Propiedad.setProperty("mail.smtp.auth", "true");
     
     Session sesion=Session.getDefaultInstance(Propiedad);
     
     String correoEnviar="yeisondbv2020@gmail.com";
     String contraseña="Emprendedorbv2020";
     String destinatario=txtCorreo.getText();
     String asunto=txtAsunto.getText();
     String Mensaje = txtMensaje.getText()+"el numero de soldado registrado es de :" + total+ "  "+
              "Soldados Registrado en la Armada : "+ totaA + "     "+""
             + "Soldados Registrado en Artilleria : " + totaART + "   "
             +"Soldados Registraedo en Infanteria : "+ totaInt + "                                                                                                                                                                                                                                                                                   "
             + "|------------------------Cuarlteles--------------------------|"
             +"   "+
             "|--------------------------Compañias------------------------------|"+"   "+
             "|-------------------------Servicio-----------------------|"+"                      "+
             " Soldados Registrados en la Escuela Naval : "+totalES+"   |  "+
             "Soldados Registrados en la Compañia AntiNarcoticos : "+totalAnt+"   |  "+
             "Numero de Soldado Que prestan Servicios "+totalServ+"   |  "+
             "Soldados Registados en el Batallon Operativo : "+totalBaOP+"  |  "+
             "Soldados Registrados en la Compañia De Rescate : "+totalREsca+"   |  "+
             "Numero de Soldado Que prestan Servicios "+totalServ+"  |         "+
             "Soldados Registrado en el BAtallon De Comando : "+totalBaCOO+"  |  "+           
             "                                                                                                                                                                                                   "+""+
             "                                                                                                                                                                                                                                                         "+""
             +"Datos de EJERCITO NACIONAL "; 
    
     
                                                                                                                                                                                                                                                                  
     MimeMessage mail= new MimeMessage(sesion);
     
        
            mail.setFrom(new InternetAddress(correoEnviar));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario) );
            mail.setSubject(asunto);
            mail.setText(Mensaje);
            
            Transport transporte =sesion.getTransport("smtp");
            transporte.connect(correoEnviar,contraseña);
            transporte.sendMessage(mail,mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(this,"correo fue enviado con exito");
            
        } catch (AddressException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
