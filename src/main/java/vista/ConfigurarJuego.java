/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author nicol
 */
public class ConfigurarJuego extends javax.swing.JFrame {

    /**
     * Creates new form ConfigurarJuego
     */
    public ConfigurarJuego() {
        initComponents();
        verDificultad.setVisible(false);
        verReloj.setVisible(false);
        verPanel.setVisible(false);
        verSonido.setVisible(false);
        horas.setVisible(false);
        minutos.setVisible(false);
        segundos.setVisible(false);
        lblSetTiempo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRetorno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        facil = new javax.swing.JCheckBox();
        medio = new javax.swing.JCheckBox();
        dificil = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cronometro = new javax.swing.JCheckBox();
        timer = new javax.swing.JCheckBox();
        ninguno = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        izquierda = new javax.swing.JCheckBox();
        derecha = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        si = new javax.swing.JCheckBox();
        no = new javax.swing.JCheckBox();
        btnComenzar = new javax.swing.JButton();
        verDificultad = new javax.swing.JLabel();
        verReloj = new javax.swing.JLabel();
        verSonido = new javax.swing.JLabel();
        verPanel = new javax.swing.JLabel();
        lblSetTiempo = new javax.swing.JLabel();
        horas = new javax.swing.JTextField();
        minutos = new javax.swing.JTextField();
        segundos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        btnRetorno.setBackground(new java.awt.Color(153, 153, 255));
        btnRetorno.setForeground(new java.awt.Color(60, 63, 65));
        btnRetorno.setText("Retorno");
        btnRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(60, 63, 65));
        jLabel2.setText("Dificultad");

