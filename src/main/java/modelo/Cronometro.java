/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static java.lang.Thread.sleep;

/**
 *
 * @author nicol
 */

public class Cronometro extends Thread{
    
    private boolean running = true;
    private boolean pausa = false;
    private final lblCronometro referencia_crono;
    
    
    public Cronometro(lblCronometro pCrono){
        this.referencia_crono = pCrono;
    }

    @Override
    public void run(){
       while (running){
           try {
               while(pausa){
                   sleep(100);
               }
               sleep(1000);
               referencia_crono.incrementarContador();
           }
           catch (InterruptedException ex) {}
       }   
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void pause(){
        this.pausa = !this.pausa;
    }

    public boolean isPaused() {
        return pausa;
    }
    
    public void detener(){
        this.running = false;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    } 
}