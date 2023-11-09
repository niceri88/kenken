package modelo;

import java.util.ArrayList;
import java.util.List;
import controlador.Configuracion;
import controlador.Timer;
import controlador.Partida;

/**
 * La clase Datos contiene los datos del juego, incluyendo configuración, temporizador y lista de partidas.
 */
public class Datos {
    private static Configuracion configuracion = new Configuracion();
    private static Timer timer = new Timer();
    private static List<Partida> listaPartidas = new ArrayList<>();
    
    /**
     * Obtiene la configuración actual del juego.
     *
     * @return La configuración actual del juego.
     */
    public static Configuracion getConfiguracion(){
        return configuracion;
    }
    
    /**
     * Establece la dificultad en la configuración del juego basada en un índice.
     *
     * @param indice El índice de la opción de dificultad a seleccionar.
     */
    public static void agregarDificultadConfiguracion(int indice){
        configuracion.setDificultadPorIndice(indice);
    }

    /**
     * Establece la opción de reloj en la configuración del juego basada en un índice.
     *
     * @param indice El índice de la opción de reloj a seleccionar.
     */
    public static void agregarRelojConfiguracion(int indice){
        configuracion.setRelojPorIndice(indice);
    }
    
    /**
     * Establece la posición del panel en la configuración del juego basada en un índice.
     *
     * @param indice El índice de la opción de posición del panel a seleccionar.
     */
    public static void agregarPosicionDePanelConfiguracion(int indice){
        configuracion.setPosicionDelPanelPorIndice(indice);
    }

    /**
     * Establece la opción de sonido final en la configuración del juego basada en un índice.
     *
     * @param indice El índice de la opción de sonido final a seleccionar.
     */
    public static void agregarSonidoFinalConfiguracion(int indice){
        configuracion.setSonidoFinalPorIndice(indice);
    }

    /**
     * Obtiene el temporizador actual del juego.
     *
     * @return El temporizador actual del juego.
     */
    public static Timer getTimer(){
        return timer;
    }
    
    /**
     * Establece las horas en el temporizador.
     *
     * @param horas Las horas que se establecerán en el temporizador.
     */
    public static void agregarHorasTimer(int horas){
        timer.setHoras(horas);
    }

    /**
     * Establece los minutos en el temporizador.
     *
     * @param minutos Los minutos que se establecerán en el temporizador.
     */
    public static void agregarMinutosTimer(int minutos){
        timer.setMinutos(minutos);
    }

    /**
     * Establece los segundos en el temporizador.
     *
     * @param segundos Los segundos que se establecerán en el temporizador.
     */
    public static void agregarSegundosTimer(int segundos){
        timer.setSegundos(segundos);
    }

    /**
     * Restablece las horas en el temporizador a su valor predeterminado (-1).
     */
    public static void quitarHorasTimer(){
        timer.setHoras(-1);
    }

    /**
     * Restablece los minutos en el temporizador a su valor predeterminado (-1).
     */
    public static void quitarMinutosTimer(){
        timer.setMinutos(-1);
    }

    /**
     * Restablece los segundos en el temporizador a su valor predeterminado (-1).
     */
    public static void quitarSegundosTimer(){
        timer.setSegundos(-1);
    }

    /**
     * Obtiene la lista de partidas del juego.
     *
     * @return Una lista de objetos Partida representando las partidas en el juego.
     */
    public static List<Partida> getListaPartidas(){
        return listaPartidas;
    }

    /**
     * Agrega una nueva partida a la lista de partidas del juego.
     *
     * @param partida La partida que se va a agregar a la lista de partidas.
     */
    public static void agregarPartida(Partida partida){
        listaPartidas.add(partida);
    }
}