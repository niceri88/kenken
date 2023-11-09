package vista;

import modelo.Datos;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import controlador.Jaula;
import controlador.Partida;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class VentanaJuego extends javax.swing.JFrame {
    private Timer timer1;
    private Timer timer2;
    private javax.swing.JToggleButton[][] listaBotones;
    private char[][] listaResultados;
    private int numeroPrincipal;
    private String operador;
    private Partida partida;
    private List<String> pilaDeshacerJugada = new ArrayList<>();
    private List<String> pilaRehacerJugada = new ArrayList<>();

    public VentanaJuego() {
        super("Juego");
        initComponents();
        listaResultados = new char[6][6];
        timer1 = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int horasCrono = Integer.parseInt(PaneHorasCrono.getText());
                    int minutosCrono = Integer.parseInt(PaneMinutosCrono.getText());
                    int segundosCrono = Integer.parseInt(PaneSegundosCrono.getText());
                    segundosCrono += 1;
                    if (segundosCrono == 60){
                        segundosCrono = 0;
                        minutosCrono += 1;
                        if (minutosCrono == 60){
                            horasCrono += 1;
                            minutosCrono = 0;
                        }
                    }
                    String horasCronoString = String.valueOf(horasCrono);
                    String minutosCronoString = String.valueOf(minutosCrono);
                    String segundosCronoString = String.valueOf(segundosCrono);
                    PaneHorasCrono.setText(horasCronoString);
                    PaneMinutosCrono.setText(minutosCronoString);
                    PaneSegundosCrono.setText(segundosCronoString);
                }
            });
        this.LabelHorasCrono.setVisible(false);
        this.LabelMinutosCrono.setVisible(false);
        this.LabelSegundosCrono.setVisible(false);
        this.PaneHorasCrono.setVisible(false);
        this.PaneMinutosCrono.setVisible(false);
        this.PaneSegundosCrono.setVisible(false);
        this.PanelCrono.setVisible(false);
        this.textoCrono.setVisible(false);
        this.PanelKenKen.setVisible(false);
        this.BotonBorrador.setVisible(false);
        this.BotonNum1.setVisible(false);
        this.BotonNum2.setVisible(false);
        this.BotonNum3.setVisible(false);
        this.BotonNum4.setVisible(false);
        this.BotonNum5.setVisible(false);
        this.BotonNum6.setVisible(false);
        this.botonBorrador.setVisible(false);
        this.botonNum1.setVisible(false);
        this.botonNum2.setVisible(false);
        this.botonNum3.setVisible(false);
        this.botonNum4.setVisible(false);
        this.botonNum5.setVisible(false);
        this.botonNum6.setVisible(false);
        Partida partida = elegirPartida();
        this.partida = partida;
        agregarBotonesALista();
        this.botonDeshacerJugada.setEnabled(false);
        this.botonRehacerJugada.setEnabled(false);
        this.botonValidarJuego.setEnabled(false);
        for (int i = 0; i < listaBotones.length; i++){
            for (int j = 0; j < listaBotones[i].length; j++){
                listaResultados[i][j] = ' ';
                listaBotones[i][j].setBackground(Color.white);
                Jaula esCelda = new Jaula();
                for (Jaula celda : partida.getCeldas()){
                    if (ubicacionEnLista(i+1, j+1, celda)){
                        esCelda = celda;
                        break;
                    }
                    int[] listaCoordenadas = {i+1, j+1};
                }
                if (esCelda.getUbicaciones().get(0)[0] == i+1 && esCelda.getUbicaciones().get(0)[1] == j+1){
                        numeroPrincipal = esCelda.getNumeroResultado();
                        operador = esCelda.getOperando();
                        if (operador == "c"){
                            listaBotones[i][j].setText("<html><center>" + numeroPrincipal + "</html>");
                        }
                        else{
                            listaBotones[i][j].setText("<html><center>" + numeroPrincipal + operador + "</html>");
                        }
                    }
                int arriba = 2;
                int izquierda = 2;
                int abajo = 2;
                int derecha = 2;
                if (ubicacionEnLista(i, j+1, esCelda)){
                    arriba = 0;
                }
                if (ubicacionEnLista(i+1, j, esCelda)){
                    izquierda = 0;
                }
                if (ubicacionEnLista(i+2, j+1, esCelda)){
                    abajo = 0;
                }
                if (ubicacionEnLista(i+1, j+2, esCelda)){
                    derecha = 0;
                }
                listaBotones[i][j].setBorder(BorderFactory.createMatteBorder(arriba, izquierda, abajo, derecha, Color.BLACK));
            }
        }
    }

    private boolean ubicacionEnLista(int x, int y, Jaula celda){
        for (int [] ubicacion : celda.getUbicaciones()){
            int x2 = ubicacion[0];
            int y2 = ubicacion[1];
            if (x2 == x && y2 == y){
                return true;
            }
        }
        return false;
    }
    private void agregarBotonesALista(){
        listaBotones = new javax.swing.JToggleButton[6][6];
        listaBotones[0][0] = kenken11;
        listaBotones[0][1] = kenken12;
        listaBotones[0][2] = kenken13;
        listaBotones[0][3] = kenken14;
        listaBotones[0][4] = kenken15;
        listaBotones[0][5] = kenken16;
        listaBotones[1][0] = kenken21;
        listaBotones[1][1] = kenken22;
        listaBotones[1][2] = kenken23;
        listaBotones[1][3] = kenken24;
        listaBotones[1][4] = kenken25;
        listaBotones[1][5] = kenken26;
        listaBotones[2][0] = kenken31;
        listaBotones[2][1] = kenken32;
        listaBotones[2][2] = kenken33;
        listaBotones[2][3] = kenken34;
        listaBotones[2][4] = kenken35;
        listaBotones[2][5] = kenken36;
        listaBotones[3][0] = kenken41;
        listaBotones[3][1] = kenken42;
        listaBotones[3][2] = kenken43;
        listaBotones[3][3] = kenken44;
        listaBotones[3][4] = kenken45;
        listaBotones[3][5] = kenken46;
        listaBotones[4][0] = kenken51;
        listaBotones[4][1] = kenken52;
        listaBotones[4][2] = kenken53;
        listaBotones[4][3] = kenken54;
        listaBotones[4][4] = kenken55;
        listaBotones[4][5] = kenken56;
        listaBotones[5][0] = kenken61;
        listaBotones[5][1] = kenken62;
        listaBotones[5][2] = kenken63;
        listaBotones[5][3] = kenken64;
        listaBotones[5][4] = kenken65;
        listaBotones[5][5] = kenken66;
    }
    
    private void inicializarTimer2(){
        timer2 = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int horasCrono = Integer.parseInt(PaneHorasCrono.getText());
                    int minutosCrono = Integer.parseInt(PaneMinutosCrono.getText());
                    int segundosCrono = Integer.parseInt(PaneSegundosCrono.getText());
                    segundosCrono -= 1;
                    if (segundosCrono == -1){
                        segundosCrono = 59;
                        minutosCrono -= 1;
                        if (minutosCrono == -1){
                            horasCrono -= 1;
                            minutosCrono = 59;
                        }
                    }
                    if (horasCrono == 0 && minutosCrono == 0 && segundosCrono == 0){
                        verificarTimer();
                        timer2.stop();
                        return;
                    }
                    String horasCronoString = String.valueOf(horasCrono);
                    String minutosCronoString = String.valueOf(minutosCrono);
                    String segundosCronoString = String.valueOf(segundosCrono);
                    PaneHorasCrono.setText(horasCronoString);
                    PaneMinutosCrono.setText(minutosCronoString);
                    PaneSegundosCrono.setText(segundosCronoString);
                }
            });
    }

    private void verificarTimer(){
        int verificacion = JOptionPane.showConfirmDialog(null, "Se acabó el juego ¿Quieres continuar?");
        if (verificacion == 1){
            VentanaInicio menu = new VentanaInicio();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            this.setVisible(false);
            this.dispose();
        }
        else{
            PaneHorasCrono.setText(Datos.getTimer().getHoras()+"");
            PaneMinutosCrono.setText(Datos.getTimer().getMinutos()+"");
            PaneSegundosCrono.setText(Datos.getTimer().getSegundos()+"");
            timer1.start();
        }
    }
    
    private Partida elegirPartida(){
        if (Datos.getConfiguracion().getDificultad()[0] == true){
            List<Partida> partidasFaciles = new ArrayList<>();
            for (Partida partida : Datos.getListaPartidas()){
                if (partida.getDificultad().equals("facil")){
                    partidasFaciles.add(partida);
                }
            }
            Random rand = new Random();
            Partida partida = partidasFaciles.get(rand.nextInt(partidasFaciles.size()));
            return partida;
        }
        else if (Datos.getConfiguracion().getDificultad()[1] == true){
            List<Partida> partidasMedio = new ArrayList<>();
            for (Partida partida : Datos.getListaPartidas()){
                if (partida.getDificultad().equals("intermedio")){
                    partidasMedio.add(partida);
                }
            }
            Random rand = new Random();
            Partida partida = partidasMedio.get(rand.nextInt(partidasMedio.size()));
            return partida;
        }
        else{
            List<Partida> partidasDificiles = new ArrayList<>();
            for (Partida partida : Datos.getListaPartidas()){
                if (partida.getDificultad().equals("dificil")){
                    partidasDificiles.add(partida);
                }
            }
            Random rand = new Random();
            Partida partida = partidasDificiles.get(rand.nextInt(partidasDificiles.size()));
            return partida;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        grupoKenKen = new javax.swing.ButtonGroup();
        grupoNumeros = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        botonIniciarJuego = new javax.swing.JButton();
        botonDeshacerJugada = new javax.swing.JButton();
        botonTerminarJuego = new javax.swing.JButton();
        botonOtroJuego = new javax.swing.JButton();
        botonRehacerJugada = new javax.swing.JButton();
        botonValidarJuego = new javax.swing.JButton();
        botonReiniciarJuego = new javax.swing.JButton();
        PanelCrono = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PaneHorasCrono = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        PaneMinutosCrono = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        PaneSegundosCrono = new javax.swing.JTextPane();
        LabelHorasCrono = new javax.swing.JLabel();
        LabelMinutosCrono = new javax.swing.JLabel();
        LabelSegundosCrono = new javax.swing.JLabel();
        textoCrono = new java.awt.Label();
        PanelKenKen = new javax.swing.JPanel();
        kenken11 = new javax.swing.JToggleButton();
        kenken12 = new javax.swing.JToggleButton();
        kenken13 = new javax.swing.JToggleButton();
        kenken14 = new javax.swing.JToggleButton();
        kenken15 = new javax.swing.JToggleButton();
        kenken16 = new javax.swing.JToggleButton();
        kenken21 = new javax.swing.JToggleButton();
        kenken22 = new javax.swing.JToggleButton();
        kenken23 = new javax.swing.JToggleButton();
        kenken24 = new javax.swing.JToggleButton();
        kenken25 = new javax.swing.JToggleButton();
        kenken26 = new javax.swing.JToggleButton();
        kenken31 = new javax.swing.JToggleButton();
        kenken32 = new javax.swing.JToggleButton();
        kenken33 = new javax.swing.JToggleButton();
        kenken34 = new javax.swing.JToggleButton();
        kenken35 = new javax.swing.JToggleButton();
        kenken36 = new javax.swing.JToggleButton();
        kenken41 = new javax.swing.JToggleButton();
        kenken42 = new javax.swing.JToggleButton();
        kenken43 = new javax.swing.JToggleButton();
        kenken44 = new javax.swing.JToggleButton();
        kenken45 = new javax.swing.JToggleButton();
        kenken46 = new javax.swing.JToggleButton();
        kenken51 = new javax.swing.JToggleButton();
        kenken52 = new javax.swing.JToggleButton();
        kenken53 = new javax.swing.JToggleButton();
        kenken54 = new javax.swing.JToggleButton();
        kenken55 = new javax.swing.JToggleButton();
        kenken56 = new javax.swing.JToggleButton();
        kenken61 = new javax.swing.JToggleButton();
        kenken62 = new javax.swing.JToggleButton();
        kenken63 = new javax.swing.JToggleButton();
        kenken64 = new javax.swing.JToggleButton();
        kenken65 = new javax.swing.JToggleButton();
        kenken66 = new javax.swing.JToggleButton();
        BotonNum1 = new javax.swing.JToggleButton();
        BotonNum2 = new javax.swing.JToggleButton();
        BotonNum3 = new javax.swing.JToggleButton();
        BotonNum4 = new javax.swing.JToggleButton();
        BotonNum5 = new javax.swing.JToggleButton();
        BotonNum6 = new javax.swing.JToggleButton();
        BotonBorrador = new javax.swing.JToggleButton();
        botonNum1 = new javax.swing.JToggleButton();
        botonNum4 = new javax.swing.JToggleButton();
        botonNum2 = new javax.swing.JToggleButton();
        botonNum3 = new javax.swing.JToggleButton();
        botonNum5 = new javax.swing.JToggleButton();
        botonNum6 = new javax.swing.JToggleButton();
        botonBorrador = new javax.swing.JToggleButton();
        botonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setForeground(new java.awt.Color(60, 63, 65));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        botonIniciarJuego.setBackground(new java.awt.Color(153, 153, 255));
        botonIniciarJuego.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonIniciarJuego.setForeground(new java.awt.Color(60, 63, 65));
        botonIniciarJuego.setText("<html><center>Iniciar Juego</html>");
        botonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarJuegoActionPerformed(evt);
            }
        });

        botonDeshacerJugada.setBackground(new java.awt.Color(153, 153, 255));
        botonDeshacerJugada.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonDeshacerJugada.setForeground(new java.awt.Color(60, 63, 65));
        botonDeshacerJugada.setText("<html><center>Deshacer Jugada</html>");
        botonDeshacerJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeshacerJugadaActionPerformed(evt);
            }
        });

        botonTerminarJuego.setBackground(new java.awt.Color(153, 153, 255));
        botonTerminarJuego.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonTerminarJuego.setForeground(new java.awt.Color(60, 63, 65));
        botonTerminarJuego.setText("<html><center>Terminar Juego</html>");
        botonTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarJuegoActionPerformed(evt);
            }
        });

        botonOtroJuego.setBackground(new java.awt.Color(153, 153, 255));
        botonOtroJuego.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonOtroJuego.setForeground(new java.awt.Color(60, 63, 65));
        botonOtroJuego.setText("<html><center>Otro Juego</html>");
        botonOtroJuego.setEnabled(false);
        botonOtroJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOtroJuegoActionPerformed(evt);
            }
        });

        botonRehacerJugada.setBackground(new java.awt.Color(153, 153, 255));
        botonRehacerJugada.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonRehacerJugada.setForeground(new java.awt.Color(60, 63, 65));
        botonRehacerJugada.setText("<html><center>Rehacer Jugada</html>");
        botonRehacerJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRehacerJugadaActionPerformed(evt);
            }
        });

        botonValidarJuego.setBackground(new java.awt.Color(153, 153, 255));
        botonValidarJuego.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonValidarJuego.setForeground(new java.awt.Color(60, 63, 65));
        botonValidarJuego.setText("<html><center>Validar Juego</html>");
        botonValidarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValidarJuegoActionPerformed(evt);
            }
        });

        botonReiniciarJuego.setBackground(new java.awt.Color(153, 153, 255));
        botonReiniciarJuego.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonReiniciarJuego.setForeground(new java.awt.Color(60, 63, 65));
        botonReiniciarJuego.setText("<html><center>Reiniciar Juego</html>");
        botonReiniciarJuego.setEnabled(false);
        botonReiniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarJuegoActionPerformed(evt);
            }
        });

        PanelCrono.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));

        PaneHorasCrono.setEditable(false);
        PaneHorasCrono.setBackground(new java.awt.Color(204, 204, 255));
        PaneHorasCrono.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(PaneHorasCrono);

        jScrollPane4.setBackground(new java.awt.Color(204, 204, 255));

        PaneMinutosCrono.setEditable(false);
        PaneMinutosCrono.setBackground(new java.awt.Color(204, 204, 255));
        PaneMinutosCrono.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 24)); // NOI18N
        jScrollPane4.setViewportView(PaneMinutosCrono);

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 255));

        PaneSegundosCrono.setEditable(false);
        PaneSegundosCrono.setBackground(new java.awt.Color(204, 204, 255));
        PaneSegundosCrono.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 24)); // NOI18N
        jScrollPane3.setViewportView(PaneSegundosCrono);

        LabelHorasCrono.setForeground(new java.awt.Color(60, 63, 65));
        LabelHorasCrono.setText("Horas");

        LabelMinutosCrono.setForeground(new java.awt.Color(60, 63, 65));
        LabelMinutosCrono.setText("Minutos");

        LabelSegundosCrono.setForeground(new java.awt.Color(60, 63, 65));
        LabelSegundosCrono.setText("Segundos");

        javax.swing.GroupLayout PanelCronoLayout = new javax.swing.GroupLayout(PanelCrono);
        PanelCrono.setLayout(PanelCronoLayout);
        PanelCronoLayout.setHorizontalGroup(
            PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCronoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCronoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(LabelHorasCrono)))
                .addGap(18, 18, 18)
                .addGroup(PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCronoLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelCronoLayout.createSequentialGroup()
                        .addComponent(LabelMinutosCrono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelSegundosCrono)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCronoLayout.setVerticalGroup(
            PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCronoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelHorasCrono)
                    .addComponent(LabelMinutosCrono)
                    .addComponent(LabelSegundosCrono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        textoCrono.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        textoCrono.setForeground(new java.awt.Color(60, 63, 65));
        textoCrono.setText("Tiempo");

        PanelKenKen.setForeground(new java.awt.Color(60, 63, 65));

        kenken11.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken11);
        kenken11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken11ActionPerformed(evt);
            }
        });

        kenken12.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken12);
        kenken12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken12ActionPerformed(evt);
            }
        });

        kenken13.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken13);
        kenken13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken13ActionPerformed(evt);
            }
        });

        kenken14.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken14);
        kenken14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken14ActionPerformed(evt);
            }
        });

        kenken15.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken15);
        kenken15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken15ActionPerformed(evt);
            }
        });

        kenken16.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken16);
        kenken16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken16ActionPerformed(evt);
            }
        });

        kenken21.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken21);
        kenken21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken21ActionPerformed(evt);
            }
        });

        kenken22.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken22);
        kenken22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken22ActionPerformed(evt);
            }
        });

        kenken23.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken23);
        kenken23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken23ActionPerformed(evt);
            }
        });

        kenken24.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken24);
        kenken24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken24ActionPerformed(evt);
            }
        });

        kenken25.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken25);
        kenken25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken25ActionPerformed(evt);
            }
        });

        kenken26.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken26);
        kenken26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken26ActionPerformed(evt);
            }
        });

        kenken31.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken31);
        kenken31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken31ActionPerformed(evt);
            }
        });

        kenken32.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken32);
        kenken32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken32ActionPerformed(evt);
            }
        });

        kenken33.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken33);
        kenken33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken33ActionPerformed(evt);
            }
        });

        kenken34.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken34);
        kenken34.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken34ActionPerformed(evt);
            }
        });

        kenken35.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken35);
        kenken35.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken35ActionPerformed(evt);
            }
        });

        kenken36.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken36);
        kenken36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken36ActionPerformed(evt);
            }
        });

        kenken41.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken41);
        kenken41.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken41ActionPerformed(evt);
            }
        });

        kenken42.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken42);
        kenken42.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken42ActionPerformed(evt);
            }
        });

        kenken43.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken43);
        kenken43.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken43ActionPerformed(evt);
            }
        });

        kenken44.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken44);
        kenken44.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken44ActionPerformed(evt);
            }
        });

        kenken45.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken45);
        kenken45.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken45ActionPerformed(evt);
            }
        });

        kenken46.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken46);
        kenken46.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken46ActionPerformed(evt);
            }
        });

        kenken51.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken51);
        kenken51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken51ActionPerformed(evt);
            }
        });

        kenken52.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken52);
        kenken52.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken52ActionPerformed(evt);
            }
        });

        kenken53.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken53);
        kenken53.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken53ActionPerformed(evt);
            }
        });

        kenken54.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken54);
        kenken54.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken54ActionPerformed(evt);
            }
        });

        kenken55.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken55);
        kenken55.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken55ActionPerformed(evt);
            }
        });

        kenken56.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken56);
        kenken56.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken56ActionPerformed(evt);
            }
        });

        kenken61.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken61);
        kenken61.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken61ActionPerformed(evt);
            }
        });

        kenken62.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken62);
        kenken62.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken62ActionPerformed(evt);
            }
        });

        kenken63.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken63);
        kenken63.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken63ActionPerformed(evt);
            }
        });

        kenken64.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken64);
        kenken64.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken64ActionPerformed(evt);
            }
        });

        kenken65.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken65);
        kenken65.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken65ActionPerformed(evt);
            }
        });

        kenken66.setBackground(new java.awt.Color(153, 153, 255));
        grupoKenKen.add(kenken66);
        kenken66.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kenken66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kenken66ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelKenKenLayout = new javax.swing.GroupLayout(PanelKenKen);
        PanelKenKen.setLayout(PanelKenKenLayout);
        PanelKenKenLayout.setHorizontalGroup(
            PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKenKenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kenken61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken12, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken15, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken16, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelKenKenLayout.setVerticalGroup(
            PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKenKenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kenken11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kenken12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kenken13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken21, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken31, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken41, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken51, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(PanelKenKenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kenken61, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(kenken62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kenken66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BotonNum1.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum1);
        BotonNum1.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum1.setText("1");
        BotonNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum1ActionPerformed(evt);
            }
        });

        BotonNum2.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum2);
        BotonNum2.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum2.setText("2");
        BotonNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum2ActionPerformed(evt);
            }
        });

        BotonNum3.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum3);
        BotonNum3.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum3.setText("3");
        BotonNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum3ActionPerformed(evt);
            }
        });

        BotonNum4.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum4);
        BotonNum4.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum4.setText("4");
        BotonNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum4ActionPerformed(evt);
            }
        });

        BotonNum5.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum5);
        BotonNum5.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum5.setText("5");
        BotonNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum5ActionPerformed(evt);
            }
        });

        BotonNum6.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonNum6);
        BotonNum6.setForeground(new java.awt.Color(60, 63, 65));
        BotonNum6.setText("6");
        BotonNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNum6ActionPerformed(evt);
            }
        });

        BotonBorrador.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(BotonBorrador);
        BotonBorrador.setForeground(new java.awt.Color(60, 63, 65));
        BotonBorrador.setText("Borrar");
        BotonBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorradorActionPerformed(evt);
            }
        });

        botonNum1.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum1);
        botonNum1.setForeground(new java.awt.Color(60, 63, 65));
        botonNum1.setText("1");
        botonNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum1ActionPerformed(evt);
            }
        });

        botonNum4.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum4);
        botonNum4.setForeground(new java.awt.Color(60, 63, 65));
        botonNum4.setText("4");
        botonNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum4ActionPerformed(evt);
            }
        });

        botonNum2.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum2);
        botonNum2.setForeground(new java.awt.Color(60, 63, 65));
        botonNum2.setText("2");
        botonNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum2ActionPerformed(evt);
            }
        });

        botonNum3.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum3);
        botonNum3.setForeground(new java.awt.Color(60, 63, 65));
        botonNum3.setText("3");
        botonNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum3ActionPerformed(evt);
            }
        });

        botonNum5.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum5);
        botonNum5.setForeground(new java.awt.Color(60, 63, 65));
        botonNum5.setText("5");
        botonNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum5ActionPerformed(evt);
            }
        });

        botonNum6.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonNum6);
        botonNum6.setForeground(new java.awt.Color(60, 63, 65));
        botonNum6.setText("6");
        botonNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNum6ActionPerformed(evt);
            }
        });

        botonBorrador.setBackground(new java.awt.Color(153, 153, 255));
        grupoNumeros.add(botonBorrador);
        botonBorrador.setForeground(new java.awt.Color(60, 63, 65));
        botonBorrador.setText("Borrar");
        botonBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorradorActionPerformed(evt);
            }
        });

        botonAtras.setBackground(new java.awt.Color(153, 153, 255));
        botonAtras.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(60, 63, 65));
        botonAtras.setText("Retorno");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(botonNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(botonNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(botonNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(botonNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(botonBorrador))
                                .addGap(18, 18, 18)
                                .addComponent(PanelKenKen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PanelCrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonBorrador, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BotonNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(BotonNum5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BotonNum6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BotonNum4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(BotonNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(textoCrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonValidarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRehacerJugada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonDeshacerJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonReiniciarJuego, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(botonOtroJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoCrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonBorrador)
                            .addComponent(PanelKenKen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PanelCrono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonNum1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNum2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNum3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNum4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNum5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNum6)
                                .addGap(39, 39, 39)
                                .addComponent(BotonBorrador))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonNum1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNum2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNum3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNum4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNum5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNum6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDeshacerJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonOtroJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRehacerJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonValidarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 63, 65));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ken Ken");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pushDeshacer(String jugada){
        pilaDeshacerJugada.add(0, jugada);
    }

    private String popDeshacer(){
        String top = pilaDeshacerJugada.get(0);
        pilaDeshacerJugada.remove(0);
        return top;
    }
    
    private String topDeshacer(){
        String top = pilaDeshacerJugada.get(0);
        return top;
    }
    
    private void pushRehacer(String jugada){
        pilaRehacerJugada.add(0, jugada);
    }

    private String popRehacer(){
        String top = pilaRehacerJugada.get(0);
        pilaRehacerJugada.remove(0);
        return top;
    }
    
    private void botonDeshacerJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeshacerJugadaActionPerformed
        String top = popDeshacer();
        pushRehacer(top);
        botonRehacerJugada.setEnabled(true);
        String operacion = top.substring(0, 5);
        String coordenadas = top.substring(6, 8);
        if (operacion.equals("PONER")){
            if (this.pilaDeshacerJugada.size() > 1){
                String topAnterior = topDeshacer();
                String operacionAnterior = topAnterior.substring(0, 5);
                String coordenadasAnteriores = topAnterior.substring(6, 8);
                if (operacionAnterior.equals("PONER") && coordenadasAnteriores.equals(coordenadas)){
                    String x = coordenadas.substring(0, 1);
                    String y = coordenadas.substring(1);
                    int x1 = Integer.parseInt(x);
                    int y1 = Integer.parseInt(y);
                    String numero = topAnterior.substring(9);
                    char charNumero = numero.charAt(0);
                    listaBotones[x1][y1].setSelected(true);
                    activarNumeroBotonPilas(charNumero, x1, y1);
                    return;
                }
            }
            String x = coordenadas.substring(0, 1);
            String y = coordenadas.substring(1);
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            listaBotones[x1][y1].setSelected(true);
            activarNumeroBotonPilas(' ', x1, y1);
        }
        else{
            String x = coordenadas.substring(0, 1);
            String y = coordenadas.substring(1);
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            listaBotones[x1][y1].setSelected(true);
            String numero = top.substring(9);
            char charNumero = numero.charAt(0);
            activarNumeroBotonPilas(charNumero, x1, y1);
        }
        if (this.pilaDeshacerJugada.isEmpty()){
            botonDeshacerJugada.setEnabled(false);
        }
    }//GEN-LAST:event_botonDeshacerJugadaActionPerformed

    private void botonOtroJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOtroJuegoActionPerformed
        if (timer1.isRunning()){
            timer1.stop();
        }
        if (timer2 != null){
            if (timer2.isRunning()){timer2.stop();}
        }
        int verificacion = JOptionPane.showConfirmDialog(null, "¿Quieres reiniciar la partida?");
        if (verificacion == 0){
            boolean otraPartida = false;
            Partida mismaPartida = partida;
            while (!otraPartida){
                this.partida = this.elegirPartida();
                if (partida != mismaPartida){otraPartida = true;}
            }
            this.PaneHorasCrono.setText("0");
            this.PaneMinutosCrono.setText("0");
            this.PaneSegundosCrono.setText("0");
            if (Datos.getConfiguracion().getReloj()[0]){
                timer1.restart();
            }
            else if (Datos.getConfiguracion().getReloj()[1]){
                timer2.restart();
            }
            for (int i = 0; i < listaBotones.length; i++){
                for (int j = 0; j < listaBotones[i].length; j++){
                    listaResultados[i][j] = ' ';
                    listaBotones[i][j].setText("");
                    Jaula esCelda = new Jaula();
                    for (Jaula celda : partida.getCeldas()){
                        if (ubicacionEnLista(i+1, j+1, celda)){
                            esCelda = celda;
                            break;
                        } 
                        int[] listaCoordenadas = {i+1, j+1};
                    }
                    if (esCelda.getUbicaciones().get(0)[0] == i+1 && esCelda.getUbicaciones().get(0)[1] == j+1){
                            numeroPrincipal = esCelda.getNumeroResultado();
                            operador = esCelda.getOperando();
                            if (operador == "c"){
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + "</html>");
                            }
                            else{
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + operador + "</html>");
                            }
                        }
                    int arriba = 2;
                    int izquierda = 2;
                    int abajo = 2;
                    int derecha = 2;
                    if (ubicacionEnLista(i, j+1, esCelda)){
                        arriba = 0;
                    }
                    if (ubicacionEnLista(i+1, j, esCelda)){
                        izquierda = 0;
                    }
                    if (ubicacionEnLista(i+2, j+1, esCelda)){
                        abajo = 0;
                    }
                    if (ubicacionEnLista(i+1, j+2, esCelda)){
                        derecha = 0;
                    }
                    listaBotones[i][j].setBorder(BorderFactory.createMatteBorder(arriba, izquierda, abajo, derecha, Color.BLACK));
                }
            }
        }
    }//GEN-LAST:event_botonOtroJuegoActionPerformed

    private void botonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarJuegoActionPerformed
        botonIniciarJuego.setEnabled(false);
        botonReiniciarJuego.setEnabled(true);
        botonOtroJuego.setEnabled(true);
        botonValidarJuego.setEnabled(true);
        PanelKenKen.setVisible(true);
        if (Datos.getConfiguracion().getPosicionDelPanel()[1]){
            this.BotonBorrador.setVisible(true);
            this.BotonNum1.setVisible(true);
            this.BotonNum2.setVisible(true);
            this.BotonNum3.setVisible(true);
            this.BotonNum4.setVisible(true);
            this.BotonNum5.setVisible(true);
            this.BotonNum6.setVisible(true);
        }
        else{
            this.botonBorrador.setVisible(true);
            this.botonNum1.setVisible(true);
            this.botonNum2.setVisible(true);
            this.botonNum3.setVisible(true);
            this.botonNum4.setVisible(true);
            this.botonNum5.setVisible(true);
            this.botonNum6.setVisible(true);
        }
        if (Datos.getConfiguracion().getReloj()[0] == true){
            this.LabelHorasCrono.setVisible(true);
            this.LabelMinutosCrono.setVisible(true);
            this.LabelSegundosCrono.setVisible(true);
            this.PaneHorasCrono.setVisible(true);
            this.PaneMinutosCrono.setVisible(true);
            this.PaneSegundosCrono.setVisible(true);
            this.PanelCrono.setVisible(true);
            this.textoCrono.setVisible(true);
            textoCrono.setText("Cronometro");
            PaneHorasCrono.setText("0");
            PaneMinutosCrono.setText("0");
            PaneSegundosCrono.setText("0");
            timer1.start();
        }
        else if (Datos.getConfiguracion().getReloj()[1] == true){
            this.LabelHorasCrono.setVisible(true);
            this.LabelMinutosCrono.setVisible(true);
            this.LabelSegundosCrono.setVisible(true);
            this.PaneHorasCrono.setVisible(true);
            this.PaneMinutosCrono.setVisible(true);
            this.PaneSegundosCrono.setVisible(true);
            this.PanelCrono.setVisible(true);
            this.textoCrono.setVisible(true);
            textoCrono.setText("Timer");
            PaneHorasCrono.setText(Datos.getTimer().getHoras()+"");
            PaneMinutosCrono.setText(Datos.getTimer().getMinutos()+"");
            PaneSegundosCrono.setText(Datos.getTimer().getSegundos()+"");
            inicializarTimer2();
            timer2.start();
        }
    }//GEN-LAST:event_botonIniciarJuegoActionPerformed

    
    private void botonTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarJuegoActionPerformed
        boolean cronometro = false;
        boolean timer = false;
        if (timer1.isRunning()){
            cronometro = true;
            timer1.stop();
        }
        else if (timer2 != null){
            if (timer2.isRunning()){
                timer = true;
                timer2.stop();
            }
        }
        int verificacion = JOptionPane.showConfirmDialog(null, "¿Quieres terminar la partida?");
        if (verificacion == 0){
            VentanaInicio menu = new VentanaInicio();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            this.setVisible(false);
            this.dispose();
        }
        else{
            if (cronometro == true){
                timer1.start();
            }
            else if (timer == true){
                timer2.start();
            }
        }
    }//GEN-LAST:event_botonTerminarJuegoActionPerformed

    private void activarBotones(){
        BotonBorrador.setSelected(false);
        BotonNum1.setSelected(false);
        BotonNum2.setSelected(false);
        BotonNum3.setSelected(false);
        BotonNum4.setSelected(false);
        BotonNum5.setSelected(false);
        BotonNum6.setSelected(false);
        botonBorrador.setSelected(false);
        botonNum1.setSelected(false);
        botonNum2.setSelected(false);
        botonNum3.setSelected(false);
        botonNum4.setSelected(false);
        botonNum5.setSelected(false);
        botonNum6.setSelected(false);
        for (JToggleButton[] fila : listaBotones) {
            for (JToggleButton boton : fila) {
                boton.setBackground(Color.white);
            }
        }
    }
    private void kenken33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken33ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken33ActionPerformed

    private void kenken54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken54ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken54ActionPerformed

    private void kenken11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken11ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken11ActionPerformed

    private void kenken12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken12ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken12ActionPerformed

    private void kenken13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken13ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken13ActionPerformed

    private void kenken14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken14ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken14ActionPerformed

    private void kenken15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken15ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken15ActionPerformed

    private void kenken16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken16ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken16ActionPerformed

    private void kenken21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken21ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken21ActionPerformed

    private void kenken22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken22ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken22ActionPerformed

    private void kenken23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken23ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken23ActionPerformed

    private void kenken24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken24ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken24ActionPerformed

    private void kenken25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken25ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken25ActionPerformed

    private void kenken26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken26ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken26ActionPerformed

    private void kenken31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken31ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken31ActionPerformed

    private void kenken32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken32ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken32ActionPerformed

    private void kenken34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken34ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken34ActionPerformed

    private void kenken35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken35ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken35ActionPerformed

    private void kenken36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken36ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken36ActionPerformed

    private void kenken41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken41ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken41ActionPerformed

    private void kenken42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken42ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken42ActionPerformed

    private void kenken43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken43ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken43ActionPerformed

    private void kenken44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken44ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken44ActionPerformed

    private void kenken45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken45ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken45ActionPerformed

    private void kenken46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken46ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken46ActionPerformed

    private void kenken51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken51ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken51ActionPerformed

    private void kenken52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken52ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken52ActionPerformed

    private void kenken53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken53ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken53ActionPerformed

    private void kenken55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken55ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken55ActionPerformed

    private void kenken56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken56ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken56ActionPerformed

    private void kenken61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken61ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken61ActionPerformed

    private void kenken62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken62ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken62ActionPerformed

    private void kenken63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken63ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken63ActionPerformed

    private void kenken64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken64ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken64ActionPerformed

    private void kenken65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken65ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken65ActionPerformed

    private void kenken66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kenken66ActionPerformed
        activarBotones();
    }//GEN-LAST:event_kenken66ActionPerformed
    private boolean esSeleccionado(){
        boolean esSeleccionado = false;
        for (javax.swing.JToggleButton[] fila : listaBotones){
            for (javax.swing.JToggleButton boton : fila){
                if (boton.isSelected()){esSeleccionado = true;break;}
            }
            if (esSeleccionado){break;}
        }
        return esSeleccionado;
    }
    
    private void activarNumeroBoton(char numeroBoton){
        if (!esSeleccionado()){
            JOptionPane.showMessageDialog(null, "Seleccione una casilla");
        }
        botonRehacerJugada.setEnabled(false);
        this.pilaRehacerJugada.clear();
        int x = 0;
        int y = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                listaBotones[i][j].setBackground(Color.white);
                if (this.listaBotones[i][j].isSelected()){
                    x = i;
                    y = j;
                    Jaula esCelda = new Jaula();
                    for (Jaula celda : partida.getCeldas()){
                        if (ubicacionEnLista(i+1, j+1, celda)){
                            esCelda = celda;
                            break;
                        } 
                    }
                    if (esCelda.getUbicaciones().get(0)[0] == i+1 && esCelda.getUbicaciones().get(0)[1] == j+1){
                        numeroPrincipal = esCelda.getNumeroResultado();
                        operador = esCelda.getOperando();
                        if (operador == "c"){
                            if (numeroBoton == ' '){
                                String accion = "QUITA_" + i + j + "_" +listaResultados[i][j];
                                this.pushDeshacer(accion);
                                this.botonDeshacerJugada.setEnabled(true);
                                
                            }
                            else{
                                String accion = "PONER_" + i + j + "_" + numeroBoton;
                                this.pushDeshacer(accion);
                                this.botonDeshacerJugada.setEnabled(true);
                            }
                            listaResultados[i][j] = numeroBoton;
                            listaBotones[i][j].setText("<html><center>" + numeroPrincipal
                                    + "<p>"+ numeroBoton +"</p>" +"</html>");
                        }
                        else{
                            if (numeroBoton == ' '){
                                String accion = "QUITA_" + i + j + "_" + listaResultados[i][j];
                                this.pushDeshacer(accion);
                                this.botonDeshacerJugada.setEnabled(true);
                            }
                            else {
                                String accion = "PONER_" + i + j + "_" + numeroBoton;
                                this.pushDeshacer(accion);
                                this.botonDeshacerJugada.setEnabled(true);
                            }
                            listaResultados[i][j] = numeroBoton;
                            listaBotones[i][j].setText("<html><center>" + numeroPrincipal + operador + "<p>"+ numeroBoton +"</p>" +"</html>");
                        }
                    }
                    else{
                        if (numeroBoton == ' '){
                            String accion = "QUITA_" + i + j + "_" +listaResultados[i][j];
                            this.pushDeshacer(accion);
                            this.botonDeshacerJugada.setEnabled(true);
                        }
                        else {
                            String accion = "PONER_" + i + j + "_" + numeroBoton;
                            this.pushDeshacer(accion);
                            this.botonDeshacerJugada.setEnabled(true);
                        }
                        this.listaResultados[i][j] = numeroBoton;
                        listaBotones[i][j].setText("<html><center><br><p>"+ numeroBoton +"</p></html>");
                    }
                }
            }
            if (x != 0 || y != 0) {break;}
        }
    }

    private void activarNumeroBotonPilas(char numeroBoton, int x, int y){
        for (javax.swing.JToggleButton[] fila : listaBotones){
            for (javax.swing.JToggleButton boton : fila){
                boton.setBackground(Color.white);
            }
        }
            Jaula esCelda = new Jaula();
            for (Jaula celda : partida.getCeldas()){
                if (ubicacionEnLista(x+1, y+1, celda)){
                    esCelda = celda;
                    break;
                } 
            }
            if (esCelda.getUbicaciones().get(0)[0] == x+1 && esCelda.getUbicaciones().get(0)[1] == y+1){
                numeroPrincipal = esCelda.getNumeroResultado();
                operador = esCelda.getOperando();
                if ("c".equals(operador)){
                    listaResultados[x][y] = numeroBoton;
                    listaBotones[x][y].setText("<html><center>" + numeroPrincipal + "<p>"+ numeroBoton +"</p>" +"</html>");
                    }
                else {
                    listaResultados[x][y] = numeroBoton;
                    listaBotones[x][y].setText("<html><center>" + numeroPrincipal + operador 
                            + "<p>"+ numeroBoton +"</p>" +"</html>");
                }
            }
            else{
                listaResultados[x][y] = numeroBoton;
                listaBotones[x][y].setText("<html><center><br><p>"+ numeroBoton +"</p></html>");
            }
    }
    
    private void BotonNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum2ActionPerformed
        activarNumeroBoton('2');
    }//GEN-LAST:event_BotonNum2ActionPerformed

    private void BotonNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum3ActionPerformed
        activarNumeroBoton('3');
    }//GEN-LAST:event_BotonNum3ActionPerformed

    private void BotonNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum4ActionPerformed
        activarNumeroBoton('4');
    }//GEN-LAST:event_BotonNum4ActionPerformed

    private void BotonNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum5ActionPerformed
        activarNumeroBoton('5');
    }//GEN-LAST:event_BotonNum5ActionPerformed

    private void BotonNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum6ActionPerformed
        activarNumeroBoton('6');
    }//GEN-LAST:event_BotonNum6ActionPerformed

    private void BotonBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorradorActionPerformed
        activarNumeroBoton(' ');
    }//GEN-LAST:event_BotonBorradorActionPerformed

    private void botonRehacerJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRehacerJugadaActionPerformed
        String top = popRehacer();
        pushDeshacer(top);
        if (!this.botonDeshacerJugada.isEnabled()){
            botonDeshacerJugada.setEnabled(true);
        }
        String operacion = top.substring(0, 5);
        String coordenadas = top.substring(6, 8);
        if (operacion.equals("QUITA")){
            String x = coordenadas.substring(0, 1);
            String y = coordenadas.substring(1);
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            listaBotones[x1][y1].setSelected(true);
            activarNumeroBotonPilas(' ', x1, y1);
        }
        else{
            String x = coordenadas.substring(0, 1);
            String y = coordenadas.substring(1);
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            listaBotones[x1][y1].setSelected(true);
            String numero = top.substring(9);
            char charNumero = numero.charAt(0);
            activarNumeroBotonPilas(charNumero, x1, y1);
        }
        if (this.pilaRehacerJugada.isEmpty()){
            botonRehacerJugada.setEnabled(false);
        }
    }//GEN-LAST:event_botonRehacerJugadaActionPerformed

    private void botonReiniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarJuegoActionPerformed
        if (timer1.isRunning()){timer1.stop();}
        if (timer2 != null){
            if (timer2.isRunning()){timer2.stop();}
        }
        int verificacion = JOptionPane.showConfirmDialog(null, "Seguro que quieres reiniciar la partida?");
        if (verificacion == 0){
            this.PaneHorasCrono.setText("0");
            this.PaneMinutosCrono.setText("0");
            this.PaneSegundosCrono.setText("0");
            if (Datos.getConfiguracion().getReloj()[0]){
                timer1.restart();
            }
            else if (Datos.getConfiguracion().getReloj()[1]){
                timer2.restart();
            }
            for (int i = 0; i < listaBotones.length; i++){
                for (int j = 0; j < listaBotones[i].length; j++){
                    listaResultados[i][j] = ' ';
                    listaBotones[i][j].setText("");
                    Jaula esCelda = new Jaula();
                    for (Jaula celda : partida.getCeldas()){
                        if (ubicacionEnLista(i+1, j+1, celda)){
                            esCelda = celda;
                            break;
                        }
                        int[] listaCoordenadas = {i+1, j+1};
                    }
                    if (esCelda.getUbicaciones().get(0)[0] == i+1 && esCelda.getUbicaciones().get(0)[1] == j+1){
                            numeroPrincipal = esCelda.getNumeroResultado();
                            operador = esCelda.getOperando();
                            if (operador == "c"){
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + "</html>");
                            }
                            else{
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + operador + "</html>");
                            }
                        }
                    int arriba = 2;
                    int izquierda = 2;
                    int abajo = 2;
                    int derecha = 2;
                    if (ubicacionEnLista(i, j+1, esCelda)){
                        arriba = 0;
                    }
                    if (ubicacionEnLista(i+1, j, esCelda)){
                        izquierda = 0;
                    }
                    if (ubicacionEnLista(i+2, j+1, esCelda)){
                        abajo = 0;
                    }
                    if (ubicacionEnLista(i+1, j+2, esCelda)){
                        derecha = 0;
                    }
                    listaBotones[i][j].setBorder(BorderFactory.createMatteBorder(arriba, izquierda, abajo, derecha, Color.BLACK));
                }
            }
        }
    }//GEN-LAST:event_botonReiniciarJuegoActionPerformed
    private boolean validarFila(int x, int y){
        for (int i = 0; i < listaBotones.length; i++){
            if (listaBotones[x][i] == listaBotones[x][y]){continue;}
            if (listaResultados[x][i] == listaResultados[x][y]){return false;}
        }
        return true;
    }

    private boolean validarColumna(int x, int y){
        for (int j = 0; j < listaBotones.length; j++){
            if (listaBotones[j][y] == listaBotones[x][y]){continue;}
            if (listaResultados[j][y] == listaResultados[x][y]){return false;}
        }
        return true;
    }

    private Jaula cualCelda(int x, int y){
        Jaula esCelda = new Jaula();
        for (Jaula celda : partida.getCeldas()){
            if (ubicacionEnLista(x+1, y+1, celda)){
                esCelda = celda;
                break;
            }
        }
        return esCelda;
    }

    private int calcularCeldaSuma(Jaula celda){
        int suma = 0;
        for (int[] coordenadas : celda.getUbicaciones()){
            int x = coordenadas[0];
            int y = coordenadas[1];
            
            char numeroChar = listaResultados[x-1][y-1];
            if (numeroChar == ' '){numeroChar = '0';}
            
            int numero = Character.getNumericValue(numeroChar);
            suma += numero;
        }
        return suma;
    }
    
    private int calcularCeldaMult(Jaula celda){
        int multiplicacion = 1;
        for (int[] coordenadas : celda.getUbicaciones()){
            int x = coordenadas[0];
            int y = coordenadas[1];
            
            char numeroChar = listaResultados[x-1][y-1];
            if (numeroChar == ' '){numeroChar = '1';}
            
            int numero = Character.getNumericValue(numeroChar);
            multiplicacion *= numero;
        }
        return multiplicacion;
    }

    private int calcularCeldaDiv1(Jaula celda){
        double nominador;
        double denominador;
        double resultado;
        int x1 = celda.getUbicaciones().get(0)[0];
        int y1 = celda.getUbicaciones().get(0)[1];
        int x2 = celda.getUbicaciones().get(1)[0];
        int y2 = celda.getUbicaciones().get(1)[1];
        nominador = Character.getNumericValue(listaResultados[x1-1][y1-1]);
        denominador = Character.getNumericValue(listaResultados[x2-1][y2-1]);
        resultado = (double) (nominador / denominador);
        if (resultado % 1 == 0){
            return (int)resultado;
        }
        else {
            return -1;
        }
    }
    
    private int calcularCeldaDiv2(Jaula celda){
        double nominador;
        double denominador;
        double resultado;
        int x1 = celda.getUbicaciones().get(0)[0];
        int y1 = celda.getUbicaciones().get(0)[1];
        int x2 = celda.getUbicaciones().get(1)[0];
        int y2 = celda.getUbicaciones().get(1)[1];
        nominador = Character.getNumericValue(listaResultados[x2-1][y2-1]);
        denominador = Character.getNumericValue(listaResultados[x1-1][y1-1]);
        resultado = (double) (nominador / denominador);
        if (resultado % 1 == 0){
            return (int)resultado;
        }
        else {
            return -1;
        }
    }

    private boolean validarDivision(Jaula celda){
        int resultado1 = calcularCeldaDiv1(celda);
        int resultado2 = calcularCeldaDiv2(celda);
        return resultado1 == celda.getNumeroResultado() || resultado2 == celda.getNumeroResultado();
    }

    private boolean validarResta(Jaula celda){
        int resultado1 = calcularResta1(celda);
        int resultado2 = calcularResta2(celda);
        return resultado1 == celda.getNumeroResultado() || resultado2 == celda.getNumeroResultado();
    }

    private int calcularResta1(Jaula celda){
        int x1 = celda.getUbicaciones().get(0)[0];
        int y1 = celda.getUbicaciones().get(0)[1];
        int x2 = celda.getUbicaciones().get(1)[0];
        int y2 = celda.getUbicaciones().get(1)[1];
        int num1 = Character.getNumericValue(listaResultados[x1 - 1][y1 - 1]);
        int num2 = Character.getNumericValue(listaResultados[x2 - 1][y2 - 1]);
        int resultado = num1 - num2;
        return resultado;
    }
    
    private int calcularResta2(Jaula celda){
        int x1 = celda.getUbicaciones().get(0)[0];
        int y1 = celda.getUbicaciones().get(0)[1];
        int x2 = celda.getUbicaciones().get(1)[0];
        int y2 = celda.getUbicaciones().get(1)[1];
        int num1 = Character.getNumericValue(listaResultados[x2 - 1][y2 - 1]);
        int num2 = Character.getNumericValue(listaResultados[x1 - 1][y1 - 1]);
        int resultado = num1 - num2;
        return resultado;
    }

    private boolean validarSumaConVacio(Jaula celda){
        boolean esValido = true;
        if (calcularCeldaSuma(celda) >= celda.getNumeroResultado()){esValido = false;}
        return esValido;
    }

    private boolean validarSumaSinVacio(Jaula celda){
        boolean esValido = true;
        if (calcularCeldaSuma(celda) != celda.getNumeroResultado()){
            esValido = false;
        }
        return esValido;
    }
    
    private boolean validarMultConVacio(Jaula celda){
        boolean esValido = true;
        if (calcularCeldaMult(celda) > celda.getNumeroResultado()){
            esValido = false;
        }
        return esValido;
    }

    private boolean validarMultSinVacio(Jaula celda){
        boolean esValido = true;
        if (calcularCeldaMult(celda) != celda.getNumeroResultado()){esValido = false;}
        
        return esValido;
    }

    private boolean validarVacio(Jaula celda){
        boolean hayVacio = false;
        for (int[] coordenada : celda.getUbicaciones()){
            int x = coordenada[0];
            int y = coordenada[1];
            if (listaResultados[x-1][y-1] == ' '){
                hayVacio = true;
                break;
            }
        }
        return hayVacio;
    }

    private boolean validarBotonesVerde(){
        boolean esVerde = true;
        for (javax.swing.JToggleButton[] fila : listaBotones){
            for (javax.swing.JToggleButton boton : fila){
                if (!boton.getBackground().equals(Color.green)){esVerde = false;}
            }
        }
        return esVerde;
    }

    private boolean validarBotonesRojo(){
        boolean esRojo = false;
        for (javax.swing.JToggleButton[] fila : listaBotones){
            for (javax.swing.JToggleButton boton : fila){
                if (boton.getBackground().equals(Color.red)){esRojo = true;}
            }
        }
        return esRojo;
    }
    
    private void esconderBotones(){
        this.PanelKenKen.setVisible(false);
        this.BotonBorrador.setVisible(false);
        this.BotonNum1.setVisible(false);
        this.BotonNum2.setVisible(false);
        this.BotonNum3.setVisible(false);
        this.BotonNum4.setVisible(false);
        this.BotonNum5.setVisible(false);
        this.BotonNum6.setVisible(false);
        this.botonBorrador.setVisible(false);
        this.botonNum1.setVisible(false);
        this.botonNum2.setVisible(false);
        this.botonNum3.setVisible(false);
        this.botonNum4.setVisible(false);
        this.botonNum5.setVisible(false);
        this.botonNum6.setVisible(false);
        this.textoCrono.setVisible(false);
        this.PanelCrono.setVisible(false);
    }
    
    private void botonValidarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonValidarJuegoActionPerformed
        for (int i = 0; i < listaBotones.length; i++){
            for (int j = 0; j < listaBotones[i].length; j++){
                if (this.listaResultados[i][j] == ' '){
                    continue;
                }
                if (!validarFila(i, j)){
                    listaBotones[i][j].setBackground(Color.red);
                    continue;
                }
                if (!validarColumna(i, j)){
                    listaBotones[i][j].setBackground(Color.red);
                    continue;
                }
                Jaula celda = cualCelda(i, j);
                if (celda.getOperando().equals("c")){
                    int resultadoActual = Character.getNumericValue(listaResultados[i][j]);
                    if (resultadoActual != celda.getNumeroResultado()){
                        listaBotones[i][j].setBackground(Color.red);
                        continue;}
                }
                if (validarVacio(celda)){
                    if (celda.getOperando().equals("+")){
                        if (!validarSumaConVacio(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;}
                    }
                    else if (celda.getOperando().equals("x")){
                        if (!validarMultConVacio(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;
                        }
                    } 
                }
                else{
                    if (celda.getOperando().equals("+")){
                        if (!validarSumaSinVacio(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;
                        }
                    }
                    else if (celda.getOperando().equals("x")){
                        if (!validarMultSinVacio(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;
                        }
                    }
                    else if (celda.getOperando().equals("-")){
                        if (!validarResta(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;
                        }
                    }
                    else if (celda.getOperando().equals("/")){
                        if (!validarDivision(celda)){
                            listaBotones[i][j].setBackground(Color.red);
                            continue;
                        }
                    }
                }
                listaBotones[i][j].setBackground(Color.green);
            }
        }
        boolean juegoTerminado = validarBotonesVerde();
        boolean juegoConErrores = validarBotonesRojo();
        if (juegoTerminado){
            if (Datos.getConfiguracion().getSonidoFinal()[0]){
                try {
                    File archivoSonido = new File("sonidos/sonidoVictoria.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivoSonido);
                    Clip sonido = AudioSystem.getClip();
                    sonido.open(audioIn);
                    sonido.start();
                }
                catch (IOException | LineUnavailableException | UnsupportedAudioFileException e){
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Has ganado el juego", "Juego", JOptionPane.INFORMATION_MESSAGE);
            esconderBotones();
            partida = elegirPartida();
            this.PaneHorasCrono.setText("0");
            this.PaneMinutosCrono.setText("0");
            this.PaneSegundosCrono.setText("0");
            for (int i = 0; i < listaBotones.length; i++){
                for (int j = 0; j < listaBotones[i].length; j++){
                    listaResultados[i][j] = ' ';
                    listaBotones[i][j].setText("");
                    Jaula esCelda = new Jaula();
                    for (Jaula celda : partida.getCeldas()){
                        if (ubicacionEnLista(i+1, j+1, celda)){
                            esCelda = celda;
                            break;
                        } 
                        int[] listaCoordenadas = {i+1, j+1};
                    }
                    if (esCelda.getUbicaciones().get(0)[0] == i+1 && esCelda.getUbicaciones().get(0)[1] == j+1){
                            numeroPrincipal = esCelda.getNumeroResultado();
                            operador = esCelda.getOperando();
                            if (operador == "c"){
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + "</html>");
                            }
                            else{
                                listaBotones[i][j].setText("<html><center>" + numeroPrincipal + operador + "</html>");
                            }
                        }
                    int arriba = 2;
                    int izquierda = 2;
                    int abajo = 2;
                    int derecha = 2;
                    if (ubicacionEnLista(i, j+1, esCelda)){
                        arriba = 0;
                    }
                    if (ubicacionEnLista(i+1, j, esCelda)){
                        izquierda = 0;
                    }
                    if (ubicacionEnLista(i+2, j+1, esCelda)){
                        abajo = 0;
                    }
                    if (ubicacionEnLista(i+1, j+2, esCelda)){
                        derecha = 0;
                    }
                    listaBotones[i][j].setBorder(BorderFactory.createMatteBorder(arriba, izquierda, abajo, derecha, Color.BLACK));
                }
                if (timer1.isRunning()){
                    timer1.stop();
                }
                if (timer2 != null){
                    timer2.stop();
                }
                this.botonIniciarJuego.setEnabled(true);
                this.botonDeshacerJugada.setEnabled(false);
                this.botonRehacerJugada.setEnabled(false);
                this.botonValidarJuego.setEnabled(false);
                this.botonOtroJuego.setEnabled(false);
                this.botonReiniciarJuego.setEnabled(false);
            }
            for (javax.swing.JToggleButton[] fila : listaBotones){
                for (javax.swing.JToggleButton boton: fila){
                    boton.setBackground(Color.white);
                }
            }
        }
        else if (juegoConErrores){
            JOptionPane.showMessageDialog(null, "Juego incorrecto", "Juego", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonValidarJuegoActionPerformed

    private void botonNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum1ActionPerformed
        activarNumeroBoton('1');
    }//GEN-LAST:event_botonNum1ActionPerformed

    private void botonNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum4ActionPerformed
        activarNumeroBoton('4');
    }//GEN-LAST:event_botonNum4ActionPerformed

    private void botonNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum2ActionPerformed
        activarNumeroBoton('2');
    }//GEN-LAST:event_botonNum2ActionPerformed

    private void botonNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum3ActionPerformed
        activarNumeroBoton('3');
    }//GEN-LAST:event_botonNum3ActionPerformed

    private void botonNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum5ActionPerformed
        activarNumeroBoton('5');
    }//GEN-LAST:event_botonNum5ActionPerformed

    private void botonNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNum6ActionPerformed
        activarNumeroBoton('6');
    }//GEN-LAST:event_botonNum6ActionPerformed

    private void botonBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorradorActionPerformed
        activarNumeroBoton(' ');
    }//GEN-LAST:event_botonBorradorActionPerformed

    private void BotonNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNum1ActionPerformed
        activarNumeroBoton('1');
    }//GEN-LAST:event_BotonNum1ActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        VentanaInicio menu = new VentanaInicio();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonBorrador;
    private javax.swing.JToggleButton BotonNum1;
    private javax.swing.JToggleButton BotonNum2;
    private javax.swing.JToggleButton BotonNum3;
    private javax.swing.JToggleButton BotonNum4;
    private javax.swing.JToggleButton BotonNum5;
    private javax.swing.JToggleButton BotonNum6;
    private javax.swing.JLabel LabelHorasCrono;
    private javax.swing.JLabel LabelMinutosCrono;
    private javax.swing.JLabel LabelSegundosCrono;
    private javax.swing.JTextPane PaneHorasCrono;
    private javax.swing.JTextPane PaneMinutosCrono;
    private javax.swing.JTextPane PaneSegundosCrono;
    private javax.swing.JPanel PanelCrono;
    private javax.swing.JPanel PanelKenKen;
    private javax.swing.JButton botonAtras;
    private javax.swing.JToggleButton botonBorrador;
    private javax.swing.JButton botonDeshacerJugada;
    private javax.swing.JButton botonIniciarJuego;
    private javax.swing.JToggleButton botonNum1;
    private javax.swing.JToggleButton botonNum2;
    private javax.swing.JToggleButton botonNum3;
    private javax.swing.JToggleButton botonNum4;
    private javax.swing.JToggleButton botonNum5;
    private javax.swing.JToggleButton botonNum6;
    private javax.swing.JButton botonOtroJuego;
    private javax.swing.JButton botonRehacerJugada;
    private javax.swing.JButton botonReiniciarJuego;
    private javax.swing.JButton botonTerminarJuego;
    private javax.swing.JButton botonValidarJuego;
    private javax.swing.ButtonGroup grupoKenKen;
    private javax.swing.ButtonGroup grupoNumeros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton kenken11;
    private javax.swing.JToggleButton kenken12;
    private javax.swing.JToggleButton kenken13;
    private javax.swing.JToggleButton kenken14;
    private javax.swing.JToggleButton kenken15;
    private javax.swing.JToggleButton kenken16;
    private javax.swing.JToggleButton kenken21;
    private javax.swing.JToggleButton kenken22;
    private javax.swing.JToggleButton kenken23;
    private javax.swing.JToggleButton kenken24;
    private javax.swing.JToggleButton kenken25;
    private javax.swing.JToggleButton kenken26;
    private javax.swing.JToggleButton kenken31;
    private javax.swing.JToggleButton kenken32;
    private javax.swing.JToggleButton kenken33;
    private javax.swing.JToggleButton kenken34;
    private javax.swing.JToggleButton kenken35;
    private javax.swing.JToggleButton kenken36;
    private javax.swing.JToggleButton kenken41;
    private javax.swing.JToggleButton kenken42;
    private javax.swing.JToggleButton kenken43;
    private javax.swing.JToggleButton kenken44;
    private javax.swing.JToggleButton kenken45;
    private javax.swing.JToggleButton kenken46;
    private javax.swing.JToggleButton kenken51;
    private javax.swing.JToggleButton kenken52;
    private javax.swing.JToggleButton kenken53;
    private javax.swing.JToggleButton kenken54;
    private javax.swing.JToggleButton kenken55;
    private javax.swing.JToggleButton kenken56;
    private javax.swing.JToggleButton kenken61;
    private javax.swing.JToggleButton kenken62;
    private javax.swing.JToggleButton kenken63;
    private javax.swing.JToggleButton kenken64;
    private javax.swing.JToggleButton kenken65;
    private javax.swing.JToggleButton kenken66;
    private java.awt.Label textoCrono;
    // End of variables declaration//GEN-END:variables
}