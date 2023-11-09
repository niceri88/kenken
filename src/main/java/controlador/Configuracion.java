package controlador;

/**
 * La clase Configuracion representa la configuración del juego, incluyendo opciones como dificultad, reloj,
 * posición del panel y sonido final.
 */
public class Configuracion {

    private boolean[] dificultad;
    private boolean[] reloj;
    private boolean[] posicionDelPanel;
    private boolean[] sonidoFinal;

    /**
     * Constructor por defecto que inicializa los arrays de configuración con valores predeterminados.
     */
    public Configuracion(){
        dificultad = new boolean[3];
        reloj = new boolean[3];
        posicionDelPanel = new boolean[2];
        sonidoFinal = new boolean[2];
        dificultad[0] = true;
        dificultad[1] = false;
        dificultad[2] = false;
        reloj[0] = true;
        reloj[1] = false;
        reloj[2] = false;
        posicionDelPanel[0] = true;
        posicionDelPanel[1] = false;
        sonidoFinal[0] = true;
        sonidoFinal[1] = false;
    }

    /**
     * Establece la configuración de dificultad.
     *
     * @param dificultad Un array de booleanos representando las opciones de dificultad.
     */
    public void setDificultad(boolean[] dificultad){
        this.dificultad = dificultad;
    }

    /**
     * Establece la configuración de reloj.
     *
     * @param reloj Un array de booleanos representando las opciones de reloj.
     */
    public void setReloj(boolean[] reloj){
        this.reloj = reloj;
    }

    /**
     * Establece la configuración de la posición del panel.
     *
     * @param posicionDelPanel Un array de booleanos representando las opciones de posición del panel.
     */
    public void setPosicionDelPanel(boolean[] posicionDelPanel){
        this.posicionDelPanel = posicionDelPanel;
    }

    /**
     * Establece la configuración del sonido final.
     *
     * @param sonidoFinal Un array de booleanos representando las opciones de sonido final.
     */
    public void setSonidoFinal(boolean[] sonidoFinal){
        this.sonidoFinal = sonidoFinal;
    }
    
    /**
     * Obtiene la configuración de dificultad.
     *
     * @return Un array de booleanos representando las opciones de dificultad.
     */
    public boolean[] getDificultad(){
        return dificultad;
    }

    /**
     * Obtiene la configuración de reloj.
     *
     * @return Un array de booleanos representando las opciones de reloj.
     */
    public boolean[] getReloj(){
        return reloj;
    }

    /**
     * Obtiene la configuración de la posición del panel.
     *
     * @return Un array de booleanos representando las opciones de posición del panel.
     */
    public boolean[] getPosicionDelPanel(){
        return posicionDelPanel;
    }
    
    /**
     * Obtiene la configuración de la posición del panel.
     *
     * @return Un array de booleanos representando las opciones de posición del panel.
     */
    public boolean[] getSonidoFinal(){
        return sonidoFinal;
    }

    /**
     * Establece la configuración de dificultad basada en un índice.
     *
     * @param indice El índice de la opción de dificultad a seleccionar.
     */
    public void setDificultadPorIndice(int indice){
        for (int i = 0; i < 3; i++){
            if (i == indice){
                dificultad[i] = true;
                continue;
            }
            dificultad[i] = false;
        }
    }

    /**
     * Establece la configuración de reloj basada en un índice.
     *
     * @param indice El índice de la opción de reloj a seleccionar.
     */
    public void setRelojPorIndice(int indice){
        for (int i = 0; i < 3; i++){
            if (i == indice){
                reloj[i] = true;
                continue;
            }
            reloj[i] = false;
        }
    }

    /**
     * Establece la configuración de la posición del panel basada en un índice.
     *
     * @param indice El índice de la opción de posición del panel a seleccionar.
     */
    public void setPosicionDelPanelPorIndice(int indice){
        for (int i = 0; i < 2; i++){
            if (i == indice){
                posicionDelPanel[i] = true;
                continue;
            }
            posicionDelPanel[i] = false;
        }
    }

    /**
     * Establece la configuración del sonido final basada en un índice.
     *
     * @param indice El índice de la opción de sonido final a seleccionar.
     */
    public void setSonidoFinalPorIndice(int indice){
        for (int i = 0; i < 2; i++){
            if (i == indice){
                sonidoFinal[i] = true;
                continue;
            }
            sonidoFinal[i] = false;
        }
    }
    
}