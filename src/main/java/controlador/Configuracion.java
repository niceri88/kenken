package controlador;

public class Configuracion {

    private boolean[] dificultad;
    private boolean[] reloj;
    private boolean[] posicionDelPanel;
    private boolean[] sonidoFinal;
    
    //Constructor
    /**
     * Constructor que inicializa por default las listas en un valor especifico.
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

    public void setDificultad(boolean[] dificultad){
        this.dificultad = dificultad;
    }

    public void setReloj(boolean[] reloj){
        this.reloj = reloj;
    }

    public void setPosicionDelPanel(boolean[] posicionDelPanel){
        this.posicionDelPanel = posicionDelPanel;
    }

    public void setSonidoFinal(boolean[] sonidoFinal){
        this.sonidoFinal = sonidoFinal;
    }
    
    public boolean[] getDificultad(){
        return dificultad;
    }

    public boolean[] getReloj(){
        return reloj;
    }

    public boolean[] getPosicionDelPanel(){
        return posicionDelPanel;
    }
    
    public boolean[] getSonidoFinal(){
        return sonidoFinal;
    }

    public void setDificultadPorIndice(int indice){
        for (int i = 0; i < 3; i++){
            if (i == indice){
                dificultad[i] = true;
                continue;
            }
            dificultad[i] = false;
        }
    }

    public void setRelojPorIndice(int indice){
        for (int i = 0; i < 3; i++){
            if (i == indice){
                reloj[i] = true;
                continue;
            }
            reloj[i] = false;
        }
    }

    public void setPosicionDelPanelPorIndice(int indice){
        for (int i = 0; i < 2; i++){
            if (i == indice){
                posicionDelPanel[i] = true;
                continue;
            }
            posicionDelPanel[i] = false;
        }
    }

    public void setSonidoFinalPorIndice(int indice){
        for (int i = 0; i < 2; i++){
            if (i == indice){
                sonidoFinal[i] = true;
                continue;
            }
            sonidoFinal[i] = false;
        }
    }
    
    public void desplegarDificultad(){
        for (int i = 0; i < 3; i++){
            System.out.println(dificultad[i]);
        }
    }
}