        facil.setForeground(new java.awt.Color(60, 63, 65));
        facil.setText("Facil");
        facil.setContentAreaFilled(false);
        facil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facilItemStateChanged(evt);
            }
        });

        medio.setForeground(new java.awt.Color(60, 63, 65));
        medio.setText("Medio");
        medio.setContentAreaFilled(false);
        medio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                medioItemStateChanged(evt);
            }
        });
        medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medioActionPerformed(evt);
            }
        });

        dificil.setForeground(new java.awt.Color(60, 63, 65));
        dificil.setText("Dificil");
        dificil.setContentAreaFilled(false);
        dificil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dificilItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 63, 65));
        jLabel3.setText("Reloj");

        cronometro.setForeground(new java.awt.Color(60, 63, 65));
        cronometro.setText("Cronometro");
        cronometro.setContentAreaFilled(false);
        cronometro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cronometroItemStateChanged(evt);
            }
        });

        timer.setForeground(new java.awt.Color(60, 63, 65));
        timer.setText("Timer");
        timer.setContentAreaFilled(false);
        timer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timerItemStateChanged(evt);
            }
        });

        ninguno.setForeground(new java.awt.Color(60, 63, 65));
        ninguno.setText("Ninguno");
        ninguno.setContentAreaFilled(false);
        ninguno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ningunoItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 63, 65));
        jLabel4.setText("Posicion de panel");

        izquierda.setForeground(new java.awt.Color(60, 63, 65));
        izquierda.setText("Izquierda");
        izquierda.setContentAreaFilled(false);
        izquierda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                izquierdaItemStateChanged(evt);
            }
        });

        derecha.setForeground(new java.awt.Color(60, 63, 65));
        derecha.setText("Derecha");
        derecha.setContentAreaFilled(false);
        derecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                derechaItemStateChanged(evt);
            }
        });
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 63, 65));
        jLabel5.setText("Sonido de victoria");

        si.setForeground(new java.awt.Color(60, 63, 65));
        si.setText("Si");
        si.setContentAreaFilled(false);
        si.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                siItemStateChanged(evt);
            }
        });
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        no.setForeground(new java.awt.Color(60, 63, 65));
        no.setText("No");
        no.setContentAreaFilled(false);
        no.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                noItemStateChanged(evt);
            }
        });
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        btnComenzar.setBackground(new java.awt.Color(153, 153, 255));
        btnComenzar.setForeground(new java.awt.Color(60, 63, 65));
        btnComenzar.setText("Comenzar juego");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        verDificultad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verDificultad.setForeground(new java.awt.Color(60, 63, 65));
        verDificultad.setText("Seleccione uno");

        verReloj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verReloj.setForeground(new java.awt.Color(60, 63, 65));
        verReloj.setText("Seleccione uno");

        verSonido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verSonido.setForeground(new java.awt.Color(60, 63, 65));
        verSonido.setText("Seleccione uno");

        verPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verPanel.setForeground(new java.awt.Color(60, 63, 65));
        verPanel.setText("Seleccione uno");

        lblSetTiempo.setForeground(new java.awt.Color(60, 63, 65));
        lblSetTiempo.setText("Hora     Minutos   Segundos");

        horas.setBackground(new java.awt.Color(153, 153, 255));
        horas.setForeground(new java.awt.Color(60, 63, 65));

        minutos.setBackground(new java.awt.Color(153, 153, 255));
        minutos.setForeground(new java.awt.Color(60, 63, 65));

        segundos.setBackground(new java.awt.Color(153, 153, 255));
        segundos.setForeground(new java.awt.Color(60, 63, 65));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(si, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(verSonido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnComenzar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ninguno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verReloj))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSetTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(horas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(facil, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dificil, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(medio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(verDificultad))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(derecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(verPanel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(facil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medio)
                    .addComponent(verDificultad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dificil)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cronometro)
                            .addComponent(lblSetTiempo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timer)
                            .addComponent(horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ninguno)
                            .addComponent(verReloj))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(izquierda)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(derecha))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(verPanel)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(si))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(no))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(verSonido)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnRetorno)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 63, 65));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configuracion de Juego");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornoActionPerformed
        dispose();
    }//GEN-LAST:event_btnRetornoActionPerformed

    private void medioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medioActionPerformed

    private void dificilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dificilItemStateChanged
        facil.setSelected(false);
        medio.setSelected(false);
        verDificultad.setVisible(false);
    }//GEN-LAST:event_dificilItemStateChanged

    private void medioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_medioItemStateChanged
        facil.setSelected(false);
        dificil.setSelected(false);
        verDificultad.setVisible(false);
    }//GEN-LAST:event_medioItemStateChanged

    private void facilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facilItemStateChanged
        medio.setSelected(false);
        dificil.setSelected(false);
        verDificultad.setVisible(false);
    }//GEN-LAST:event_facilItemStateChanged

    private void cronometroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cronometroItemStateChanged
        timer.setSelected(false);
        ninguno.setSelected(false);
        verReloj.setVisible(false);
        horas.setVisible(false);
        minutos.setVisible(false);
        segundos.setVisible(false);
        lblSetTiempo.setVisible(false);
    }//GEN-LAST:event_cronometroItemStateChanged

    private void timerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timerItemStateChanged
        cronometro.setSelected(false);
        ninguno.setSelected(false);
        verReloj.setVisible(false);
        if (timer.isSelected()){
            lblSetTiempo.setVisible(true);
            horas.setVisible(true);
            minutos.setVisible(true);
            segundos.setVisible(true);
            lblSetTiempo.setVisible(true);
        }
        else{
            lblSetTiempo.setVisible(false);
            horas.setVisible(false);
            minutos.setVisible(false);
            segundos.setVisible(false);
            lblSetTiempo.setVisible(false);
        }
    }//GEN-LAST:event_timerItemStateChanged

    private void ningunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ningunoItemStateChanged
        timer.setSelected(false);
        cronometro.setSelected(false);
        verReloj.setVisible(false);
        horas.setVisible(false);
        minutos.setVisible(false);
        segundos.setVisible(false);
        lblSetTiempo.setVisible(false);
    }//GEN-LAST:event_ningunoItemStateChanged

    private void izquierdaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_izquierdaItemStateChanged
        derecha.setSelected(false);
        verPanel.setVisible(false);
    }//GEN-LAST:event_izquierdaItemStateChanged

    private void derechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_derechaItemStateChanged
        izquierda.setSelected(false);
        verPanel.setVisible(false);
    }//GEN-LAST:event_derechaItemStateChanged

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_derechaActionPerformed

    private void siItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_siItemStateChanged
        no.setSelected(false);
        verSonido.setVisible(false);
    }//GEN-LAST:event_siItemStateChanged

    private void noItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_noItemStateChanged
        si.setSelected(false);
        verSonido.setVisible(false);
    }//GEN-LAST:event_noItemStateChanged

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        boolean banderaDificultad = false;
        boolean banderaReloj = false;
        boolean banderaPanel = false;
        boolean banderaSonido = false;
        if (facil.isSelected() || medio.isSelected() || dificil.isSelected()){
            banderaDificultad = true;
        }
        else{
            verDificultad.setVisible(true);
        }
        if (cronometro.isSelected() || timer.isSelected() || ninguno.isSelected()){
            banderaReloj = true;
        }
        else{
            verReloj.setVisible(true);
        }
        if (izquierda.isSelected() || derecha.isSelected()){
            banderaPanel = true;
        }
        else{
            verPanel.setVisible(true);
        }
        if (no.isSelected() || si.isSelected()){
            banderaSonido = true;
        }
        else{
            verSonido.setVisible(true);
        }
        if (banderaDificultad && banderaReloj && banderaPanel && banderaSonido){
            dispose();
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnRetorno;
    private javax.swing.JCheckBox cronometro;
    private javax.swing.JCheckBox derecha;
    private javax.swing.JCheckBox dificil;
    private javax.swing.JCheckBox facil;
    private javax.swing.JTextField horas;
    private javax.swing.JCheckBox izquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSetTiempo;
    private javax.swing.JCheckBox medio;
    private javax.swing.JTextField minutos;
    private javax.swing.JCheckBox ninguno;
    private javax.swing.JCheckBox no;
    private javax.swing.JTextField segundos;
    private javax.swing.JCheckBox si;
    private javax.swing.JCheckBox timer;
    private javax.swing.JLabel verDificultad;
    private javax.swing.JLabel verPanel;
    private javax.swing.JLabel verReloj;
    private javax.swing.JLabel verSonido;
    // End of variables declaration//GEN-END:variables
}
