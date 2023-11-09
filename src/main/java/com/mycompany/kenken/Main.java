package com.mycompany.kenken;

import modelo.LeerPartidas;
import vista.VentanaInicio;

public class Main {
    public static void main(String[] args) {
        LeerPartidas.guardarDatos();
        
        VentanaInicio menu = new VentanaInicio();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
}