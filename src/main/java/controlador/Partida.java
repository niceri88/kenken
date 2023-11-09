package controlador;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Partida representa una partida del juego, que contiene información sobre la dificultad y una lista de celdas (jaulas) en el tablero.
 */
public class Partida {
    private String dificultad;
    private List<Jaula> celdas = new ArrayList<>();

    /**
     * Establece la dificultad de la partida.
     *
     * @param nDificultad La dificultad de la partida.
     */
    public void setDificultad(String nDificultad){
        dificultad = nDificultad;
    }

    /**
     * Obtiene la dificultad de la partida.
     *
     * @return La dificultad de la partida.
     */
    public String getDificultad(){
        return dificultad;
    }

    /**
     * Obtiene la lista de celdas (jaulas) en la partida.
     *
     * @return Una lista de objetos Jaula representando las celdas en el tablero.
     */
    public List<Jaula> getCeldas(){
        return celdas;
    }

    /**
     * Agrega una celda (jaula) a la partida.
     *
     * @param celda La celda (jaula) que se va a agregar a la partida.
     */
    public void agregarCelda(Jaula celda){
        celdas.add(celda);
    }
}