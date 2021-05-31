/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio.Militar.Principal;

import Servicio.Militar.Principal.ventanas.VentanaPrincipal;

/**
 *
 * @author Fabian Iriarte, Yeison Barrios
 */
public class Principal {
    public static void main(String[] args) {
       VentanaPrincipal miVentana = new VentanaPrincipal();
       miVentana.setVisible(true);
       miVentana.setLocationRelativeTo(null);
       miVentana.setResizable(false);  
    }
   
               
    
}
